package arrays;

import java.util.HashMap;
import java.util.Map;

public class twoSums {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        //fill the map adding the
        for(int i = 0 ; i < nums.length; i++){
            int complement = target - nums[i];
            if(!numsMap.containsKey(complement)){
                numsMap.put(nums[i], i);
            }
            else{
                return new int[]{numsMap.get(complement), i};
            }
            numsMap.clear();
        }

        return null;
    }
}
