package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private int[] tName;
    private String[] tNames;
    private int[] tTime;
    public MyAdapter(int[][] train,String[] trainNames)
    {
        this.tName = train[0];
        this.tTime = train[1];
        tNames = trainNames;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.train_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

       /* Calendar calendar =(Calendar) Calendar.getInstance();
        int curHour = calendar.get(Calendar.HOUR);
        int curMinute = calendar.get(Calendar.MINUTE);
        int tFormat = calendar.get(Calendar.AM_PM);
        int currentTimeInMinute;
        if(tFormat == Calendar.AM) {
            currentTimeInMinute = curHour*60 + curMinute;
        }
        else{
            currentTimeInMinute = (curHour + 12)*60 + curMinute;
        }*/


        String tempName = tNames[tName[position]] +  " Local";
        String tempTime = tTime[position]/60 + ":" + tTime[position]%60;//Integer.toString(tTime[position]);
        holder.trnName.setText(tempName);
        holder.trnTime.setText(tempTime);
        int i = 12345 + position*50;
        holder.trnNo.setText(Integer.toString(i));


    }

    @Override
    public int getItemCount() {
        return tName.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView trnNo;
        TextView trnName;
        TextView trnTime;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            trnName = itemView.findViewById(R.id.trnName);
            trnNo = itemView.findViewById(R.id.trnNo);
            trnTime = itemView.findViewById(R.id.trnTime);
        }
    }
}
