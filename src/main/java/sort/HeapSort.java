package sort;

import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public void sift(List<Integer> li, int low, int high) {
        int i = low;
        int j = 2 * i + 1;
        int tmp = li.get(low);
        while (j <= high) {
            if (j + 1 <= high && li.get(j) < li.get(j + 1)) {
                j++;
            }
            if (tmp < li.get(j)) {
                li.set(i, li.get(j));
                i = j;
                j = 2 * i + 1;
            }else{
                break;
            }
        }
        li.set(i, tmp);
    }

    public void heapSort(List<Integer> li) {
        // create heap
        for (int i = (li.size() - 2) / 2; i > -1; --i) {
            sift(li, i, li.size() - 1);
        }
        // sort
        for (int i = li.size() - 1; i > -1; --i) {
            int tmp = li.get(0);
            li.set(0, li.get(i));
            li.set(i, tmp);
            sift(li, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {4, 1, 3, 2, 5, 9, 6, 7, 8, 15, 12, 14, 11, 10, 13};
        List<Integer> li = Arrays.asList(list);
        System.out.println(li);
        HeapSort hs = new HeapSort();
        hs.heapSort(li);
        System.out.println(li);
    }
}
