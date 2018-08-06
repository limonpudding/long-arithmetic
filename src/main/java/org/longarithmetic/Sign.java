package org.longarithmetic;

enum Sign {
    PLUS, MINUS;
    public Sign reverse() { return this == PLUS ? MINUS : PLUS; }
}
