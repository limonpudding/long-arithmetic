package org.longarithmetic;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSum(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Sum(b,a);
        assertEquals("1098", c.ToString());
    }

    public void testSub(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Sub(b,a);
        assertEquals("700", c.ToString());
    }
    public void testSub2(){
        LongArithmetic a = new LongArithmetic("2001");
        LongArithmetic b = new LongArithmetic("2");
        LongArithmetic c = LongArithmetic.Sub(a,b);
        assertEquals("1999", c.ToString());
    }

    public void testMul(){
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic c = LongArithmetic.Mul(a,b);
        assertEquals("178901", c.ToString());
    }

}
