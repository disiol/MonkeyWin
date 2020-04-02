package com.wildsevensmyluckys.routers.main;

import com.wildsevensmyluckys.R;
import com.wildsevensmyluckys.routers.base.BaseRouter;
import com.wildsevensmyluckys.ui.activities.MainActivity;
import com.wildsevensmyluckys.ui.fragments.game.view.GameFragment;
import com.wildsevensmyluckys.ui.fragments.start.view.StartFragment;
import com.wildsevensmyluckys.ui.fragments.web.view.WebFragment;

import javax.inject.Inject;


public class MainActivityRouterImpl extends BaseRouter<MainActivity> implements MainActivityRouter {


    @Inject
    MainActivityRouterImpl(MainActivity activity) {
        super(activity);
    }

    @Override
    public void showGameFragment() {
        if (!isCurrentFragment(R.id.fragment_container, GameFragment.class)) {
            replaceFragment(R.id.fragment_container, new GameFragment());
        }
    }


    @Override
    public void showLogoFragment() {
        if (!isCurrentFragment(R.id.fragment_container, StartFragment.class)) {
            replaceFragment(R.id.fragment_container, new StartFragment());
        }
    }
    @Override
    public void showWebFragment() {
        if(!isCurrentFragment(R.id.fragment_container, WebFragment.class)) {
            replaceFragment(R.id.fragment_container, new WebFragment());
        }
    }

}
