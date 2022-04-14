package com.example.shoping.home.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoping.R;
import com.example.shoping.home.entry.Hot;
import com.example.shoping.home.entry.Product;

import java.util.List;

public class HotAdapter extends RecyclerView.Adapter {
    List<Product> hotList;
    Context context;

    public HotAdapter (List<Product> hotList,Context context){
        this.context = context;
        this.hotList = hotList;
    }

    class HotHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public HotHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hot_img);
            textView1 = itemView.findViewById(R.id.hot_title);
            textView2 = itemView.findViewById(R.id.hot_price);
        }

        public void setData(int position){
//            imageView.setImageResource(hotList.get(position).getImg());
//            textView1.setText(hotList.get(position).getTitle());
            textView2.setText(hotList.get(position).getPrice()+"");
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_item,parent,false);
        HotHolder holder = new HotHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotHolder holder1 = (HotHolder) holder;
        holder1.setData(position);
    }

    @Override
    public int getItemCount() {
        return hotList.size();
    }
}
