package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public void merge (List<Integer> li, int low, int mid, int high) {
        List<Integer> tmp = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (li.get(i) < li.get(j)) {
                tmp.add(li.get(i++));
            }else{
                tmp.add(li.get(j++));
            }
        }
        while (i <= mid) {
            tmp.add(li.get(i++));
        }
        while (j <= high) {
            tmp.add(li.get(j++));
        }
        for (int x = 0; x < tmp.size(); ++x) {
            li.set(x + low, tmp.get(x));
        }
    }

    public void mergeSort (List<Integer> li, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(li, low, mid);
            mergeSort(li, mid + 1, high);
            merge(li, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {5, 7, 1, 4, 3, 2, 6, 9, 8};
        List<Integer> li = Arrays.asList(list);
        System.out.println(li);
        MergeSort ms = new MergeSort();
        ms.mergeSort1(li, 0, li.size() - 1);
        System.out.println(li);
    }


    public void mergeSort1(List<Integer> li, int left, int right) {
        int mid = (right + left) / 2;
        if (left < right) {
            mergeSort1(li, left, mid);
            mergeSort1(li, mid + 1, right);
            merge1(li, mid, left, right);
        }
    }

    public void merge1(List<Integer> li, int mid, int left, int right) {
        List<Integer> temp = new ArrayList<>();
        int leftStart = left;
        int rightStart = mid + 1;
        while (leftStart <= mid && rightStart <= right) {
            if (li.get(leftStart) < li.get(rightStart)) {
                temp.add(li.get(leftStart++));
            } else {
                temp.add(li.get(rightStart++));
            }
        }
        while (leftStart <= mid) {
            temp.add(li.get(leftStart++));
        }
        while (rightStart <= right) {
            temp.add(li.get(rightStart++));
        }
        for (int i = 0; i < temp.size(); i++) {
            li.set(left + i, temp.get(i));
        }
    }








}
