package leetcode.problem239;

import java.util.*;

public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> window = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; ++i) {
            while (window.size() > 0 && window.peekFirst() <= i - k) {
                window.pollFirst();
            }
            while (window.size() > 0 && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[window.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SlidingWindow s = new SlidingWindow();
        int[] nums = {1,3,1,2,0,5};
        int[] ints = s.maxSlidingWindow(nums, 3);
        for (int i = 0; i < ints.length; ++i) {
            System.out.print(ints[i] + ", ");
        }
        System.out.println();
    }

}
