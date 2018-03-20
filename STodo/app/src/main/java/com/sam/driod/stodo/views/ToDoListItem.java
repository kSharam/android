package com.sam.driod.stodo.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sam.driod.stodo.R;
import com.sam.driod.stodo.tasks.Task;

/**
 * Created by sam on 3/13/18.
 */

public class ToDoListItem extends LinearLayout {

    private Task task;
    private CheckedTextView checkbox;
    private TextView description;

    public ToDoListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate(){
        super.onFinishInflate();
        checkbox = findViewById(android.R.id.text1);
         description = findViewById(R.id.descriptionId);
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
        checkbox.setText(task.getName());
        checkbox.setChecked(task.isComplete());
        description.setText(task.getDescription());
    }

}
