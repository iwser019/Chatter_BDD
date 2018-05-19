package chatterbdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Chatter {

    private HashMap<String, String> exactMatchBase;
    private HashMap<String, String[]> typicalMatchBase;
    private Random randomizer;
    // Конструктор
    public Chatter() {
        randomizer = new Random();
        exactMatchBase = new HashMap<>();
        typicalMatchBase = new HashMap<>();
    }

    /**
     * Получение ответа на фразу
     * @param saying Текст исходной фразы
     * @return Текст ответа
     */
    public String getAnswer(String saying) {
        if (saying != null)
        {
            if (saying.equals("Ты спишь?"))
                return "Нет";
            return "Не понял.";
        }
        return "Не понял.";
    }

    /**
     * Установка базы точных соответствий
     * @param exMatchBase Словарь точных соответствий для фраз
     */
    public void setExactMatchBase(HashMap<String, String> exMatchBase) {
        this.exactMatchBase = exMatchBase;
    }

    /**
     * Получение базы точных соответствий
     * @return Словарь точных соответствий для фраз
     */
    public HashMap getExactMatchBase() {
        return this.exactMatchBase;
    }

    /**
     * Проверка на наличие точного соответствия
     * @param saying Текст исходной фразы
     * @return Результат проверки
     */
    public boolean hasExactMatch(String saying) {
        return this.exactMatchBase.containsKey(saying);
    }

    /**
     * Получение точного соответствия
     * @param saying Текст исходной фразы
     * @return Текст фразы, соответствующей исходной
     */
    public String getExactMatch(String saying) {
        if (saying == null)
            return null;
        if (hasExactMatch(saying))
            return exactMatchBase.get(saying);
        return null;
    }

    /**
     * Установка базы типичных соответствий
     * @param typMatchBase Словарь фраз и соответствующих списков ответов
     */
    public void setTypicalMatchBase(HashMap<String,String[]> typMatchBase) {
        this.typicalMatchBase = typMatchBase;
    }

    /**
     * Получение базы типичных соответствий
     * @return Словарь фраз и соответствующих списков ответов
     */
    public HashMap<String,String[]> getTypicalMatchBase() {
        return this.typicalMatchBase;
    }

    /**
     * Проверка на наличие типичных соответствий
     * @param saying Исходная реплика
     * @return Результат проверки
     */
    public boolean hasTypicalMatch(String saying) {
        return this.typicalMatchBase.containsKey(saying);
    }

    /**
     * Разбиение текста на предложения
     * @param s Исходный текст
     * @return Массив предложений
     */
    public String[] splitIntoSentences(String s) {
        if (s == null)
            return new String[]{};
        ArrayList<String> result = new ArrayList<>();
        int size = s.length();
        int ptr = 0;
        int ptrStart = 0;
        char currChar = 0;
        boolean atEnd = false;
        boolean finalized = false;
        while (!atEnd) {
            if (ptr >= size) {
                atEnd = true;
                break;
            }
            currChar = s.charAt(ptr);
            if (currChar == '.' || currChar == '!' || currChar == '?') {
                if ((ptr + 1) < size) {
                    if (s.charAt(ptr + 1) == ' ') {
                        result.add(s.substring(ptrStart, ptr + 1));
                        if ((ptr + 2) < size) {
                            ptrStart = ptr + 2;
                            ptr = ptr + 2;
                        } else {
                            finalized = true;
                            atEnd = true;
                        }
                    }
                } else {
                    result.add(s.substring(ptrStart, ptr + 1));
                    finalized = true;
                    atEnd = true;
                }
            } else {
                ptr++;
            }
        }
        if (atEnd && !finalized) {
            result.add(s.substring(ptrStart, ptr + 1));
        }
        String[] resultArr = new String[result.size()];
        resultArr = result.toArray(resultArr);
        return resultArr;
    }

    /**
     * Получение ответа на типичную фразу
     * @param saying Текст исходной фразы
     * @return Текст ответа
     */
    public String getTypicalMatch(String saying) {
        if (saying == null)
            return null;
        if (hasTypicalMatch(saying)) {
            String[] variants = typicalMatchBase.get(saying);
            return variants[randomizer.nextInt(variants.length - 1)];
        }
        return null;
    }

    /**
     * Проверка на соответствие на уровне значимых слов
     * @param saying Тескт исходной реплики
     * @return Результат проверки
     */
    public boolean hasExactMatchSub(String saying) {
        return (getExactMatchSub(saying) != null);
    }

    /**
     * Получение ответа при соответствии на уровне значимых слов
     * @param saying Текст исходной реплики
     * @return Текст ответа
     */
    public String getExactMatchSub(String saying) {
        if (saying == null)
            return null;
        ArrayList<String> variants = new ArrayList<>();
        String[] vals = new String[exactMatchBase.keySet().size()];
        vals = exactMatchBase.keySet().toArray(vals);
        String[] srcWords = splitIntoWords(saying);
        for (String val : vals) {
            int wordCount = 0;
            String[] valWords = splitIntoWords(val);
            for (String srcWord : srcWords) {
                for (String valWord : valWords) {
                    if (srcWord.equals(valWord)) {
                        wordCount++;
                    }
                }
            }
            if (wordCount >= 2) {
                variants.add(val);
                wordCount = 0;
            }
        }
        return (variants.size() > 0
                ? exactMatchBase.get(variants.size() > 1
                    ? variants.get(randomizer.nextInt(variants.size() - 1))
                    : variants.get(0))
                : null);
    }

    /**
     * Разбиение текста на слова
     * @param s Исходный текст
     * @return Массив слов
     */
    public String[] splitIntoWords(String s) {
        if (s == null)
            return new String[]{};
        return s.split("[\\s\\t]+");
    }

    public void setKeywordMatchBase(ArrayList<Pair<String[],String>> kwMatchBase) {

    }

    public ArrayList<Pair<String[],String>> getKeywordMatchBase() {
        ArrayList<Pair<String[],String>> kwMatchBase = new ArrayList<>();
        kwMatchBase.add(new Pair<>(
                new String[]{
                        "не",
                        "знаю."},
                "А что ты вообще знаешь?")
        );
        kwMatchBase.add(new Pair<>(
                new String[]{
                        "блин"
                },
                "Я тоже люблю блины"
        ));
        return kwMatchBase;
    }

    public boolean hasKeywordMatch(String saying) {
        if (saying.equals("Я этого не знаю."))
            return true;
        return false;
    }
}
