package leetcode.problem347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            frequentMap.put(nums[i], frequentMap.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key: frequentMap.keySet()) {
            int frequent = frequentMap.get(key);
            if(bucket[frequent] == null) {
                bucket[frequent] = new ArrayList();
            }
            bucket[frequent].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; --i) {
            if (bucket[i] == null) {
                continue;
            }
            if(bucket[i].size() < k - topK.size()) {
                topK.addAll(bucket[i]);
            } else if (bucket[i].size() >= k - topK.size()) {
                topK.addAll(bucket[i].subList(0, k - topK.size()));
            }
        }
        int[] res = new int[topK.size()];
        for (int i = 0; i < res.length; ++i) {
            res[i] = topK.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        TopKFrequent t = new TopKFrequent();
        int[] res = t.topKFrequent(nums, 1);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + ", ");
        }
    }

}
