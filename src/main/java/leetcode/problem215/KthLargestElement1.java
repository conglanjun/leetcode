package leetcode.problem215;

public class KthLargestElement1 {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int tmp = nums[l];
        while (l < h) {
            while (l < h && nums[h] >= tmp) {
                --h;
            }
            nums[l] = nums[h];
            while (l < h && nums[l] <= tmp) {
                ++l;
            }
            nums[h] = nums[l];
        }
        nums[l] = tmp;
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargestElement1 k = new KthLargestElement1();
        System.out.println(k.findKthLargest(nums, 4));
    }

}
