package org.longarithmetic;

public class LongArithmetic {
    private static byte []digits = new byte[10000];
    private static int length = 0;
    public LongArithmetic(String number) {

    }

    public LongArithmetic() {
        length = 0;
    }

    private int getLength() {
        return length;
    }

    public static LongArithmetic Sum(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        int maxLenght = a.getLength() > b.getLength()? a.getLength() : b.getLength();
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
