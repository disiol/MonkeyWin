package com.wildsevensmyluckys.di.component;

import android.content.Context;


import com.wildsevensmyluckys.App;
import com.wildsevensmyluckys.di.modules.ApplicationModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder context(Context context);
        ApplicationComponent build();
    }

    void inject(App fruitsBoom);
}
