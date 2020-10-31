package offer;

public class Offer03Array {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] != nums[nums[i]]) {
                int tmp = nums[i];
                nums[i] = nums[nums[i]];
                nums[tmp] = tmp;
                continue;
            } else {
                ++i;
            }
            if (i - 1 != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,0,2,5,3};
        Offer03Array f = new Offer03Array();
        System.out.print(f.findRepeatNumber(nums));
    }

}
