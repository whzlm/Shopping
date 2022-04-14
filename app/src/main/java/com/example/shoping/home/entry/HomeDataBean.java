package com.example.shoping.home.entry;

import java.util.List;

public class HomeDataBean {
    private List<Product> sg_pros;
    private List<Product> recommend_pros;
    private List<Product> hot_pros;

    public List<Product> getSg_pros() {
        return sg_pros;
    }

    public void setSg_pros(List<Product> sg_pros) {
        this.sg_pros = sg_pros;
    }

    public List<Product> getRecommend_pros() {
        return recommend_pros;
    }

    public void setRecommend_pros(List<Product> recommend_pros) {
        this.recommend_pros = recommend_pros;
    }

    public List<Product> getHot_pros() {
        return hot_pros;
    }

    public void setHot_pros(List<Product> hot_pros) {
        this.hot_pros = hot_pros;
    }
}
