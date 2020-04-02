package com.wildsevensmyluckys.ui.fragments.start.view;


import com.wildsevensmyluckys.routers.main.MainActivityRouter;
import com.wildsevensmyluckys.ui.base.BaseView;

public interface StartView extends BaseView {

    void showGame(MainActivityRouter mainActivityRouter);

    void showWeb(MainActivityRouter mainActivityRouter);
}
