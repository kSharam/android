package com.sam.driod.stodo;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.sam.driod.stodo.adapter.ToDoTaskAdapter;


public class CreateTaskActivity extends ListActivity {
    private Button newButton;
    private Button deletebutton;
    private ToDoTasksApplication app;
    private ToDoTaskAdapter adapter;
    private int resource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
        setUpViews();

        app = (ToDoTasksApplication)getApplication();
        adapter = new ToDoTaskAdapter(this,resource ,app.getCurrentTasks());
        setListAdapter(adapter);
    }


    @Override
    protected void onResume(){
        super.onResume();
        adapter.forceReload();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        adapter.toggleTaskCompleteAtPosition(position);

    }


    private void setUpViews() {
        newButton = findViewById(R.id.imageButton);
        deletebutton = findViewById(R.id.deleteButton);

        //When add newButton is clicked, it takes to a new activity to collect the details about the task.
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CollectTaskDetailActivity.class);
                startActivity(intent);
            }
        });

        deletebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeCompletedTasks();
            }
        });

    }

    private void removeCompletedTasks() {
        adapter.removeCompletedTasks();
    }


}
