package org.longarithmetic;

enum Sign {
    PLUS, MINUS;
    public Sign reverse() { return this == PLUS ? MINUS : PLUS; }
}

enum LongConst {
    ONE, ZERO
}


public interface LongArithmethic extends Comparable<LongArithmethic> {
    byte[] getDigits();

    void setLength(int length);

    byte getDigit(int index);

    void setDigit(byte digit, int index);

    int getLength();

    Sign getSign();

    void setSign(Sign sign);

    String toString();

}
