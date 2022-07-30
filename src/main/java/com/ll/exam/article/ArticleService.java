package com.ll.exam.article;

public class ArticleService {
    private static ArticleRepository articleRepository;

    public ArticleService() {
        articleRepository = new ArticleRepository();
    }

    public long write(String title, String body) {
        return articleRepository.add(title, body);
    }
}
