package org.longarithmetic;

enum LongConst {
    ONE(new LongArithmeticImplList("1")),
    ZERO(new LongArithmeticImplList("0"));

    private LongArithmethic value;

    public LongArithmethic getValue() {
        return value;
    }

    LongConst(LongArithmethic value) {
        this.value = value;
    }

}
