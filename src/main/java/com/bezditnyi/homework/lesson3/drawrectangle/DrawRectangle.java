package com.bezditnyi.homework.lesson3.drawrectangle;

import java.util.Scanner;

/**
 * @author Viktor Bezditnyi.
 */
public class DrawRectangle {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input width: ");
        int width = scanner.nextInt();
        System.out.print("Input height: ");
        int height = scanner.nextInt();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
