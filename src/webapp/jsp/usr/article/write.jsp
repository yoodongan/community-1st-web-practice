<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.ll.exam.article.dto.ArticleDto" %>

<h1>게시물 작성</h1>

<script>
    function submitForm(form) {
        form.title.value = form.title.value.trim();
        if (form.title.value.length == 0) {
            alert("제목을 입력해주세요!!!");
            form.title.onfocus();
            return;
        }
        form.body.value = form.body.value.trim();
        if (form.body.value.length == 0) {
            alert("내용을 입력해주세요!!!");
            form.body.onfocus();
            return;
        }
        form.submit();

    }
</script>

<form method ="POST" onsubmit="submitForm(this); return false;">
    <div>
        <span>제목</span>
        <div>
            <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요." />
        </div>
    </div>

    <div>
        <span>내용</span>
        <div>
            <input name="body" type="text" maxlength="300" placeholder="내용을 입력해주세요." />
        </div>
    </div>

    <div>
        <span>작성</span>
        <div>
            <input type="submit" value="작성" />
        </div>
    </div>
</form>