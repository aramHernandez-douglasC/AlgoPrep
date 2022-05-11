package com.datastructures.arrays;

import arrays.firstDuplicate;
import org.junit.Assert;
import org.junit.Test;


public class firstDuplicateTest {

    @Test
    public void test1(){
        int[] testArray = new int[]{2,1,3,5,3,2};
        firstDuplicate duplicate = new firstDuplicate();
        Assert.assertEquals(3,duplicate.solution(testArray));
    }

    @Test
    public void test2(){
        int[] testArray = new int[]{8, 4, 6, 2, 6, 4, 7, 9, 5, 8};
        firstDuplicate duplicate = new firstDuplicate();
        Assert.assertEquals(6,duplicate.solutionb(testArray));
    }

    @Test
    public void test3(){
        int[] testArray = new int[]{10, 6, 8, 4, 9, 1, 7, 2, 5, 3};
        firstDuplicate duplicate = new firstDuplicate();
        Assert.assertEquals(-1,duplicate.solution(testArray));
    }


}
