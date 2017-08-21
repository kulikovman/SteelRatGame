package ru.kulikovman.steelratgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class GameProcess extends AppCompatActivity {

    private TextView mChapterText;
    private LinearLayout mButtonContainer;
    private ScrollView mScrollContainer;
    private int mChapterNumber;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_process);

        // Инициализируем необходимые вью элементы
        mButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        mScrollContainer = (ScrollView) findViewById(R.id.scroll_container);
        mChapterText = (TextView) findViewById(R.id.chapter_text);

        //
        //mScrollContainer.setFocusableInTouchMode(true);
        //mScrollContainer.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

        // Получаем SharedPreferences
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);

        // Востанавливаем значение текущей главы
        mChapterNumber = mSharedPref.getInt(getString(R.string.chapter_number), 0);
        Log.d("myLog", "Восстановили текущую главу: " + mChapterNumber);

        // Запускаем игровой процесс
        gameProcess();

        Log.d("myLog", "Запущен игровой активити");
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Сохраняем главу при выходе из приложения
        saveChapter();
    }

    public void saveChapter() {
        // Сохраняем текущую главу
        mSharedPref = getSharedPreferences(getString(R.string.pref_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPref.edit();
        editor.putInt(getString(R.string.chapter_number), mChapterNumber);
        editor.apply();

        Log.d("myLog", "Сохранили текущую главу: " + mChapterNumber);
    }

    private void addButton(String textButton, final int nextChapter) {
        // Создаем кнопку - используем специальный макет и указываем родительский элемент без привязки
        Button button = (Button) getLayoutInflater().inflate(R.layout.my_button, mButtonContainer, false);
        button.setText(textButton);

        // Добавляем кнопку в LinearLayout контейнер
        mButtonContainer.addView(button);
        Log.d("myLog", "Создали кнопку" + textButton);

        // Назначаем слушатель
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Устанавливаем следующую главу и удаляем кнопки из контейнера
                mChapterNumber = nextChapter;
                mButtonContainer.removeAllViews();

                // Перезапускаем метод игры
                gameProcess();
            }
        });
    }

    private void gameProcess() {
        // Вся логика игры прописана в этом методе
        // Каждый case это текщая глава, текст главы и сопутствующие кнопки выбора
        // Отсутствующие главы закомментированы, они были удалены в ходе оптимизации текстов
        switch (mChapterNumber) {
            case 0:
                // Это первая глава, с нее все начинается
                mChapterText.setText(R.string.ch_0);
                addButton(getString(R.string.way_0_30), 30);
                break;
            case 1:
                mChapterText.setText(R.string.ch_1);
                addButton(getString(R.string.way_1_229), 229);
                addButton(getString(R.string.way_1_347), 347);
                break;
            case 2:
                mChapterText.setText(R.string.ch_2);
                addButton(getString(R.string.way_2_4), 4);
                addButton(getString(R.string.way_2_138), 138);
                break;
            case 3:
                mChapterText.setText(R.string.ch_3);
                addButton(getString(R.string.way_3_218), 218);
                break;
            case 4:
                mChapterText.setText(R.string.ch_4);
                addButton(getString(R.string.way_4_134), 134);
                break;
            case 5:
                mChapterText.setText(R.string.ch_5);
                addButton(getString(R.string.way_5_342), 342);
                addButton(getString(R.string.way_5_343), 343);
                break;
            case 6:
                mChapterText.setText(R.string.ch_6);
                addButton(getString(R.string.way_6_76), 76);
                addButton(getString(R.string.way_6_232), 232);
                break;
            case 7:
                mChapterText.setText(R.string.ch_7);
                addButton(getString(R.string.way_7_65), 65);
                break;
            case 8:
                mChapterText.setText(R.string.ch_8);
                addButton(getString(R.string.way_8_253), 253);
                break;
            case 9:
                mChapterText.setText(R.string.ch_9);
                addButton(getString(R.string.way_9_311), 311);
                break;
            case 10:
                mChapterText.setText(R.string.ch_10);
                addButton(getString(R.string.way_10_82), 82);
                break;
            case 11:
                mChapterText.setText(R.string.ch_11);
                addButton(getString(R.string.way_11_140), 140);
                break;
            case 12:
                mChapterText.setText(R.string.ch_12);
                addButton(getString(R.string.way_12_65), 65);
                break;
            case 13:
                mChapterText.setText(R.string.ch_13);
                addButton(getString(R.string.way_13_88), 88);
                break;
            case 14:
                mChapterText.setText(R.string.ch_14);
                addButton(getString(R.string.way_14_99), 99);
                break;
            case 15:
                mChapterText.setText(R.string.ch_15);
                addButton(getString(R.string.way_15_113), 113);
                break;
            case 16:
                mChapterText.setText(R.string.ch_16);
                addButton(getString(R.string.way_16_139), 139);
                break;
            case 17:
                mChapterText.setText(R.string.ch_17);
                addButton(getString(R.string.way_17_115), 115);
                break;
            case 18:
                mChapterText.setText(R.string.ch_18);
                addButton(getString(R.string.way_18_87), 87);
                break;
            case 19:
                mChapterText.setText(R.string.ch_19);
                addButton(getString(R.string.way_19_49), 49);
                addButton(getString(R.string.way_19_124), 124);
                break;
            case 20:
                mChapterText.setText(R.string.ch_20);
                addButton(getString(R.string.way_20_339), 339);
                break;
            case 21:
                mChapterText.setText(R.string.ch_21);
                addButton(getString(R.string.way_21_80), 80);
                break;
            case 22:
                mChapterText.setText(R.string.ch_22);
                addButton(getString(R.string.way_22_34), 34);
                break;
            case 23:
                mChapterText.setText(R.string.ch_23);
                addButton(getString(R.string.way_23_340), 340);
                break;
            case 24:
                mChapterText.setText(R.string.ch_24);
                addButton(getString(R.string.way_24_302), 302);
                addButton(getString(R.string.way_24_332), 332);
                break;
            case 25:
                mChapterText.setText(R.string.ch_25);
                addButton(getString(R.string.way_25_90), 90);
                addButton(getString(R.string.way_25_167), 167);
                break;
            case 26:
                mChapterText.setText(R.string.ch_26);
                addButton(getString(R.string.way_26_205), 205);
                break;
            case 27:
                mChapterText.setText(R.string.ch_27);
                addButton(getString(R.string.way_27_163), 163);
                addButton(getString(R.string.way_27_289), 289);
                break;
            case 28:
                mChapterText.setText(R.string.ch_28);
                addButton(getString(R.string.way_28_121), 121);
                break;
            case 29:
                mChapterText.setText(R.string.ch_29);
                addButton(getString(R.string.way_29_64), 64);
                break;
            case 30:
                mChapterText.setText(R.string.ch_30);
                addButton(getString(R.string.way_30_42), 42);
                break;
            case 31:
                mChapterText.setText(R.string.ch_31);
                addButton(getString(R.string.way_31_292), 292);
                addButton(getString(R.string.way_31_344), 344);
                addButton(getString(R.string.way_31_346), 346);
                break;
            case 32:
                mChapterText.setText(R.string.ch_32);
                addButton(getString(R.string.way_32_118), 118);
                break;
            case 33:
                mChapterText.setText(R.string.ch_33);
                addButton(getString(R.string.way_33_12), 12);
                break;
            case 34:
                mChapterText.setText(R.string.ch_34);
                addButton(getString(R.string.way_34_32), 32);
                addButton(getString(R.string.way_34_118), 118);
                break;
            case 35:
                mChapterText.setText(R.string.ch_35);
                addButton(getString(R.string.way_35_197), 197);
                break;
            case 36:
                mChapterText.setText(R.string.ch_36);
                addButton(getString(R.string.way_36_120), 120);
                break;
            case 37:
                mChapterText.setText(R.string.ch_37);
                addButton(getString(R.string.way_37_18), 18);
                break;
            case 38:
                mChapterText.setText(R.string.ch_38);
                addButton(getString(R.string.way_38_216), 216);
                break;
            case 39:
                mChapterText.setText(R.string.ch_39);
                addButton(getString(R.string.way_39_255), 255);
                break;
            case 40:
                mChapterText.setText(R.string.ch_40);
                addButton(getString(R.string.way_40_254), 254);
                addButton(getString(R.string.way_40_284), 284);
                break;
            case 41:
                mChapterText.setText(R.string.ch_41);
                addButton(getString(R.string.way_41_50), 50);
                addButton(getString(R.string.way_41_54), 54);
                addButton(getString(R.string.way_41_315), 315);
                break;
            case 42:
                mChapterText.setText(R.string.ch_42);
                addButton(getString(R.string.way_42_62), 62);
                break;
            case 43:
                mChapterText.setText(R.string.ch_43);
                addButton(getString(R.string.way_43_63), 63);
                break;
            case 44:
                mChapterText.setText(R.string.ch_44);
                addButton(getString(R.string.way_44_23), 23);
                break;
            case 45:
                mChapterText.setText(R.string.ch_45);
                addButton(getString(R.string.way_45_215), 215);
                break;
            case 46:
                mChapterText.setText(R.string.ch_46);
                addButton(getString(R.string.way_46_193), 193);
                addButton(getString(R.string.way_46_339), 339);
                break;
            case 47:
                mChapterText.setText(R.string.ch_47);
                addButton(getString(R.string.way_47_98), 98);
                break;
            case 48:
                mChapterText.setText(R.string.ch_48);
                addButton(getString(R.string.way_48_61), 61);
                addButton(getString(R.string.way_48_67), 67);
                break;
            case 49:
                mChapterText.setText(R.string.ch_49);
                addButton(getString(R.string.way_49_304), 304);
                addButton(getString(R.string.way_49_337), 337);
                break;
            case 50:
                mChapterText.setText(R.string.ch_50);
                addButton(getString(R.string.way_50_164), 164);
                break;
            case 51:
                mChapterText.setText(R.string.ch_51);
                addButton(getString(R.string.way_51_45), 45);
                addButton(getString(R.string.way_51_215), 215);
                break;
            case 52:
                mChapterText.setText(R.string.ch_52);
                addButton(getString(R.string.way_52_307), 307);
                break;
            case 53:
                mChapterText.setText(R.string.ch_53);
                addButton(getString(R.string.way_53_16), 16);
                addButton(getString(R.string.way_53_139), 139);
                break;
            case 54:
                mChapterText.setText(R.string.ch_54);
                addButton(getString(R.string.way_54_71), 71);
                break;
            case 55:
                mChapterText.setText(R.string.ch_55);
                addButton(getString(R.string.way_55_206), 206);
                break;
            case 56:
                mChapterText.setText(R.string.ch_56);
                addButton(getString(R.string.way_56_11), 11);
                break;
            case 57:
                mChapterText.setText(R.string.ch_57);
                addButton(getString(R.string.way_57_255), 255);
                break;
            case 58:
                mChapterText.setText(R.string.ch_58);
                addButton(getString(R.string.way_58_160), 160);
                addButton(getString(R.string.way_58_283), 283);
                break;
            case 59:
                mChapterText.setText(R.string.ch_59);
                addButton(getString(R.string.way_59_80), 80);
                break;
            case 60:
                mChapterText.setText(R.string.ch_60);
                addButton(getString(R.string.way_60_72), 72);
                break;
            case 61:
                mChapterText.setText(R.string.ch_61);
                addButton(getString(R.string.way_61_67), 67);
                break;
            case 62:
                mChapterText.setText(R.string.ch_62);
                addButton(getString(R.string.way_62_14), 14);
                addButton(getString(R.string.way_62_99), 99);
                break;
            case 63:
                mChapterText.setText(R.string.ch_63);
                addButton(getString(R.string.way_63_130), 130);
                break;
            case 64:
                mChapterText.setText(R.string.ch_64);
                addButton(getString(R.string.way_64_114), 114);
                addButton(getString(R.string.way_64_345), 345);
                break;
            case 65:
                mChapterText.setText(R.string.ch_65);
                addButton(getString(R.string.way_65_48), 48);
                break;
            case 66:
                mChapterText.setText(R.string.ch_66);
                addButton(getString(R.string.way_66_181), 181);
                break;
            case 67:
                mChapterText.setText(R.string.ch_67);
                addButton(getString(R.string.way_67_97), 97);
                addButton(getString(R.string.way_67_146), 146);
                break;
            /*case 68:
                break;*/
            case 69:
                mChapterText.setText(R.string.ch_69);
                addButton(getString(R.string.way_69_70), 70);
                break;
            case 70:
                mChapterText.setText(R.string.ch_70);
                addButton(getString(R.string.way_70_278), 278);
                break;
            case 71:
                mChapterText.setText(R.string.ch_71);
                addButton(getString(R.string.way_71_161), 161);
                break;
            case 72:
                mChapterText.setText(R.string.ch_72);
                addButton(getString(R.string.way_72_348), 348);
                break;
            case 73:
                mChapterText.setText(R.string.ch_73);
                addButton(getString(R.string.way_73_313), 313);
                break;
            case 74:
                mChapterText.setText(R.string.ch_74);
                addButton(getString(R.string.way_74_320), 320);
                break;
            case 75:
                mChapterText.setText(R.string.ch_75);
                addButton(getString(R.string.way_75_70), 70);
                break;
            case 76:
                mChapterText.setText(R.string.ch_76);
                addButton(getString(R.string.way_76_237), 237);
                addButton(getString(R.string.way_76_310), 310);
                break;
            case 77:
                mChapterText.setText(R.string.ch_77);
                addButton(getString(R.string.way_77_78), 78);
                break;
            case 78:
                mChapterText.setText(R.string.ch_78);
                addButton(getString(R.string.way_78_128), 128);
                break;
            case 79:
                mChapterText.setText(R.string.ch_79);
                addButton(getString(R.string.way_79_51), 51);
                break;
            case 80:
                mChapterText.setText(R.string.ch_80);
                addButton(getString(R.string.way_80_21), 21);
                addButton(getString(R.string.way_80_59), 59);
                addButton(getString(R.string.way_80_149), 149);
                addButton(getString(R.string.way_80_159), 159);
                addButton(getString(R.string.way_80_168), 168);
                addButton(getString(R.string.way_80_330), 330);
                break;
            case 81:
                mChapterText.setText(R.string.ch_81);
                addButton(getString(R.string.way_81_51), 51);
                break;
            case 82:
                mChapterText.setText(R.string.ch_82);
                addButton(getString(R.string.way_82_148), 148);
                break;
            case 83:
                mChapterText.setText(R.string.ch_83);
                addButton(getString(R.string.way_83_170), 170);
                break;
            case 84:
                mChapterText.setText(R.string.ch_84);
                addButton(getString(R.string.way_84_9), 9);
                addButton(getString(R.string.way_84_166), 166);
                break;
            case 85:
                mChapterText.setText(R.string.ch_85);
                addButton(getString(R.string.way_85_31), 31);
                break;
            case 86:
                mChapterText.setText(R.string.ch_86);
                addButton(getString(R.string.way_86_25), 25);
                addButton(getString(R.string.way_86_137), 137);
                break;
            case 87:
                mChapterText.setText(R.string.ch_87);
                addButton(getString(R.string.way_87_306), 306);
                break;
            case 88:
                mChapterText.setText(R.string.ch_88);
                addButton(getString(R.string.way_88_131), 131);
                addButton(getString(R.string.way_88_249), 249);
                break;
            case 89:
                mChapterText.setText(R.string.ch_89);
                addButton(getString(R.string.way_89_1), 1);
                break;
            case 90:
                mChapterText.setText(R.string.ch_90);
                addButton(getString(R.string.way_90_175), 175);
                break;
            /*case 91:
                break;*/
            case 92:
                mChapterText.setText(R.string.ch_92);
                addButton(getString(R.string.way_92_53), 53);
                addButton(getString(R.string.way_92_200), 200);
                break;
            case 93:
                mChapterText.setText(R.string.ch_93);
                addButton(getString(R.string.way_93_103), 103);
                addButton(getString(R.string.way_93_158), 158);
                addButton(getString(R.string.way_93_221), 221);
                break;
            case 94:
                mChapterText.setText(R.string.ch_94);
                addButton(getString(R.string.way_94_7), 7);
                addButton(getString(R.string.way_94_65), 65);
                break;
            case 95:
                mChapterText.setText(R.string.ch_95);
                addButton(getString(R.string.way_95_255), 255);
                break;
            case 96:
                mChapterText.setText(R.string.ch_96);
                addButton(getString(R.string.way_96_47), 47);
                addButton(getString(R.string.way_96_66), 66);
                addButton(getString(R.string.way_96_105), 105);
                addButton(getString(R.string.way_96_123), 123);
                break;
            case 97:
                mChapterText.setText(R.string.ch_97);
                addButton(getString(R.string.way_97_129), 129);
                addButton(getString(R.string.way_97_174), 174);
                addButton(getString(R.string.way_97_186), 186);
                addButton(getString(R.string.way_97_193), 193);
                break;
            case 98:
                mChapterText.setText(R.string.ch_98);
                addButton(getString(R.string.way_98_181), 181);
                break;
            case 99:
                mChapterText.setText(R.string.ch_99);
                addButton(getString(R.string.way_99_106), 106);
                addButton(getString(R.string.way_99_189), 189);
                break;
            case 100:
                mChapterText.setText(R.string.ch_100);
                addButton(getString(R.string.way_100_58), 58);
                break;
            case 101:
                mChapterText.setText(R.string.ch_101);
                addButton(getString(R.string.way_101_20), 20);
                break;
            case 102:
                mChapterText.setText(R.string.ch_102);
                addButton(getString(R.string.way_102_109), 109);
                break;
            case 103:
                mChapterText.setText(R.string.ch_103);
                addButton(getString(R.string.way_103_221), 221);
                break;
            case 104:
                mChapterText.setText(R.string.ch_104);
                addButton(getString(R.string.way_104_15), 15);
                addButton(getString(R.string.way_104_155), 155);
                addButton(getString(R.string.way_104_314), 314);
                break;
            case 105:
                mChapterText.setText(R.string.ch_105);
                addButton(getString(R.string.way_105_181), 181);
                break;
            case 106:
                mChapterText.setText(R.string.ch_106);
                addButton(getString(R.string.way_106_65), 65);
                addButton(getString(R.string.way_106_94), 94);
                break;
            case 107:
                mChapterText.setText(R.string.ch_107);
                addButton(getString(R.string.way_107_110), 110);
                addButton(getString(R.string.way_107_111), 111);
                addButton(getString(R.string.way_107_145), 145);
                break;
            case 108:
                mChapterText.setText(R.string.ch_108);
                addButton(getString(R.string.way_108_110), 110);
                break;
            case 109:
                mChapterText.setText(R.string.ch_109);
                addButton(getString(R.string.way_109_125), 125);
                break;
            case 110:
                mChapterText.setText(R.string.ch_110);
                addButton(getString(R.string.way_110_207), 207);
                break;
            case 111:
                mChapterText.setText(R.string.ch_111);
                addButton(getString(R.string.way_111_145), 145);
                break;
            case 112:
                mChapterText.setText(R.string.ch_112);
                addButton(getString(R.string.way_112_305), 305);
                break;
            case 113:
                mChapterText.setText(R.string.ch_113);
                addButton(getString(R.string.way_113_199), 199);
                break;
            case 114:
                mChapterText.setText(R.string.ch_114);
                addButton(getString(R.string.way_114_25), 25);
                addButton(getString(R.string.way_114_137), 137);
                break;
            case 115:
                mChapterText.setText(R.string.ch_115);
                addButton(getString(R.string.way_115_96), 96);
                break;
            case 116:
                mChapterText.setText(R.string.ch_116);
                addButton(getString(R.string.way_116_185), 185);
                break;
            case 117:
                mChapterText.setText(R.string.ch_117);
                addButton(getString(R.string.way_117_142), 142);
                break;
            case 118:
                mChapterText.setText(R.string.ch_118);
                addButton(getString(R.string.way_118_36), 36);
                addButton(getString(R.string.way_118_120), 120);
                break;
            case 119:
                mChapterText.setText(R.string.ch_119);
                addButton(getString(R.string.way_119_165), 165);
                addButton(getString(R.string.way_119_248), 248);
                break;
            case 120:
                mChapterText.setText(R.string.ch_120);
                addButton(getString(R.string.way_120_39), 39);
                addButton(getString(R.string.way_120_57), 57);
                addButton(getString(R.string.way_120_276), 276);
                break;
            case 121:
                mChapterText.setText(R.string.ch_121);
                addButton(getString(R.string.way_121_18), 18);
                addButton(getString(R.string.way_121_37), 37);
                break;
            case 122:
                mChapterText.setText(R.string.ch_122);
                addButton(getString(R.string.way_122_333), 333);
                break;
            case 123:
                mChapterText.setText(R.string.ch_123);
                addButton(getString(R.string.way_123_17), 17);
                addButton(getString(R.string.way_123_191), 191);
                break;
            case 124:
                mChapterText.setText(R.string.ch_124);
                addButton(getString(R.string.way_124_304), 304);
                addButton(getString(R.string.way_124_337), 337);
                break;
            case 125:
                mChapterText.setText(R.string.ch_125);
                addButton(getString(R.string.way_125_55), 55);
                addButton(getString(R.string.way_125_206_1), 206);
                addButton(getString(R.string.way_125_206_2), 206);
                break;
            case 126:
                mChapterText.setText(R.string.ch_126);
                addButton(getString(R.string.way_126_136), 136);
                break;
            case 127:
                mChapterText.setText(R.string.ch_127);
                addButton(getString(R.string.way_127_252), 252);
                break;
            case 128:
                mChapterText.setText(R.string.ch_128);
                addButton(getString(R.string.way_128_271), 271);
                addButton(getString(R.string.way_128_301), 301);
                addButton(getString(R.string.way_128_336), 336);
                break;
            case 129:
                mChapterText.setText(R.string.ch_129);
                addButton(getString(R.string.way_129_180), 180);
                break;
            case 130:
                mChapterText.setText(R.string.ch_130);
                addButton(getString(R.string.way_130_192_1), 192);
                addButton(getString(R.string.way_130_192_2), 192);
                break;
            case 131:
                mChapterText.setText(R.string.ch_131);
                addButton(getString(R.string.way_131_40), 40);
                addButton(getString(R.string.way_131_257), 257);
                break;
            case 132:
                mChapterText.setText(R.string.ch_132);
                addButton(getString(R.string.way_132_190), 190);
                break;
            case 133:
                mChapterText.setText(R.string.ch_133);
                addButton(getString(R.string.way_133_342), 342);
                addButton(getString(R.string.way_133_343), 343);
                break;
            case 134:
                mChapterText.setText(R.string.ch_134);
                addButton(getString(R.string.way_134_38), 38);
                addButton(getString(R.string.way_134_169), 169);
                break;
            case 135:
                mChapterText.setText(R.string.ch_135);
                addButton(getString(R.string.way_135_13), 13);
                addButton(getString(R.string.way_135_230), 230);
                break;
            case 136:
                mChapterText.setText(R.string.ch_136);
                addButton(getString(R.string.way_136_43), 43);
                addButton(getString(R.string.way_136_63), 63);
                break;
            case 137:
                mChapterText.setText(R.string.ch_137);
                addButton(getString(R.string.way_137_90), 90);
                addButton(getString(R.string.way_137_167), 167);
                break;
            case 138:
                mChapterText.setText(R.string.ch_138);
                addButton(getString(R.string.way_138_4), 4);
                break;
            case 139:
                mChapterText.setText(R.string.ch_139);
                addButton(getString(R.string.way_139_83), 83);
                addButton(getString(R.string.way_139_170), 170);
                break;
            case 140:
                mChapterText.setText(R.string.ch_140);
                addButton(getString(R.string.way_140_179), 179);
                break;
            case 141:
                mChapterText.setText(R.string.ch_141);
                addButton(getString(R.string.way_141_260), 260);
                break;
            case 142:
                mChapterText.setText(R.string.ch_142);
                addButton(getString(R.string.way_142_171), 171);
                addButton(getString(R.string.way_142_177), 177);
                break;
            case 143:
                mChapterText.setText(R.string.ch_143);
                addButton(getString(R.string.way_143_126), 126);
                addButton(getString(R.string.way_143_136), 136);
                break;
            case 144:
                mChapterText.setText(R.string.ch_144);
                addButton(getString(R.string.way_144_60), 60);
                addButton(getString(R.string.way_144_282), 282);
                break;
            case 145:
                mChapterText.setText(R.string.ch_145);
                addButton(getString(R.string.way_145_108), 108);
                break;
            case 146:
                mChapterText.setText(R.string.ch_146);
                addButton(getString(R.string.way_146_129), 129);
                addButton(getString(R.string.way_146_174), 174);
                addButton(getString(R.string.way_146_186), 186);
                addButton(getString(R.string.way_146_193), 193);
                break;
            case 147:
                mChapterText.setText(R.string.ch_147);
                addButton(getString(R.string.way_147_41), 41);
                addButton(getString(R.string.way_147_319), 319);
                break;
            case 148:
                mChapterText.setText(R.string.ch_148);
                addButton(getString(R.string.way_148_143), 143);
                break;
            case 149:
                mChapterText.setText(R.string.ch_149);
                addButton(getString(R.string.way_149_80), 80);
                break;
            case 150:
                mChapterText.setText(R.string.ch_150);
                addButton(getString(R.string.way_150_119), 119);
                break;
            case 151:
                mChapterText.setText(R.string.ch_151);
                addButton(getString(R.string.way_151_270), 270);
                break;
            case 152:
                mChapterText.setText(R.string.ch_152);
                addButton(getString(R.string.way_152_112), 112);
                break;
            case 153:
                mChapterText.setText(R.string.ch_153);
                addButton(getString(R.string.way_153_28), 28);
                break;
            case 154:
                mChapterText.setText(R.string.ch_154);
                addButton(getString(R.string.way_154_176), 176);
                addButton(getString(R.string.way_154_190), 190);
                break;
            case 155:
                mChapterText.setText(R.string.ch_155);
                addButton(getString(R.string.way_155_113), 113);
                break;
            case 156:
                mChapterText.setText(R.string.ch_156);
                addButton(getString(R.string.way_156_21), 21);
                addButton(getString(R.string.way_156_59), 59);
                addButton(getString(R.string.way_156_149), 149);
                addButton(getString(R.string.way_156_159), 159);
                addButton(getString(R.string.way_156_330), 330);
                break;
            case 157:
                mChapterText.setText(R.string.ch_157);
                addButton(getString(R.string.way_157_69), 69);
                addButton(getString(R.string.way_157_275), 275);
                break;
            case 158:
                mChapterText.setText(R.string.ch_158);
                addButton(getString(R.string.way_158_299), 299);
                break;
            case 159:
                mChapterText.setText(R.string.ch_159);
                addButton(getString(R.string.way_159_80), 80);
                break;
            case 160:
                mChapterText.setText(R.string.ch_160);
                addButton(getString(R.string.way_160_72), 72);
                break;
            case 161:
                mChapterText.setText(R.string.ch_161);
                addButton(getString(R.string.way_161_328), 328);
                break;
            /*case 162:
                break;*/
            case 163:
                mChapterText.setText(R.string.ch_163);
                addButton(getString(R.string.way_163_5), 5);
                addButton(getString(R.string.way_163_342), 342);
                break;
            case 164:
                mChapterText.setText(R.string.ch_164);
                addButton(getString(R.string.way_164_329), 329);
                break;
            case 165:
                mChapterText.setText(R.string.ch_165);
                addButton(getString(R.string.way_165_308), 308);
                addButton(getString(R.string.way_165_325), 325);
                break;
            case 166:
                mChapterText.setText(R.string.ch_166);
                addButton(getString(R.string.way_166_133), 133);
                addButton(getString(R.string.way_166_343), 343);
                break;
            case 167:
                mChapterText.setText(R.string.ch_167);
                addButton(getString(R.string.way_167_53), 53);
                addButton(getString(R.string.way_167_92), 92);
                break;
            case 168:
                mChapterText.setText(R.string.ch_168);
                addButton(getString(R.string.way_168_323), 323);
                break;
            case 169:
                mChapterText.setText(R.string.ch_169);
                addButton(getString(R.string.way_169_38), 38);
                break;
            case 170:
                mChapterText.setText(R.string.ch_170);
                addButton(getString(R.string.way_170_214), 214);
                break;
            case 171:
                mChapterText.setText(R.string.ch_171);
                addButton(getString(R.string.way_171_213), 213);
                break;
            /*case 172:
                break;*/
            case 173:
                mChapterText.setText(R.string.ch_173);
                addButton(getString(R.string.way_173_144), 144);
                break;
            case 174:
                mChapterText.setText(R.string.ch_174);
                addButton(getString(R.string.way_174_20), 20);
                addButton(getString(R.string.way_174_101), 101);
                break;
            case 175:
                mChapterText.setText(R.string.ch_175);
                addButton(getString(R.string.way_175_29), 29);
                break;
            case 176:
                mChapterText.setText(R.string.ch_176);
                addButton(getString(R.string.way_176_190), 190);
                break;
            case 177:
                mChapterText.setText(R.string.ch_177);
                addButton(getString(R.string.way_177_171), 171);
                break;
            case 178:
                mChapterText.setText(R.string.ch_178);
                addButton(getString(R.string.way_178_205), 205);
                break;
            case 179:
                mChapterText.setText(R.string.ch_179);
                addButton(getString(R.string.way_179_156), 156);
                break;
            case 180:
                mChapterText.setText(R.string.ch_180);
                addButton(getString(R.string.way_180_46), 46);
                addButton(getString(R.string.way_180_339), 339);
                break;
            case 181:
                mChapterText.setText(R.string.ch_181);
                addButton(getString(R.string.way_181_122_1), 122);
                addButton(getString(R.string.way_181_122_2), 122);
                break;
            case 182:
                mChapterText.setText(R.string.ch_182);
                addButton(getString(R.string.way_182_194), 194);
                break;
            case 183:
                mChapterText.setText(R.string.ch_183);
                addButton(getString(R.string.way_183_112), 112);
                break;
            case 184:
                mChapterText.setText(R.string.ch_184);
                addButton(getString(R.string.way_184_5), 5);
                addButton(getString(R.string.way_184_342), 342);
                break;
            case 185:
                mChapterText.setText(R.string.ch_185);
                addButton(getString(R.string.way_185_328), 328);
                break;
            case 186:
                mChapterText.setText(R.string.ch_186);
                addButton(getString(R.string.way_186_12), 12);
                addButton(getString(R.string.way_186_33), 33);
                break;
            case 187:
                mChapterText.setText(R.string.ch_187);
                addButton(getString(R.string.way_187_104), 104);
                break;
            case 188:
                mChapterText.setText(R.string.ch_188);
                addButton(getString(R.string.way_188_150), 150);
                addButton(getString(R.string.way_188_267), 267);
                break;
            case 189:
                mChapterText.setText(R.string.ch_189);
                addButton(getString(R.string.way_189_65), 65);
                addButton(getString(R.string.way_189_94), 94);
                break;
            case 190:
                mChapterText.setText(R.string.ch_190);
                addButton(getString(R.string.way_190_182), 182);
                addButton(getString(R.string.way_190_194), 194);
                break;
            case 191:
                mChapterText.setText(R.string.ch_191);
                addButton(getString(R.string.way_191_98), 98);
                break;
            case 192:
                mChapterText.setText(R.string.ch_192);
                addButton(getString(R.string.way_192_225), 225);
                break;
            case 193:
                mChapterText.setText(R.string.ch_193);
                addButton(getString(R.string.way_193_86), 86);
                addButton(getString(R.string.way_193_175), 175);
                break;
            case 194:
                mChapterText.setText(R.string.ch_194);
                addButton(getString(R.string.way_194_334), 334);
                break;
            /*case 195:
                break;*/
            case 196:
                mChapterText.setText(R.string.ch_196);
                addButton(getString(R.string.way_196_153), 153);
                break;
            case 197:
                mChapterText.setText(R.string.ch_197);
                addButton(getString(R.string.way_197_242), 242);
                break;
            case 198:
                mChapterText.setText(R.string.ch_198);
                addButton(getString(R.string.way_198_28), 28);
                addButton(getString(R.string.way_198_196), 196);
                break;
            case 199:
                mChapterText.setText(R.string.ch_199);
                addButton(getString(R.string.way_199_117), 117);
                addButton(getString(R.string.way_199_327), 327);
                break;
            case 200:
                mChapterText.setText(R.string.ch_200);
                addButton(getString(R.string.way_200_53), 53);
                break;
            case 201:
                mChapterText.setText(R.string.ch_201);
                addButton(getString(R.string.way_201_85), 85);
                break;
            case 202:
                mChapterText.setText(R.string.ch_202);
                addButton(getString(R.string.way_202_210), 210);
                addButton(getString(R.string.way_202_226), 226);
                break;
            case 203:
                mChapterText.setText(R.string.ch_203);
                addButton(getString(R.string.way_203_208), 208);
                addButton(getString(R.string.way_203_264), 264);
                break;
            /*case 204:
                break;*/
            case 205:
                mChapterText.setText(R.string.ch_205);
                addButton(getString(R.string.way_205_3), 3);
                addButton(getString(R.string.way_205_198), 198);
                break;
            case 206:
                mChapterText.setText(R.string.ch_206);
                addButton(getString(R.string.way_206_107), 107);
                break;
            case 207:
                mChapterText.setText(R.string.ch_207);
                addButton(getString(R.string.way_207_224), 224);
                addButton(getString(R.string.way_207_266), 266);
                break;
            case 208:
                mChapterText.setText(R.string.ch_208);
                addButton(getString(R.string.way_208_261), 261);
                break;
            case 209:
                mChapterText.setText(R.string.ch_209);
                addButton(getString(R.string.way_209_348), 348);
                break;
            case 210:
                mChapterText.setText(R.string.ch_210);
                addButton(getString(R.string.way_210_202), 202);
                break;
            case 211:
                mChapterText.setText(R.string.ch_211);
                addButton(getString(R.string.way_211_241), 241);
                addButton(getString(R.string.way_211_281), 281);
                addButton(getString(R.string.way_211_297), 297);
                break;
            case 212:
                mChapterText.setText(R.string.ch_212);
                addButton(getString(R.string.way_212_240), 240);
                addButton(getString(R.string.way_212_296), 296);
                break;
            case 213:
                mChapterText.setText(R.string.ch_213);
                addButton(getString(R.string.way_213_188), 188);
                break;
            case 214:
                mChapterText.setText(R.string.ch_214);
                addButton(getString(R.string.way_214_26), 26);
                addButton(getString(R.string.way_214_178), 178);
                break;
            case 215:
                mChapterText.setText(R.string.ch_215);
                addButton(getString(R.string.way_215_128), 128);
                break;
            case 216:
                mChapterText.setText(R.string.ch_216);
                addButton(getString(R.string.way_216_22), 22);
                break;
            case 217:
                mChapterText.setText(R.string.ch_217);
                addButton(getString(R.string.way_217_300), 300);
                break;
            case 218:
                mChapterText.setText(R.string.ch_218);
                addButton(getString(R.string.way_218_28), 28);
                break;
            case 219:
                mChapterText.setText(R.string.ch_219);
                addButton(getString(R.string.way_219_266), 266);
                break;
            case 220:
                mChapterText.setText(R.string.ch_220);
                addButton(getString(R.string.way_220_234), 234);
                addButton(getString(R.string.way_220_235), 235);
                addButton(getString(R.string.way_220_240), 240);
                break;
            case 221:
                mChapterText.setText(R.string.ch_221);
                addButton(getString(R.string.way_221_299), 299);
                break;
            case 222:
                mChapterText.setText(R.string.ch_222);
                addButton(getString(R.string.way_222_228), 228);
                addButton(getString(R.string.way_222_235), 235);
                break;
            case 223:
                mChapterText.setText(R.string.ch_223);
                addButton(getString(R.string.way_223_96), 96);
                break;
            case 224:
                mChapterText.setText(R.string.ch_224);
                addButton(getString(R.string.way_224_219), 219);
                break;
            case 225:
                mChapterText.setText(R.string.ch_225);
                addButton(getString(R.string.way_225_96), 96);
                addButton(getString(R.string.way_225_223), 223);
                break;
            case 226:
                mChapterText.setText(R.string.ch_226);
                addButton(getString(R.string.way_226_202), 202);
                addButton(getString(R.string.way_226_294), 294);
                addButton(getString(R.string.way_226_296), 296);
                break;
            case 227:
                mChapterText.setText(R.string.ch_227);
                addButton(getString(R.string.way_227_297), 297);
                addButton(getString(R.string.way_227_341), 341);
                break;
            case 228:
                mChapterText.setText(R.string.ch_228);
                addButton(getString(R.string.way_228_222), 222);
                break;
            case 229:
                mChapterText.setText(R.string.ch_229);
                addButton(getString(R.string.way_229_35), 35);
                addButton(getString(R.string.way_229_197), 197);
                break;
            case 230:
                mChapterText.setText(R.string.ch_230);
                addButton(getString(R.string.way_230_88), 88);
                break;
            case 231:
                mChapterText.setText(R.string.ch_231);
                addButton(getString(R.string.way_231_82), 82);
                break;
            case 232:
                mChapterText.setText(R.string.ch_232);
                addButton(getString(R.string.way_232_81), 81);
                break;
            /*case 233:
                break;*/
            case 234:
                mChapterText.setText(R.string.ch_234);
                addButton(getString(R.string.way_234_220), 220);
                addButton(getString(R.string.way_234_241), 241);
                break;
            case 235:
                mChapterText.setText(R.string.ch_235);
                addButton(getString(R.string.way_235_220), 220);
                addButton(getString(R.string.way_235_222), 222);
                break;
            /*case 236:
                break;*/
            case 237:
                mChapterText.setText(R.string.ch_237);
                addButton(getString(R.string.way_237_79), 79);
                break;
            case 238:
                mChapterText.setText(R.string.ch_238);
                addButton(getString(R.string.way_238_241), 241);
                break;
            case 239:
                mChapterText.setText(R.string.ch_239);
                addButton(getString(R.string.way_239_24), 24);
                addButton(getString(R.string.way_239_318), 318);
                break;
            case 240:
                mChapterText.setText(R.string.ch_240);
                addButton(getString(R.string.way_240_212), 212);
                addButton(getString(R.string.way_240_220), 220);
                break;
            case 241:
                mChapterText.setText(R.string.ch_241);
                addButton(getString(R.string.way_241_211), 211);
                addButton(getString(R.string.way_241_234), 234);
                addButton(getString(R.string.way_241_238), 238);
                break;
            case 242:
                mChapterText.setText(R.string.ch_242);
                addButton(getString(R.string.way_242_8), 8);
                break;
            /*case 243:
                break;*/
            case 244:
                mChapterText.setText(R.string.ch_244);
                addButton(getString(R.string.way_244_259), 259);
                addButton(getString(R.string.way_244_295), 295);
                break;
            case 245:
                mChapterText.setText(R.string.ch_245);
                addButton(getString(R.string.way_245_6), 6);
                addButton(getString(R.string.way_245_127), 127);
                break;
            case 246:
                mChapterText.setText(R.string.ch_246);
                addButton(getString(R.string.way_246_258), 258);
                addButton(getString(R.string.way_246_262), 262);
                break;
            case 247:
                mChapterText.setText(R.string.ch_247);
                addButton(getString(R.string.way_247_296), 296);
                break;
            case 248:
                mChapterText.setText(R.string.ch_248);
                addButton(getString(R.string.way_248_165), 165);
                break;
            case 249:
                mChapterText.setText(R.string.ch_249);
                addButton(getString(R.string.way_249_131), 131);
                break;
            case 250:
                mChapterText.setText(R.string.ch_250);
                addButton(getString(R.string.way_250_316), 316);
                break;
            case 251:
                mChapterText.setText(R.string.ch_251);
                addButton(getString(R.string.way_251_239), 239);
                break;
            case 252:
                mChapterText.setText(R.string.ch_252);
                addButton(getString(R.string.way_252_74), 74);
                addButton(getString(R.string.way_252_246), 246);
                break;
            case 253:
                mChapterText.setText(R.string.ch_253);
                addButton(getString(R.string.way_253_227), 227);
                addButton(getString(R.string.way_253_269), 269);
                break;
            case 254:
                mChapterText.setText(R.string.ch_254);
                addButton(getString(R.string.way_254_163), 163);
                addButton(getString(R.string.way_254_289), 289);
                break;
            case 255:
                mChapterText.setText(R.string.ch_255);
                addButton(getString(R.string.way_255_10), 10);
                addButton(getString(R.string.way_255_231), 231);
                break;
            /*case 256:
                break;*/
            case 257:
                mChapterText.setText(R.string.ch_257);
                addButton(getString(R.string.way_257_27), 27);
                addButton(getString(R.string.way_257_84), 84);
                break;
            case 258:
                mChapterText.setText(R.string.ch_258);
                addButton(getString(R.string.way_258_250), 250);
                break;
            case 259:
                mChapterText.setText(R.string.ch_259);
                addButton(getString(R.string.way_259_244), 244);
                break;
            case 260:
                mChapterText.setText(R.string.ch_260);
                addButton(getString(R.string.way_260_141), 141);
                addButton(getString(R.string.way_260_187), 187);
                addButton(getString(R.string.way_260_287), 287);
                addButton(getString(R.string.way_260_312), 312);
                break;
            case 261:
                mChapterText.setText(R.string.ch_261);
                addButton(getString(R.string.way_261_277), 277);
                addButton(getString(R.string.way_261_290), 290);
                break;
            case 262:
                mChapterText.setText(R.string.ch_262);
                addButton(getString(R.string.way_262_250), 250);
                break;
            case 263:
                mChapterText.setText(R.string.ch_263);
                addButton(getString(R.string.way_263_13), 13);
                addButton(getString(R.string.way_263_230), 230);
                break;
            case 264:
                mChapterText.setText(R.string.ch_264);
                addButton(getString(R.string.way_264_203), 203);
                addButton(getString(R.string.way_264_294), 294);
                break;
            case 265:
                mChapterText.setText(R.string.ch_265);
                addButton(getString(R.string.way_265_135), 135);
                addButton(getString(R.string.way_265_263), 263);
                break;
            case 266:
                mChapterText.setText(R.string.ch_266);
                addButton(getString(R.string.way_266_73), 73);
                break;
            case 267:
                mChapterText.setText(R.string.ch_267);
                addButton(getString(R.string.way_267_119), 119);
                break;
            case 268:
                mChapterText.setText(R.string.ch_268);
                addButton(getString(R.string.way_268_157), 157);
                break;
            case 269:
                mChapterText.setText(R.string.ch_269);
                addButton(getString(R.string.way_269_293), 293);
                addButton(getString(R.string.way_269_341), 341);
                break;
            case 270:
                mChapterText.setText(R.string.ch_270);
                addButton(getString(R.string.way_270_75), 75);
                break;
            case 271:
                mChapterText.setText(R.string.ch_271);
                addButton(getString(R.string.way_271_265), 265);
                break;
            case 272:
                mChapterText.setText(R.string.ch_272);
                addButton(getString(R.string.way_272_280), 280);
                break;
            case 273:
                mChapterText.setText(R.string.ch_273);
                addButton(getString(R.string.way_273_239_1), 239);
                addButton(getString(R.string.way_273_239_2), 239);
                addButton(getString(R.string.way_273_239_3), 239);
                break;
            /*case 274:
                break;*/
            case 275:
                mChapterText.setText(R.string.ch_275);
                addButton(getString(R.string.way_275_70), 70);
                break;
            case 276:
                mChapterText.setText(R.string.ch_276);
                addButton(getString(R.string.way_276_95), 95);
                break;
            case 277:
                mChapterText.setText(R.string.ch_277);
                addButton(getString(R.string.way_277_290), 290);
                break;
            case 278:
                mChapterText.setText(R.string.ch_278);
                addButton(getString(R.string.way_278_147), 147);
                break;
            case 279:
                mChapterText.setText(R.string.ch_279);
                addButton(getString(R.string.way_279_326), 326);
                break;
            case 280:
                mChapterText.setText(R.string.ch_280);
                addButton(getString(R.string.way_280_100), 100);
                addButton(getString(R.string.way_280_173), 173);
                break;
            case 281:
                mChapterText.setText(R.string.ch_281);
                addButton(getString(R.string.way_281_211), 211);
                addButton(getString(R.string.way_281_300), 300);
                break;
            case 282:
                mChapterText.setText(R.string.ch_282);
                addButton(getString(R.string.way_282_209_1), 209);
                addButton(getString(R.string.way_282_209_2), 209);
                break;
            case 283:
                mChapterText.setText(R.string.ch_283);
                addButton(getString(R.string.way_283_209_1), 209);
                addButton(getString(R.string.way_283_209_2), 209);
                break;
            case 284:
                mChapterText.setText(R.string.ch_284);
                addButton(getString(R.string.way_284_184), 184);
                addButton(getString(R.string.way_284_286), 286);
                break;
            /*case 285:
                break;*/
            case 286:
                mChapterText.setText(R.string.ch_286);
                addButton(getString(R.string.way_286_44), 44);
                break;
            case 287:
                mChapterText.setText(R.string.ch_287);
                addButton(getString(R.string.way_287_260), 260);
                break;
            /*case 288:
                break;*/
            case 289:
                mChapterText.setText(R.string.ch_289);
                addButton(getString(R.string.way_289_133), 133);
                addButton(getString(R.string.way_289_343), 343);
                break;
            case 290:
                mChapterText.setText(R.string.ch_290);
                addButton(getString(R.string.way_290_132), 132);
                addButton(getString(R.string.way_290_154), 154);
                break;
            case 291:
                mChapterText.setText(R.string.ch_291);
                addButton(getString(R.string.way_291_350), 350);
                break;
            case 292:
                mChapterText.setText(R.string.ch_292);
                addButton(getString(R.string.way_292_229), 229);
                break;
            case 293:
                mChapterText.setText(R.string.ch_293);
                addButton(getString(R.string.way_293_269), 269);
                addButton(getString(R.string.way_293_295), 295);
                break;
            case 294:
                mChapterText.setText(R.string.ch_294);
                addButton(getString(R.string.way_294_226), 226);
                addButton(getString(R.string.way_294_264), 264);
                break;
            case 295:
                mChapterText.setText(R.string.ch_295);
                addButton(getString(R.string.way_295_244), 244);
                addButton(getString(R.string.way_295_293), 293);
                break;
            case 296:
                mChapterText.setText(R.string.ch_296);
                addButton(getString(R.string.way_296_212), 212);
                addButton(getString(R.string.way_296_226), 226);
                addButton(getString(R.string.way_296_247), 247);
                break;
            case 297:
                mChapterText.setText(R.string.ch_297);
                addButton(getString(R.string.way_297_211), 211);
                addButton(getString(R.string.way_297_227), 227);
                break;
            case 298:
                mChapterText.setText(R.string.ch_298);
                addButton(getString(R.string.way_298_229), 229);
                break;
            case 299:
                mChapterText.setText(R.string.ch_299);
                addButton(getString(R.string.way_299_350), 350);
                break;
            case 300:
                mChapterText.setText(R.string.ch_300);
                addButton(getString(R.string.way_300_217), 217);
                addButton(getString(R.string.way_300_281), 281);
                break;
            case 301:
                mChapterText.setText(R.string.ch_301);
                addButton(getString(R.string.way_301_271), 271);
                addButton(getString(R.string.way_301_336), 336);
                break;
            case 302:
                mChapterText.setText(R.string.ch_302);
                addButton(getString(R.string.way_302_331), 331);
                break;
            case 303:
                mChapterText.setText(R.string.ch_303);
                addButton(getString(R.string.way_303_335), 335);
                break;
            case 304:
                mChapterText.setText(R.string.ch_304);
                addButton(getString(R.string.way_304_93), 93);
                break;
            case 305:
                mChapterText.setText(R.string.ch_305);
                addButton(getString(R.string.way_305_335), 335);
                break;
            case 306:
                mChapterText.setText(R.string.ch_306);
                addButton(getString(R.string.way_306_2), 2);
                addButton(getString(R.string.way_306_3), 3);
                addButton(getString(R.string.way_306_198), 198);
                break;
            case 307:
                mChapterText.setText(R.string.ch_307);
                addButton(getString(R.string.way_307_309), 309);
                break;
            case 308:
                mChapterText.setText(R.string.ch_308);
                addButton(getString(R.string.way_308_324), 324);
                break;
            case 309:
                mChapterText.setText(R.string.ch_309);
                addButton(getString(R.string.way_309_338), 338);
                break;
            case 310:
                mChapterText.setText(R.string.ch_310);
                addButton(getString(R.string.way_310_79), 79);
                break;
            case 311:
                mChapterText.setText(R.string.ch_311);
                addButton(getString(R.string.way_311_23), 23);
                break;
            case 312:
                mChapterText.setText(R.string.ch_312);
                addButton(getString(R.string.way_312_260), 260);
                break;
            case 313:
                mChapterText.setText(R.string.ch_313);
                addButton(getString(R.string.way_313_245), 245);
                break;
            case 314:
                mChapterText.setText(R.string.ch_314);
                addButton(getString(R.string.way_314_113), 113);
                break;
            case 315:
                mChapterText.setText(R.string.ch_315);
                addButton(getString(R.string.way_315_116), 116);
                break;
            case 316:
                mChapterText.setText(R.string.ch_316);
                addButton(getString(R.string.way_316_77), 77);
                addButton(getString(R.string.way_316_78), 78);
                break;
            case 317:
                mChapterText.setText(R.string.ch_317);
                addButton(getString(R.string.way_317_157), 157);
                addButton(getString(R.string.way_317_268), 268);
                break;
            case 318:
                mChapterText.setText(R.string.ch_318);
                addButton(getString(R.string.way_318_152), 152);
                addButton(getString(R.string.way_318_183), 183);
                break;
            case 319:
                mChapterText.setText(R.string.ch_319);
                addButton(getString(R.string.way_319_41), 41);
                break;
            case 320:
                mChapterText.setText(R.string.ch_320);
                addButton(getString(R.string.way_320_316), 316);
                break;
            case 321:
                mChapterText.setText(R.string.ch_321);
                addButton(getString(R.string.way_321_279), 279);
                addButton(getString(R.string.way_321_326), 326);
                break;
            case 322:
                mChapterText.setText(R.string.ch_322);
                addButton(getString(R.string.way_322_188), 188);
                break;
            case 323:
                mChapterText.setText(R.string.ch_323);
                addButton(getString(R.string.way_323_52_1), 52);
                addButton(getString(R.string.way_323_52_2), 52);
                break;
            case 324:
                mChapterText.setText(R.string.ch_324);
                addButton(getString(R.string.way_324_151), 151);
                addButton(getString(R.string.way_324_317), 317);
                break;
            case 325:
                mChapterText.setText(R.string.ch_325);
                addButton(getString(R.string.way_325_308), 308);
                break;
            case 326:
                mChapterText.setText(R.string.ch_326);
                addButton(getString(R.string.way_326_322), 322);
                break;
            case 327:
                mChapterText.setText(R.string.ch_327);
                addButton(getString(R.string.way_327_321), 321);
                break;
            case 328:
                mChapterText.setText(R.string.ch_328);
                addButton(getString(R.string.way_328_11), 11);
                addButton(getString(R.string.way_328_56), 56);
                break;
            case 329:
                mChapterText.setText(R.string.ch_329);
                addButton(getString(R.string.way_329_328), 328);
                break;
            case 330:
                mChapterText.setText(R.string.ch_330);
                addButton(getString(R.string.way_330_80), 80);
                break;
            case 331:
                mChapterText.setText(R.string.ch_331);
                addButton(getString(R.string.way_331_303), 303);
                break;
            case 332:
                mChapterText.setText(R.string.ch_332);
                addButton(getString(R.string.way_332_331), 331);
                break;
            case 333:
                mChapterText.setText(R.string.ch_333);
                addButton(getString(R.string.way_333_19), 19);
                break;
            case 334:
                mChapterText.setText(R.string.ch_334);
                addButton(getString(R.string.way_334_273), 273);
                break;
            case 335:
                mChapterText.setText(R.string.ch_335);
                addButton(getString(R.string.way_335_102), 102);
                addButton(getString(R.string.way_335_272), 272);
                addButton(getString(R.string.way_335_280_1), 280);
                addButton(getString(R.string.way_335_280_2), 280);
                break;
            case 336:
                mChapterText.setText(R.string.ch_336);
                addButton(getString(R.string.way_336_271), 271);
                break;
            case 337:
                mChapterText.setText(R.string.ch_337);
                addButton(getString(R.string.way_337_93), 93);
                break;
            case 338:
                // Это финальная глава игры
                mChapterText.setText(R.string.ch_338);
                addButton(getString(R.string.way_338_351), 351);
                break;
            case 339:
                mChapterText.setText(R.string.ch_339);
                addButton(getString(R.string.way_339_129), 129);
                addButton(getString(R.string.way_339_174), 174);
                addButton(getString(R.string.way_339_186), 186);
                addButton(getString(R.string.way_339_193), 193);
                break;
            case 340:
                mChapterText.setText(R.string.ch_340);
                addButton(getString(R.string.way_340_260), 260);
                break;
            case 341:
                mChapterText.setText(R.string.ch_341);
                addButton(getString(R.string.way_341_227), 227);
                addButton(getString(R.string.way_341_269), 269);
                break;
            case 342:
                mChapterText.setText(R.string.ch_342);
                addButton(getString(R.string.way_342_44), 44);
                break;
            case 343:
                mChapterText.setText(R.string.ch_343);
                addButton(getString(R.string.way_343_311), 311);
                break;
            case 344:
                mChapterText.setText(R.string.ch_344);
                addButton(getString(R.string.way_344_89), 89);
                break;
            case 345:
                mChapterText.setText(R.string.ch_345);
                addButton(getString(R.string.way_345_339), 339);
                break;
            case 346:
                mChapterText.setText(R.string.ch_346);
                addButton(getString(R.string.way_346_89), 89);
                break;
            case 347:
                mChapterText.setText(R.string.ch_347);
                addButton(getString(R.string.way_347_298), 298);
                break;
            case 348:
                mChapterText.setText(R.string.ch_348);
                addButton(getString(R.string.way_348_102), 102);
                addButton(getString(R.string.way_348_239), 239);
                addButton(getString(R.string.way_348_251), 251);
                addButton(getString(R.string.way_348_280), 280);
                break;
            /*case 349:
                break;*/
            case 350:
                mChapterText.setText(R.string.ch_350);
                addButton(getString(R.string.way_350_201), 201);
                addButton(getString(R.string.way_350_291), 291);
                break;
            case 351:
                // Переадресация на Rate активити для оценки приложения
                Intent intent = new Intent(this, Rate.class);
                startActivity(intent);
                break;
        }
    }


}
