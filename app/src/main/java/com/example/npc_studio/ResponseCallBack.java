package com.example.npc_studio;

public interface ResponseCallBack {

    void onResponse(String response);
    void onError(Throwable throwable );
}
