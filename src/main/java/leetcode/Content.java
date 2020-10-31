package leetcode;

import java.util.Arrays;

public class Content {

    // 2 3 5 6
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int x = 1;
        for (int i = 0; i < nums.length;) {
            int ele = nums[i];
            if (ele >= x) {
                if (nums.length - i == x) {
                    return x;
                } else if (nums.length - i > x) {
                    ++x;
                } else {
                    ++i;
                }
            } else {
                ++i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Content c = new Content();
        int i = c.specialArray(new int[]{3,6,7,7,0});
        System.out.println(i);
    }

}
