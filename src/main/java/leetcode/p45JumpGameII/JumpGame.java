package leetcode.p45JumpGameII;

public class JumpGame {
    public static int jump(int[] nums) {
        int maxPosition = nums.length - 1;
        int step = 0;
        while (maxPosition > 0) {
            for (int i = 0; i < maxPosition; i++) {
                if (i + nums[i] >= maxPosition) {
                    maxPosition = i;
                    step++;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }


    public static int jump1(int[] nums) {
        int maxPosition = 0;
        int step = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
