package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public void merge (List<Integer> li, int low, int mid, int high) {
        List<Integer> tmp = new ArrayList<Integer>();
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
        ms.mergeSort(li, 0, li.size() - 1);
        System.out.println(li);
    }
}
