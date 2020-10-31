package leetcode.problem834;

import java.util.ArrayList;
import java.util.List;

public class TreePathSum {

    ArrayList<Integer>[] graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        graph = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; ++i) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        int[] distSum = new int[N];
        int[] nodeNum = new int[N];
        for (int i = 0; i < N; ++i) {
            nodeNum[i] = 1;
        }
        calDist(distSum, nodeNum, 0, -1);
        calResult(distSum, nodeNum, 0, -1);
        return distSum;
    }

    private void calDist(int[] distSum, int[] nodeNum, int root, int parent) {
        ArrayList<Integer> neighbors = graph[root];
        for (int i = 0; i < neighbors.size(); ++i) {
            int nei = neighbors.get(i);
            if (nei == parent) {
                continue;
            }
            calDist(distSum, nodeNum, nei, root);
            nodeNum[root] += nodeNum[nei];
            distSum[root] += distSum[nei] + nodeNum[nei];
        }
    }

    private void calResult(int[] distSum, int[] nodeNum, int root, int parent) {
        ArrayList<Integer> neighbors = graph[root];
        for (int i = 0; i < neighbors.size(); ++i) {
            int nei = neighbors.get(i);
            if (nei == parent) {
                continue;
            }
            distSum[nei] = distSum[root] - nodeNum[nei] + (distSum.length - nodeNum[nei]);
            calResult(distSum, nodeNum, nei, root);
        }
    }

}
