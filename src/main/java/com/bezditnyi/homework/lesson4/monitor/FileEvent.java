package com.bezditnyi.homework.lesson4.monitor;

public class FileEvent implements FileEvenListener {

    @Override
    public void onFileAdded(String s) {
        System.out.println("File added: " + s);

    }

}
