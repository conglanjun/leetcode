package leetcode.problem5536;

import java.util.*;

public class Path {

    // n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
    public int maximalNetworkRank(int n, int[][] roads) {
        int max = 0;
        if (roads == null || roads.length == 0) return 0;
//        List<Integer> visited = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            for (int i1 = i + 1; i1 < n; ++i1) {
                visited.clear();
                int node1 = i;
                int node2 = i1;
                // 1 over
//                visited.add(node1 * 100 + node2);
                int res = 0;
                for (int j = 0; j < roads.length; ++j) {
                    int node11 = roads[j][0];
                    int node22 = roads[j][1];
                    if (visited.contains(node11 * 100 + node22)) continue;
                    if (node11 == node1 || node11 == node2) {
                        visited.add(node11 * 100 + node22);
                        res += 1;
                    } else if (node22 == node1 || node22 == node2) {
                        visited.add(node11 * 100 + node22);
                        res += 1;
                    }
                }
                if (max < res) {
                    max = res;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] l1 = new int[]{0,1};
        int[] l2 = new int[]{1,2};
        int[] l3 = new int[]{2,3};
        int[] l4 = new int[]{2,4};
        int[] l5 = new int[]{5,6};
        int[] l6 = new int[]{5,7};
        int[][] p = new int[6][2];
        p[0] = l1;
        p[1] = l2;
        p[2] = l3;
        p[3] = l4;
        p[4] = l5;
        p[5] = l6;
        Path path = new Path();
        int i = path.maximalNetworkRank(8, p);
        System.out.println(i);
    }

}
