package com.example.shoping.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoping.R;
import com.example.shoping.home.entry.Channel;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Channel> channelList;
    public ChannelAdapter(Context context,List<Channel> channelList){
        this.context = context;
        this.channelList = channelList;
    }


    class ChannelHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ChannelHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.channel_img);
            textView = itemView.findViewById(R.id.channel_name);
        }

        public void setData(int position){
            Channel channel = channelList.get(position);
            imageView.setImageResource(channel.getImgRes());
            textView.setText(channel.getChannelName());
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.channel_item,parent,false);
        return new ChannelHolder(view);
    }

    @Override  //注入数据
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChannelHolder channelHolder = (ChannelHolder)holder;
        channelHolder.setData(position);
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }
}
