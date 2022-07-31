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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        ArticleController articleController = new ArticleController();
        MemberController memberController = new MemberController();
        String url = req.getRequestURI();
        Rq rq = new Rq(req, resp);
        switch(rq.getRouteMethod()) {
            case "GET" :
                switch(rq.getActionPath()) {
                    case "/usr/article/list" :
                        articleController.showList(rq);
                        break;
                    case "/usr/article/detail" :
                        articleController.showDetail(rq);
                        break;
                    case "/usr/article/write" :
                        articleController.showWrite(rq);
                        break;
                    case "/usr/member/login" :
                        memberController.showLogin(rq);
                        break;
                    case "/usr/article/delete" :
                        articleController.doDelete(rq);
                        break;
                    case "/usr/article/modify" :
                        articleController.showModify(rq);
                        break;
                }
                break;
            case "POST" :
                switch (rq.getActionPath()) {
                    case "/usr/article/write" :
                        articleController.doWrite(rq);
                        break;
                    case "/usr/article/modify" :
                        articleController.doModify(rq);
                        break;
                }
                break;
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        doGet(req, resp);
    }

}
