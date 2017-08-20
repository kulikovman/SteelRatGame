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

    private Button mOpenGameButton;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем необходимые вью элементы
        mOpenGameButton = (Button) findViewById(R.id.open_game_button);

        // Получаем SharedPreferences
        mSharedPref = getPreferences(Context.MODE_PRIVATE);

        // Если текущая глава не нулевая, то меняем название стартовой кнопки
        if (mSharedPref.getInt(getString(R.string.chapter_number), 0) > 0) {
            mOpenGameButton.setText(getString(R.string.continue_game));
        }

        Log.d("myLog", "Запущен стартовый активити");
    }

    public void openGame(View view) {
        Intent intent = new Intent(this, GameProcess.class);
        startActivity(intent);
    }
}
