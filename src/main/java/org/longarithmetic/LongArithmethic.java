package org.longarithmetic;


public interface LongArithmethic <T> extends Comparable<LongArithmethic> {
    byte[] getDigits();

    void setLength(int length);

    T getDigit(int index);

    void setDigit(T digit, int index);

    int getLength();

    Sign getSign();

    void setSign(Sign sign);

    String toString();

}
