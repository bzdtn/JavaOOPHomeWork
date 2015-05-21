package com.bezditnyi.homework.lesson3.intparser;

/**
 * @author Viktor Bezditnyi.
 */
public class MyInt {
    //value holder
    private final int value;

    //const
    public static final int MAX_MYITN = 0x7fffffff; //2147483647
    public static final int MIN_MYITN = 0x80000000;
    public static final int DIV_10 = 214748364;

    public MyInt(String str) throws MyException {
        this.value = parseMyInt(str);
    }

    public static int parseMyInt(String str) throws MyException {
        if (str == null){
            throw new MyException("null pointer");
        }
        if ("".equals(str)){
            throw new MyException("Empty string");
        }
        char[] tmp = str.toCharArray();
        boolean isNegative = false;
        int value = 0;
        if (tmp[0] == '-'){
            if(tmp.length < 2){
                throw new MyException("single \"minus\" character");
            }
            isNegative = true;
            tmp[0] = '0';
        }
        if (tmp[0] == '+'){
            if(tmp.length < 2){
                throw new MyException("single \"plus\" character");
            }
            tmp[0] = '0';
        }
        for(char c: tmp){
            int digit = c - '0';
            if (digit < 0 | digit > 9){
                throw new MyException("Illegal characters: " + c);
            }
            if (value > MyInt.DIV_10){
                throw new MyException("MAX or MIN overflow");
            }
            if (isNegative){
                if((MyInt.MIN_MYITN + digit > -10 * value)) {
                    throw new MyException("MIN overflow");
                }
            }
            else{
                if (MyInt.MAX_MYITN - digit < 10 * value){
                    throw new MyException("MAX overflow");
                }
            }
            value = value * 10 + digit;
        }
        if(isNegative){
            return -value;
        }
        else{
            return value;
        }
    }

    public int getValue() {
        return value;
    }
}
