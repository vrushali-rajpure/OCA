package com.company.miscellaneous;

/**
 * Created by rajpurev on 6/14/16.
 */
public class ReverseNumber {

    public static void main(String args[]) {

        int i = 123;

        int reverse = 0,mod = 0;

        while ( i > 0) {
            mod = i % 10;
            reverse = reverse * 10 + mod;
            i = i / 10;
        }

        System.out.println( reverse);
    }
}
