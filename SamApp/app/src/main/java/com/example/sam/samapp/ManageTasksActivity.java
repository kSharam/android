package com.example.sam.samapp;

import android.app.Activity;

/**
 * Created by sam on 3/12/18.
 */

public class ManageTasksActivity extends Activity {
    protected ToDoTasksApplication getToDoTasksApplication(){
        ToDoTasksApplication tda = (ToDoTasksApplication)getApplication();
        return tda;
    }
}
