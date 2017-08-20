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

public class GameProcess extends AppCompatActivity {

    private TextView mChapterText;
    private LinearLayout mButtonContainer;
    private int mChapterNumber;
    private SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_process);

        // Инициализируем необходимые вью элементы
        mButtonContainer = (LinearLayout) findViewById(R.id.button_container);
        mChapterText = (TextView) findViewById(R.id.chapter_text);

        // Получаем SharedPreferences
        mSharedPref = getPreferences(Context.MODE_PRIVATE);

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
        mSharedPref = getPreferences(Context.MODE_PRIVATE);
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
        switch (mChapterNumber) {
            case 0:
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
                addButton(getString(R.string.way_2), 555);
                break;
            case 3:
                mChapterText.setText(R.string.ch_3);
                addButton(getString(R.string.way_3), 555);
                break;
            case 4:
                mChapterText.setText(R.string.ch_4);
                addButton(getString(R.string.way_4), 555);
                break;
            case 5:
                mChapterText.setText(R.string.ch_5);
                addButton(getString(R.string.way_5), 555);
                break;
            case 6:
                mChapterText.setText(R.string.ch_6);
                addButton(getString(R.string.way_6), 555);
                break;
            case 7:
                mChapterText.setText(R.string.ch_7);
                addButton(getString(R.string.way_7), 555);
                break;
            case 8:
                mChapterText.setText(R.string.ch_8);
                addButton(getString(R.string.way_8), 555);
                break;
            case 9:
                mChapterText.setText(R.string.ch_9);
                addButton(getString(R.string.way_9), 555);
                break;
            case 10:
                mChapterText.setText(R.string.ch_10);
                addButton(getString(R.string.way_10), 555);
                break;
            case 11:
                mChapterText.setText(R.string.ch_11);
                addButton(getString(R.string.way_11), 555);
                break;
            case 12:
                mChapterText.setText(R.string.ch_12);
                addButton(getString(R.string.way_12), 555);
                break;
            case 13:
                mChapterText.setText(R.string.ch_13);
                addButton(getString(R.string.way_13), 555);
                break;
            case 14:
                mChapterText.setText(R.string.ch_14);
                addButton(getString(R.string.way_14), 555);
                break;
            case 15:
                mChapterText.setText(R.string.ch_15);
                addButton(getString(R.string.way_15), 555);
                break;
            case 16:
                mChapterText.setText(R.string.ch_16);
                addButton(getString(R.string.way_16), 555);
                break;
            case 17:
                mChapterText.setText(R.string.ch_17);
                addButton(getString(R.string.way_17), 555);
                break;
            case 18:
                mChapterText.setText(R.string.ch_18);
                addButton(getString(R.string.way_18), 555);
                break;
            case 19:
                mChapterText.setText(R.string.ch_19);
                addButton(getString(R.string.way_19), 555);
                break;
            case 20:
                mChapterText.setText(R.string.ch_20);
                addButton(getString(R.string.way_20), 555);
                break;
            case 21:
                mChapterText.setText(R.string.ch_21);
                addButton(getString(R.string.way_21), 555);
                break;
            case 22:
                mChapterText.setText(R.string.ch_22);
                addButton(getString(R.string.way_22), 555);
                break;
            case 23:
                mChapterText.setText(R.string.ch_23);
                addButton(getString(R.string.way_23), 555);
                break;
            case 24:
                mChapterText.setText(R.string.ch_24);
                addButton(getString(R.string.way_24), 555);
                break;
            case 25:
                mChapterText.setText(R.string.ch_25);
                addButton(getString(R.string.way_25), 555);
                break;
            case 26:
                mChapterText.setText(R.string.ch_26);
                addButton(getString(R.string.way_26), 555);
                break;
            case 27:
                mChapterText.setText(R.string.ch_27);
                addButton(getString(R.string.way_27), 555);
                break;
            case 28:
                mChapterText.setText(R.string.ch_28);
                addButton(getString(R.string.way_28), 555);
                break;
            case 29:
                mChapterText.setText(R.string.ch_29);
                addButton(getString(R.string.way_29), 555);
                break;
            case 30:
                mChapterText.setText(R.string.ch_30);
                addButton(getString(R.string.way_30), 555);
                break;
            case 31:
                mChapterText.setText(R.string.ch_31);
                addButton(getString(R.string.way_31), 555);
                break;
            case 32:
                mChapterText.setText(R.string.ch_32);
                addButton(getString(R.string.way_32), 555);
                break;
            case 33:
                mChapterText.setText(R.string.ch_33);
                addButton(getString(R.string.way_33), 555);
                break;
            case 34:
                mChapterText.setText(R.string.ch_34);
                addButton(getString(R.string.way_34), 555);
                break;
            case 35:
                mChapterText.setText(R.string.ch_35);
                addButton(getString(R.string.way_35), 555);
                break;
            case 36:
                mChapterText.setText(R.string.ch_36);
                addButton(getString(R.string.way_36), 555);
                break;
            case 37:
                mChapterText.setText(R.string.ch_37);
                addButton(getString(R.string.way_37), 555);
                break;
            case 38:
                mChapterText.setText(R.string.ch_38);
                addButton(getString(R.string.way_38), 555);
                break;
            case 39:
                mChapterText.setText(R.string.ch_39);
                addButton(getString(R.string.way_39), 555);
                break;
            case 40:
                mChapterText.setText(R.string.ch_40);
                addButton(getString(R.string.way_40), 555);
                break;
            case 41:
                mChapterText.setText(R.string.ch_41);
                addButton(getString(R.string.way_41), 555);
                break;
            case 42:
                mChapterText.setText(R.string.ch_42);
                addButton(getString(R.string.way_42), 555);
                break;
            case 43:
                mChapterText.setText(R.string.ch_43);
                addButton(getString(R.string.way_43), 555);
                break;
            case 44:
                mChapterText.setText(R.string.ch_44);
                addButton(getString(R.string.way_44), 555);
                break;
            case 45:
                mChapterText.setText(R.string.ch_45);
                addButton(getString(R.string.way_45), 555);
                break;
            case 46:
                mChapterText.setText(R.string.ch_46);
                addButton(getString(R.string.way_46), 555);
                break;
            case 47:
                mChapterText.setText(R.string.ch_47);
                addButton(getString(R.string.way_47), 555);
                break;
            case 48:
                mChapterText.setText(R.string.ch_48);
                addButton(getString(R.string.way_48), 555);
                break;
            case 49:
                mChapterText.setText(R.string.ch_49);
                addButton(getString(R.string.way_49), 555);
                break;
            case 50:
                mChapterText.setText(R.string.ch_50);
                addButton(getString(R.string.way_50), 555);
                break;
            case 51:
                mChapterText.setText(R.string.ch_51);
                addButton(getString(R.string.way_51), 555);
                break;
            case 52:
                mChapterText.setText(R.string.ch_52);
                addButton(getString(R.string.way_52), 555);
                break;
            case 53:
                mChapterText.setText(R.string.ch_53);
                addButton(getString(R.string.way_53), 555);
                break;
            case 54:
                mChapterText.setText(R.string.ch_54);
                addButton(getString(R.string.way_54), 555);
                break;
            case 55:
                mChapterText.setText(R.string.ch_55);
                addButton(getString(R.string.way_55), 555);
                break;
            case 56:
                mChapterText.setText(R.string.ch_56);
                addButton(getString(R.string.way_56), 555);
                break;
            case 57:
                mChapterText.setText(R.string.ch_57);
                addButton(getString(R.string.way_57), 555);
                break;
            case 58:
                mChapterText.setText(R.string.ch_58);
                addButton(getString(R.string.way_58), 555);
                break;
            case 59:
                mChapterText.setText(R.string.ch_59);
                addButton(getString(R.string.way_59), 555);
                break;
            case 60:
                mChapterText.setText(R.string.ch_60);
                addButton(getString(R.string.way_60), 555);
                break;
            case 61:
                mChapterText.setText(R.string.ch_61);
                addButton(getString(R.string.way_61), 555);
                break;
            case 62:
                mChapterText.setText(R.string.ch_62);
                addButton(getString(R.string.way_62), 555);
                break;
            case 63:
                mChapterText.setText(R.string.ch_63);
                addButton(getString(R.string.way_63), 555);
                break;
            case 64:
                mChapterText.setText(R.string.ch_64);
                addButton(getString(R.string.way_64), 555);
                break;
            case 65:
                mChapterText.setText(R.string.ch_65);
                addButton(getString(R.string.way_65), 555);
                break;
            case 66:
                mChapterText.setText(R.string.ch_66);
                addButton(getString(R.string.way_66), 555);
                break;
            case 67:
                mChapterText.setText(R.string.ch_67);
                addButton(getString(R.string.way_67), 555);
                break;
            case 68:
                mChapterText.setText(R.string.ch_68);
                addButton(getString(R.string.way_68), 555);
                break;
            case 69:
                mChapterText.setText(R.string.ch_69);
                addButton(getString(R.string.way_69), 555);
                break;
            case 70:
                mChapterText.setText(R.string.ch_70);
                addButton(getString(R.string.way_70), 555);
                break;
            case 71:
                mChapterText.setText(R.string.ch_71);
                addButton(getString(R.string.way_71), 555);
                break;
            case 72:
                mChapterText.setText(R.string.ch_72);
                addButton(getString(R.string.way_72), 555);
                break;
            case 73:
                mChapterText.setText(R.string.ch_73);
                addButton(getString(R.string.way_73), 555);
                break;
            case 74:
                mChapterText.setText(R.string.ch_74);
                addButton(getString(R.string.way_74), 555);
                break;
            case 75:
                mChapterText.setText(R.string.ch_75);
                addButton(getString(R.string.way_75), 555);
                break;
            case 76:
                mChapterText.setText(R.string.ch_76);
                addButton(getString(R.string.way_76), 555);
                break;
            case 77:
                mChapterText.setText(R.string.ch_77);
                addButton(getString(R.string.way_77), 555);
                break;
            case 78:
                mChapterText.setText(R.string.ch_78);
                addButton(getString(R.string.way_78), 555);
                break;
            case 79:
                mChapterText.setText(R.string.ch_79);
                addButton(getString(R.string.way_79), 555);
                break;
            case 80:
                mChapterText.setText(R.string.ch_80);
                addButton(getString(R.string.way_80), 555);
                break;
            case 81:
                mChapterText.setText(R.string.ch_81);
                addButton(getString(R.string.way_81), 555);
                break;
            case 82:
                mChapterText.setText(R.string.ch_82);
                addButton(getString(R.string.way_82), 555);
                break;
            case 83:
                mChapterText.setText(R.string.ch_83);
                addButton(getString(R.string.way_83), 555);
                break;
            case 84:
                mChapterText.setText(R.string.ch_84);
                addButton(getString(R.string.way_84), 555);
                break;
            case 85:
                mChapterText.setText(R.string.ch_85);
                addButton(getString(R.string.way_85), 555);
                break;
            case 86:
                mChapterText.setText(R.string.ch_86);
                addButton(getString(R.string.way_86), 555);
                break;
            case 87:
                mChapterText.setText(R.string.ch_87);
                addButton(getString(R.string.way_87), 555);
                break;
            case 88:
                mChapterText.setText(R.string.ch_88);
                addButton(getString(R.string.way_88), 555);
                break;
            case 89:
                mChapterText.setText(R.string.ch_89);
                addButton(getString(R.string.way_89), 555);
                break;
            case 90:
                mChapterText.setText(R.string.ch_90);
                addButton(getString(R.string.way_90), 555);
                break;
            case 91:
                mChapterText.setText(R.string.ch_91);
                addButton(getString(R.string.way_91), 555);
                break;
            case 92:
                mChapterText.setText(R.string.ch_92);
                addButton(getString(R.string.way_92), 555);
                break;
            case 93:
                mChapterText.setText(R.string.ch_93);
                addButton(getString(R.string.way_93), 555);
                break;
            case 94:
                mChapterText.setText(R.string.ch_94);
                addButton(getString(R.string.way_94), 555);
                break;
            case 95:
                mChapterText.setText(R.string.ch_95);
                addButton(getString(R.string.way_95), 555);
                break;
            case 96:
                mChapterText.setText(R.string.ch_96);
                addButton(getString(R.string.way_96), 555);
                break;
            case 97:
                mChapterText.setText(R.string.ch_97);
                addButton(getString(R.string.way_97), 555);
                break;
            case 98:
                mChapterText.setText(R.string.ch_98);
                addButton(getString(R.string.way_98), 555);
                break;
            case 99:
                mChapterText.setText(R.string.ch_99);
                addButton(getString(R.string.way_99), 555);
                break;
            case 100:
                mChapterText.setText(R.string.ch_100);
                addButton(getString(R.string.way_100), 555);
                break;
            case 101:
                mChapterText.setText(R.string.ch_101);
                addButton(getString(R.string.way_101), 555);
                break;
            case 102:
                mChapterText.setText(R.string.ch_102);
                addButton(getString(R.string.way_102), 555);
                break;
            case 103:
                mChapterText.setText(R.string.ch_103);
                addButton(getString(R.string.way_103), 555);
                break;
            case 104:
                mChapterText.setText(R.string.ch_104);
                addButton(getString(R.string.way_104), 555);
                break;
            case 105:
                mChapterText.setText(R.string.ch_105);
                addButton(getString(R.string.way_105), 555);
                break;
            case 106:
                mChapterText.setText(R.string.ch_106);
                addButton(getString(R.string.way_106), 555);
                break;
            case 107:
                mChapterText.setText(R.string.ch_107);
                addButton(getString(R.string.way_107), 555);
                break;
            case 108:
                mChapterText.setText(R.string.ch_108);
                addButton(getString(R.string.way_108), 555);
                break;
            case 109:
                mChapterText.setText(R.string.ch_109);
                addButton(getString(R.string.way_109), 555);
                break;
            case 110:
                mChapterText.setText(R.string.ch_110);
                addButton(getString(R.string.way_110), 555);
                break;
            case 111:
                mChapterText.setText(R.string.ch_111);
                addButton(getString(R.string.way_111), 555);
                break;
            case 112:
                mChapterText.setText(R.string.ch_112);
                addButton(getString(R.string.way_112), 555);
                break;
            case 113:
                mChapterText.setText(R.string.ch_113);
                addButton(getString(R.string.way_113), 555);
                break;
            case 114:
                mChapterText.setText(R.string.ch_114);
                addButton(getString(R.string.way_114), 555);
                break;
            case 115:
                mChapterText.setText(R.string.ch_115);
                addButton(getString(R.string.way_115), 555);
                break;
            case 116:
                mChapterText.setText(R.string.ch_116);
                addButton(getString(R.string.way_116), 555);
                break;
            case 117:
                mChapterText.setText(R.string.ch_117);
                addButton(getString(R.string.way_117), 555);
                break;
            case 118:
                mChapterText.setText(R.string.ch_118);
                addButton(getString(R.string.way_118), 555);
                break;
            case 119:
                mChapterText.setText(R.string.ch_119);
                addButton(getString(R.string.way_119), 555);
                break;
            case 120:
                mChapterText.setText(R.string.ch_120);
                addButton(getString(R.string.way_120), 555);
                break;
            case 121:
                mChapterText.setText(R.string.ch_121);
                addButton(getString(R.string.way_121), 555);
                break;
            case 122:
                mChapterText.setText(R.string.ch_122);
                addButton(getString(R.string.way_122), 555);
                break;
            case 123:
                mChapterText.setText(R.string.ch_123);
                addButton(getString(R.string.way_123), 555);
                break;
            case 124:
                mChapterText.setText(R.string.ch_124);
                addButton(getString(R.string.way_124), 555);
                break;
            case 125:
                mChapterText.setText(R.string.ch_125);
                addButton(getString(R.string.way_125), 555);
                break;
            case 126:
                mChapterText.setText(R.string.ch_126);
                addButton(getString(R.string.way_126), 555);
                break;
            case 127:
                mChapterText.setText(R.string.ch_127);
                addButton(getString(R.string.way_127), 555);
                break;
            case 128:
                mChapterText.setText(R.string.ch_128);
                addButton(getString(R.string.way_128), 555);
                break;
            case 129:
                mChapterText.setText(R.string.ch_129);
                addButton(getString(R.string.way_129), 555);
                break;
            case 130:
                mChapterText.setText(R.string.ch_130);
                addButton(getString(R.string.way_130), 555);
                break;
            case 131:
                mChapterText.setText(R.string.ch_131);
                addButton(getString(R.string.way_131), 555);
                break;
            case 132:
                mChapterText.setText(R.string.ch_132);
                addButton(getString(R.string.way_132), 555);
                break;
            case 133:
                mChapterText.setText(R.string.ch_133);
                addButton(getString(R.string.way_133), 555);
                break;
            case 134:
                mChapterText.setText(R.string.ch_134);
                addButton(getString(R.string.way_134), 555);
                break;
            case 135:
                mChapterText.setText(R.string.ch_135);
                addButton(getString(R.string.way_135), 555);
                break;
            case 136:
                mChapterText.setText(R.string.ch_136);
                addButton(getString(R.string.way_136), 555);
                break;
            case 137:
                mChapterText.setText(R.string.ch_137);
                addButton(getString(R.string.way_137), 555);
                break;
            case 138:
                mChapterText.setText(R.string.ch_138);
                addButton(getString(R.string.way_138), 555);
                break;
            case 139:
                mChapterText.setText(R.string.ch_139);
                addButton(getString(R.string.way_139), 555);
                break;
            case 140:
                mChapterText.setText(R.string.ch_140);
                addButton(getString(R.string.way_140), 555);
                break;
            case 141:
                mChapterText.setText(R.string.ch_141);
                addButton(getString(R.string.way_141), 555);
                break;
            case 142:
                mChapterText.setText(R.string.ch_142);
                addButton(getString(R.string.way_142), 555);
                break;
            case 143:
                mChapterText.setText(R.string.ch_143);
                addButton(getString(R.string.way_143), 555);
                break;
            case 144:
                mChapterText.setText(R.string.ch_144);
                addButton(getString(R.string.way_144), 555);
                break;
            case 145:
                mChapterText.setText(R.string.ch_145);
                addButton(getString(R.string.way_145), 555);
                break;
            case 146:
                mChapterText.setText(R.string.ch_146);
                addButton(getString(R.string.way_146), 555);
                break;
            case 147:
                mChapterText.setText(R.string.ch_147);
                addButton(getString(R.string.way_147), 555);
                break;
            case 148:
                mChapterText.setText(R.string.ch_148);
                addButton(getString(R.string.way_148), 555);
                break;
            case 149:
                mChapterText.setText(R.string.ch_149);
                addButton(getString(R.string.way_149), 555);
                break;
            case 150:
                mChapterText.setText(R.string.ch_150);
                addButton(getString(R.string.way_150), 555);
                break;
            case 151:
                mChapterText.setText(R.string.ch_151);
                addButton(getString(R.string.way_151), 555);
                break;
            case 152:
                mChapterText.setText(R.string.ch_152);
                addButton(getString(R.string.way_152), 555);
                break;
            case 153:
                mChapterText.setText(R.string.ch_153);
                addButton(getString(R.string.way_153), 555);
                break;
            case 154:
                mChapterText.setText(R.string.ch_154);
                addButton(getString(R.string.way_154), 555);
                break;
            case 155:
                mChapterText.setText(R.string.ch_155);
                addButton(getString(R.string.way_155), 555);
                break;
            case 156:
                mChapterText.setText(R.string.ch_156);
                addButton(getString(R.string.way_156), 555);
                break;
            case 157:
                mChapterText.setText(R.string.ch_157);
                addButton(getString(R.string.way_157), 555);
                break;
            case 158:
                mChapterText.setText(R.string.ch_158);
                addButton(getString(R.string.way_158), 555);
                break;
            case 159:
                mChapterText.setText(R.string.ch_159);
                addButton(getString(R.string.way_159), 555);
                break;
            case 160:
                mChapterText.setText(R.string.ch_160);
                addButton(getString(R.string.way_160), 555);
                break;
            case 161:
                mChapterText.setText(R.string.ch_161);
                addButton(getString(R.string.way_161), 555);
                break;
            case 162:
                mChapterText.setText(R.string.ch_162);
                addButton(getString(R.string.way_162), 555);
                break;
            case 163:
                mChapterText.setText(R.string.ch_163);
                addButton(getString(R.string.way_163), 555);
                break;
            case 164:
                mChapterText.setText(R.string.ch_164);
                addButton(getString(R.string.way_164), 555);
                break;
            case 165:
                mChapterText.setText(R.string.ch_165);
                addButton(getString(R.string.way_165), 555);
                break;
            case 166:
                mChapterText.setText(R.string.ch_166);
                addButton(getString(R.string.way_166), 555);
                break;
            case 167:
                mChapterText.setText(R.string.ch_167);
                addButton(getString(R.string.way_167), 555);
                break;
            case 168:
                mChapterText.setText(R.string.ch_168);
                addButton(getString(R.string.way_168), 555);
                break;
            case 169:
                mChapterText.setText(R.string.ch_169);
                addButton(getString(R.string.way_169), 555);
                break;
            case 170:
                mChapterText.setText(R.string.ch_170);
                addButton(getString(R.string.way_170), 555);
                break;
            case 171:
                mChapterText.setText(R.string.ch_171);
                addButton(getString(R.string.way_171), 555);
                break;
            case 172:
                mChapterText.setText(R.string.ch_172);
                addButton(getString(R.string.way_172), 555);
                break;
            case 173:
                mChapterText.setText(R.string.ch_173);
                addButton(getString(R.string.way_173), 555);
                break;
            case 174:
                mChapterText.setText(R.string.ch_174);
                addButton(getString(R.string.way_174), 555);
                break;
            case 175:
                mChapterText.setText(R.string.ch_175);
                addButton(getString(R.string.way_175), 555);
                break;
            case 176:
                mChapterText.setText(R.string.ch_176);
                addButton(getString(R.string.way_176), 555);
                break;
            case 177:
                mChapterText.setText(R.string.ch_177);
                addButton(getString(R.string.way_177), 555);
                break;
            case 178:
                mChapterText.setText(R.string.ch_178);
                addButton(getString(R.string.way_178), 555);
                break;
            case 179:
                mChapterText.setText(R.string.ch_179);
                addButton(getString(R.string.way_179), 555);
                break;
            case 180:
                mChapterText.setText(R.string.ch_180);
                addButton(getString(R.string.way_180), 555);
                break;
            case 181:
                mChapterText.setText(R.string.ch_181);
                addButton(getString(R.string.way_181), 555);
                break;
            case 182:
                mChapterText.setText(R.string.ch_182);
                addButton(getString(R.string.way_182), 555);
                break;
            case 183:
                mChapterText.setText(R.string.ch_183);
                addButton(getString(R.string.way_183), 555);
                break;
            case 184:
                mChapterText.setText(R.string.ch_184);
                addButton(getString(R.string.way_184), 555);
                break;
            case 185:
                mChapterText.setText(R.string.ch_185);
                addButton(getString(R.string.way_185), 555);
                break;
            case 186:
                mChapterText.setText(R.string.ch_186);
                addButton(getString(R.string.way_186), 555);
                break;
            case 187:
                mChapterText.setText(R.string.ch_187);
                addButton(getString(R.string.way_187), 555);
                break;
            case 188:
                mChapterText.setText(R.string.ch_188);
                addButton(getString(R.string.way_188), 555);
                break;
            case 189:
                mChapterText.setText(R.string.ch_189);
                addButton(getString(R.string.way_189), 555);
                break;
            case 190:
                mChapterText.setText(R.string.ch_190);
                addButton(getString(R.string.way_190), 555);
                break;
            case 191:
                mChapterText.setText(R.string.ch_191);
                addButton(getString(R.string.way_191), 555);
                break;
            case 192:
                mChapterText.setText(R.string.ch_192);
                addButton(getString(R.string.way_192), 555);
                break;
            case 193:
                mChapterText.setText(R.string.ch_193);
                addButton(getString(R.string.way_193), 555);
                break;
            case 194:
                mChapterText.setText(R.string.ch_194);
                addButton(getString(R.string.way_194), 555);
                break;
            case 195:
                mChapterText.setText(R.string.ch_195);
                addButton(getString(R.string.way_195), 555);
                break;
            case 196:
                mChapterText.setText(R.string.ch_196);
                addButton(getString(R.string.way_196), 555);
                break;
            case 197:
                mChapterText.setText(R.string.ch_197);
                addButton(getString(R.string.way_197), 555);
                break;
            case 198:
                mChapterText.setText(R.string.ch_198);
                addButton(getString(R.string.way_198), 555);
                break;
            case 199:
                mChapterText.setText(R.string.ch_199);
                addButton(getString(R.string.way_199), 555);
                break;
            case 200:
                mChapterText.setText(R.string.ch_200);
                addButton(getString(R.string.way_200), 555);
                break;
            case 201:
                mChapterText.setText(R.string.ch_201);
                addButton(getString(R.string.way_201), 555);
                break;
            case 202:
                mChapterText.setText(R.string.ch_202);
                addButton(getString(R.string.way_202), 555);
                break;
            case 203:
                mChapterText.setText(R.string.ch_203);
                addButton(getString(R.string.way_203), 555);
                break;
            case 204:
                mChapterText.setText(R.string.ch_204);
                addButton(getString(R.string.way_204), 555);
                break;
            case 205:
                mChapterText.setText(R.string.ch_205);
                addButton(getString(R.string.way_205), 555);
                break;
            case 206:
                mChapterText.setText(R.string.ch_206);
                addButton(getString(R.string.way_206), 555);
                break;
            case 207:
                mChapterText.setText(R.string.ch_207);
                addButton(getString(R.string.way_207), 555);
                break;
            case 208:
                mChapterText.setText(R.string.ch_208);
                addButton(getString(R.string.way_208), 555);
                break;
            case 209:
                mChapterText.setText(R.string.ch_209);
                addButton(getString(R.string.way_209), 555);
                break;
            case 210:
                mChapterText.setText(R.string.ch_210);
                addButton(getString(R.string.way_210), 555);
                break;
            case 211:
                mChapterText.setText(R.string.ch_211);
                addButton(getString(R.string.way_211), 555);
                break;
            case 212:
                mChapterText.setText(R.string.ch_212);
                addButton(getString(R.string.way_212), 555);
                break;
            case 213:
                mChapterText.setText(R.string.ch_213);
                addButton(getString(R.string.way_213), 555);
                break;
            case 214:
                mChapterText.setText(R.string.ch_214);
                addButton(getString(R.string.way_214), 555);
                break;
            case 215:
                mChapterText.setText(R.string.ch_215);
                addButton(getString(R.string.way_215), 555);
                break;
            case 216:
                mChapterText.setText(R.string.ch_216);
                addButton(getString(R.string.way_216), 555);
                break;
            case 217:
                mChapterText.setText(R.string.ch_217);
                addButton(getString(R.string.way_217), 555);
                break;
            case 218:
                mChapterText.setText(R.string.ch_218);
                addButton(getString(R.string.way_218), 555);
                break;
            case 219:
                mChapterText.setText(R.string.ch_219);
                addButton(getString(R.string.way_219), 555);
                break;
            case 220:
                mChapterText.setText(R.string.ch_220);
                addButton(getString(R.string.way_220), 555);
                break;
            case 221:
                mChapterText.setText(R.string.ch_221);
                addButton(getString(R.string.way_221), 555);
                break;
            case 222:
                mChapterText.setText(R.string.ch_222);
                addButton(getString(R.string.way_222), 555);
                break;
            case 223:
                mChapterText.setText(R.string.ch_223);
                addButton(getString(R.string.way_223), 555);
                break;
            case 224:
                mChapterText.setText(R.string.ch_224);
                addButton(getString(R.string.way_224), 555);
                break;
            case 225:
                mChapterText.setText(R.string.ch_225);
                addButton(getString(R.string.way_225), 555);
                break;
            case 226:
                mChapterText.setText(R.string.ch_226);
                addButton(getString(R.string.way_226), 555);
                break;
            case 227:
                mChapterText.setText(R.string.ch_227);
                addButton(getString(R.string.way_227), 555);
                break;
            case 228:
                mChapterText.setText(R.string.ch_228);
                addButton(getString(R.string.way_228), 555);
                break;
            case 229:
                mChapterText.setText(R.string.ch_229);
                addButton(getString(R.string.way_229), 555);
                break;
            case 230:
                mChapterText.setText(R.string.ch_230);
                addButton(getString(R.string.way_230), 555);
                break;
            case 231:
                mChapterText.setText(R.string.ch_231);
                addButton(getString(R.string.way_231), 555);
                break;
            case 232:
                mChapterText.setText(R.string.ch_232);
                addButton(getString(R.string.way_232), 555);
                break;
            case 233:
                mChapterText.setText(R.string.ch_233);
                addButton(getString(R.string.way_233), 555);
                break;
            case 234:
                mChapterText.setText(R.string.ch_234);
                addButton(getString(R.string.way_234), 555);
                break;
            case 235:
                mChapterText.setText(R.string.ch_235);
                addButton(getString(R.string.way_235), 555);
                break;
            case 236:
                mChapterText.setText(R.string.ch_236);
                addButton(getString(R.string.way_236), 555);
                break;
            case 237:
                mChapterText.setText(R.string.ch_237);
                addButton(getString(R.string.way_237), 555);
                break;
            case 238:
                mChapterText.setText(R.string.ch_238);
                addButton(getString(R.string.way_238), 555);
                break;
            case 239:
                mChapterText.setText(R.string.ch_239);
                addButton(getString(R.string.way_239), 555);
                break;
            case 240:
                mChapterText.setText(R.string.ch_240);
                addButton(getString(R.string.way_240), 555);
                break;
            case 241:
                mChapterText.setText(R.string.ch_241);
                addButton(getString(R.string.way_241), 555);
                break;
            case 242:
                mChapterText.setText(R.string.ch_242);
                addButton(getString(R.string.way_242), 555);
                break;
            case 243:
                mChapterText.setText(R.string.ch_243);
                addButton(getString(R.string.way_243), 555);
                break;
            case 244:
                mChapterText.setText(R.string.ch_244);
                addButton(getString(R.string.way_244), 555);
                break;
            case 245:
                mChapterText.setText(R.string.ch_245);
                addButton(getString(R.string.way_245), 555);
                break;
            case 246:
                mChapterText.setText(R.string.ch_246);
                addButton(getString(R.string.way_246), 555);
                break;
            case 247:
                mChapterText.setText(R.string.ch_247);
                addButton(getString(R.string.way_247), 555);
                break;
            case 248:
                mChapterText.setText(R.string.ch_248);
                addButton(getString(R.string.way_248), 555);
                break;
            case 249:
                mChapterText.setText(R.string.ch_249);
                addButton(getString(R.string.way_249), 555);
                break;
            case 250:
                mChapterText.setText(R.string.ch_250);
                addButton(getString(R.string.way_250), 555);
                break;
            case 251:
                mChapterText.setText(R.string.ch_251);
                addButton(getString(R.string.way_251), 555);
                break;
            case 252:
                mChapterText.setText(R.string.ch_252);
                addButton(getString(R.string.way_252), 555);
                break;
            case 253:
                mChapterText.setText(R.string.ch_253);
                addButton(getString(R.string.way_253), 555);
                break;
            case 254:
                mChapterText.setText(R.string.ch_254);
                addButton(getString(R.string.way_254), 555);
                break;
            case 255:
                mChapterText.setText(R.string.ch_255);
                addButton(getString(R.string.way_255), 555);
                break;
            case 256:
                mChapterText.setText(R.string.ch_256);
                addButton(getString(R.string.way_256), 555);
                break;
            case 257:
                mChapterText.setText(R.string.ch_257);
                addButton(getString(R.string.way_257), 555);
                break;
            case 258:
                mChapterText.setText(R.string.ch_258);
                addButton(getString(R.string.way_258), 555);
                break;
            case 259:
                mChapterText.setText(R.string.ch_259);
                addButton(getString(R.string.way_259), 555);
                break;
            case 260:
                mChapterText.setText(R.string.ch_260);
                addButton(getString(R.string.way_260), 555);
                break;
            case 261:
                mChapterText.setText(R.string.ch_261);
                addButton(getString(R.string.way_261), 555);
                break;
            case 262:
                mChapterText.setText(R.string.ch_262);
                addButton(getString(R.string.way_262), 555);
                break;
            case 263:
                mChapterText.setText(R.string.ch_263);
                addButton(getString(R.string.way_263), 555);
                break;
            case 264:
                mChapterText.setText(R.string.ch_264);
                addButton(getString(R.string.way_264), 555);
                break;
            case 265:
                mChapterText.setText(R.string.ch_265);
                addButton(getString(R.string.way_265), 555);
                break;
            case 266:
                mChapterText.setText(R.string.ch_266);
                addButton(getString(R.string.way_266), 555);
                break;
            case 267:
                mChapterText.setText(R.string.ch_267);
                addButton(getString(R.string.way_267), 555);
                break;
            case 268:
                mChapterText.setText(R.string.ch_268);
                addButton(getString(R.string.way_268), 555);
                break;
            case 269:
                mChapterText.setText(R.string.ch_269);
                addButton(getString(R.string.way_269), 555);
                break;
            case 270:
                mChapterText.setText(R.string.ch_270);
                addButton(getString(R.string.way_270), 555);
                break;
            case 271:
                mChapterText.setText(R.string.ch_271);
                addButton(getString(R.string.way_271), 555);
                break;
            case 272:
                mChapterText.setText(R.string.ch_272);
                addButton(getString(R.string.way_272), 555);
                break;
            case 273:
                mChapterText.setText(R.string.ch_273);
                addButton(getString(R.string.way_273), 555);
                break;
            case 274:
                mChapterText.setText(R.string.ch_274);
                addButton(getString(R.string.way_274), 555);
                break;
            case 275:
                mChapterText.setText(R.string.ch_275);
                addButton(getString(R.string.way_275), 555);
                break;
            case 276:
                mChapterText.setText(R.string.ch_276);
                addButton(getString(R.string.way_276), 555);
                break;
            case 277:
                mChapterText.setText(R.string.ch_277);
                addButton(getString(R.string.way_277), 555);
                break;
            case 278:
                mChapterText.setText(R.string.ch_278);
                addButton(getString(R.string.way_278), 555);
                break;
            case 279:
                mChapterText.setText(R.string.ch_279);
                addButton(getString(R.string.way_279), 555);
                break;
            case 280:
                mChapterText.setText(R.string.ch_280);
                addButton(getString(R.string.way_280), 555);
                break;
            case 281:
                mChapterText.setText(R.string.ch_281);
                addButton(getString(R.string.way_281), 555);
                break;
            case 282:
                mChapterText.setText(R.string.ch_282);
                addButton(getString(R.string.way_282), 555);
                break;
            case 283:
                mChapterText.setText(R.string.ch_283);
                addButton(getString(R.string.way_283), 555);
                break;
            case 284:
                mChapterText.setText(R.string.ch_284);
                addButton(getString(R.string.way_284), 555);
                break;
            case 285:
                mChapterText.setText(R.string.ch_285);
                addButton(getString(R.string.way_285), 555);
                break;
            case 286:
                mChapterText.setText(R.string.ch_286);
                addButton(getString(R.string.way_286), 555);
                break;
            case 287:
                mChapterText.setText(R.string.ch_287);
                addButton(getString(R.string.way_287), 555);
                break;
            case 288:
                mChapterText.setText(R.string.ch_288);
                addButton(getString(R.string.way_288), 555);
                break;
            case 289:
                mChapterText.setText(R.string.ch_289);
                addButton(getString(R.string.way_289), 555);
                break;
            case 290:
                mChapterText.setText(R.string.ch_290);
                addButton(getString(R.string.way_290), 555);
                break;
            case 291:
                mChapterText.setText(R.string.ch_291);
                addButton(getString(R.string.way_291), 555);
                break;
            case 292:
                mChapterText.setText(R.string.ch_292);
                addButton(getString(R.string.way_292), 555);
                break;
            case 293:
                mChapterText.setText(R.string.ch_293);
                addButton(getString(R.string.way_293), 555);
                break;
            case 294:
                mChapterText.setText(R.string.ch_294);
                addButton(getString(R.string.way_294), 555);
                break;
            case 295:
                mChapterText.setText(R.string.ch_295);
                addButton(getString(R.string.way_295), 555);
                break;
            case 296:
                mChapterText.setText(R.string.ch_296);
                addButton(getString(R.string.way_296), 555);
                break;
            case 297:
                mChapterText.setText(R.string.ch_297);
                addButton(getString(R.string.way_297), 555);
                break;
            case 298:
                mChapterText.setText(R.string.ch_298);
                addButton(getString(R.string.way_298), 555);
                break;
            case 299:
                mChapterText.setText(R.string.ch_299);
                addButton(getString(R.string.way_299), 555);
                break;
            case 300:
                mChapterText.setText(R.string.ch_300);
                addButton(getString(R.string.way_300), 555);
                break;
            case 301:
                mChapterText.setText(R.string.ch_301);
                addButton(getString(R.string.way_301), 555);
                break;
            case 302:
                mChapterText.setText(R.string.ch_302);
                addButton(getString(R.string.way_302), 555);
                break;
            case 303:
                mChapterText.setText(R.string.ch_303);
                addButton(getString(R.string.way_303), 555);
                break;
            case 304:
                mChapterText.setText(R.string.ch_304);
                addButton(getString(R.string.way_304), 555);
                break;
            case 305:
                mChapterText.setText(R.string.ch_305);
                addButton(getString(R.string.way_305), 555);
                break;
            case 306:
                mChapterText.setText(R.string.ch_306);
                addButton(getString(R.string.way_306), 555);
                break;
            case 307:
                mChapterText.setText(R.string.ch_307);
                addButton(getString(R.string.way_307), 555);
                break;
            case 308:
                mChapterText.setText(R.string.ch_308);
                addButton(getString(R.string.way_308), 555);
                break;
            case 309:
                mChapterText.setText(R.string.ch_309);
                addButton(getString(R.string.way_309), 555);
                break;
            case 310:
                mChapterText.setText(R.string.ch_310);
                addButton(getString(R.string.way_310), 555);
                break;
            case 311:
                mChapterText.setText(R.string.ch_311);
                addButton(getString(R.string.way_311), 555);
                break;
            case 312:
                mChapterText.setText(R.string.ch_312);
                addButton(getString(R.string.way_312), 555);
                break;
            case 313:
                mChapterText.setText(R.string.ch_313);
                addButton(getString(R.string.way_313), 555);
                break;
            case 314:
                mChapterText.setText(R.string.ch_314);
                addButton(getString(R.string.way_314), 555);
                break;
            case 315:
                mChapterText.setText(R.string.ch_315);
                addButton(getString(R.string.way_315), 555);
                break;
            case 316:
                mChapterText.setText(R.string.ch_316);
                addButton(getString(R.string.way_316), 555);
                break;
            case 317:
                mChapterText.setText(R.string.ch_317);
                addButton(getString(R.string.way_317), 555);
                break;
            case 318:
                mChapterText.setText(R.string.ch_318);
                addButton(getString(R.string.way_318), 555);
                break;
            case 319:
                mChapterText.setText(R.string.ch_319);
                addButton(getString(R.string.way_319), 555);
                break;
            case 320:
                mChapterText.setText(R.string.ch_320);
                addButton(getString(R.string.way_320), 555);
                break;
            case 321:
                mChapterText.setText(R.string.ch_321);
                addButton(getString(R.string.way_321), 555);
                break;
            case 322:
                mChapterText.setText(R.string.ch_322);
                addButton(getString(R.string.way_322), 555);
                break;
            case 323:
                mChapterText.setText(R.string.ch_323);
                addButton(getString(R.string.way_323), 555);
                break;
            case 324:
                mChapterText.setText(R.string.ch_324);
                addButton(getString(R.string.way_324), 555);
                break;
            case 325:
                mChapterText.setText(R.string.ch_325);
                addButton(getString(R.string.way_325), 555);
                break;
            case 326:
                mChapterText.setText(R.string.ch_326);
                addButton(getString(R.string.way_326), 555);
                break;
            case 327:
                mChapterText.setText(R.string.ch_327);
                addButton(getString(R.string.way_327), 555);
                break;
            case 328:
                mChapterText.setText(R.string.ch_328);
                addButton(getString(R.string.way_328), 555);
                break;
            case 329:
                mChapterText.setText(R.string.ch_329);
                addButton(getString(R.string.way_329), 555);
                break;
            case 330:
                mChapterText.setText(R.string.ch_330);
                addButton(getString(R.string.way_330), 555);
                break;
            case 331:
                mChapterText.setText(R.string.ch_331);
                addButton(getString(R.string.way_331), 555);
                break;
            case 332:
                mChapterText.setText(R.string.ch_332);
                addButton(getString(R.string.way_332), 555);
                break;
            case 333:
                mChapterText.setText(R.string.ch_333);
                addButton(getString(R.string.way_333), 555);
                break;
            case 334:
                mChapterText.setText(R.string.ch_334);
                addButton(getString(R.string.way_334), 555);
                break;
            case 335:
                mChapterText.setText(R.string.ch_335);
                addButton(getString(R.string.way_335), 555);
                break;
            case 336:
                mChapterText.setText(R.string.ch_336);
                addButton(getString(R.string.way_336), 555);
                break;
            case 337:
                mChapterText.setText(R.string.ch_337);
                addButton(getString(R.string.way_337), 555);
                break;
            case 338:
                mChapterText.setText(R.string.ch_338);
                addButton(getString(R.string.way_338), 555);
                break;
            case 339:
                mChapterText.setText(R.string.ch_339);
                addButton(getString(R.string.way_339), 555);
                break;
            case 340:
                mChapterText.setText(R.string.ch_340);
                addButton(getString(R.string.way_340), 555);
                break;
            case 341:
                mChapterText.setText(R.string.ch_341);
                addButton(getString(R.string.way_341), 555);
                break;
            case 342:
                mChapterText.setText(R.string.ch_342);
                addButton(getString(R.string.way_342), 555);
                break;
            case 343:
                mChapterText.setText(R.string.ch_343);
                addButton(getString(R.string.way_343), 555);
                break;
            case 344:
                mChapterText.setText(R.string.ch_344);
                addButton(getString(R.string.way_344), 555);
                break;
            case 345:
                mChapterText.setText(R.string.ch_345);
                addButton(getString(R.string.way_345), 555);
                break;
            case 346:
                mChapterText.setText(R.string.ch_346);
                addButton(getString(R.string.way_346), 555);
                break;
            case 347:
                mChapterText.setText(R.string.ch_347);
                addButton(getString(R.string.way_347), 555);
                break;
            case 348:
                mChapterText.setText(R.string.ch_348);
                addButton(getString(R.string.way_348), 555);
                break;
            case 349:
                mChapterText.setText(R.string.ch_349);
                addButton(getString(R.string.way_349), 555);
                break;
            case 350:
                mChapterText.setText(R.string.ch_350);
                addButton(getString(R.string.way_350), 555);
                break;
            case 351:
                mChapterText.setText(R.string.ch_351);
                addButton(getString(R.string.way_351), 555);
                break;



        }
    }


}
