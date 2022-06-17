package com.example.lesson26ht.Servlet;

import java.io.*;

import com.example.lesson26ht.Service.SessionAttributes;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "authorizationServlet", value = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    public String login, password;

    public void init(){
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        SessionAttributes sa = new SessionAttributes();
        login =request.getParameter("login");
        password = request.getParameter("password");
        sa.isLogged(login, password);
        String route = sa.getRoute(request, request.getSession());
        request.getRequestDispatcher(route).forward(request,response);

    }

    public void destroy() {
    }
}