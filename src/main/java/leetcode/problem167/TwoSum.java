package leetcode.problem167;

public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        int i = 0;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum > target) {
                --j;
            } else if (sum < target) {
                ++i;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] ret = t.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int i = 0; i < ret.length; ++i) {
            System.out.print(ret[i] + ", ");
        }
    }
}
