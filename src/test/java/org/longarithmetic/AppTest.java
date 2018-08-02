package org.longarithmetic;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testSum(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Sum(b,a);
        assertEquals("1098", c.ToString());
    }

    @Test
    public void testSum1(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("-899");
        LongArithmetic c = LongArithmetic.Sum(a,b);
        assertEquals("-700", c.ToString());
    }

    @Test
    public void testSum2(){
        LongArithmetic a = new LongArithmetic("-199");
        LongArithmetic b = new LongArithmetic("-899");
        LongArithmetic c = LongArithmetic.Sum(a,b);
        assertEquals("-1098", c.ToString());
    }

    @Test
    public void testSub(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Sub(b,a);
        assertEquals("700", c.ToString());
    }

    @Test
    public void testSub2(){
        LongArithmetic a = new LongArithmetic("2001");
        LongArithmetic b = new LongArithmetic("2");
        LongArithmetic c = LongArithmetic.Sub(a,b);
        assertEquals("1999", c.ToString());
    }
    @Test
    public void testSub3(){
        LongArithmetic a = new LongArithmetic("2001");
        LongArithmetic b = new LongArithmetic("2");
        LongArithmetic c = LongArithmetic.Sub(a,b);
        assertEquals("1999", c.ToString());
    }

    @Test
    public void testSub4(){
        LongArithmetic a = new LongArithmetic("-2001");
        LongArithmetic b = new LongArithmetic("2");
        LongArithmetic c = LongArithmetic.Sub(a,b);
        assertEquals("-2003", c.ToString());
    }

    @Test
    public void testSub5(){
        LongArithmetic a = new LongArithmetic("-2001");
        LongArithmetic b = new LongArithmetic("-2");
        LongArithmetic c = LongArithmetic.Sub(a,b);
        assertEquals("-1999", c.ToString());
    }

    @Test
    public void testMul(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Mul(a,b);
        assertEquals("178901", c.ToString());
    }

    @Test
    public void testDiv2(){
        LongArithmetic b = new LongArithmetic("199");
        LongArithmetic a = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Div(a,b);
        assertEquals("4", c.ToString());
    }

    @Test
    public void testDivNull(){
        LongArithmetic b = new LongArithmetic("199");
        LongArithmetic a = new LongArithmetic("0");
        LongArithmetic c = LongArithmetic.Div(b,a);
        assertEquals("Деление на ноль невозможно", c.ToString());
    }

}
