package com.example.cursova;


public class Task implements Comparable<Task> {
    private String title;
    private String description;
    private String date;
    private String priority;

    public Task(String title, String description, String date, String priority) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Заголовок: " + title + ", Опис задачі: " + description + ", Пріоритетність: " + priority + ", Дедлайн: " + date;
    }

    @Override
    public int compareTo(Task other) {
        int priorityComparison = this.priority.compareTo(other.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }
        return this.date.compareTo(other.date);
    }
}
