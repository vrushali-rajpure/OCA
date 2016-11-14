package com.company;

import java.util.TreeMap;

public class Main {

    private int i = 10;
    private static String a = "test";

    static {

        System.out.println("static block" + a);
    }

    {

        System.out.println("instance block" + i);
    }

    Main(){
        System.out.println("Constructor" + i);
    }

    public static void main(String[] args) {
        Main main = new Main();
	// write your code here
        StringBuilder sb = new StringBuilder();

        TreeMap<String,String> v = new TreeMap<>();
    }
}
