package com.bezditnyi.homework.lesson5.file;

import java.io.File;
import java.io.FileFilter;

/**
 * @author Viktor Bezditnyi.
 */
public class FileOnlyFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isFile();
    }
}
