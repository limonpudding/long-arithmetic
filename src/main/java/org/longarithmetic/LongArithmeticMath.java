package org.longarithmetic;

public class LongArithmeticMath {

    //TODO атрибуты, которые содержат непосредственно данные о числе. методы доступа к ним и т.п. вынести в отдельный класс
    //TODO переопределить метод equals, либо имплементировать интерфейс Comaparable
    private static int n = 10000;//максимальная длина числа
    public byte[] digits = new byte[n];
    private int length = 0;
    private boolean sign = true;

    public static void SetDigitsCount(int dimension) {
        n = dimension;
    }

    //TODO переименовать класс, содержащий операции над числами в длинной арифметике. Всё, что статик в нём оставить. LongArithmeticMath
    public static LongArithmethic Sum(LongArithmethic a, LongArithmethic b) {
        LongArithmethic result = new LongArithmeticImpl();
        result.setSign(a.getSign());
        if (a.getSign() && !b.getSign()) {
            b.setSign(true);
            return Sub(a, b);
        }
        if (!a.getSign() && b.getSign()) {
            b.setSign(false);
            return Sub(b, a);
        }
        int maxLength = a.getLength() > b.getLength() ? a.getLength() : b.getLength();
        int tmp = 0;
        int i;
        for (i = 0; i < maxLength; ++i) {
            result.getDigits()[i] = (byte) ((a.getDigits()[i] + b.getDigits()[i] + tmp) % 10);
            tmp = (a.getDigits()[i] + b.getDigits()[i] + tmp) / 10;
        }
        result.getDigits()[i] = (byte) tmp;
        result.getLength();
        return result;
    }

    /**
     * Функция умножения двух длинных чисел
     *
     * @param a первый множитель
     * @param b второй множитель
     * @return результат умножения
     */
    public static LongArithmethic Mul(LongArithmethic a, LongArithmethic b) {
        LongArithmethic result = new LongArithmeticImpl();
        if (!(a.getSign() && b.getSign() || (!a.getSign() && !b.getSign()))) {
            result.setSign(false);
        }
        int tmp = 0;
        int tmp1;
        int i;
        int j;
        for (i = 0; i < b.getLength(); ++i) {
            for (j = 0; j < a.getLength(); ++j) {
                tmp1 = result.getDigits()[j + i];
                result.getDigits()[j + i] = (byte) ((a.getDigits()[j] * b.getDigits()[i] + tmp1 + tmp) % 10);
                tmp = (byte) (tmp1 + a.getDigits()[j] * b.getDigits()[i] + tmp) / 10;
            }
            if (tmp > 0)
                result.getDigits()[result.getLength()] += (byte) (tmp % 10);
            result.setLength(result.getLength());
            tmp = 0;
        }
        return result;
    }

    /**
     * Метод. применяемый к экземпляру объекта длинного числа.
     *
     * @return Возвращает строку (число со знаком или без)
     */


    /**
     * Функция вычитания двух длинных чисел
     *
     * @param tmpa Уменьшаемое значение
     * @param tmpb Вычетаемое значение
     * @return Разность
     */
    public static LongArithmethic Sub(LongArithmethic tmpa, LongArithmethic tmpb) {
        LongArithmethic a = tmpa;
        LongArithmethic b = tmpb;
        if (a.getSign() && !b.getSign()) {
            b.setSign(true);
            return Sum(a, b);
        }
        if (!a.getSign() && b.getSign()) {
            b.setSign(false);
            return Sum(b, a);
        }
        if (!a.getSign() && !b.getSign()) {
            b.setSign(true);
            LongArithmethic temp = a;
            a = b;
            b = temp;
        }

        int maxLength = a.getLength() > b.getLength() ? a.getLength() : b.getLength();
        LongArithmethic c = new LongArithmeticImpl();

        if (a.compareTo(b) == -1) {
            LongArithmethic temp = a;
            a = b;
            b = temp;
            c.setSign(false);
        }

        for (int i = 0; i < maxLength; ++i) {
            if (a.getDigits()[i] >= b.getDigits()[i]) {
                c.setDigit((byte) (a.getDigits()[i] - b.getDigits()[i]), i);
            } else {
                c.setDigit((byte) (a.getDigits()[i] - b.getDigits()[i] + 10), i);
                a.setDigit((byte) (a.getDigit(i + 1) - 1), i + 1);
            }
        }
        c.getLength();
        return c;
    }

    /*  1 если a>b
        0 a=b
       -1 a<b
     */

    /**
     * Функция сравнения двух длинных чисел.
     *
     * @param a Первое число для сравнения
     * @param b Второе число для сравнения
     * @return результат сравнения: 1 если a больше b; 0 a равно b; -1 a меньше b.
     */


    /**
     * Функция деления без остатка двух длинных чисел
     *
     * @param dividend Делимое
     * @param divider  Делитель
     * @return Результат деления без остатка
     */
    public static LongArithmethic div(LongArithmethic dividend, LongArithmethic divider) {

        //TODO выбрасывать исключение ArithmeticException
        LongArithmethic result = new LongArithmeticImpl();
        if (divider.toString().equals("0")) {
            throw new ArithmeticException();
        }
        if ((dividend.getSign() && divider.getSign()) || (!dividend.getSign() && !divider.getSign())) {
            result.setSign(true);
        }
        LongArithmethic tmp = divider;
        LongArithmethic one = new LongArithmeticImpl();
        one.setDigit((byte) 1, 0);
        one.setLength(1);
        while (dividend.compareTo(tmp) >= 0) {
            result = Sum(result, one);
            tmp = Sum(tmp, divider);
        }
        result.getLength();
        return result;
    }
}
