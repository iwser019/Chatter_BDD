package chatterbdd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Chatter chatter = new Chatter();
        // добавление минимального примера
        HashMap<String, String> exactMatch = new HashMap<String, String>();
        exactMatch.put("Как дела?", "Неплохо.");
        exactMatch.put("Как поживаешь?", "Средне.");
        exactMatch.put("Ты спишь?", "Нет");
        exactMatch.put("Сколько будет два плюс два?", "Четыре.");
        chatter.setExactMatchBase(exactMatch);
        HashMap<String, String[]> typicalBase = new HashMap<String, String[]>();
        typicalBase.put("Привет", new String[] {
                "Привет",
                "Здовово",
                "Здравствуй"
        });
        typicalBase.put("Не знаю.", new String[] {
                "Я тоже не знаю.",
                "А почему?",
                "Жаль."
        });
        chatter.setTypicalMatchBase(typicalBase);
        ArrayList<Pair<String[], String>> keywordBase = new ArrayList<Pair<String[], String>>();
        keywordBase.add(
                new Pair<>(
                        new String[] {
                                "блин,"
                        },
                        "Я тоже люблю блины."
                )
        );
        chatter.setKeywordMatchBase(keywordBase);
        String[] genBase = new String[] {
                "Ты вообще о чем?",
                "И такое бывает...",
                "Ясно, понятно."
        };
        chatter.setGenericBase(genBase);
        // выполнение
        // Собственно, выполнение
        System.out.println("Введите stop() для выхода.\n");
        String saying = null;
        String answer = null;
        while (true) {
            saying = br.readLine();
            if (saying.equals("stop()"))
                break;
            else if (saying.equals(""))
                saying = null;
            answer = chatter.getAnswer(saying);
            System.out.println(answer);
        }
    }
}
