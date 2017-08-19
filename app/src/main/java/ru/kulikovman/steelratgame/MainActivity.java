package ru.kulikovman.steelratgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mChapterText;
    private LinearLayout mButtonContainer;
    private int mChapterNumber;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем наши вью элементы
        mButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        mChapterText = (TextView) findViewById(R.id.chapter_text);

        // Получаем SharedPreferences
        mSharedPref = getPreferences(Context.MODE_PRIVATE);

        // Востанавливаем значение текущей главы
        mChapterNumber = mSharedPref.getInt(getString(R.string.chapter_number), 0);
        Log.d("myLog", "Восстановили текущую главу: " + mChapterNumber);

        // Запускаем игровой процесс
        startGame();
    }

    @Override
    protected void onPause() {
        super.onPause();

        saveChapter();
    }

    public void saveChapter() {
        // Сохраняем текущую главу
        mSharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt(getString(R.string.chapter_number), mChapterNumber);
        editor.apply();

        Log.d("myLog", "Сохранили текущую главу: " + mChapterNumber);
    }

    private void startGame() {
        switch (mChapterNumber) {
            case 0:
                mChapterText.setText(R.string.ch_0);

                addButton(getString(R.string.way_0_30), 30);
                addButton(getString(R.string.way_1_229), 229);

                break;
            case 30:
                mChapterText.setText(R.string.ch_30);

                addButton(getString(R.string.way_0_30), 30);
                addButton(getString(R.string.way_1_229), 229);
                break;
            case 229:
                mChapterText.setText(R.string.ch_229);

                addButton(getString(R.string.way_0_30), 30);
                addButton(getString(R.string.way_1_229), 229);
                break;
        }
    }

    private void addButton(String textButton, final int nextChapter) {
        Button button = (Button) getLayoutInflater().inflate(R.layout.my_button, mButtonContainer, false);
        button.setText(textButton);
        mButtonContainer.addView(button);
        Log.d("myLog", "Создали кнопку" + textButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChapterNumber = nextChapter;
                saveChapter();
                startGame();
            }
        });
    }
}
