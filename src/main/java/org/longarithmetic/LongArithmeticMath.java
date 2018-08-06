package org.longarithmetic;

public class LongArithmeticMath {

    private static int n = 10000;//максимальная длина числа

    public static void setDigitsCount(int dimension) {
        n = dimension;
    }

    public static LongArithmethic<Integer> sum(LongArithmethic addendum, LongArithmethic term) {
        LongArithmethic<Integer> a = addendum;
        LongArithmethic<Integer> b = term;
        LongArithmethic<Integer> result = new LongArithmeticImplList();
        result.setSign(a.getSign());
        if (a.getSign()==Sign.PLUS && b.getSign()==Sign.MINUS) {
            b.setSign(Sign.PLUS);
            return sub(a, b);
        }
        if (a.getSign()==Sign.MINUS && b.getSign()==Sign.PLUS) {
            b.setSign(Sign.MINUS);
            return sub(b, a);
        }
        int maxLength = a.getLength() > b.getLength() ? a.getLength() : b.getLength();
        int tmp = 0;
        int i;
        for (i = 0; i < maxLength; ++i) {
            result.setDigit(((a.getDigit(i) + b.getDigit(i) + tmp) % 10),i);
            tmp = (a.getDigit(i) + b.getDigit(i) + tmp) / 10;
        }
        result.setDigit(tmp,i);
        result.setLength(i+1);
        return result;
    }

    /**
     * Функция умножения двух длинных чисел
     *
     * @param multiplied первый множитель
     * @param factor второй множитель
     * @return результат умножения
     */
    public static LongArithmethic<Integer> mul(LongArithmethic multiplied, LongArithmethic factor) {
        LongArithmethic<Integer> a = multiplied;
        LongArithmethic<Integer> b = factor;
        LongArithmethic<Integer> result = new LongArithmeticImplList();
        if (a.getSign()!=b.getSign()) {
            result.setSign(Sign.MINUS);
        }
        int tmp = 0;
        int tmp1;
        int i;
        int j;
        for (i = 0; i < b.getLength(); ++i) {
            for (j = 0; j < a.getLength(); ++j) {
                tmp1 = result.getDigit(j + i);
                result.setDigit(((a.getDigit(j) * b.getDigit(i) + tmp1 + tmp) % 10),j + i);
                tmp = (tmp1 + a.getDigit(j) * b.getDigit(i) + tmp) / 10;
            }
            if (tmp > 0)
                result.setDigit((result.getDigit(result.getLength())+ (tmp % 10)),result.getLength());
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
     * @param minuend Уменьшаемое значение
     * @param subtrahend Вычетаемое значение
     * @return Разность
     */
    public static LongArithmethic<Integer> sub(LongArithmethic minuend, LongArithmethic subtrahend) {
        LongArithmethic<Integer> a = minuend;
        LongArithmethic<Integer> b = subtrahend;
        if (a.getSign()==Sign.PLUS && b.getSign()==Sign.MINUS) {
            b.setSign(Sign.PLUS);
            return sum(a, b);
        }
        if (a.getSign()==Sign.MINUS && b.getSign()==Sign.PLUS) {
            b.setSign(Sign.MINUS);
            return sum(b, a);
        }
        if (a.getSign()==Sign.MINUS && b.getSign()==Sign.MINUS) {
            b.setSign(Sign.PLUS);
            LongArithmethic<Integer> temp = a;
            a = b;
            b = temp;
        }

        int maxLength = a.getLength() > b.getLength() ? a.getLength() : b.getLength();
        LongArithmethic<Integer> c = new LongArithmeticImplList();

        if (a.compareTo(b) == -1) {
            LongArithmethic temp = a;
            a = b;
            b = temp;
            c.setSign(Sign.MINUS);
        }

        for (int i = 0; i < maxLength; ++i) {
            if (a.getDigit(i) >= b.getDigit(i)) {
                c.setDigit((a.getDigit(i) - b.getDigit(i)), i);
            } else {
                c.setDigit((a.getDigit(i) - b.getDigit(i) + 10), i);
                a.setDigit((a.getDigit(i + 1) - 1), i + 1);
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
    public static LongArithmethic<Integer> div(LongArithmethic dividend, LongArithmethic divider) {
        LongArithmethic<Integer> result = new LongArithmeticImplList();
        if (divider.toString().equals("0")) {
            throw new ArithmeticException();
        }
        if (dividend.getSign()!=divider.getSign()) {
            result.setSign(Sign.MINUS);
        }
        LongArithmethic<Integer> tmp = divider;
        LongArithmethic<Integer> one = new LongArithmeticImplList();
        one.setDigit( 1, 0);
        one.setLength(1);
        while (dividend.compareTo(tmp) >= 0) {
            result = sum(result, one);
            tmp = sum(tmp, divider);
        }
        result.getLength();
        return result;
    }
}
