package leetcode.problem703;

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; ++i) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (pq.size() < this.k) {
            pq.add(val);
        } else if (pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest obj = new KthLargest(3, new int[]{4,5,8,2});
        int add = obj.add(3);
        System.out.println(add);
        add = obj.add(5);
        System.out.println(add);
        add = obj.add(10);
        System.out.println(add);
        add = obj.add(9);
        System.out.println(add);
        add = obj.add(4);
        System.out.println(add);
    }

}
