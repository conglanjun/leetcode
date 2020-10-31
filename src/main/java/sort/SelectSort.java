package sort;

import java.util.Arrays;
import java.util.List;

public class SelectSort {

    public void selectSort(List<Integer> li) {
        for (int i = 0; i < li.size() - 1; ++i){
            int minLocal = i;
            for (int j = i + 1; j < li.size(); ++j) {
                if (li.get(j) < li.get(minLocal)){
                    minLocal = j;
                }
            }
            if (minLocal != i){
                int tmp = li.get(i);
                li.set(i, li.get(minLocal));
                li.set(minLocal, tmp);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] li = {5, 1, 2, 8, 4, 3, 9, 6, 7};
        List<Integer> list = Arrays.asList(li);
        SelectSort ss = new SelectSort();
        System.out.println(list);
        ss.selectSort(list);
        System.out.println(list);
    }

}
