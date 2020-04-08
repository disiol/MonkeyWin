package com.monkeywintolucky.routers.main;

import com.monkeywintolucky.R;
import com.monkeywintolucky.routers.base.BaseRouter;
import com.monkeywintolucky.ui.activities.MainActivity;
import com.monkeywintolucky.ui.fragments.game.view.GameFragment;
import com.monkeywintolucky.ui.fragments.start.view.StartFragment;
import com.monkeywintolucky.ui.fragments.web.view.WebFragment;

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
