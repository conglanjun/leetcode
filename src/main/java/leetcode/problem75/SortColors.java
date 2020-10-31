package leetcode.problem75;

public class SortColors {

    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 0) {
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) {
                swap(nums, --two, one);
            } else {
                one++;
            }
        }
    }

    private void swap(int[] p, int a, int b) {
        int tmp = p[a];
        p[a] = p[b];
        p[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        SortColors s = new SortColors();
        s.sortColors(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + ", ");
        }
    }

}
