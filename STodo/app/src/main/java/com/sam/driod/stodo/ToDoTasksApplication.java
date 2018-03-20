package com.sam.driod.stodo;

import android.app.Application;


import com.sam.driod.stodo.tasks.Task;

import java.util.ArrayList;

/**
 * Created by sam on 3/12/18.
 */

public class ToDoTasksApplication extends Application {
    private ArrayList<Task> currentTasks;

    @Override
    public void onCreate() {
        super.onCreate();
        if (currentTasks == null) {
            currentTasks = new ArrayList<>();
        }
    }

    public void setCurrentTasks(ArrayList<Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public ArrayList<Task> getCurrentTasks() {
        return currentTasks;
    }

    public  void addTask(Task newtask){
        currentTasks.add(newtask);
    }

}
