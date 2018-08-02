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
        //LongArithmetic r = LongArithmetic.Sum(a,b);
        LongArithmetic c = LongArithmetic.Sub(b,a);
        //System.out.println(r.ToString());
        System.out.println(c.ToString());
        System.out.println( "Hello World!" );
    }
}
