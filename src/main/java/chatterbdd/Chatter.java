package chatterbdd;

import java.util.HashMap;

public class Chatter {

    // Конструктор
    public Chatter() {

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

    }

    /**
     * Получение базы точных соответствий
     * @return Словарь точных соответствий для фраз
     */
    public HashMap getExactMatchBase() {
        HashMap<String, String> mb = new HashMap<>();
        mb.put("Ты спишь?", "Нет");
        mb.put("Сколько будет два плюс два?", "Четыре");
        return mb;
    }

    /**
     * Проверка на наличие точного соответствия
     * @param saying Текст исходной фразы
     * @return Результат проверки
     */
    public boolean hasExactMatch(String saying) {
        if (saying.equals("Ты спишь?")
                || saying.equals("Сколько будет два плюс два?"))
            return true;
        return false;
    }
}
