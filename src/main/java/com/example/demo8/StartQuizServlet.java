package com.example.demo8;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "StartQuizServlet", value = "/StartQuizServlet")
public class StartQuizServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Before starting the game you need to enter your name and   number of Quiz ";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<form method = 'post'>");
        out.println("<input type = 'text' name = 'username'>");
        out.println("<input type = 'text' name = 'StartQuiz'>");
        out.println("<input type = 'submit' value = 'start game'>");
        out.println("</form");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String numberQuiz = request.getParameter("StartQuiz");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");



// Сохранение обновленного значения в атрибуте сессии
        session.setAttribute("gamesPlayed", gamesPlayed);

        if (numberQuiz != null) {
            if (numberQuiz.equals("1")) {
                response.sendRedirect("welcome.jsp");
            } else if (numberQuiz.equals("2")) {
                response.sendRedirect("welcome2.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }

    }
}