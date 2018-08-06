package org.longarithmetic;

enum LongConst {
    ONE, ZERO;

    public LongArithmethic value() {
        return this == ONE ? new LongArithmeticImplList("1") : new LongArithmeticImplList("0");
    }
    }
