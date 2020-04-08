package com.monkeywintolucky.di.modules;


import com.monkeywintolucky.di.scopes.ActivityScope;
import com.monkeywintolucky.di.scopes.FragmentScope;
import com.monkeywintolucky.routers.main.MainActivityRouter;
import com.monkeywintolucky.routers.main.MainActivityRouterImpl;
import com.monkeywintolucky.ui.fragments.game.view.GameFragment;
import com.monkeywintolucky.ui.fragments.start.view.StartFragment;
import com.monkeywintolucky.ui.fragments.web.view.WebFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {
    @ActivityScope
    @Binds
    MainActivityRouter mainActivityRouter(MainActivityRouterImpl mainRouter);

    @FragmentScope
    @ContributesAndroidInjector
    WebFragment webFragment();

    @FragmentScope
    @ContributesAndroidInjector
    StartFragment logoFragment();

    @FragmentScope
    @ContributesAndroidInjector
    GameFragment gameFragment();



}
