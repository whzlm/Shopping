package com.example.shoping.home.entry;

public class Channel {
    private String channelName;
    private int imgRes;

    public Channel(){}
    public Channel(String channelName, int imgRes) {
        this.channelName = channelName;
        this.imgRes = imgRes;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }
}
