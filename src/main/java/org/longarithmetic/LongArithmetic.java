package org.longarithmetic;

public class LongArithmetic {

    private int n=10000;//максимальная длина числа
    private byte []digits = new byte[n];
    private int length = 0;
    private boolean sign = true;

    public LongArithmetic(String number) {
        length=number.length();
        int j=0;
        for (int i = length - 1; i >= 0; --i)
            digits[j++]=(byte)(number.charAt(i) - '0');
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
        result.sign=a.sign;
        if (a.sign == true && b.sign == false){
            return Sub(a,b);
        }
        if (a.sign == false && b.sign == true){
            return Sub(b,a);
        }
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
        int tmp = 0;
        int tmp1;
        int i;
        int j;
        for (i = 0; i < b.length; ++i) {
            for (j = 0; j < a.length; ++j) {
                tmp1 = result.digits[j+i];
                result.digits[j+i] = (byte)((a.digits[j] * b.digits[i] + tmp1 + tmp) % 10);
                tmp = (byte)(tmp1 + a.digits[j] * b.digits[i] + tmp) / 10;
            }
            if (tmp>0)
                result.digits[result.GetLength()] += (byte)(tmp % 10);
            result.length = result.GetLength();
            tmp = 0;
            System.out.println(result.ToString());
        }
        return result;
    }

    public String ToString() {
        String s = "";
        for (int i = 0; i < this.GetLength(); ++i)
            s = this.digits[i] + s;
        return s;
    }

    public static LongArithmetic Sub(LongArithmetic a, LongArithmetic b) {
        if (a.sign == true && b.sign == false){
            return Sum(a,b);
        }
        if (a.sign == false && b.sign == true){
            b.sign=false;
            return Sum(b,a);
        }
        int maxLength = a.GetLength() > b.GetLength()? a.length : b.length;
        LongArithmetic c = new LongArithmetic( );
        int p=0;
        System.out.println(maxLength);
        for (int i = 0; i < maxLength; ++i){
            if (a.digits[i] >= b.digits[i]) {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i]);
            }
            else {
                c.digits[i] = (byte) (a.digits[i] - b.digits[i] + 10);
                a.digits[i+1]--;
            }
        }
        c.GetLength();
        return  c;
    }

    /*  1 если a>b
        0 a=b
       -1 a<b
     */
    public int Compare(LongArithmetic a, LongArithmetic b) {
        for (int i = n - 1; i >= 0 && a.digits[i] == 0 && b.digits[i] == 0; ++i);
        return 1;
    }

    public static LongArithmetic Div(LongArithmetic a, LongArithmetic b) {
        LongArithmetic result = new LongArithmetic( );
        result.GetLength();
        return  result;
    }
}
