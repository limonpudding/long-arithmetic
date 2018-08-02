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

    private int GetLength() {
        int i;
        for (i = n - 1; i >= 0 && digits[i] == 0; --i);
        length = i;
        return length;
    }

    public static LongArithmetic Sub(LongArithmetic a, LongArithmetic b) {
        int maxLength = a.GetLength() > b.GetLength()? a.length : b.length;
        LongArithmetic c = new LongArithmetic();
        for (int i = 0; i < maxLength; ++i){
            if (a.digits[i] >= b.digits[i])
                c.digits[i]=a.digits[i] - b.digits[i];
        }
    }

}
