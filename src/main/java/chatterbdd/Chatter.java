package chatterbdd;

import java.util.HashMap;

public class Chatter {

    // Конструктор
    public Chatter() {

    }


    public String getAnswer(String saying) {
        if (saying != null)
        {
            if (saying.equals("Ты спишь?"))
                return "Нет";
            return "Не понял.";
        }
        return "Не понял.";
    }

    public void setExactMatchBase(HashMap<String, String> exMatchBase) {

    }
}
