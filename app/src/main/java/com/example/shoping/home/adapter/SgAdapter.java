package com.example.shoping.home.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoping.R;
import com.example.shoping.home.entry.Product;
import com.example.shoping.home.entry.Sg;

import java.util.List;

public class SgAdapter extends RecyclerView.Adapter {
    private List<Product> sgList;
    private Context context;

    public SgAdapter (List<Product> sgList , Context context){
        this.context = context;
        this.sgList = sgList;
    }



    class SgHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        public SgHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sg_sp);
            textView1 = itemView.findViewById(R.id.sg_price);
            textView2 = itemView.findViewById(R.id.price);
        }

        public void setData(int positon){
//            imageView.setImageResource(sgList.get(positon).getSgimg());
//            textView1.setText("￥"+sgList.get(positon).getSgprice());
            textView2.setText("￥"+sgList.get(positon).getPrice());
            textView2.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            textView2.getPaint().setAntiAlias(true);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sg_item,parent,false);
        SgHolder sgHolder = new SgHolder(view);
        return sgHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SgHolder sgHolder = (SgHolder) holder;
        sgHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return sgList.size();
    }
}
