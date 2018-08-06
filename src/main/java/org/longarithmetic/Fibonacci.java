package org.longarithmetic;

public class Fibonacci {
    /**
     * Конструктор. устанавливает значение указанного числа фибоначчи в number
     * @param x x-ое число фибоначчи
     */
    public LongArithmethic number;
    public Fibonacci(int x){
        LongArithmethic prev = new LongArithmeticImplList("1");
        LongArithmethic current = new LongArithmeticImplList("1");
        LongArithmethic next = new LongArithmeticImplList("2");
        if (x == 1) {
            number = new LongArithmeticImplList("1");
            return;
        }
        if (x == 2) {
            number = new LongArithmeticImplList("1");
            return;
        }
        for (int i = 2; i < x; ++i) {
            next = LongArithmeticMath.sum(current, prev);
            prev = current;
            current = next;
        }
        number = next;
    }
}
