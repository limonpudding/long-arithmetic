package org.longarithmetic;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    private LongArithmeticMath a;
    private LongArithmeticMath b;
    private LongArithmeticMath c;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Начато тестирование класса длинных чисел");
    }

    @AfterClass
    public  static void afterClass() {
        System.out.println("Тестирование класса длинных чисел окончено");
    }

    @Before
    public void startTest() {
        System.out.println("Тест начат");
    }
    
    @After
    public void endTest() {
        System.out.println("Тест завершён");
    }

    @Test
    public void testSum(){
        LongArithmethic a = new LongArithmeticImpl("199");
        LongArithmethic b = new LongArithmeticImpl("899");
        LongArithmethic c = LongArithmeticMath.Sum(b,a);
        assertEquals("1098", c.toString());
    }

    //TODO переименовать тесты. Имена должны быть "говорящими"

    @Test
    public void testSumWithNegativeNumber(){
        LongArithmethic a = new LongArithmeticImpl("199");
        LongArithmethic b = new LongArithmeticImpl("-899");
        LongArithmethic c = LongArithmeticMath.Sum(a,b);
        assertEquals("-700", c.toString());
    }

    @Test
    public void testSum2(){
        LongArithmethic a = new LongArithmeticImpl("-199");
        LongArithmethic b = new LongArithmeticImpl("-899");
        LongArithmethic c = LongArithmeticMath.Sum(a,b);
        assertEquals("-1098", c.toString());
    }

    @Test
    public void testSub(){
        LongArithmethic a = new LongArithmeticImpl("199");
        LongArithmethic b = new LongArithmeticImpl("899");
        LongArithmethic c = LongArithmeticMath.Sub(b,a);
        assertEquals("700", c.toString());
    }

    @Test
    public void testSub2(){
        LongArithmethic a = new LongArithmeticImpl("2001");
        LongArithmethic b = new LongArithmeticImpl("2");
        LongArithmethic c = LongArithmeticMath.Sub(a,b);
        assertEquals("1999", c.toString());
    }

    @Test
    public void testSub4(){
        LongArithmethic a = new LongArithmeticImpl("-2001");
        LongArithmethic b = new LongArithmeticImpl("2");
        LongArithmethic c = LongArithmeticMath.Sub(a,b);
        assertEquals("-2003", c.toString());
    }

    @Test
    public void testSub5(){
        LongArithmethic a = new LongArithmeticImpl("-2001");
        LongArithmethic b = new LongArithmeticImpl("-2");
        LongArithmethic c = LongArithmeticMath.Sub(a,b);
        assertEquals("-1999", c.toString());
    }

    @Test
    public void testMul(){
        LongArithmethic a = new LongArithmeticImpl("199");
        LongArithmethic b = new LongArithmeticImpl("899");
        LongArithmethic c = LongArithmeticMath.Mul(a,b);
        assertEquals("178901", c.toString());
    }

    @Test
    public void testDiv2(){
        LongArithmethic b = new LongArithmeticImpl("199");
        LongArithmethic a = new LongArithmeticImpl("899");
        LongArithmethic c = LongArithmeticMath.div(a,b);
        assertEquals("4", c.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void testDivNull(){
        LongArithmethic a = new LongArithmeticImpl("199");
        LongArithmethic b = new LongArithmeticImpl("0");
        LongArithmeticMath.div(a,b);
    }
    @Test
    public void fibonacci(){
        assertEquals("6765", new Fibonacci(20).number.toString());
    }

}
