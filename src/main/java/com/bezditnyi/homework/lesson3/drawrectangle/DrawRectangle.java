package com.bezditnyi.homework.lesson3.drawrectangle;

import java.util.Scanner;

/**
 * @author Viktor Bezditnyi.
 */
public class DrawRectangle {

    public static void draw(int width, int height){
        if (width <1 | height < 1){
            System.out.println("Bad params");
            return;
        }
        if (width == 1){
            for (int i = 0; i < height; i++) {
                System.out.println("*");
            }
            return;
        }
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
        if (height == 1){
            return;
        }

        for (int i = 1; i < height - 1; i++) {
            System.out.print("*");
            for (int j = 1; j < width - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input width: ");
        int width = scanner.nextInt();
        System.out.print("Input height: ");
        int height = scanner.nextInt();
        draw(width, height);
    }
}
