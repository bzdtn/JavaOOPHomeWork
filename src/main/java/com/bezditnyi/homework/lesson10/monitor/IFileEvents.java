package com.bezditnyi.homework.lesson10.monitor;

public interface IFileEvents {
    void onFileChanged(String path);
    void onFileAdded(String path);
    void onFileDeleted(String path);
}
