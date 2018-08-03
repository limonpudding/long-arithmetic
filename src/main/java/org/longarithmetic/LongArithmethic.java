package org.longarithmetic;

public interface LongArithmethic extends Comparable<LongArithmethic> {
    byte[] getDigits();

    void setDigits(byte[] digits);

    void setLength(int length);

    byte getDigit(int index);

    void setDigit(byte digit, int index);

    void clean();

    int getLength();

    boolean getSign();

    void setSign(boolean sign);

    String toString();

}
