package org.longarithmetic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LongArithmetic a = new LongArithmetic("2");
        LongArithmetic b = new LongArithmetic("2001");
        //LongArithmetic r1 = LongArithmetic.Sum(a,b);
        //LongArithmetic r2 = LongArithmetic.Mul(a,b);
        //System.out.println(r1.ToString());
        //System.out.println(r2.toString());
        //LongArithmetic r = LongArithmetic.Sum(a,b);
        LongArithmetic c = LongArithmetic.Sub(b,a);
        //System.out.println(r.ToString());
        System.out.println("-"+c.ToString()+"-");
        System.out.println( "Hello World!" );
    }
}
