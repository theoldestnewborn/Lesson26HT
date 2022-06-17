package com.example.lesson26ht.Servlet;

import java.io.*;

import com.example.lesson26ht.Service.SessionAttributes;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "signUpServlet", value = "/signUp")
public class SignUpServlet extends HttpServlet {

    public void init(){
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        SessionAttributes sa = new SessionAttributes();
        sa.ifLogged(request,response);
    }

    public void destroy() {
    }
}