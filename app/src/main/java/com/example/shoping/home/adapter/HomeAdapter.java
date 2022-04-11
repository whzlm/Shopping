package com.example.shoping.home.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.shoping.R;
import com.example.shoping.home.entry.Channel;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;
import com.zhy.magicviewpager.transformer.RotateDownPageTransformer;
import com.zhy.magicviewpager.transformer.RotateYTransformer;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    public static final int BANNER = 0;
    public static final int CHANNEL = 1;
    public static final int AD = 2;

    private Context context;
    public HomeAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override  //创建ViewHolder
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType){
            case BANNER:
                View view1 = LayoutInflater.from(context).inflate(R.layout.home_banner_item,parent,false);
                holder = new BannerHolder(view1);
                break;
            case CHANNEL:
                View view2 = LayoutInflater.from(context).inflate(R.layout.home_channel_item,parent,false);
                holder = new ChannelHolder(view2);
                break;
            case AD:
                View view3 = LayoutInflater.from(context).inflate(R.layout.home_ad_item,parent,false);
                holder = new AdHolder(view3);
                break;
        }

        return holder;
    }

    @Override  //绑定数据
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int spoition) {
        //
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        switch (position){
            case BANNER:
                type = BANNER;
                break;
            case CHANNEL:
                type = CHANNEL;
                break;
            case AD:
                type = AD;
                break;
        }
        return type;
    }

    @Override  //总共有几项
    public int getItemCount() {
        return 3;
    }

    class BannerHolder extends RecyclerView.ViewHolder{

        public BannerHolder(@NonNull View itemView) {
            super(itemView);

            SliderLayout sliderShow = (SliderLayout) itemView.findViewById(R.id.slider);

            DefaultSliderView textSliderView = new DefaultSliderView(context);
            textSliderView.image(R.drawable.banner1);
            sliderShow.addSlider(textSliderView);

            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    sliderShow.stopAutoCycle();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            sliderShow.startAutoCycle();
                        }
                    },5000);
                }
            });

            TextSliderView textSliderView2 = new TextSliderView(context);
            textSliderView2.description("第二个轮播图的描述信息").image(R.drawable.banner2);
            sliderShow.addSlider(textSliderView2);

            TextSliderView textSliderView3 = new TextSliderView(context);
            textSliderView3.description("第二个轮播图的描述信息").image(R.drawable.banner3);
            sliderShow.addSlider(textSliderView3);

            sliderShow.setDuration(3000);
            sliderShow.setPresetTransformer(SliderLayout.Transformer.Default);
            sliderShow.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        }


    }


    class ChannelHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;

        public ChannelHolder(@NonNull View itemView) {
            super(itemView);
            //找到RecyclerView
            recyclerView = itemView.findViewById(R.id.ch_recycleview);
            //创建Adapter---ChannerAdapter
            List<Channel> list = initChannel();  //数据
            ChannelAdapter adapter = new ChannelAdapter(context,list);
            //注入数据
            //添加适配器
            recyclerView.setAdapter(adapter);
            //设置布局管理器
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context,5);
            recyclerView.setLayoutManager(gridLayoutManager);

        }

        public List<Channel> initChannel(){
            List<Channel> list = new ArrayList<Channel>();
            Channel c1 = new Channel("动漫",R.drawable.ch_dm);
            Channel c2 = new Channel("服饰",R.drawable.ch_fs);
            Channel c3 = new Channel("更多",R.drawable.ch_more);
            Channel c4 = new Channel("古风",R.drawable.ch_gf);
            Channel c5 = new Channel("零食",R.drawable.ch_ls);
            Channel c6 = new Channel("票务",R.drawable.ch_pw);
            Channel c7 = new Channel("首饰",R.drawable.ch_ss);
            Channel c8 = new Channel("文具",R.drawable.ch_wj);
            Channel c9 = new Channel("游戏",R.drawable.ch_yx);
            Channel c10 = new Channel("装饰",R.drawable.ch_zs);
            list.add(c1);list.add(c2);list.add(c3);list.add(c4);list.add(c5);
            list.add(c6);list.add(c7);list.add(c8);list.add(c9);list.add(c10);
            return list;
        }
    }

    class AdHolder extends RecyclerView.ViewHolder{

        public AdHolder(@NonNull View itemView) {
            super(itemView);
            //创建三个视图文件，放入到PageAdapter中，再注入到ViewPage中
            initData(itemView);
        }

        public void initData(View itemView){
            //创建三个View----
            ImageView imageView1 = new ImageView(context);
            imageView1.setImageResource(R.drawable.act_img1);
            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);

            ImageView imageView2 = new ImageView(context);
            imageView2.setImageResource(R.drawable.act_img2);
            imageView2.setScaleType(ImageView.ScaleType.FIT_XY);

            ImageView imageView3 = new ImageView(context);
            imageView3.setImageResource(R.drawable.act_img3);
            imageView3.setScaleType(ImageView.ScaleType.FIT_XY);

            List<View> views = new ArrayList<View>();
            views.add(imageView1);
            views.add(imageView2);
            views.add(imageView3);
            //放入到PageAdapter中，
            AdAdapter adAdapter = new AdAdapter(views);
            //向ViewPage中设置adapter来显示视图
            ViewPager viewPager = itemView.findViewById(R.id.vp1);
            viewPager.setAdapter(adAdapter);
            //美化操作
            viewPager.setPageMargin(20);
            viewPager.setOffscreenPageLimit(3);
            viewPager.setPageTransformer(true, new RotateYTransformer());
        }
    }





}
