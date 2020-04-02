package com.wildsevensmyluckys.ui.fragments.game.view;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;


import com.wildsevensmyluckys.R;
import com.wildsevensmyluckys.databinding.FragmentGameBinding;
import com.wildsevensmyluckys.routers.main.MainActivityRouter;
import com.wildsevensmyluckys.ui.base.BaseBindingFragment;
import com.wildsevensmyluckys.ui.fragments.game.presenter.GamePresenter;

import java.util.ArrayList;
import java.util.Random;

import static com.wildsevensmyluckys.constants.Constants.MYLOG_TEG;


public class GameFragment extends BaseBindingFragment<GamePresenter, FragmentGameBinding> implements GameView {


    public static final int MILLIS_IN_FUTURE = 3000;
    private Animation animRotate = null;
    private ArrayList<Integer> cards = new ArrayList<>();


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_game;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    public void onClick(View view) {
        Random random = new Random();
        // Массив из пяти цветов
        int colors[] = { Color.BLUE, Color.GREEN, Color.MAGENTA, Color.RED,
                Color.CYAN };
        int pos = random.nextInt(colors.length);
        // Меняем цвет у кнопки
        binding.colorLinearLayout.setBackgroundColor(colors[pos]);
    }



    @Override
    public void showProgress(ProgressBar progressBar) {

    }

    @Override
    public void hideProgress(ProgressBar progressBar) {

    }

    @Override
    public void showMessage(String message) {

        Log.d(MYLOG_TEG, "showMessage:  " + message);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }


    @Override
    public void showError(Throwable throwable, MainActivityRouter mainActivityRouter) {

    }



    @Override
    public void showGameFragment(MainActivityRouter mainActivityRouter) {
        mainActivityRouter.showLogoFragment();
    }

}