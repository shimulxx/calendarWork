package com.example.calenderwork;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHOlder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Alarm> alarms;

    @NonNull
    @Override
    public ViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_of_recyclerview, parent, false);
        ViewHOlder holder = new ViewHOlder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHOlder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        holder.alarmMessage.setText(alarms.get(position).getMessage());
        String time = alarms.get(position).getHour() + " : " + alarms.get(position).getMin();
        holder.alarmTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

    public class ViewHOlder extends RecyclerView.ViewHolder{
        private TextView alarmMessage;
        private TextView alarmTime;
        public ViewHOlder(@NonNull View itemView) {
            super(itemView);
            alarmMessage = itemView.findViewById(R.id.alarmMessage);
            alarmTime = itemView.findViewById(R.id.alarmTime);
        }
    }

    public void setAlarms(ArrayList<Alarm> alarms) {
        this.alarms = alarms;
        notifyDataSetChanged();
    }
}
