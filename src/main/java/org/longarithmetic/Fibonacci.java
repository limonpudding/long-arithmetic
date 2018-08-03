package org.longarithmetic;

public class Fibonacci {
    /**
     * Конструктор. устанавливает значение указанного числа фибоначчи в number
     * @param x x-ое число фибоначчи
     */
    public LongArithmeticMath number;
    public Fibonacci(int x){
        LongArithmeticMath prev = new LongArithmeticMath("1");
        LongArithmeticMath current = new LongArithmeticMath("1");
        LongArithmeticMath next = new LongArithmeticMath("2");
        if (x==1){
            number = new LongArithmeticMath("1");
            return;
        }
        if (x==2){
            number = new LongArithmeticMath("1");
            return;
        }
        for (int i=2;i<x;++i){
            next = LongArithmeticMath.Sum(current,prev);
            prev = current;
            current = next;
        }
        number = next;
    }
}
