package com.monkeywintolucky.di.component;

import android.content.Context;


import com.monkeywintolucky.App;
import com.monkeywintolucky.di.modules.ApplicationModule;

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
