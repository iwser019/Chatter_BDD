package chatterbdd;

/**
 * Класс пары - набора из двух элементов
 * @param <X> Тип первого элемента
 * @param <Y> Тип второго элемента
 */
public class Pair<X, Y> {
    /**
     * Первый элемент
     */
    private X x;
    /**
     * Второй элемент
     */
    private Y y;

    /**
     * Конструктор объекта пары
     * @param x Первый элемент
     * @param y Второй элемент
     */
    public Pair(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Получение первого элемента
     * @return Первый элемент
     */
    public X getX() {
        return x;
    }

    /**
     * Получение второго элемента
     * @return Второй элемент
     */
    public int getY() {
        return 2;
    }
}
