package com.example.lesson26ht.Servlet;

import java.io.*;

import com.example.lesson26ht.Service.SessionAttributes;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "successServlet", value = "/successful")
public class SuccessServlet extends HttpServlet {
    public static int visits;

    public void init(){
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        SessionAttributes sa = new SessionAttributes();
        HttpSession session = request.getSession();
        if ((boolean)session.getAttribute("isLogged")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("successful.jsp");
            dispatcher.forward(request,response);
            visits++;
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request,response);
        }
    }

    public void destroy() {
    }
}