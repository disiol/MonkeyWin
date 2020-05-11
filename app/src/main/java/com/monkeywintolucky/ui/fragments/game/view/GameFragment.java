package com.monkeywintolucky.ui.fragments.game.view;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;


import com.monkeywintolucky.R;

import com.monkeywintolucky.databinding.FragmentGameBinding;
import com.monkeywintolucky.routers.main.MainActivityRouter;
import com.monkeywintolucky.ui.base.BaseBindingFragment;
import com.monkeywintolucky.ui.fragments.game.presenter.GamePresenter;

import java.util.ArrayList;
import java.util.Random;

import static com.monkeywintolucky.constants.Constants.MYLOG_TEG;


public class GameFragment extends BaseBindingFragment<GamePresenter, FragmentGameBinding> implements GameView {


    private ArrayList<Button> buttons = new ArrayList<>();
    int butonCaunter = 4;
    private int pos;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_game;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button1.setOnClickListener(v -> {
            binding.colorLinearLayout.setVisibility(View.VISIBLE);
            chekForWin(binding.button1.getTag());
        });
        binding.button2.setOnClickListener(v -> {
            binding.colorLinearLayout.setVisibility(View.VISIBLE);
            chekForWin(binding.button2.getTag());
        });
        binding.button3.setOnClickListener(v -> {
            binding.colorLinearLayout.setVisibility(View.VISIBLE);
            chekForWin(binding.button3.getTag());
        });
        binding.button4.setOnClickListener(v -> {
            binding.colorLinearLayout.setVisibility(View.VISIBLE);
            chekForWin(binding.button4.getTag());
        });

        binding.startButton.setOnClickListener( v ->{
            binding.startButton.setVisibility(View.GONE);
            binding.colorLinearLayout.setVisibility(View.VISIBLE);
            binding.buttonsLinearLayout.setVisibility(View.VISIBLE);

            showMessage("Guess color", "start");
           generateColor();


        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    public void generateColor() {
        Random random = new Random();
        // Массив из пяти цветов
        int colors[] = {R.drawable.rounded_button_black,
                        R.drawable.rounded_button_blue,
                        R.drawable.rounded_button_green,
                        R.drawable.rounded_button_red};

         pos = random.nextInt(colors.length);
        // Меняем цвет у кнопки
        binding.colorLinearLayout.setBackgroundDrawable(getResources().getDrawable(colors[pos]));


    }

    private void chekForWin(Object buttonTeg) {
        Log.d(MYLOG_TEG, (String) buttonTeg.toString());
        binding.colorLinearLayout.setVisibility(View.VISIBLE);
        if (buttonTeg.toString().equals(String.valueOf(pos))) {
            showMessage("Yuo win", "newGame");
        } else {
            showMessage("Yuo lose", "newGame");

        }
    }


    @Override
    public void showProgress(ProgressBar progressBar) {

    }

    @Override
    public void hideProgress(ProgressBar progressBar) {

    }

    @Override
    public void showMessage(String message, String flag) {

        Log.d(MYLOG_TEG, "showMessage:  " + message);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        (dialog, id) -> {
                            if (flag.equals("newGame")) {
                                presenter.newGame();
                            }
                            dialog.cancel();
                        });
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