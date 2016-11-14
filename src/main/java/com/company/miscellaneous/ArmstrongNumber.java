package com.company.miscellaneous;

/**
 * Created by rajpurev on 6/14/16.
 */
public class ArmstrongNumber {

    /**
     * Armstrong number is a number that is the sum of its own digits each
     * raised to the power of the number of digits is equal to the number itself.
     *
     * Three Digits Armstrong number is 153, 1 ^ 3 + 5 ^ 3 + 3 ^ 3 = 153
       Four Digits Armstrong number is 1634, 1 ^ 4 + 6 ^ 4 + 3 ^ 4 + 4 ^ 4 + = 1634

     * @param args
     */
    public static void main(String args[]) {
        int num = 153;
        int length = String.valueOf(num).length();
        int arm = 0;
        int mod = 0;
        while( num > 0) {
            mod = num % 10;
            num = num / 10;

            arm += Math.pow( mod,length);
        }
        System.out.println( arm);
    }
}
