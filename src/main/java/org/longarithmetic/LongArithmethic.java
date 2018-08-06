package org.longarithmetic;


public interface LongArithmethic <T extends  Number> extends Comparable<LongArithmethic> {


    void setLength(int length);

    T getDigit(int index);

    void setDigit(T digit, int index);

    int getLength();

    Sign getSign();

    void setSign(Sign sign);

    String toString();

}
