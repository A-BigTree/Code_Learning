package com.servlet;

import com.beans.User;
import com.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

public class UserServlet extends ModelBaseServlet {
    private final UserServiceImpl userService = new UserServiceImpl();
    protected void showList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ArrayList<User> users = (ArrayList<User>) userService.getUserList();
        request.setAttribute("userList", users);
        // 转发
        processTemplate("list", request, response);
    }

    protected void removeUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        userService.removeUser(userId);
        //重定向
        response.sendRedirect(request.getContextPath() + "/UserServlet?method=showList");
    }
}
