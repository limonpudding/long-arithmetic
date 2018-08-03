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
        LongArithmeticMath a = new LongArithmeticMath("199");
        LongArithmeticMath b = new LongArithmeticMath("899");
        LongArithmeticMath c = LongArithmeticMath.Sum(b,a);
        assertEquals("1098", c.ToString());
    }

    //TODO переименовать тесты. Имена должны быть "говорящими"

    @Test
    public void testSumWithNegativeNumber(){
        LongArithmeticMath a = new LongArithmeticMath("199");
        LongArithmeticMath b = new LongArithmeticMath("-899");
        LongArithmeticMath c = LongArithmeticMath.Sum(a,b);
        assertEquals("-700", c.ToString());
    }

    @Test
    public void testSum2(){
        LongArithmeticMath a = new LongArithmeticMath("-199");
        LongArithmeticMath b = new LongArithmeticMath("-899");
        LongArithmeticMath c = LongArithmeticMath.Sum(a,b);
        assertEquals("-1098", c.ToString());
    }

    @Test
    public void testSub(){
        LongArithmeticMath a = new LongArithmeticMath("199");
        LongArithmeticMath b = new LongArithmeticMath("899");
        LongArithmeticMath c = LongArithmeticMath.Sub(b,a);
        assertEquals("700", c.ToString());
    }

    @Test
    public void testSub2(){
        LongArithmeticMath a = new LongArithmeticMath("2001");
        LongArithmeticMath b = new LongArithmeticMath("2");
        LongArithmeticMath c = LongArithmeticMath.Sub(a,b);
        assertEquals("1999", c.ToString());
    }
    //TODO убрать совпадающие тесты
    @Test
    public void testSub3(){
        LongArithmeticMath a = new LongArithmeticMath("2001");
        LongArithmeticMath b = new LongArithmeticMath("2");
        LongArithmeticMath c = LongArithmeticMath.Sub(a,b);
        assertEquals("1999", c.ToString());
    }

    @Test
    public void testSub4(){
        LongArithmeticMath a = new LongArithmeticMath("-2001");
        LongArithmeticMath b = new LongArithmeticMath("2");
        LongArithmeticMath c = LongArithmeticMath.Sub(a,b);
        assertEquals("-2003", c.ToString());
    }

    @Test
    public void testSub5(){
        LongArithmeticMath a = new LongArithmeticMath("-2001");
        LongArithmeticMath b = new LongArithmeticMath("-2");
        LongArithmeticMath c = LongArithmeticMath.Sub(a,b);
        assertEquals("-1999", c.ToString());
    }

    @Test
    public void testMul(){
        LongArithmeticMath a = new LongArithmeticMath("199");
        LongArithmeticMath b = new LongArithmeticMath("899");
        LongArithmeticMath c = LongArithmeticMath.Mul(a,b);
        assertEquals("178901", c.ToString());
    }

    @Test
    public void testDiv2(){
        LongArithmeticMath b = new LongArithmeticMath("199");
        LongArithmeticMath a = new LongArithmeticMath("899");
        LongArithmeticMath c = LongArithmeticMath.div(a,b);
        assertEquals("4", c.ToString());
    }

    @Test
    public void testDivNull(){
        LongArithmeticMath a = new LongArithmeticMath("199");
        LongArithmeticMath b = new LongArithmeticMath("0");
        LongArithmeticMath c = LongArithmeticMath.div(a,b);
        assertEquals("Деление на ноль невозможно", c.ToString());
    }
    @Test
    public void fibonacci(){
        assertEquals("6765", new Fibonacci(20).number.ToString());
    }

}
