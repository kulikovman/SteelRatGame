package ru.kulikovman.steelratgame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mOpenGameButton, mResetGameButton;
    private SharedPreferences mSharedPref;
    private int mChapterNumber;

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

        // Обновляем интерфейс
        updateUI();
    }

    private void updateUI() {
        // Получаем SharedPreferences и устанавливаем текущую главу
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        mChapterNumber = mSharedPref.getInt(getString(R.string.chapter_number), 0);

        if (mChapterNumber > 0) {
            mOpenGameButton.setText(getString(R.string.continue_game));
            mResetGameButton.setVisibility(View.VISIBLE);
        } else {
            mOpenGameButton.setText(getString(R.string.start_game));
            mResetGameButton.setVisibility(View.INVISIBLE);
        }

        Log.d("myLog", "Восстановили текущую главу и обновили кнопки");
    }

    public void openGame(View view) {
        Intent intent = new Intent(this, GameProcess.class);
        startActivity(intent);
    }

    public void resetProgress(View view) {
        // Диалог подтверждения сброса игрового прогресса
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.reset_progress_title)
                .setMessage(R.string.reset_progress_message)
                .setNegativeButton(R.string.reset_progress_cancel, null)
                .setPositiveButton(R.string.reset_progress_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Устанавливаем значение текущей главы = 0
                        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mSharedPref.edit();
                        editor.putInt(getString(R.string.chapter_number), 0);
                        editor.apply();

                        // Обновляем интерфейс
                        updateUI();
                    }
                })
                .show();
    }
}
