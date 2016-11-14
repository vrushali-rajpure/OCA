package com.company.sorting;

/**
 * Created by rajpurev on 7/29/16.
 */
public class MergeSort {

    public static void main(String args[]){
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void merge( int arr[], int low, int mid,int high) {



// Find sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;

        /* Create temp arrays */
        int a1[] = new int [n1];
        int a2[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            a1[i] = arr[low + i];
        for (int j=0; j<n2; ++j)
            a2[j] = arr[mid + 1+ j];


//        int[] a1, a2;
//        a1 = getSubList( arr,low, mid);
//        a2 = getSubList( arr, mid+1,high);

        int s1 = mid - low +1;
        int s2 = high - mid;

        int i = 0 , j = 0;
        int k = low;
        while ( i < s1 && j < s2 ){
            if( a1[i] < a2[j]){
                arr[k] = a1[i];
                i++;
            } else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }

        while ( i < s1) {
            arr[k] = a1[i];
            k++;
            i++;
        }

        while ( j < s2) {
            arr[k] = a2[j];
            k++;
            j++;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    private static void sort(int arr[],int l , int r) {
        if( l < r){
            int m = (l+r)/2;
            sort( arr, l, m);
            sort( arr, m+1,r);
            merge( arr, l,m,r);
        }
    }

    private static int[] getSubList(int arr[], int start, int end) {
        int newArr[] = new int[end-start];
        for ( int i = start, j = 0; i <= end; i++) {
            newArr[j] = arr[i];
            j++;
        }
        return  newArr;
    }
}
