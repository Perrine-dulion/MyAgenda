package com.example.myagenda.models;

import java.time.LocalDate;

public class TodoTask {

    private long todoTaskId;
    private String name;
    private LocalDate creationDate;
    private LocalDate limitDate;
    private LocalDate finishDate;

    public TodoTask(long todoTaskId, String name, LocalDate creationDate, LocalDate limitDate, LocalDate finishDate) {
        this(name,  creationDate, limitDate);
        this.todoTaskId = todoTaskId;
        this.finishDate = finishDate;
    }

    public TodoTask(String name, LocalDate creationDate, LocalDate limitDate) {
        this.todoTaskId = 0;
        this.name = name;
        this.creationDate = creationDate;
        this.limitDate = limitDate;
        this.finishDate = null;
    }


    public long getTodoTaskId() {
        return todoTaskId;
    }

    public void setTodoTaskId(long todoTaskId) {
        this.todoTaskId = todoTaskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isDone() {
        return this.finishDate != null;
    }
}
