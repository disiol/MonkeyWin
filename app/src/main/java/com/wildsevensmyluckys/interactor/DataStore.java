package com.wildsevensmyluckys.interactor;


import com.google.gson.Gson;
import com.wildsevensmyluckys.api.Api;
import com.wildsevensmyluckys.util.RxTransformers;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.ResponseBody;
import rx.Observable;

@Singleton
public class DataStore {
    private Api api;
    private Gson gson;

    @Inject
    public DataStore(Api api, Gson gson) {
        this.api = api;
        this.gson = gson;
    }
  //TODO

    public Observable<ResponseBody> sendRequest() {
        return api.sendRequest().compose(RxTransformers.applyApiRequestSchedulers());
    }
}
