package com.monkeywintolucky.ui.fragments.start.view;


import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.monkeywintolucky.R;
import com.monkeywintolucky.databinding.StartBinding;
import com.monkeywintolucky.manedger.PreferencesManager;
import com.monkeywintolucky.routers.main.MainActivityRouter;
import com.monkeywintolucky.ui.base.BaseBindingFragment;
import com.monkeywintolucky.ui.fragments.start.presenter.StartPresenter;

import javax.inject.Inject;

import static com.monkeywintolucky.constants.Constants.MYLOG_TEG;


public class StartFragment extends BaseBindingFragment<StartPresenter, StartBinding> implements StartView {


    public static final String SHOW_WEB_FRAGMENT = "showWebFragment";
    public static final String SHOW_GAME = "showGame";
    final String PREFS_NAME = "MyPrefsFile";
    final String PREFS = "forRanWeb";
    final String PREFS2 = "forRanGAme";
    private SharedPreferences forRanWeb;
    private SharedPreferences forRanGame;
    private boolean settingsBoolean;
    @Inject
    PreferencesManager preferencesManager;

    @Override
    public int getLayoutResId() {
        return R.layout.start;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        forRanWeb = getActivity().getSharedPreferences(PREFS, 0);
        forRanGame = getActivity().getSharedPreferences(PREFS2, 0);

        settingsBoolean = preferencesManager.getMyFirstTime();
        if (settingsBoolean) {
            //the app is being launched for first time, do something
            Log.d(MYLOG_TEG, "First time");

            // first time task
            showProgress(binding.progressBar);
            presenter.check();
            showProgress(binding.progressBar);

            // record the fact that the app has been started at least once
            preferencesManager.setMyFirstTime(false);
            forRanWeb.edit().putBoolean(SHOW_WEB_FRAGMENT, false).apply();
            forRanGame.edit().putBoolean(SHOW_GAME, false).apply();


        } else {
            if (forRanWeb.getBoolean(SHOW_WEB_FRAGMENT, true)) {
                presenter.showWeb();
            } else if (forRanGame.getBoolean(SHOW_GAME, true)) {
                presenter.showGame();

            }

        }


    }


    @SuppressLint("CommitPrefEdits")
    @Override
    public void showWeb(MainActivityRouter mainActivityRouter) {
        forRanWeb.edit().putBoolean(SHOW_WEB_FRAGMENT, true).apply();
        mainActivityRouter.showWebFragment();

    }
    @Override
    public void showGame(MainActivityRouter mainActivityRouter) {
        forRanGame.edit().putBoolean(SHOW_GAME, true).apply();
        mainActivityRouter.showGameFragment();

    }

    @Override
    public void showMessage(String message, String flag) {

    }

    @Override
    public void showError(Throwable throwable, MainActivityRouter mainActivityRouter) {
        forRanGame.edit().putBoolean(SHOW_GAME, true).apply();
        mainActivityRouter.showGameFragment();
    }
}