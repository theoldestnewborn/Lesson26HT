package com.example.lesson26ht.Service;

import com.example.lesson26ht.DB.UserRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class SessionAttributes {


    public String getRoute(HttpServletRequest request, HttpSession session) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String route = "error.jsp";

        if (isLogged(login, password)) {
            session.setAttribute("isLogged", true);
            route = "/successful";
        }
        return route;
    }

    public boolean isLogged(String login, String password){
        UserRepository ur = new UserRepository();
        return login!=null && password!=null &&
                (ur.getUser(login).equals(login+password));


    }
}
