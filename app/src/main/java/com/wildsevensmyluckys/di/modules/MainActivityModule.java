package com.wildsevensmyluckys.di.modules;





import com.wildsevensmyluckys.di.scopes.ActivityScope;
import com.wildsevensmyluckys.di.scopes.FragmentScope;
import com.wildsevensmyluckys.routers.main.MainActivityRouter;
import com.wildsevensmyluckys.routers.main.MainActivityRouterImpl;
import com.wildsevensmyluckys.ui.fragments.game.view.GameFragment;
import com.wildsevensmyluckys.ui.fragments.start.view.StartFragment;
import com.wildsevensmyluckys.ui.fragments.web.view.WebFragment;

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
