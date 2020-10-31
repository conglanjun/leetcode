package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Content3 {

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int same = 0;
        List<Double> comparePoints = new ArrayList<>();
        for (int i = 0; i < points.size(); ++i) {
            List<Integer> point = points.get(i);
            int x = point.get(0), y = point.get(1);
            if (x == location.get(0) && y == location.get(1)) {
                same++;
            } else {
                comparePoints.add(Math.atan2(y - location.get(1), x - location.get(0)) * 180 / Math.PI);
            }
        }
        Double[] doubles = comparePoints.toArray(new Double[comparePoints.size()]);
        Arrays.sort(doubles);
        comparePoints = new ArrayList<>(Arrays.asList(doubles));
        int m = comparePoints.size();
        for (int i = 0; i < m; ++i) {
            comparePoints.add(comparePoints.get(i) + 360);
        }
        int r = 0;
        int hi = 0;
        for (int i = 0; i < m; ++i) {
            while (r + 1 < comparePoints.size() && comparePoints.get(r + 1) - comparePoints.get(i) <= angle) {
                ++r;
            }
            hi = Math.max(hi, r + 1 - i);
        }
        return hi + same;
    }

    public static void main(String[] args) {
        // [[1,1],[2,2],[3,3],[4,4],[1,2],[2,1]]
        List<Integer> l1 = new ArrayList<>(Arrays.asList(new Integer[]{2,1}));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(new Integer[]{2,2}));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(new Integer[]{3,3}));
//        List<Integer> l4 = new ArrayList<>(Arrays.asList(new Integer[]{4,4}));
//        List<Integer> l5 = new ArrayList<>(Arrays.asList(new Integer[]{1,2}));
//        List<Integer> l6 = new ArrayList<>(Arrays.asList(new Integer[]{2,1}));
        List<List<Integer>> li = new ArrayList<>();
        li.add(l1);
        li.add(l2);
        li.add(l3);
//        li.add(l4);
//        li.add(l5);
//        li.add(l6);
        Content3 c = new Content3();
        int i = c.visiblePoints(li, 90, new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 1})));
        System.out.println(i);
    }

}
