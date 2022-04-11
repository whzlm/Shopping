package com.example.shoping.home.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.shoping.R;

public class HomeAdapter extends RecyclerView.Adapter {

    public static final int BANNER = 0;
    public static final int CHANNEL = 1;

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
        }
        return type;
    }

    @Override  //总共有几项
    public int getItemCount() {
        return 2;
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

        public ChannelHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
