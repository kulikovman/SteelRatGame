package ru.kulikovman.steelratgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.ViewGroup.LayoutParams;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.security.AccessController.getContext;

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
        mChapterText = (TextView) findViewById(R.id.chapter_text) ;

        //
        //LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(LayoutParams.MATCH_PARENT,
                //LayoutParams.WRAP_CONTENT);




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
                mChapterText.setText(R.string.ch_3);

                //ContextThemeWrapper newContext = new ContextThemeWrapper(this, R.style.MyButton);
                //Button btn1 = new Button(this, null, R.style.MyButton);
                Button button = new Button(new ContextThemeWrapper(this, R.style.MyButton), null, R.style.MyButton);


                button.setText("Проверяем как работает эта чертова динамическая кнопка!");



                mButtonContainer.addView(button);

                break;
        }
    }
}
