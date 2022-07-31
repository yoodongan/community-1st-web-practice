package com.ll.exam.article;

import com.ll.exam.article.dto.ArticleDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArticleRepository {
    private static List<ArticleDto> articleDtos;
    private static long lastId;

    static {
        articleDtos = new ArrayList<>();
        lastId = 0;
        makeTestData();
    }
    public static long add(String title, String body) {
        ++lastId;
        articleDtos.add(new ArticleDto(lastId, title, body));
        return lastId;
    }

    public static List<ArticleDto> findAll() {
        return articleDtos;
    }

    public static ArticleDto findById(long id) {
        for (ArticleDto articleDto : articleDtos) {
            if (articleDto.getId() == id) {
                return articleDto;
            }
        }
        return null;
    }
    public static void makeTestData() {
        IntStream.rangeClosed(1, 10).forEach(id -> {
            String title = "제목%d".formatted(id);
            String body = "내용%d".formatted(id);
            add(title, body);
        });


    }

}
