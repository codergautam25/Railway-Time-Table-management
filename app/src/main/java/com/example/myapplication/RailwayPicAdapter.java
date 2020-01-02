package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RailwayPicAdapter extends RecyclerView.Adapter<RailwayPicAdapter.MyViewHolder> {

    private String[] data;
    int[] imageView;


    public RailwayPicAdapter(String[] data,int[] imageView)
    {
        this.data = data;
        this.imageView = imageView;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.railway_pic_view,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title = data[position];
        int img = imageView[position];
        holder.txtTitle.setText(title);
        holder.imgIcon.setImageResource(img);

    }

    @Override
    public int getItemCount() {
        return imageView.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgIcon;
        TextView txtTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgIcon =(ImageView) itemView.findViewById(R.id.imgIcon);
            txtTitle =(TextView) itemView.findViewById(R.id.txtTitle);

        }
    }
}
