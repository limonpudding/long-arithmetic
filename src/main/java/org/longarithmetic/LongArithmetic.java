package org.longarithmetic;

public class LongArithmetic {

    private int n=10000;//максимальная длина числа
    private byte []digits = new byte[n];
    private int length = 0;

    public LongArithmetic(String number) {
        length=number.length();
        int j=0;
        for (int i = length - 1; i >= 0; --i)
            digits[j++]=(byte)(number.charAt(i)-'0');
    }

    public LongArithmetic() {
        length = 0;
    }

    private int GetLength() {
        int i;
        for (i = n - 1; i >= 0 && digits[i] == 0; --i);
        length = i + 1;
        return length;
    }

    private void Clean(){
        for (int i=0;i<n;++i)
            digits[i]=0;
        length = 0;
    }

    public static LongArithmetic Sum(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        int maxLength = a.GetLength() > b.GetLength()? a.GetLength() : b.GetLength();
        int tmp = 0;
        int i;
        for (i = 0; i < maxLength; ++i) {
            result.digits[i] = (byte)((a.digits[i] + b.digits[i] + tmp) % 10);
            tmp = (a.digits[i] + b.digits[i] + tmp) / 10;
        }
        result.digits[i] = (byte)tmp;
        result.length = i + 1;
        return result;
    }

    public static LongArithmetic Mul(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic();
        int maxLength = a.GetLength() > b.GetLength()? a.GetLength() : b.GetLength();
        int tmp = 0;
        int i;
        int j;
        for (i = 0; i < maxLength; ++i) {
            for (j = 0; j < maxLength; ++j) {
                result.digits[j+i] += (byte) ((a.digits[i] * b.digits[j] + tmp) % 10);
                tmp = (a.digits[i] * b.digits[j] + tmp) / 10;
            }
            if (tmp>0)
                result.digits[j + i + 1] = (byte) tmp;
            result.length = j + i + 1;
            tmp = 0;
            if (result.length > maxLength)
                maxLength = result.length;
            System.out.println(result.ToString());
        }
        return result;
    }

    public String ToString() {
        String s = "";
        for (int i = 0; i < this.GetLength(); ++i) {
            s = this.digits[i] + s;
        }
        System.out.println(length);
        return s;
    }

    public static LongArithmetic Sub(LongArithmetic a, LongArithmetic b) {
        int maxLength = a.GetLength() > b.GetLength()? a.length : b.length;
        LongArithmetic c = new LongArithmetic( );
        int p=0;
        System.out.println(maxLength);
        for (int i = 0; i < maxLength; ++i){
            if (a.digits[i] + p >= b.digits[i]) {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i] + p);
                p = 0;
            }
            else {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i] + 10);
                p = -1;
            }
        }
        c.GetLength();
        return  c;
    }
}
