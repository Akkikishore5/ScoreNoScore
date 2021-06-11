package com.scorenoscore.springclient.retrofit;

import com.scorenoscore.springclient.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MessageAPI {

    @GET("/messages/get-all")
    Call<List<Message>> getAllMessages();

    @POST("/message/save")
    Call<Message> save(@Body Message message);
}
