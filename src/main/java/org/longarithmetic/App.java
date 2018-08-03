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
                    LongArithmeticMath.setDigitsCount(Integer.valueOf(args[++i]));
            } catch (Exception e) {
                System.out.println("Параметр -c задан неверно!");
            }
        }

        Scanner in = new Scanner(System.in);
        boolean F=true;
        String a,b;
        int k=0;
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
                    System.out.println("\nОтвет: "+ LongArithmeticMath.Mul(new LongArithmeticImpl(a),new LongArithmeticImpl(b)).toString()); break;
                case 2:
                    System.out.println("\nОтвет: "+ LongArithmeticMath.div(new LongArithmeticImpl(a),new LongArithmeticImpl(b)).toString()); break;
                case 3:
                    System.out.println("\nОтвет: "+ LongArithmeticMath.sum(new LongArithmeticImpl(a),new LongArithmeticImpl(b)).toString()); break;
                case 4:
                    System.out.println("\nОтвет: "+ LongArithmeticMath.sub(new LongArithmeticImpl(a),new LongArithmeticImpl(b)).toString()); break;
            }



    }
}
