package org.longarithmetic;

public class LongArithmetic {

    private static int n=10000;//максимальная длина числа
    private byte []digits = new byte[n];
    private int length = 0;
    private boolean sign = true;

    public static void SetDigitsCount(int dimension) {
            n = dimension;
    }

    /**
     * Конструктор для создания длинного числа.
     * Принимает строку. которая представляет собой целое число со знаком или без
     * @param number Строка
     */
    public LongArithmetic(String number) {
        length=number.length();
        if (number.charAt(0)=='-'){
            int j=1;
            for (int i = length - 1; i >= 0; --i)
                digits[j++]=(byte)(number.charAt(i) - '0');
            length--;
        }
        else {
            int j = 0;
            for (int i = length - 1; i >= 0; --i)
                digits[j++] = (byte) (number.charAt(i) - '0');
        }
    }

    private LongArithmetic() {
        length = 0;
    }

    private int GetLength() {
        int i;
        for (i = n - 1; i >= 0 && digits[i] == 0; --i);
        length = i + 1;
        return length;
    }

    private void Clean(){
        for (int i=0;i<n;++i)
            digits[i]=0;
        length = 0;
    }

    public static LongArithmetic Sum(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        result.sign=a.sign;
        if (a.sign == true && b.sign == false){
            b.sign=true;
            return Sub(a,b);
        }
        if (a.sign == false && b.sign == true){
            b.sign=false;
            return Sub(b,a);
        }
        int maxLength = a.GetLength() > b.GetLength()? a.GetLength() : b.GetLength();
        int tmp = 0;
        int i;
        for (i = 0; i < maxLength; ++i) {
            result.digits[i] = (byte)((a.digits[i] + b.digits[i] + tmp) % 10);
            tmp = (a.digits[i] + b.digits[i] + tmp) / 10;
        }
        result.digits[i] = (byte)tmp;
        result.length = i + 1;
        return result;
    }

    /**
     * Функция умножения двух длинных чисел
     * @param a первый множитель
     * @param b второй множитель
     * @return результат умножения
     */
    public static LongArithmetic Mul(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        if (a.sign != b.sign)
            result.sign = false;
        int tmp = 0;
        int tmp1;
        int i;
        int j;
        for (i = 0; i < b.length; ++i) {
            for (j = 0; j < a.length; ++j) {
                tmp1 = result.digits[j+i];
                result.digits[j+i] = (byte)((a.digits[j] * b.digits[i] + tmp1 + tmp) % 10);
                tmp = (byte)(tmp1 + a.digits[j] * b.digits[i] + tmp) / 10;
            }
            if (tmp>0)
                result.digits[result.GetLength()] += (byte)(tmp % 10);
            result.length = result.GetLength();
            tmp = 0;
        }
        return result;
    }

    /**
     * Метод. применяемый к экземпляру объекта длинного числа.
     * @return Возвращает строку (число со знаком или без)
     */
    public String ToString() {
        String s = "";

        for (int i = 0; i < this.GetLength(); ++i)
            s = this.digits[i] + s;
        if (sign==false)
            s="-" + s;
        return s;
    }

    /**
     * Функция вычитания двух длинных чисел
     * @param tmpa Уменьшаемое значение
     * @param tmpb Вычетаемое значение
     * @return Разность
     */
    public static LongArithmetic Sub(LongArithmetic tmpa, LongArithmetic tmpb) {
        LongArithmetic a = tmpa;
        LongArithmetic b = tmpb;
        if (a.sign == true && b.sign == false){
            b.sign=true;
            return Sum(a,b);
        }
        if (a.sign == false && b.sign == true){
            b.sign=false;
            return Sum(b,a);
        }
        if (a.sign == false && b.sign == false){
            b.sign=true;
            LongArithmetic temp = a;
            a = b;
            b = temp;
        }

        int maxLength = a.GetLength() > b.GetLength()? a.length : b.length;
        LongArithmetic c = new LongArithmetic( );

        if (Compare(a,b) == -1)
        {
            LongArithmetic temp = a;
            a = b;
            b = temp;
            c.sign=false;
        }

        int p=0;
        for (int i = 0; i < maxLength; ++i){
            if (a.digits[i] >= b.digits[i]) {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i]);
            }
            else {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i] + 10);
                a.digits[i+1]--;
            }
        }
        c.GetLength();
        return  c;
    }

    /*  1 если a>b
        0 a=b
       -1 a<b
     */

    /**
     * Функция сравнения двух длинных чисел.
     * @param a Первое число для сравнения
     * @param b Второе число для сравнения
     * @return результат сравнения: 1 если a больше b; 0 a равно b; -1 a меньше b.
     */
    public static int Compare(LongArithmetic a, LongArithmetic b) {
        int i = 0;
        int maxLength = a.GetLength() > b.GetLength()? a.GetLength() : b.GetLength();
        for (i = n - 1; i >= 0 && a.digits[i] == 0 && b.digits[i] == 0; --i);
        while (i >= 0 && a.digits[i] == b.digits[i])
            --i;
        if (i < 0)
            return 0;
        else if (a.digits[i] > b.digits[i])
            return 1;
        else
            return -1;
    }

    /**
     * Функция деления без остатка двух длинных чисел
     * @param a Делимое
     * @param b Делитель
     * @return Результат деления без остатка
     */
    public static LongArithmetic Div(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        if (a.sign != b.sign)
            result.sign = false;
        LongArithmetic tmp = b;
        LongArithmetic one = new LongArithmetic();
        one.digits[0] = 1;
        one.length = 1;
        int flagC = Compare(a, tmp);
        while (flagC != -1) {
            result = Sum(result, one);
            tmp = Sum(tmp, b);
            flagC = Compare(a, tmp);
        }
        result.GetLength();
        return  result;
    }
}
