package com.example.shoping.home.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.shoping.R;
import com.example.shoping.home.entry.Channel;
import com.example.shoping.home.entry.HomeDataBean;
import com.example.shoping.home.entry.Hot;
import com.example.shoping.home.entry.Product;
import com.example.shoping.home.entry.Recommend;
import com.example.shoping.home.entry.Sg;
import com.zhy.magicviewpager.transformer.AlphaPageTransformer;
import com.zhy.magicviewpager.transformer.RotateDownPageTransformer;
import com.zhy.magicviewpager.transformer.RotateYTransformer;
import com.zhy.magicviewpager.transformer.ScaleInTransformer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    public static final int BANNER = 0;
    public static final int CHANNEL = 1;
    public static final int AD = 2;
    public static final int SG = 3;
    public static final int RECOMMEND = 4;
    public static final int HOT = 5;

    private HomeDataBean homeDataBean;
    private Context context;
    public HomeAdapter(Context context ,HomeDataBean homeDataBean){
        this.context = context;
        this.homeDataBean=homeDataBean;
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
            case SG:
                View view4 = LayoutInflater.from(context).inflate(R.layout.home_sg_item,parent,false);
                holder = new SGHolder(view4);
                break;
            case RECOMMEND:
                View view5 = LayoutInflater.from(context).inflate(R.layout.home_recommend_item,parent,false);
                holder = new RecommendHolder(view5);
                break;
            case HOT:
                View view6 = LayoutInflater.from(context).inflate(R.layout.home_hot_item,parent,false);
                holder = new HotHolder(view6);
                break;
        }
        return holder;
    }

    @Override  //绑定数据
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int spoition) {
        //填充Holder中需要绑定的数据
        switch (getItemViewType(spoition)){
            case BANNER:

                break;
            case CHANNEL:

                break;
            case AD:

                break;
            case SG:
                SGHolder sgHolder = (SGHolder) holder;
                sgHolder.setData(homeDataBean.getSg_pros());
                break;
            case RECOMMEND:
                RecommendHolder recommendHolder = (RecommendHolder) holder;
                recommendHolder.setData(homeDataBean.getRecommend_pros());
                break;
            case HOT:
                HotHolder hotHolder = (HotHolder) holder;
                hotHolder.setData(homeDataBean.getHot_pros());
                break;
        }
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
            case SG:
                type = SG;
                break;
            case RECOMMEND:
                type = RECOMMEND;
                break;
            case HOT:
                type = HOT;
                break;
        }
        return type;
    }

    @Override  //总共有几项
    public int getItemCount() {
        return 6;
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
            textSliderView2.description("第一个轮播图的描述信息").image(R.drawable.banner2);
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



    TextView djsTv;
    class SGHolder extends RecyclerView.ViewHolder{
        private List<Product> sgList;
        RecyclerView recyclerView;
        TextView sg_more_tv;

        public SGHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.sg_recycleview);
            djsTv = itemView.findViewById(R.id.countdown);
            sg_more_tv = itemView.findViewById(R.id.check_more);

        }

        public void setData(List<Product> sg_pro_list){
            SgAdapter sgAdapter = new SgAdapter(sg_pro_list,context);
            recyclerView.setAdapter(sgAdapter);

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
        }

        public void setcountdown(){
            //发延时消息，每隔一秒，减一，并设置到界面上
            Date date = new Date();//当前时间---服务器返回的时间
            Long nowtime = date.getTime(); //毫秒----到现在的总毫秒数
            //倒数计时两小时
            Message msg = new Message();
            handler.sendMessage(msg);
        }

    }
    private int totalTime = 2*60*60*1000;
    public Handler handler = new Handler(Looper.getMainLooper()){
         @Override
        public void handleMessage(@NonNull Message msg){
             super.handleMessage(msg);
             if (msg.what == 9){
                 totalTime = totalTime - 1000;
                 if (djsTv!=null){
                     djsTv.setText(new Date(totalTime).toLocaleString());
                 }
             }
         }
    };



    class RecommendHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        RecommendAdapter recommendAdapter;

        List<Product> recommendList;
        public RecommendHolder(@NonNull View itemView) {
            super(itemView);

            recyclerView = itemView.findViewById(R.id.recmd_recycleview);

        }
        public void setData(List<Product> recommend_list){
            recommendAdapter = new RecommendAdapter(recommend_list,context);
            recyclerView.setAdapter(recommendAdapter);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context,RecyclerView.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
        }


    }

    class HotHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        HotAdapter hotAdapter;
        List<Product> hotList;
        public HotHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.hot_recycleview);

        }
        public void setData(List<Product> hot_list){
            hotAdapter = new HotAdapter(hot_list,context);
            recyclerView.setAdapter(hotAdapter);

            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
        }

    }


}
