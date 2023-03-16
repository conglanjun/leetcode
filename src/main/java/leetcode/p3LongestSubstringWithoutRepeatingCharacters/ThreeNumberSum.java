package leetcode.p3LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int a, b, c, size = nums.length;
        for (a = 0; a < size - 2; ++a) {
            if (nums[a] > 0) break;
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            b = a + 1;
            c = size - 1;
            while (b < c) {
                if (nums[a] + nums[b] + nums[c] > 0) {
                    --c;
                } else if (nums[a] + nums[b] + nums[c] < 0) {
                    ++b;
                } else {
                    List<Integer> ele = new ArrayList<>();
                    ele.add(nums[a]);
                    ele.add(nums[b]);
                    ele.add(nums[c]);
                    ret.add(ele);
                    while (nums[b] == nums[b + 1]) {
                        ++b;
                    }
                    while (nums[c] == nums[c - 1]) {
                        --c;
                    }
                    ++b;
                    --c;
                }
            }
        }
        return ret;
    }

}
