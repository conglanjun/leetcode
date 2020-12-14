package leetcode.problem1122;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Array {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; ++i) {
            map.put(arr2[i], i);
        }
        Integer[] array = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; ++i) {
            array[i] = arr1[i];
        }
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (map.containsKey(a) && map.containsKey(b)) {
                    return map.get(a) - map.get(b);
                }
                if (map.containsKey(a)) {
                    return -1;
                }
                if (map.containsKey(b)) {
                    return 1;
                }
                return a - b;
            }
        });
        for (int i = 0; i < array.length; ++i) {
            arr1[i] = array[i];
        }
        return arr1;
    }
}
