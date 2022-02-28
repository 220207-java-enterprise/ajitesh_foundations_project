package com.revature.foundation.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundation.daos.ReimbursementDAO;
import com.revature.foundation.daos.UserDAO;
import com.revature.foundation.services.UserService;
import com.revature.foundation.services.ReimbursementService;
import com.revature.foundation.servlets.AuthServlet;
import com.revature.foundation.servlets.UserServlet;
import com.revature.foundation.servlets.ReimbursementServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing Foundation web application");

        ObjectMapper mapper = new ObjectMapper();

        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        UserServlet userServlet = new UserServlet(userService,mapper);

        ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
        ReimbursementService reimbursementService = new ReimbursementService(reimbursementDAO);
        ReimbursementServlet reimbursementServlet = new ReimbursementServlet(reimbursementService,mapper);

        AuthServlet authServlet = new AuthServlet(userService,mapper);

        // Programmatic Servlet Registration
        ServletContext context = sce.getServletContext();
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addServlet("AuthServlet", authServlet).addMapping("/auth");
        context.addServlet("ReimbursementServlet", reimbursementServlet).addMapping("/reimb");

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down Foundation web application");
    }


}
