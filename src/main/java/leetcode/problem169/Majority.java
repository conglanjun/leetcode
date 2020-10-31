package leetcode.problem169;

import java.util.HashMap;
import java.util.Map;

public class Majority {

    private Map<Integer, Integer> map = new HashMap<>();

    public int majorityElement(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int max = 0;
        int res = -1;
        for (int key: map.keySet()) {
            int val = map.get(key);
            if (val > max) {
                max = val;
                res = key;
            }
        }
        return res;
    }

}
