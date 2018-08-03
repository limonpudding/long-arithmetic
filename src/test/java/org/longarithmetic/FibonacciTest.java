package org.longarithmetic;

import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest extends AbstractTests{
    @Test
    public void fibonacci(){
        assertEquals(0, new Fibonacci(20).number.compareTo(new LongArithmeticImpl("6765")));
    }

}