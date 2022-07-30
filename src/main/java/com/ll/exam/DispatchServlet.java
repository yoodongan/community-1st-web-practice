package com.ll.exam;

import com.ll.exam.article.ArticleController;
import com.ll.exam.member.MemberController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Member;

@WebServlet("/usr/*")
public class DispatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArticleController articleController = new ArticleController();
        MemberController memberController = new MemberController();
        String url = req.getRequestURI();
        Rq rq = new Rq(req, resp);
        switch(url) {

            case "/usr/article/list/free" :
                articleController.showList(rq);
                break;
            case "/usr/member/login" :
                memberController.showLogin(rq);
                break;
        }




    }
}