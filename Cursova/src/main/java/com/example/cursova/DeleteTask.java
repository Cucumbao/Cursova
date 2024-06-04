package com.example.cursova;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;

import java.util.*;

@WebServlet(name = "DeleteTask", value = "/delete")
public class DeleteTask extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        String priority = req.getParameter("priority");

        if (tasks != null) {
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getTitle().equals(title) && task.getDescription().equals(description)
                        && task.getDate().equals(date) && task.getPriority().equals(priority)) {
                    iterator.remove();
                }
            }
        }

        session.setAttribute("tasks", tasks);
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/TasksPage.jsp").forward(req, resp);
    }
}
