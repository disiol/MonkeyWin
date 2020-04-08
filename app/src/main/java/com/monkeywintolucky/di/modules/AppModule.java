package com.monkeywintolucky.di.modules;


import com.google.gson.Gson;
import com.monkeywintolucky.api.Api;
import com.monkeywintolucky.interactor.DataStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    DataStore provideDataStore(Api api, Gson gson) {
        return new DataStore(api, gson);
    }
}
