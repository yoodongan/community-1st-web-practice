package com.ll.exam.article;

import com.ll.exam.Rq;
import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    public void showList(Rq rq) {
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleDtos.add(new ArticleDto(1, "제목1", "내용1"));
        articleDtos.add(new ArticleDto(2, "제목2", "내용2"));
        articleDtos.add(new ArticleDto(3, "제목3", "내용3"));

        rq.setAttr("articles", articleDtos);
        rq.view("usr/article/list");
    }

    public void doWrite(Rq rq) {
        rq.view("usr/article/write");


    }
}
