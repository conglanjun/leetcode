package sort;

import java.util.Arrays;
import java.util.List;

public class InsertSort {

    public void insertSort(List<Integer> li){
        for (int i = 1; i < li.size(); ++i){
            int tmp = li.get(i);
            int j = i - 1;
            while(j >= 0 && li.get(j) > tmp){
                j--;
            }
            li.set(j + 1, tmp);
        }
    }

    public static void main(String[] args) {
        Integer[] list = {8, 7, 2, 1, 4, 5, 7, 9, 3, 6};
        List<Integer> li = Arrays.asList(list);
        InsertSort is = new InsertSort();
        System.out.println(li);
        is.insertSort(li);
        System.out.println(li);
    }

}
