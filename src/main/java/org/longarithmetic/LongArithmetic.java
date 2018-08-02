package org.longarithmetic;

public class LongArithmetic {
    private int n;//максимальная длина числа
    private byte []digits = new byte[n];
    private int length = 0;
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
        for (i = n - 1; i >= 0 && digits[i] == 0; --i);
        length = i;
        return length;
    }

    public static LongArithmetic Sum(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        int maxLenght = a.GetLength() > b.GetLength()? a.GetLength() : b.GetLength();
        int tmp = 0;
        int i;
        for (i = 0; i < maxLenght; ++i) {
            result.digits[i] = (byte)((a.digits[i] + b.digits[i] + tmp) % 10);
            tmp = (a.digits[i] + b.digits[i] + tmp) / 10;
        }
        result.digits[++i] = (byte)tmp;
        result.length = i;
        return result;
    }

    public String ToString() {
        String s = "";
        for (int i = 0; i < this.length; ++i)
            s = this.digits[i] + s;
        return s;
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
