package com.datastructures.arrays;

import arrays.SlidingWindowTechnique;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class slidingWindowTechniqueTest {

    SlidingWindowTechnique slidingWindowTechnique = new SlidingWindowTechnique();
    @Test
    public void test (){
        String input = "abcabcbb";

    }

    @Test
    public void subTest(){
        int [] values = new int[] {4,2,1,7,8,1,2,8,1,0};
        int sum = slidingWindowTechnique.maximumSum(values);

        assertEquals(16, sum);
    }
}
