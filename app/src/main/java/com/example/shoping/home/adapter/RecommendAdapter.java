package com.example.shoping.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoping.R;
import com.example.shoping.home.entry.Product;
import com.example.shoping.home.entry.Recommend;

import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter {
    List<Product> recommendList;
    Context context;

    public RecommendAdapter(List<Product> recommendList,Context context){
        this.context = context;
        this.recommendList = recommendList;
    }


    ImageView imageView;
    TextView textView1;
    TextView textView2;
    class RcmdHolder extends RecyclerView.ViewHolder{

        public RcmdHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.recmd_img);
            textView1 = itemView.findViewById(R.id.recmd_title);
            textView2 = itemView.findViewById(R.id.recmd_price);
        }

        public void setData(int position){
//            imageView.setImageResource(recommendList.get(position).getImg());
//            textView1.setText(recommendList.get(position).getTitle());
            textView2.setText("￥:"+recommendList.get(position).getPrice());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_item,parent,false);
        RcmdHolder holder = new RcmdHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RcmdHolder rcmdHolder = (RcmdHolder) holder;
        rcmdHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }
}
