package sort;

import java.util.Arrays;
import java.util.List;

public class QuickSort {

    public int partition(List<Integer> li, int left, int right) {
        int tmp = li.get(left);
        while (left < right) {
            while (left < right && li.get(right) > tmp) {
                right--;
            }
            li.set(left, li.get(right));
            while (left < right && li.get(left) < tmp) {
                left++;
            }
            li.set(right, li.get(left));
        }
        li.set(left, tmp);
        return left;
    }

    public void quickSort(List<Integer> li, int left, int right) {
        if (li.size() < 2) {
            return;
        }
        if (left < right) {
            int mid = partition(li, left, right);
            quickSort(li, left, mid - 1);
            quickSort(li, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {8, 5, 1, 2, 4, 3, 9, 6, 7};
        List<Integer> li = Arrays.asList(list);
        QuickSort qs = new QuickSort();
        System.out.println(li);
        qs.quickSort1(li, 0, li.size() - 1);
        System.out.println(li);
    }

    public void quickSort1(List<Integer> li, int left, int right) {
        if (li.size() < 2) {
            return;
        }
        if (left < right) {
            int index = partition1(li, left, right);
            quickSort1(li, left, index - 1);
            quickSort1(li, index + 1, right);
        }
    }

    public int partition1(List<Integer> li, int left, int right) {
        int curr = li.get(left);
        while (left < right) {
            while (left < right && li.get(right) > curr) {
                right--;
            }
            li.set(left, li.get(right));
            while (left < right && li.get(left) < curr) {
                left++;
            }
            li.set(right, li.get(left));
        }
        li.set(left, curr);
        return left;
    }


}
