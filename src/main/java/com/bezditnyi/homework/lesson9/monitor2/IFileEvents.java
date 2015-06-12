package com.bezditnyi.homework.lesson9.monitor2;

public interface IFileEvents {
    void onFileAdded(String path);
    void onFileDeleted(String path);
    void onFileModified(String path);

}
