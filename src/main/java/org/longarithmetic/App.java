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
        LongArithmetic a = new LongArithmetic("199");
        LongArithmetic b = new LongArithmetic("899");
        LongArithmetic r1 = LongArithmetic.Sum(a,b);
        LongArithmetic r2 = LongArithmetic.Mul(a,b);
        System.out.println(r1.ToString());
        System.out.println(r2.toString());
    }
}
