package leetcode.p4MedianofTwoSortedArrays;

public class MedianTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int pre = -1;
        int result = -1;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i <= (len1 + len2) / 2; i++) {
            pre = result;
            if (index1 < len1 && (index2 >= len2 || nums1[index1] < nums2[index2])) {
                result = nums1[index1++];
            } else {
                result = nums2[index2++];
            }
        }
        if (((len1 + len2) & 1) == 0) {
            return (result + pre) / 2.0;
        }
        return result;
    }

}
