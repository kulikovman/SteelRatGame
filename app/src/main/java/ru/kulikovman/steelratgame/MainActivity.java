package ru.kulikovman.steelratgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mOpenGameButton, mResetGameButton;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем необходимые вью элементы
        mOpenGameButton = (Button) findViewById(R.id.open_game_button);
        mResetGameButton = (Button) findViewById(R.id.reset_game_button);

        Log.d("myLog", "Запущен стартовый активити");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Получаем SharedPreferences
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        // Меняем название стартовой кнопки и скрываем/показываем кнопку сброса
        if (mSharedPref.getInt(getString(R.string.chapter_number), 0) > 0) {
            mOpenGameButton.setText(getString(R.string.continue_game));
            mResetGameButton.setVisibility(View.VISIBLE);
        } else {
            mOpenGameButton.setText(getString(R.string.start_game));
            mResetGameButton.setVisibility(View.INVISIBLE);
        }

        Log.d("myLog", "Восстановили текущую главу");
    }

    public void openGame(View view) {
        Intent intent = new Intent(this, GameProcess.class);
        startActivity(intent);
    }

    public void resetProgress(View view) {
        // Сбрасываем игровой процесс
        // Устанавливаем текущую главу - 0
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt(getString(R.string.chapter_number), 0);
        editor.apply();

        // Меняем название стартовой кнопки и скрываем кнопку сброса
        mOpenGameButton.setText(getString(R.string.start_game));
        mResetGameButton.setVisibility(View.INVISIBLE);
        Log.d("myLog", "Игровой прогресс был сброшен");
    }
}
