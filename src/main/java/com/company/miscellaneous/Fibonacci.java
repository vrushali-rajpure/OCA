package com.company.miscellaneous;

/**
 * Created by rajpurev on 6/14/16.
 */
public class Fibonacci {

    public static void main(String args[]) {
        withoutRecursion(8);
    }

    public static void withoutRecursion(int num) {

        int a = 0 , b = 1, c = 0;
        while ( a <= num){
            System.out.print( a);
            c = a + b;
            a = b;
            b = c;
        }

    }
}
