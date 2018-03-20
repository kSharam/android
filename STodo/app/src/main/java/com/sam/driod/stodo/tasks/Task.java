package com.sam.driod.stodo.tasks;

/**
 * Created by sam on 3/12/18.
 */

public class Task extends Object {
    private String name;
    private String description;
    private boolean complete;

     public Task(String name, String description) {
       this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public void toggleComplete() {
        complete = !complete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
