package com.monkeywintolucky.ui.fragments.game.presenter;


import android.widget.ImageView;


import com.monkeywintolucky.routers.main.MainActivityRouter;
import com.monkeywintolucky.ui.base.BasePresenter;
import com.monkeywintolucky.ui.fragments.game.view.GameView;

import javax.inject.Inject;


public class GamePresenter extends BasePresenter<GameView> {
    private MainActivityRouter mainActivityRouter;

    @Inject
    GamePresenter(MainActivityRouter mainActivityRouter) {
        this.mainActivityRouter = mainActivityRouter;
    }

    public void setPointsAndCheakForWin(int imageResource, ImageView deackImageView, String flag, int minPointsDiler) {


    }

    public void newGame() {
        getView().showGameFragment(mainActivityRouter);
    }

}
