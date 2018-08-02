package org.longarithmetic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        for (int i = 0; i < args.length; i+=2)
        {
            try {
                if (args[i].equals("-c"))
                    LongArithmetic.SetDigitsCount(Integer.valueOf(args[++i]));
            } catch (Exception e) {
                System.out.println("Параметр -c задан неверно!");
            }
        }

    }
}
