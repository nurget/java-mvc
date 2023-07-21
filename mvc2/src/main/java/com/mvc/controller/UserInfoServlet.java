package com.mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int idx = uri.lastIndexOf("/");
        uri = uri.substring(idx + 1);
        String path = "/WEB-INF/views/";

        if ("list".equals(uri)) {
            path += "user-info/list.jsp";
        } else if ("view".equals(uri)) {
            path += "user-info/view.jsp";
        } else if ("insert".equals(uri)) {
            path += "user-info/insert.jsp";
        } else if ("update".equals(uri)) {
            path += "user-info/update.jsp";
        } else if ("delete".equals(uri)) {
            path += "user-info/delete.jsp";
        }

        // RequestDispatcher 객체를 생성하여 해당 경로로 포워드
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

}
