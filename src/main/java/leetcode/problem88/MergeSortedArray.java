package leetcode.problem88;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int mergeIndex = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[mergeIndex--] = nums2[j--];
            } else if (j < 0) {
                nums1[mergeIndex--] = nums1[i--];
            } else if (nums1[i] >= nums2[j]) {
                nums1[mergeIndex--] = nums1[i--];
            } else {
                nums1[mergeIndex--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        MergeSortedArray m = new MergeSortedArray();
        m.merge(num1, 3, num2, 3);
        for (int i = 0; i < num1.length; ++i) {
            System.out.print(num1[i] + ", ");
        }
    }

}
