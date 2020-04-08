package com.monkeywintolucky.ui.fragments.start.presenter;


import android.util.Log;



import com.monkeywintolucky.interactor.DataStore;
import com.monkeywintolucky.manedger.PreferencesManager;
import com.monkeywintolucky.routers.main.MainActivityRouter;
import com.monkeywintolucky.ui.base.BasePresenter;
import com.monkeywintolucky.ui.fragments.start.view.StartView;

import java.io.IOException;

import javax.inject.Inject;

import static com.monkeywintolucky.constants.Constants.MYLOG_TEG;


public class StartPresenter extends BasePresenter<StartView> {

    private MainActivityRouter mainActivityRouter;
    private DataStore dataStore;
    private PreferencesManager preferencesManager;

    @Inject
    StartPresenter(MainActivityRouter mainActivityRouter, DataStore dataStore, PreferencesManager preferencesManager) {
        this.mainActivityRouter = mainActivityRouter;
        this.dataStore = dataStore;
        this.preferencesManager = preferencesManager;
    }

    public void check() {

        dataStore.sendRequest().subscribe(sendRequest -> {
            String string = null;
            try {
                string = sendRequest.string();

                Log.d(MYLOG_TEG, "sendRequest" + string);
                StringBuilder stringBuilder = new StringBuilder();



                if (string != null && string != "") {
                    String managerURL = preferencesManager.getURL();
                    if (managerURL != null) {
                        stringBuilder.append(string);
                        stringBuilder.append(managerURL);

                        stringBuilder.toString();
                        Log.d(MYLOG_TEG, "stringBuilder " + stringBuilder.toString());
                        showWeb();
                        preferencesManager.setURL(String.valueOf(stringBuilder)); //TODO
                    } else if (string != null && string != ""){
                        Log.d(MYLOG_TEG, "stringBuilder  no " + stringBuilder.toString());
                        Log.d(MYLOG_TEG, "sstring " + string);
                        preferencesManager.setURL(string);
                        showWeb();
                    }else{
                        showGame();

                    }


                } else if (string == "") {
                    showGame();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, throwable -> getView().showError(throwable, mainActivityRouter));
    }

    public void showGame() {
        getView().showGame(mainActivityRouter);
    }

    public void showWeb() {
        getView().showWeb(mainActivityRouter);
    }


}
