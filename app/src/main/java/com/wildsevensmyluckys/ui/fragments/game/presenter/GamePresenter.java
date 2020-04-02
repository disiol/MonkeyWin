package com.wildsevensmyluckys.ui.fragments.game.presenter;


import android.util.Log;
import android.widget.ImageView;


import com.wildsevensmyluckys.R;
import com.wildsevensmyluckys.routers.main.MainActivityRouter;
import com.wildsevensmyluckys.ui.base.BasePresenter;
import com.wildsevensmyluckys.ui.fragments.game.view.GameView;

import javax.inject.Inject;

import static com.wildsevensmyluckys.constants.Constants.MYLOG_TEG;


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
