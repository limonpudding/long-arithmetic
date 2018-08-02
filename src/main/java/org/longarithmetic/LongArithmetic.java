package org.longarithmetic;

public class LongArithmetic {
    private static byte []digits = new byte[10000];
    private static int length = 0;
    public LongArithmetic(String number) {
        length=number.length();
        int j=0;
        for (int i = length - 1; i >= 0; --i)
            digits[j++]=(byte)number.charAt(i);
    }

    private int GetLength() {
        return length;
    }
}
