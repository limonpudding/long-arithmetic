package org.longarithmetic;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * Главный класс. интерфейс работы с пользователем
     * @param args
     */
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

        Scanner in = new Scanner(System.in);
        boolean F=true;
        String a,b;
        int k=0;
        while(F)
        {
            System.out.println( "Введите первое число: " );
            a=in.nextLine();
            System.out.println( "Введите второе число: " );
            b=in.nextLine();
            System.out.println( "Выберите операцию;\n" );
            System.out.println( "" +
                    "1. Умножение\n" +
                    "2. Деление\n" +
                    "3. Сложение\n" +
                    "4. Вычитание\n"+
                    "0. Выход\n");
            k = in.nextInt();
            switch (k) {
                case 0:
                    F=false;break;
                case 1:
                    System.out.println(LongArithmetic.Mul(new LongArithmetic(a),new LongArithmetic(b)).ToString());
                case 2:
                    System.out.println(LongArithmetic.Div(new LongArithmetic(a),new LongArithmetic(b)).ToString());
                case 3:
                    System.out.println(LongArithmetic.Sum(new LongArithmetic(a),new LongArithmetic(b)).ToString());
                case 4:
                    System.out.println(LongArithmetic.Sub(new LongArithmetic(a),new LongArithmetic(b)).ToString());
            }
        }


    }
}
