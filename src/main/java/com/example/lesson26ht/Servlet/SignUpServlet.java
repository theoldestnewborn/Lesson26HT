package com.example.lesson26ht.Servlet;

import java.io.*;

import com.example.lesson26ht.DB.UserRepository;
import com.example.lesson26ht.Service.SessionAttributes;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "signUpServlet", value = "/signUp")
public class SignUpServlet extends HttpServlet {
    String login, password;

    public void init(){
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        UserRepository ur = new UserRepository();
        login = request.getParameter("login");
        password = request.getParameter("password");
        if (ur.addUser(login,password)) {
            HttpSession session = request.getSession();
            session.setAttribute("isLogged", true);
            request.getRequestDispatcher("/successful").forward(request,response);
        } else {
            request.getRequestDispatcher("errorLoginExists.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }
}