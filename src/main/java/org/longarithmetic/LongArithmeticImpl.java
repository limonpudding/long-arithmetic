package org.longarithmetic;

public class LongArithmeticImpl implements LongArithmethic {//реализация интерфейса LongArithmetic

    private static int n = 10000;//максимальная длина числа
    private byte[] digits = new byte[n];
    private int length = 0;
    Sign sign = Sign.PLUS;

    public LongArithmeticImpl(String number) {
        length = number.length();
        int j = 0;
        if (number.charAt(0) == '-') {
            sign = Sign.MINUS; //TODO добавить случай для знака +
            for (int i = length - 1; i >= 1; --i)
                digits[j++] = (byte) (number.charAt(i) - '0');
            length--;
        } else {
            for (int i = length - 1; i >= 0; --i)
                digits[j++] = (byte) (number.charAt(i) - '0');
        }
    }

    public LongArithmeticImpl() {
        length = 0;
    }

    public byte getDigit(int index){
        return digits[index];
    }

    public void setDigit(byte digit, int index){
        digits[index]=digit;
    }

    public byte[] getDigits() {
        return digits;
    }

    public void setDigits(byte[] digits) {
        this.digits = digits;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void clean() {
        for (int i = 0; i < n; ++i)
            digits[i] = 0;
        length = 0;
    }

    public int getLength() {
        int i;
        for (i = n - 1; i >= 0 && digits[i] == 0; --i) ;
        length = i + 1;
        return length;
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign sign) {
        this.sign=sign;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.getLength(); ++i)
            s = this.digits[i] + s;
        if (s == "")
            return "0";
        if (sign == Sign.MINUS)
            s = "-" + s;
        return s;

    }


    public int compareTo(LongArithmethic o) {
        int i = 0;
        for (i = n - 1; i >= 0 && digits[i] == 0 && o.getDigit(i) == 0; --i) ;
        while (i >= 0 && digits[i] == o.getDigit(i))
            --i;
        if (i < 0)
            return 0;
        else if (digits[i] > o.getDigit(i))
            return 1;
        else
            return -1;
    }
}
