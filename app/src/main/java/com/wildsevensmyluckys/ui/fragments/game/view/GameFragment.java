package com.wildsevensmyluckys.ui.fragments.game.view;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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


    private ArrayList<Button> buttons = new ArrayList<>();
    int butonCaunter = 4;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_game;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        while (butonCaunter <= 4) {
            Button button  = getActivity().findViewById(R.id.button + butonCaunter);
            button.setOnClickListener(v -> {
                generateColor(binding.button2.getTag());
            });
        }
        showMessage("Guess color", "start");
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    public void generateColor(Object buttonTeg) {
        Random random = new Random();
        // Массив из пяти цветов
        int colors[] = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED};
        int pos = random.nextInt(colors.length);
        // Меняем цвет у кнопки
        binding.colorLinearLayout.setBackgroundColor(colors[pos]);

        if((int)buttonTeg == pos) {
          showMessage("Yuo win", "newGame");
        }else{
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
                            if(flag.equals("newGame")){
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