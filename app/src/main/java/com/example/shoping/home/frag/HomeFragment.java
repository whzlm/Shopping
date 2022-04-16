package com.example.shoping.home.frag;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ejlchina.okhttps.OkHttps;
import com.example.shoping.R;
import com.example.shoping.home.adapter.HomeAdapter;
import com.example.shoping.home.entry.HomeDataBean;
import com.example.shoping.home.entry.Product;
import com.scwang.smart.refresh.layout.api.RefreshLayout;

import java.util.List;

public class HomeFragment extends Fragment {

    public static final int REFRESH=1;
    public static final int LOADDING=2;


    private RecyclerView homeRecycleView;
    private Context context;

        public void getData(int flag){
            if (flag == REFRESH){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //请求所有板块数据(异步请求，同步请求)
                        //请求闪购板块数据
                        List<Product> sg_pros =OkHttps.sync("http://124.221.67.36:9998/android/findSome")
                                                        .bind(context)
                                                        .get()
                                                        .getBody()
                                                        .toList(Product.class);
                        //请求推荐板块数据
                        List<Product> recommend_pros =OkHttps.sync("http://124.221.67.36:9998/android/findSome")
                                                            .bind(context)
                                                            .get()
                                                            .getBody()
                                                            .toList(Product.class);

                        //请求热门板块数据
                        List<Product> hot_pros =OkHttps.sync("http://124.221.67.36:9998/android/findByPage?pageNow=1&pageSize=20 ")
                                .bind(context)
                                .get()
                                .getBody()
                                .toList(Product.class);

                        //封装一个HOmeDataBean
                        HomeDataBean homeDataBean = new HomeDataBean();
                        homeDataBean.setHot_pros(hot_pros);
                        homeDataBean.setRecommend_pros(recommend_pros);
                        homeDataBean.setSg_pros(sg_pros);

                        //程序执行到这，三个板块数据都请求成功 ,通知主线程修改UI
                        Message  message = Message.obtain();
                        message.what = REFRESH;
                        message.obj = homeDataBean;

                        //发送消息给handler处理
                        handler.sendMessage(message);

                    }
                }).start();

            }

            if (flag == LOADDING){
                OkHttps.async("findByPage").bind(context)
                        .addUrlPara("pageNow",2)
                        .addUrlPara("pageSize",20)
                        .setOnResList(Product.class,hot_pros ->{
                        }).get();
            }
        }

    private Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            //接收到数据
            switch (msg.what){
                case REFRESH:
                    HomeDataBean homeDataBean = (HomeDataBean) msg.obj;
                    //把数据注入到Adapter
                    HomeAdapter homeAdapter = new HomeAdapter(context,homeDataBean);
                    homeRecycleView.setAdapter(homeAdapter);
            }

        }
    };

    @Override   //fragment界面被创建时调用
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //找到Recycleview
        homeRecycleView= view.findViewById(R.id.home_recycle);
        context = this.getContext();

        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getData(REFRESH);

        //设置布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        homeRecycleView.setLayoutManager(gridLayoutManager);
    }
}