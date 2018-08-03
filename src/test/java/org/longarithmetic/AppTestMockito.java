package org.longarithmetic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AppTestMockito extends AbstractTests {

    private LongArithmethic a;
    private LongArithmethic b;

    @Before
    public void prepareMock(){
        a = mock(LongArithmethic.class);
        b = mock(LongArithmethic.class);
        when(a.getSign()).thenReturn(true);
        when(b.getSign()).thenReturn(false, true);
        when(a.getLength()).thenReturn(2);
        when(b.getLength()).thenReturn(2);
        byte[] t1 = new byte[10000];
        t1[0] = 0;
        t1[1] = 1;
        byte[] t2 = new byte[10000];
        t2[0] = 9;
        byte[] t3 = new byte[10000];
        when(a.getDigits()).thenReturn(t1, t1, t3, t3, t1);
        when(b.getDigits()).thenReturn(t2);
        when(a.getDigit(anyInt())).thenReturn((byte) 0);
    }

    @Test
    public void getSignTest() {
        LongArithmethic sum = LongArithmeticMath.sum(a, b);
        assertEquals(0, sum.compareTo(new LongArithmeticImpl("1")));
        assertEquals(0, (new LongArithmeticImpl("-9")).compareTo(b));
        assertEquals(0, (new LongArithmeticImpl("10")).compareTo(a));
    }

    @After
    public void afterMock(){
        Mockito.reset(a,b);
    }
}
