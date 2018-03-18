package com.example.sam.samapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sam.samapp.tasks.Task;

public class CollectTaskDetailActivity extends ManageTasksActivity {

    private EditText taskText;
    private EditText taskDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_task_detail);
        setUpViews();
    }

    protected void addTask() {

        getToDoTasksApplication()
                .addTask(new Task(taskText.getText().toString(),taskDesc.getText().toString()));

        finish();

    }

    private void cancel() {
        finish();
    }

    private void setUpViews() {
        Button saveButton = findViewById(R.id.save_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        taskText = findViewById(R.id.editText);
        taskDesc = findViewById(R.id.describe_task);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTask();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }
}
