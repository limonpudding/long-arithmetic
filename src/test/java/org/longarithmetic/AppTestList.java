package org.longarithmetic;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTestList extends AbstractTests {

    @Test
    public void testSum(){
        LongArithmethic a = new LongArithmeticImplList("199");
        LongArithmethic b = new LongArithmeticImplList("899");
        LongArithmethic c = LongArithmeticMath.sum(b,a);
        assertEquals(c.compareTo(new LongArithmeticImplList("1098")), 0);
    }

    @Test
    public void testSumWithNegativeNumber(){
        LongArithmethic a = new LongArithmeticImplList("199");
        LongArithmethic b = new LongArithmeticImplList("-899");
        LongArithmethic c = LongArithmeticMath.sum(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("-700")), 0);
    }

    @Test
    public void testSumNegativeWithNegative(){
        LongArithmethic a = new LongArithmeticImplList("-199");
        LongArithmethic b = new LongArithmeticImplList("-899");
        LongArithmethic c = LongArithmeticMath.sum(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("-1098")), 0);
    }

    @Test
    public void testSubPositiveWithPositive(){
        LongArithmethic a = new LongArithmeticImplList("199");
        LongArithmethic b = new LongArithmeticImplList("899");
        LongArithmethic c = LongArithmeticMath.sub(b,a);
        assertEquals(c.compareTo(new LongArithmeticImplList("700")), 0);
    }

    @Test
    public void testSubPositiveWithPositiveHard(){
        LongArithmethic a = new LongArithmeticImplList("2001");
        LongArithmethic b = new LongArithmeticImplList("2");
        LongArithmethic c = LongArithmeticMath.sub(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("1999")), 0);
    }

    @Test
    public void testSubNegativeWithPositive(){
        LongArithmethic a = new LongArithmeticImplList("-2001");
        LongArithmethic b = new LongArithmeticImplList("2");
        LongArithmethic c = LongArithmeticMath.sub(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("-2003")), 0);
    }

    @Test
    public void testSubHard(){
        LongArithmethic a = new LongArithmeticImplList("1001");
        LongArithmethic b = new LongArithmeticImplList("1000");
        LongArithmethic c = LongArithmeticMath.sub(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("1")), 0);
    }

    @Test
    public void testSubNegativeWithNegative(){
        LongArithmethic a = new LongArithmeticImplList("-2001");
        LongArithmethic b = new LongArithmeticImplList("-2");
        LongArithmethic c = LongArithmeticMath.sub(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("-1999")), 0);
    }

    @Test
    public void testMulPositiveWithPositive(){
        LongArithmethic a = new LongArithmeticImplList("199");
        LongArithmethic b = new LongArithmeticImplList("899");
        LongArithmethic c = LongArithmeticMath.mul(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("178901")), 0);
    }

    @Test
    public void testDivPositiveWithPositive(){
        LongArithmethic b = new LongArithmeticImplList("199");
        LongArithmethic a = new LongArithmeticImplList("899");
        LongArithmethic c = LongArithmeticMath.div(a,b);
        assertEquals(c.compareTo(new LongArithmeticImplList("4")), 0);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivNull(){
        LongArithmethic a = new LongArithmeticImplList("199");
        LongArithmethic b = new LongArithmeticImplList("0");
        LongArithmeticMath.div(a,b);
    }
    @Test
    public void fibonacci(){
        assertEquals(0, new Fibonacci(20).number.compareTo(new LongArithmeticImplList("6765")));
    }

}
