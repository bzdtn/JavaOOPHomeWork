package com.bezditnyi.homework.lesson3.intparser;

import com.bezditnyi.homework.lesson3.polymorphism.developer.TraineeDeveloper;

import java.security.PublicKey;

/**
 * @author Viktor Bezditnyi.
 */
public class MyException extends Exception {

    public MyException(String message){
        super(message);
    }
    public MyException(String message, Throwable cause){
        super(message, cause);
    }

    public MyException(){
        super("MyException has nothing to say");
    }
}
