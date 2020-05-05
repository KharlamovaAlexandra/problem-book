package com.example.anlaba5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Task> task;

    DataAdapter(Context context, List<Task> task) {
        this.task = task;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Task task1 = task.get(position);
        holder.nameView.setText(task1.title);
        holder.prior.setText("приоритет: "+(task1.prioritet+1));
        String strdate = null;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        if (task1.dateAndTime != null) {
            strdate = sdf.format(task1.dateAndTime .getTime());
        }
        holder.dnt.setText(strdate.toString());

    }

    @Override
    public int getItemCount() {
        return task.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, prior, dnt;
        final ImageView del;
        ViewHolder(View view){
            super(view);
            nameView = (TextView) view.findViewById(R.id.name);
            prior = (TextView) view.findViewById(R.id.prior);
            dnt = (TextView) view.findViewById(R.id.dandt);
            del=(ImageView)view.findViewById(R.id.image2);
        }
    }
}