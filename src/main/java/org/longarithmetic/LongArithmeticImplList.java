package org.longarithmetic;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LongArithmeticImplList <T extends Number> implements LongArithmethic <T> {

    private List<T> digits = new ArrayList<T>(); //TODO в чём минус использования ArrayList в этой задаче
    private int length = 0;

    Sign sign = Sign.PLUS;

    public LongArithmeticImplList(String number) {
        length = number.length();
        if (number.charAt(0) == '-') {
            sign = Sign.MINUS;
            for (int i = length - 1; i >= 1; --i){
                digits.add(kostyl(number.charAt(i)));
            }
            length--;
        } else {
            for (int i = length - 1; i >= 0; --i){
                digits.add(kostyl(number.charAt(i)));
            }
        }
    }

    private T kostyl(char symbol){
        Object o=null;
        switch (symbol) {
            case '0':
                o = new Integer(0);
                break;
            case '1':
                o = new Integer(1);
                break;
            case '2':
                o = new Integer(2);
                break;
            case '3':
                o = new Integer(3);
                break;
            case '4':
                o = new Integer(4);
                break;
            case '5':
                o = new Integer(5);
                break;
            case '6':
                o = new Integer(6);
                break;
            case '7':
                o = new Integer(7);
                break;
            case '8':
                o = new Integer(8);
                break;
            case '9':
                o = new Integer(9);
                break;
        }
        return (T)o;
    }

    public LongArithmeticImplList() {
    }

    public void setDigit(T digit, int index) {
        int len = digits.size();
        while (index + 1 > len) {
            digits.add(kostyl('0'));
            len++;
        }
        digits.set(index, digit);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public T getDigit(int index) {
        int len = digits.size();
        if (index + 1 > len)
            return kostyl('0');
        return digits.get(index);
    }

    public int getLength() {
        return digits.size();
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign = sign;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.getLength(); ++i)
            s = this.digits.get(i) + s;
        if (StringUtils.isBlank(s))
            return "0";
        if (sign == Sign.MINUS)
            s = "-" + s;
        return s;

    }


    public int compareTo(LongArithmethic o) {
        int i = 0;
        int n = digits.size() > o.getLength() ? digits.size() : o.getLength();
        for (i = n - 1; i >= 0 && getDigit(i) == kostyl('0') && o.getDigit(i) == kostyl('0'); --i) ;
        while (i >= 0 && getDigit(i) == o.getDigit(i))
            --i;
        if (i < 0)
            return 0;
        else if ((Integer)getDigit(i) > (Integer)o.getDigit(i))
            return 1;
        else
            return -1;
    }
}
