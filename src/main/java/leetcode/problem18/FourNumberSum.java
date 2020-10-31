package leetcode.problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        int a, b, c, d, size = nums.length;
        for (a = 0; a < size - 3; ++a) {
            if (a > 0 && nums[a - 1] == nums[a]) continue;
            for (b = a + 1; b < size - 2; ++b) {
                if (b > a + 1 && nums[b - 1] == nums[b]) continue;
                c = b + 1;
                d = size - 1;
                while (c < d) {
                    if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        --d;
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] < target) {
                        ++c;
                    } else {
                        List<Integer> ele = new ArrayList<>();
                        ele.add(nums[a]);
                        ele.add(nums[b]);
                        ele.add(nums[c]);
                        ele.add(nums[d]);
                        ret.add(ele);
                        while (c < d && nums[c] == nums[c + 1]) {
                            ++c;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            --d;
                        }
                        ++c;
                        --d;
                    }
                }
            }
        }
        return ret;
    }

}
