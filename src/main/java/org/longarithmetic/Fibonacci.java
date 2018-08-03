package org.longarithmetic;

public class Fibonacci {
    /**
     * Конструктор. устанавливает значение указанного числа фибоначчи в number
     * @param x x-ое число фибоначчи
     */
    public LongArithmetic number;
    public Fibonacci(int x){
        LongArithmetic prev = new LongArithmetic("1");
        LongArithmetic current = new LongArithmetic("1");
        LongArithmetic next = new LongArithmetic("2");
        if (x==1){
            number = new LongArithmetic("1");
            return;
        }
        if (x==2){
            number = new LongArithmetic("1");
            return;
        }
        for (int i=2;i<x;++i){
            next = LongArithmetic.Sum(current,prev);
            prev = current;
            current = next;
        }
        number = next;
    }
}
