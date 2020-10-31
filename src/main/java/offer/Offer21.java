package offer;

public class Offer21 {

    // nums = [1,2,3,4]  output：[1,3,2,4]
    public int[] exchange(int[] nums) {
        int odd = -1;
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i] & 1) == 1) {
                if (i > odd) {
                    int tmp = nums[odd + 1];
                    nums[odd + 1] = nums[i];
                    nums[i] = tmp;
                    odd++;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Offer21 o = new Offer21();
        o.exchange(nums);
    }

}
