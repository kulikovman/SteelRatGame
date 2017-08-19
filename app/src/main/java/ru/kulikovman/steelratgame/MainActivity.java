package ru.kulikovman.steelratgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private int mChapterNumber;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
}
