package com.example.cursova;

import java.io.IOException;
import java.util.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit-task")
public class EditTask extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskTitle = req.getParameter("title");
        HttpSession session = req.getSession();
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTitle().equals(taskTitle)) {
                    req.setAttribute("task", task);
                    break;
                }
            }
        }

        req.getRequestDispatcher("/editTask.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String date = req.getParameter("date");
        String priority = req.getParameter("priority");

        HttpSession session = req.getSession();
        List<Task> tasks = (List<Task>) session.getAttribute("tasks");

        if (tasks != null) {
            for (Task task : tasks) {
                if (task.getTitle().equals(title)) {
                    task.setDescription(description);
                    task.setDate(date);
                    task.setPriority(priority);
                    break;
                }
            }
            Collections.sort(tasks);
            session.setAttribute("tasks", tasks);
        }

        resp.sendRedirect(req.getContextPath() + "/TasksPage.jsp");
    }
}