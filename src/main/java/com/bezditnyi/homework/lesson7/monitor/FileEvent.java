package com.bezditnyi.homework.lesson7.monitor;

public class FileEvent implements IFileEvenListener {

    @Override
    public void onFileAdded(String s) {
        System.out.println("File added: " + s);

    }

}
