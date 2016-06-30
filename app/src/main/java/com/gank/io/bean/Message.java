package com.gank.io.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/27.
 */

public class Message {
    /**
     * {
     * "_id": "5771d5eb421aa931ddcc50d6",
     * "createdAt": "2016-06-28T09:42:03.761Z",
     * "desc": "Dagger2\u56fe\u6587\u5b8c\u5168\u6559\u7a0b",
     * "publishedAt": "2016-06-28T11:33:25.276Z",
     * "source": "web",
     * "type": "Android",
     * "url": "https://github.com/luxiaoming/dagger2Demo",
     * "used": true,
     * "who": "\u4ee3\u7801GG\u9646\u6653\u660e"
     * }
     */
    @Expose
    @SerializedName("_id")
    private String id;

    @Expose
    @SerializedName("who")
    private String who;

    @Expose
    @SerializedName("desc")
    private String desc;

    @Expose
    private String createdAt;

    @Expose
    private String publishedAt;

    @Expose
    private String source;

    @Expose
    private String type;

    @Expose
    private String url;

    @Expose
    private boolean used;

    public Message(JSONObject obj) {
        id = obj.optString("_id");
        who = obj.optString("who");
        desc = obj.optString("desc");
    }

    public Message(String id, String who, String desc) {
        this.id = id;
        this.who = who;
        this.desc = desc;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public String getWho() {
        return who;
    }


    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
