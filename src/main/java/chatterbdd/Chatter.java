package chatterbdd;

import java.util.HashMap;

public class Chatter {

    private HashMap<String, String> exactMatchBase;
    // Конструктор
    public Chatter() {
        exactMatchBase = new HashMap<>();
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

    public void setTypicalMatchBase(HashMap<String,String[]> typMatchBase) {

    }

    public HashMap<String,String[]> getTypicalMatchBase() {
        HashMap<String, String[]> mb = new HashMap<>();
        mb.put("Не знаю.", new String[]{
                "Я тоже не знаю.",
                "А почему?",
                "Жаль."
        });
        return mb;
    }

    public boolean hasTypicalMatch(String saying) {
        if (saying.equals("Не знаю."))
            return true;
        return false;
    }

    public String[] splitIntoSentences(String s) {
        return new String[]{"Не знаю.", "Как-то не думал."};
    }
}
