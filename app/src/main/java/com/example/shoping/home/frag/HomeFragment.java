package com.example.shoping.home.frag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shoping.R;
import com.example.shoping.home.adapter.HomeAdapter;

public class HomeFragment extends Fragment {


    private RecyclerView homeRecycleView;
    private Context context;

    @Override   //fragment界面被创建时调用
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        context = this.getContext();
        //找到Recycleview
        homeRecycleView = view.findViewById(R.id.home_recycle);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //注入数据Adapter适配器，注入数据
        HomeAdapter homeAdapter = new HomeAdapter(context);
        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        homeRecycleView.setLayoutManager(gridLayoutManager);
        homeRecycleView.setAdapter(homeAdapter);

    }
}