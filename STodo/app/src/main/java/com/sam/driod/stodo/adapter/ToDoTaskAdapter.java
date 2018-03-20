package com.sam.driod.stodo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.sam.driod.stodo.R;
import com.sam.driod.stodo.tasks.Task;

import java.util.ArrayList;

/**
 * Created by sam on 3/13/18.
 */

public class ToDoTaskAdapter extends ArrayAdapter {

    private ArrayList<Task> tasks;
    private Context context;
    private CheckedTextView title;
    private TextView description;

    public ToDoTaskAdapter(@NonNull Context context,int resource,ArrayList<Task> tasks) {
        super(context,resource, tasks);
        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return (tasks == null)? null : tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext()
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list,parent,false);
        }

        Task task = (Task) getItem(position);

        title =convertView.findViewById(R.id.titleId);
        title.setText(task.getName());
        title.setChecked(task.isComplete());

        description = convertView.findViewById(R.id.descriptionId);
        description.setText(task.getDescription());
        return convertView;

    }



    public void forceReload() {
        notifyDataSetChanged();
    }

    public void toggleTaskCompleteAtPosition(int position) {
        Task t = tasks.get(position);
        t.toggleComplete();
        notifyDataSetChanged();
    }

    public void removeCompletedTasks() {
        ArrayList<Task> completedTask = new ArrayList<>();
        for(Task t : tasks){
            if(t.isComplete()){
                completedTask.add(t);
            }
        }
        tasks.removeAll(completedTask);
        notifyDataSetChanged();
    }
}
