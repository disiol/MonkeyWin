package com.wildsevensmyluckys.di.modules;

import android.content.Context;


import com.wildsevensmyluckys.manedger.PreferencesManager;
import com.wildsevensmyluckys.manedger.PreferencesManagerImpl;

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
