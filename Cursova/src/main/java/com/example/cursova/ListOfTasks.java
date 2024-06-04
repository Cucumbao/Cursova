package com.example.cursova;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import java.util.*;
import java.io.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ListOfTasks", value = "/list-of-tasks")
public class ListOfTasks extends HttpServlet {
    private List<Task> tasks = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        tasks = (List<Task>) session.getAttribute("tasks");
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        Collections.sort(tasks);
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/TasksPage.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String taskName = req.getParameter("title");
        String description = req.getParameter("description");
        String taskDate = req.getParameter("date");
        String priority = req.getParameter("priority");

        if (taskName == null || taskName.trim().isEmpty()) {
            req.setAttribute("error", "Введіть назву задачі");
            req.getRequestDispatcher("/TasksPage.jsp").forward(req, resp);
            return;
        }

        Task newTask = new Task(taskName, description, taskDate, priority);
        tasks = (List<Task>) session.getAttribute("tasks");
        if (tasks == null) {
            tasks = new ArrayList<>();
        }
        tasks.add(newTask);
        Collections.sort(tasks);
        session.setAttribute("tasks", tasks);
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/TasksPage.jsp").forward(req, resp);
    }
}