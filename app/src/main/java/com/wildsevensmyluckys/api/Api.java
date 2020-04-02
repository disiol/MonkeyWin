package com.wildsevensmyluckys.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import rx.Observable;

import static com.wildsevensmyluckys.constants.Constants.END_STRING;


public interface Api {

   @GET(END_STRING)
   Observable<ResponseBody> sendRequest();
}
