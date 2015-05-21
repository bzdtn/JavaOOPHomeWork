package com.bezditnyi.homework.lesson3.exceptions;

/**
 * @author Viktor Bezditnyi.
 */
public class Parser {

    public static void parse(String queryString) throws IllegalArgumentException
    {
        String[] pairs = queryString.split("&", -1);
        for (String pair : pairs) {
            if ("".equals(pair)) {
                throw new IllegalArgumentException("Empty pair");
            }
            String[] parts = pair.split("=", -1);
            if (parts.length != 2) {
                throw new IllegalArgumentException("Wrong parts number");
            }
            if ("".equals(parts[0]) | "".equals(parts[1])) {
                throw new IllegalArgumentException("Empty parts");
            }
            System.out.println(parts[0] + ":" + parts[1]);
        }
    }

    public static void main(String[] args){
        String[] testQueryStrings = {
                null,
                "",
                "asdda=s",
                "as&ggt=ere&sdsd=121",
                "as=&ggt=ere&sdsd=121",
                "as=2&ggt=ere&sdsd=121",
        };
        for(String testQueryString: testQueryStrings) {
            System.out.println(testQueryString);
            try {
                parse(testQueryString);
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println("Exception: " + e.getMessage());
            } finally {
                System.out.println("-----------------------");
            }
        }
    }
}
