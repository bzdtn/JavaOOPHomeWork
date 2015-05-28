package com.bezditnyi.homework.lesson5.file;


import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Viktor Bezditnyi.
 */
public class MyFileFilter implements FilenameFilter {
    private String ext;

    public MyFileFilter (String ext) {
        this.ext = ext;
    }

    @Override
    public boolean accept (File dir, String name) {
        return name.endsWith(this.ext);
    }
}
