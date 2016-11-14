package com.company.miscellaneous;

/**
 * Created by rajpurev on 6/14/16.
 */
public class PrintTriangle {

    //http://www.codenirvana.net/2013/04/creating-number-patterns-in-java_25.html

    public static void main(String args[]) {

        print1( 3);

        System.out.println("------------------");
        print2(4);

        System.out.println("------------------");
        print3(4);

    }


    /**
            *
            * *
            * * *
            * * * *

     */

    public static void print1(int row) {

        for (int i = 1; i <= row ; i++) {
            for ( int j = 0 ; j < i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /**

     * * * * * * *
       * * * * *
         * * *
           *

    LOGIC : Consecutive rows should
     contain 2n − 1, 2n − 3, . . . , 3, 1 asterisks and should be indented by 0, 2, 4, . . . , 2(n − 1)
     spaces

     */

    public static void print2(int row){

        for ( int i = row ; i > 0 ; i--) {

            for( int j = 0 ; j < row-i ; j++){
                System.out.print(" ");
            }

            for ( int k = 0 ; k < (2*i -1); k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    /**
             *
            ***
           *****
          *******

     */

    public static void print3(int row) {

        for (int i = 1; i <= row ; i++) {

            for (int k = 0; k < (row-i); k++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (2*i-1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
