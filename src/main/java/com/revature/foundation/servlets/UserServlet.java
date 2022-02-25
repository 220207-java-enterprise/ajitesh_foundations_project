package com.revature.foundation.servlets;

import com.revature.foundation.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserService userService;

    public UserServlet(UserService userService) {
        this.userService = userService;
    }

    // get users (either get all or by id, or w/e)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1>/users works!</h1>");
        System.out.println(userService.isUsernameValid("tester99"));
    }

    // registration endpoint
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("<h1>post to /users works!</h1>");
    }

}
