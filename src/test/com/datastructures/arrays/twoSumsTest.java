package com.datastructures.arrays;

import arrays.twoSums;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class twoSumsTest {
    @Test
    public void test(){
        int[]array = {2,7,11,15};
        int target = 9;

        twoSums twoSums = new twoSums();
        assertEquals(twoSums.twoSum(array, target), new int[]{0,2});
    }
}
