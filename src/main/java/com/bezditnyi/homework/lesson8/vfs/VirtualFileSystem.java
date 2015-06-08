package com.bezditnyi.homework.lesson8.vfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Viktor Bezditnyi.
 */
public class VirtualFileSystem {
    public static void main(String...args) throws NullPointerException{
        VirtualObject fs = new VirtualObject("root", true, null);
        System.out.println(fs);
        fs.add("home", true);
        fs.add("temp", true);
        fs.add("file.z", false);
        System.out.println(fs);
        System.out.println(fs.getParentName());


        VirtualObject tmp = fs.getChild("temp");
        if (!tmp.add("templates", true)){
            System.out.println("Adding failed");
        }
        if (!tmp.add("templates", true)){
            System.out.println("Adding failed");
        }
        if (!tmp.add("temp", true)){
            System.out.println("Adding failed");
        }
        if (!tmp.add("template.xml", false)){
            System.out.println("Adding failed");
        }
        tmp = tmp.getChild(1);
        if (!tmp.add("abc", true)) {
            System.out.println("Adding failed");
        }
        if (!tmp.add("abc.tmp", false)) {
            System.out.println("Adding failed");
        }
        if (!tmp.add("abcd", true)) {
            System.out.println("Adding failed");
        }
        System.out.println(fs.treeToString("-"));

        if ((tmp = tmp.getParent()) == null){
            throw new NullPointerException();
        }
        System.out.println(tmp.treeToString("-"));
        System.out.println(tmp);

        System.out.println(fs.getChild("file.z"));

        if(!fs.delete("temp")) {
            System.out.println("Deleting failed");
        }
        System.out.println(fs.treeToString("-"));

        tmp = fs.getChild("home");
        String[] s = tmp.getChildrenNames();
        if (s != null) {
            Arrays.stream(s).forEach(System.out::println);
        }
    }
}
