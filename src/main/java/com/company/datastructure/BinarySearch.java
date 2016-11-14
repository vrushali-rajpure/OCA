package com.company.datastructure;

/**
 * Created by rajpurev on 6/3/16.
 */
public class BinarySearch {

    public static void main(String args[]) {
        int arr[] = {1,2,3,4,6};

        System.out.println( "binarySearchNonRecursive(5) :" +  binarySearchNonRecursive( arr , 5));
        System.out.println( "binarySearchNonRecursive(3) :" +  binarySearchNonRecursive( arr , 3));
        System.out.println( "binarySearchNonRecursive(4) :" +  binarySearchNonRecursive( arr , 4));
        System.out.println( "binarySearchNonRecursive(1) :" +  binarySearchNonRecursive( arr , 1));

        System.out.println("----------------------------");

        int length = arr.length -1 ;
        System.out.println( "binarySearchRecursive(5) :" +  binarySearchRecursive( arr , 0,length,5));
        System.out.println( "binarySearchRecursive(3) :" +  binarySearchRecursive( arr , 0,length,3));
        System.out.println( "binarySearchRecursive(4) :" +  binarySearchRecursive( arr , 0,length,4));
        System.out.println( "binarySearchRecursive(1) :" +  binarySearchRecursive( arr , 0,length,1));

        System.out.println("----------------------------");
        System.out.println( "binarySearchIterative(5) :" +  binarySearchIterative( arr , 5));
        System.out.println( "binarySearchIterative(3) :" +  binarySearchIterative( arr , 3));
        System.out.println( "binarySearchIterative(4) :" +  binarySearchIterative( arr , 4));
        System.out.println( "binarySearchIterative(1) :" +  binarySearchIterative( arr , 1));


        System.out.println("----------------------------");
        int array[] = {5,6,1,2,4};
        System.out.println( "minimumInRotatingArray(5) :" +  minimumInRotatingArray( array ));

        int array1[] = {1,2,4};
        System.out.println( "minimumInRotatingArray(5) :" +  minimumInRotatingArray( array1 ));


        int array2[] = {5,6,4};
        System.out.println( "minimumInRotatingArray(5) :" +  minimumInRotatingArray( array2 ));


    }

    public static int linearSearch(int arr[],int num) {
        for ( int index = 0 ; index < arr.length ; index++) {
            if( num == arr[index]){
                return index;
            }
        }
        return -1;

    }
    public static int binarySearchNonRecursive( int arr[],int num) {
        int length = arr.length;
        int middleIndex = (length - 1) / 2;
        if( num == arr[middleIndex]) {
            return middleIndex;
        }

        if( num < arr[middleIndex]) {

            for ( int index = 0 ; index < middleIndex -1 ; index++) {
                if( num == arr[index]){
                    return index;
                }
            }
            return -1;
        } else {
            for ( int index = middleIndex + 1 ; index < length -1 ; index++) {
                if( num == arr[index]){
                    return index;
                }
            }
            return -1;
        }
    }

    public static int binarySearchRecursive( int arr[] , int startIndex, int length, int num  ) {

        if( length >= startIndex) {
            int middleIndex = startIndex + ( length - startIndex )/ 2;
            if( num == arr[ middleIndex]) {
                return middleIndex;
            }
            else if(  num < arr[middleIndex]){
                return binarySearchRecursive( arr,startIndex,middleIndex-1,num);
            } else {
                return binarySearchRecursive( arr,middleIndex+1,length,num);
            }
        }

        return -1;
    }

    public static int binarySearchIterative(int arr[] , int num) {

        int startIndex = 0 , length = arr.length -1;
        while ( startIndex <= length) {
            int middleIndex = startIndex + ( length - startIndex) / 2;
            if( num == arr[middleIndex]) {
                return middleIndex;
            } else if( num < arr[middleIndex]) {
                length = middleIndex -1;
            } else {
                startIndex = middleIndex + 1;
            }
        }
        return -1;
    }

    /**
     * Input: {5, 6, 1, 2, 3, 4}
     Output: 1

     Input: {1, 2, 3, 4}
     Output: 1

     Input: {2, 1}
     Output: 1

     * @param arr
     * @return
     */
    public static int minimumInRotatingArray(int arr[]) {

        int length = arr.length -1;
        int min = -1;
        for ( int index = length ; index > 0 ; index--) {
            if( arr[index] < arr[ index-1]) {
                min =  arr[index];
                break;
            } else {
                min = arr[index -1];
            }
        }
        return min;
    }
}
