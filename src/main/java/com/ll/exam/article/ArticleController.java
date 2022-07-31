package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    private ArticleService articleService;

    public ArticleController() {
        articleService = new ArticleService();
    }

    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = articleService.findAll();
        if (articleDtos.size() == 0) {
            rq.print("게시물이 없습니다!");
            return;
        }
        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");
    }

    public void doWrite(Rq rq) {
        String title = rq.getParam("title", "");
        String body = rq.getParam("body", "");
        long id = articleService.write(title, body);
        rq.print("%d번 게시물이 등록되었습니다.".formatted(id));
    }

    public void showDetail(Rq rq) {
        long id = rq.getLongPathValueByIndex(1, 0);  // 이렇게 해야 usr/article/detail/free/1 에서 1을 가져온다.
        if (id == 0) {
            rq.print("게시물이 없습니다! 게시물 입력해주세요.");
            return;
        }
        ArticleDto articleDto = articleService.findById(id);
        if (articleDto == null) {
            rq.print("해당 글이 존재하지 않습니다.");
            return;
        }

        rq.setAttr("article", articleDto);
        rq.view("/usr/article/detail");
    }
}
