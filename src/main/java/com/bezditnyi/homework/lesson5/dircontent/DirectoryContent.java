package com.bezditnyi.homework.lesson5.dircontent;

import com.bezditnyi.homework.util.Constants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Viktor Bezditnyi.
 */
public class DirectoryContent {

    public static void dirContent (String srcDir, String infoFileDir)
            throws IOException
    {
        File dir = new File(srcDir);
        if (dir.listFiles() == null){
            throw new IOException("wrong directory name");
        }
        //result info file will have name like "info2015-05-28_10-32-55.txt"
        // try-with-resources to autoclose, exceptions will be caught in caller
        try (FileWriter infoFile = new FileWriter(infoFileDir + "/info" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".txt")){
            //System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")));
            for (File file: dir.listFiles()) {
                //
                if (file.isDirectory()) {
                    continue;
                }
                infoFile.write("Path: " + file.getAbsolutePath() + "\n");
                infoFile.write("File: " + file.getName() + "\n");
                infoFile.write("Last Modified: " + Date.from(Instant.ofEpochMilli(file.lastModified())) + "\n");
                //it is to hard to get time of file creation
                infoFile.write("Created: " + Files.readAttributes(FileSystems.getDefault().getPath(file.getAbsolutePath()), BasicFileAttributes.class).creationTime().toString() + "\n\n");
            }
        }
    }

    public static void main (String ... args) {
        try{
            dirContent(Constants.FILE_PATH_LESSON_5 + "/src", Constants.FILE_PATH_LESSON_5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
