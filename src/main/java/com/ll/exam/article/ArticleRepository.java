package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private static List<ArticleDto> articleDtos;
    private static long lastId;

    static {
        articleDtos = new ArrayList<>();
        lastId = 0;
    }
    public long add(String title, String body) {
        ++lastId;
        articleDtos.add(new ArticleDto(lastId, title, body));
        return lastId;
    }
}
