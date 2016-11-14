package com.company.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajpurev on 6/14/16.
 */
public class EquilibriumIndex {

    public static void main(String args[]) {
        int[] arr = {-1, 3, -4, 5, 1, -6, 2, 1};
        long before = System.currentTimeMillis();
        System.out.println( solutionMine( arr));
        long after = System.currentTimeMillis();

        System.out.println( "Time Take solutionMine:" + (after - before));
        before = System.currentTimeMillis();
        System.out.println( solutionIdeal( arr));
        after = System.currentTimeMillis();

        System.out.println( "Time Take solutionIdeal:" + (after - before));
    }

    // Inefficient : Time complexity of this solution is O(n^2
    public static int solutionMine(int[] a) {
        // write your code in Java SE 8

        List<Integer> result = new ArrayList<>();
        for(int index = 0 ; index < a.length ; index++) {
            int sumBefore = 0;
            int sumAfter = 0;
            for(int k = 0 ; k < index; k++) {
                // System.out.println("index:" + index +" :K - " + a[k]);
                sumBefore += a[k];
            }
            //  System.out.println("index:" + index +" : sumB" + sumBefore);
            for(int j = index+1 ; j < a.length; j++) {
                //     System.out.println("index:" + index +" :J - " + a[j]);
                sumAfter +=  a[j];
            }
            // System.out.println("index:" + index +" : sumA" + sumAfter);
            if( sumBefore == sumAfter) {
                result.add(index);
            }
        }

        if( result.size() > 0) {
            return result.get(0);
        } else {
            return -1;
        }
    }

    // Efficient : Time Complexity: O(n)
    // Get total sum
    // for each iteration sum = sum - arr[index] // this is right sum
    // if leftSum == rightSum
    // else leftSum = leftSum + arr[index]
    public static int solutionIdeal(int[] arr) {

        int totalSum = 0, leftSum = 0;

        for ( int element: arr) {
            totalSum += element;
        }

        for ( int index = 0 ; index < arr.length ; index++) {

            totalSum  = totalSum - arr[index];

            if( leftSum == totalSum){
                return index;
            }

            leftSum = leftSum + arr[index];
        }

        return -1;
    }
}
