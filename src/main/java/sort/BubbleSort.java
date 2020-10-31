package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public void bubbleSort(List<Integer> li) {
        for (int i = 0; i < li.size() - 1; ++i) {
            boolean exchange = false;
            for (int j = 0; j < li.size() - i - 1; ++j) {
                if (li.get(j) > li.get(j + 1)) {
                    int tmp = li.get(j);
                    li.set(j, li.get(j + 1));
                    li.set(j + 1, tmp);
                    exchange = true;
                }
            }
            if (!exchange){
                return;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] li = {3, 8, 9, 4, 5, 7, 6, 2, 1};
        List<Integer> arrayList = Arrays.asList(li);
        BubbleSort bubble = new BubbleSort();
        System.out.println(arrayList);
        bubble.bubbleSort(arrayList);
        System.out.println(arrayList);
    }
}
