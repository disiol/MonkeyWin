package com.monkeywintolucky.di.modules;

import android.content.Context;


import com.monkeywintolucky.manedger.PreferencesManager;
import com.monkeywintolucky.manedger.PreferencesManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ManagersModule {

    @Provides
    @Singleton
    PreferencesManager providePreferencesManager(Context context){
        return new PreferencesManagerImpl(context);
    }


}
