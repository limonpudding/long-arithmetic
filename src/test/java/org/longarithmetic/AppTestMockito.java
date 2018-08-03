package org.longarithmetic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AppTestMockito extends AbstractTests {
    @Test
    public void getSignTest() {
        LongArithmethic a = mock(LongArithmethic.class); // 10
        LongArithmethic b = mock(LongArithmethic.class); // -9
        when (a.getSign()).thenReturn(true);
        when (b.getSign()).thenReturn(false,true);
        when (a.getLength()).thenReturn(2);
        when (b.getLength()).thenReturn(2);
        byte [] t1={0,1};
        byte [] t2={9,0};
        byte [] t3={0,0};
        when (a.getDigits()).thenReturn(t1,t1,t3);
        when (b.getDigits()).thenReturn(t2);
        when (a.getDigit(anyInt())).thenReturn((byte)0);
        LongArithmethic sum = LongArithmeticMath.sum(a, b);
        assertEquals(0, sum.compareTo(new LongArithmeticImpl("1")));

        /*when (a.getSign()).thenReturn(true);
        when (b.getSign()).thenReturn(true);
        when (a.getLength()).thenReturn(1);
        when (a.getLength()).thenReturn(1);
        byte [] t1={2};
        byte [] t2={5};
        when (a.getDigits()).thenReturn(t1);
        when (b.getDigits()).thenReturn(t2);
        LongArithmethic sum = LongArithmeticMath.sum(a, b);
        assertEquals(0, sum.compareTo(new LongArithmeticImpl("7")));*/
    }
}
