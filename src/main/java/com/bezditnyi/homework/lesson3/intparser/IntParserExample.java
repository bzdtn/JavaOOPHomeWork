package com.bezditnyi.homework.lesson3.intparser;

/**
 * @author Viktor Bezditnyi.
 */
public class IntParserExample {
    public static void main(String[] args){
        String [] testValues = {
                "0",
                "-1",
                "+12",
                "12345",
                null,
                "",
                "-",
                "+",
                "214748364",
                "2147483647",
                "2147483648",
                "-2147483647",
                "-2147483648",
                "-2147483649",
                "2147483650",
                "-2147483650",
                "-asde",
                "1313-212"
        };
        int i = 0;
        for(String test: testValues){
            try{
                i = MyInt.parseMyInt(test);
                System.out.println("i = " + i);
            }
            catch (MyException e){
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
}
