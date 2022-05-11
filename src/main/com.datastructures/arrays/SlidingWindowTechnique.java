package arrays;

import java.util.*;

public class SlidingWindowTechnique {

    //Sliding window algorithm using a hashset
    public int lengthOfLongestSubstring(String s) {
        int pointer1 = 0;
        int pointer2 = 0;
        int max = 0 ;

        Set<Character> hashSet = new HashSet<>();

        while(pointer2 < s.length()){
            if(!hashSet.contains(s.charAt(pointer2))){
                hashSet.add(s.charAt(pointer2));
                pointer2 ++;
                max = Math.max(hashSet.size(), max);
            } else{
                hashSet.remove(s.charAt(pointer1));
                pointer1 ++;
            }

        }
        return hashSet.size();

    }

    //MAXIMUM SUM OF CONTIGUOUS SUBARRAY OF SIZE 3
    //      BIG-0 =  O(n)
    public int maximumSum(int [] array){
        int currentRunningSum = 0;
        int maxSum = 0;
        int pointer1 = 0;
        int pointer2= 0;


        while(pointer2 < array.length ){
            int windowSize= pointer2-pointer1;
            if(windowSize == 3){
                maxSum = Math.max(maxSum, currentRunningSum);
                currentRunningSum = 0;
                pointer1++;
                pointer2 = pointer1;

            }
            currentRunningSum += array[pointer2];

            pointer2++;


        }

        return maxSum;
    }

    //Give a smallest subarray for a given sum so that the sum is >= k
    public int smallestSubArray(int array [], int k){
        int pointer1 = 0;
        int pointer2 = 0;
        int smallestSum = 0;
        int subArraySize = 0;

        while(pointer2 < array.length){
            int currentSum = 0 ;
            smallestSum =
            pointer2++;

        }

    }

}
