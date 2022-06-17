package com.example.lesson26ht.Service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class SessionAttributes {


    public boolean ifLogged (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if (login==null||password==null) {
        session.setAttribute("ifLogged", false);
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request,response);
        } else if (login.equals("123")&&password.equals("123")) {
            session.setAttribute("ifLogged", true);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/successful");
            dispatcher.forward(request,response);
        } else {
            session.setAttribute("ifLogged", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request,response);
        }
        return (boolean) session.getAttribute("ifLogged");
    }


    public Integer countVisits (HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer visits = (Integer) session.getAttribute("visits");

        if (visits == null) {
            visits = 1;
            session.setAttribute("visits", visits);
        } else {
            visits++;
            session.setAttribute("visits", visits);
        }
        return visits;
    }
}
