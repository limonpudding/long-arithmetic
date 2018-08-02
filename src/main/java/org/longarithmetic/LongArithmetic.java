package org.longarithmetic;

public class LongArithmetic {
    private static int n;//максимальная длина числа
    private static byte []digits = new byte[n];
    private static int length = 0;
    public LongArithmetic(String number) {
        length=number.length();
        int j=0;
        for (int i = length - 1; i >= 0; --i)
            digits[j++]=(byte)number.charAt(i);
    }

    public LongArithmetic() {
        length = 0;
    }

    private int GetLength() {
        int i;
        for (i = n - 1; i >= 0 && digits[i] == 0; --i) ;
        length = i;
        return length;
    }

    public static LongArithmetic Sum(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        int maxLenght = a.GetLength() > b.GetLength()? a.GetLength() : b.GetLength();
        int tmp = 0;
        int i;
        for (i = 0; i < maxLenght; ++i) {
            result.digits[0] = (byte)((a.digits[0] + b.digits[0] + tmp) % 10);
            tmp = (a.digits[0] + b.digits[0] + tmp) / 10;
        }
        result.digits[++i] = (byte)tmp;
        return result;
    }
}
