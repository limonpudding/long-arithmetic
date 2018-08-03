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

    /**
     * Конструктор для создания длинного числа.
     * Принимает строку. которая представляет собой целое число со знаком или без
     *
     * @param number Строка
     */
    public LongArithmeticMath(String number) {
        length = number.length();
        int j = 0;
        if (number.charAt(0) == '-') {
            sign = false;
            for (int i = length - 1; i >= 1; --i)
                digits[j++] = (byte) (number.charAt(i) - '0');
            length--;
        } else {
            for (int i = length - 1; i >= 0; --i)
                digits[j++] = (byte) (number.charAt(i) - '0');
        }
    }

    private LongArithmeticMath() {
        length = 0;
    }




    //TODO переименовать класс, содержащий операции над числами в длинной арифметике. Всё, что статик в нём оставить. LongArithmeticMath
    public static LongArithmethic Sum(LongArithmethic a, LongArithmethic b) {
        LongArithmeticImpl result = new LongArithmeticImpl();
        result.setSign(a.getSign());
        if (a.getSign() == true && b.getSign() == false) {
            b.setSign(true);
            return Sub(a, b);
        }
        if (a.getSign() == false && b.getSign() == true) {
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
        result.getDigits()[i] = (byte)tmp;
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
    public static LongArithmeticMath Mul(LongArithmeticMath a, LongArithmeticMath b) {
        LongArithmeticMath result = new LongArithmeticMath();
        if (a.sign != b.sign)
            result.sign = false;
        int tmp = 0;
        int tmp1;
        int i;
        int j;
        for (i = 0; i < b.length; ++i) {
            for (j = 0; j < a.length; ++j) {
                tmp1 = result.digits[j + i];
                result.digits[j + i] = (byte) ((a.digits[j] * b.digits[i] + tmp1 + tmp) % 10);
                tmp = (byte) (tmp1 + a.digits[j] * b.digits[i] + tmp) / 10;
            }
            if (tmp > 0)
                result.digits[result.GetLength()] += (byte) (tmp % 10);
            result.length = result.GetLength();
            tmp = 0;
        }
        return result;
    }

    /**
     * Метод. применяемый к экземпляру объекта длинного числа.
     *
     * @return Возвращает строку (число со знаком или без)
     */
    public String ToString() {
        String s = "";
        if (length == -1) {
            return "Деление на ноль невозможно";
        }
        for (int i = 0; i < this.GetLength(); ++i)
            s = this.digits[i] + s;
        if (s == "")
            return "0";
        if (sign == false)
            s = "-" + s;
        return s;

    }

    /**
     * Функция вычитания двух длинных чисел
     *
     * @param tmpa Уменьшаемое значение
     * @param tmpb Вычетаемое значение
     * @return Разность
     */
    public static LongArithmeticMath Sub(LongArithmeticMath tmpa, LongArithmeticMath tmpb) {
        LongArithmeticMath a = tmpa;
        LongArithmeticMath b = tmpb;
        if (a.sign == true && b.sign == false) {
            b.sign = true;
            return Sum(a, b);
        }
        if (a.sign == false && b.sign == true) {
            b.sign = false;
            return Sum(b, a);
        }
        if (a.sign == false && b.sign == false) {
            b.sign = true;
            LongArithmeticMath temp = a;
            a = b;
            b = temp;
        }

        int maxLength = a.GetLength() > b.GetLength() ? a.length : b.length;
        LongArithmeticMath c = new LongArithmeticMath();

        if (Compare(a, b) == -1) {
            LongArithmeticMath temp = a;
            a = b;
            b = temp;
            c.sign = false;
        }

        int p = 0;
        for (int i = 0; i < maxLength; ++i) {
            if (a.digits[i] >= b.digits[i]) {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i]);
            } else {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i] + 10);
                a.digits[i + 1]--;
            }
        }
        c.GetLength();
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
     * @param divider Делитель
     * @return Результат деления без остатка
     */
    public static LongArithmethic div(LongArithmethic dividend, LongArithmethic divider) {

        //TODO выбрасывать исключение ArithmeticException
        LongArithmethic result = new LongArithmeticImpl();
        if (divider.toString().equals("0")) {
            return result;
        }
        if ((dividend.getSign() && divider.getSign()) || (!dividend.getSign() && !divider.getSign())) {
            result.setSign(false);
        }
        LongArithmethic tmp = divider;
        LongArithmethic one = new LongArithmeticImpl();
        one.getDigits()[0] = 1;
        one.setLength(1);
        while (dividend.compareTo(tmp) >= 0) {
            result = Sum(result, one);
            tmp = Sum(tmp, divider);
        }
        result.getLength();
        return result;
    }
}
