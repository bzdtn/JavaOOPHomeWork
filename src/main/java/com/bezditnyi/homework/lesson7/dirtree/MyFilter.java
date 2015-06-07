package com.bezditnyi.homework.lesson7.dirtree;

import com.bezditnyi.homework.lesson3.intparser.MyException;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Viktor Bezditnyi.
 */
// useless
public class MyFilter implements FilenameFilter {
    private int len;
    String pattern;

    public MyFilter(){
        this(5, "^.e.*");
    }

    public MyFilter(int len, String pattern){
        this.len = len;
        this.pattern = pattern;
    }

    @Override
    public boolean accept(File dir, String name) {
        return (name.length() > len) && (name.matches(pattern));
    }
}
