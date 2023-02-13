package com.ryanmark;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt(){
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private static int getIntEAFP(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        try{
            return scan.nextInt();}
        catch(InputMismatchException e){
            return 0;
        }
    }

    private static int divideBYL(int x, int y){
        if (y !=0)
            return x/y;
        else
            return 0;
    }

    private static int divideEAFP(int x, int y){
        try {
            return x/y;
        }catch(ArithmeticException e){
            return 0;
        }
    }

    private static int divide (int x, int y){
        return x/y;
    }

}