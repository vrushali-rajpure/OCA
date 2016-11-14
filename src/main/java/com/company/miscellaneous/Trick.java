package com.company.miscellaneous;

import org.junit.Test;

/**
 * Created by rajpurev on 6/11/16.
 */
public class Trick {

    @Test
    public void testIntegerEquality() {
        Integer i1 = 100, i2 = 100;
        Integer i3 = 400 , i4 = 400;

        System.out.println("i1 == i2 :" + (i1 == i2));
        System.out.println("i3 == i4 :" + (i3 == i4));

        Integer val1 = Integer.valueOf(100);
        Integer val2 = Integer.valueOf(100);

        Integer val3 = Integer.valueOf(400);
        Integer val4 = Integer.valueOf(400);

        System.out.println("val1 == val2 :" + (val1 == val2));
        System.out.println("val3 == val4 :" + (val3 == val4));

        int[] i = {1,1,1};

    }

    @Test
    public void testLongEquality() {
        Long i1 = 100L, i2 = 100L;
        Long i3 = 400L , i4 = 400L;

        System.out.println("i1 == i2 :" + (i1 == i2));
        System.out.println("i3 == i4 :" + (i3 == i4));

        Long val1 = Long.valueOf(100);
        Long val2 = Long.valueOf(100);

        Long val3 = Long.valueOf(400);
        Long val4 = Long.valueOf(400);

        System.out.println("val1 == val2 :" + (val1 == val2));
        System.out.println("val3 == val4 :" + (val3 == val4));
    }


}
