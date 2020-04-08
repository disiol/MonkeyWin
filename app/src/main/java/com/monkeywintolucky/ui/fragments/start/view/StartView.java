package com.monkeywintolucky.ui.fragments.start.view;


import com.monkeywintolucky.routers.main.MainActivityRouter;
import com.monkeywintolucky.ui.base.BaseView;

public interface StartView extends BaseView {

    void showGame(MainActivityRouter mainActivityRouter);

    void showWeb(MainActivityRouter mainActivityRouter);
}
