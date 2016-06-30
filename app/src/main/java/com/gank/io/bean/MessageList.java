package com.gank.io.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/6/28.
 */

public class MessageList {
    @SerializedName("error")
    private boolean error;

    @SerializedName("results")
    private List<Message> results;

//    public MessageList(JSONObject obj) throws JSONException{
//        results=new ArrayList<>();
//        JSONArray results=obj.getJSONArray("results");
//        for(int i=0;i<results.length();i++){
//            Message message=new Message(results.getJSONObject(i));
//            results.add(message);
//        }
//    }

    public List<Message> getMessageList(){
        return results;
    }
}
