package leetcode.problem767;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>((o1, o2) -> counts[o2 - 'a'] - counts[o1 - 'a']);
        for (char i = 'a'; i <= 'z'; i++) {
            if (counts[i - 'a'] > 0) {
                queue.offer(i);
            }
        }
        Character pre = null;
        StringBuffer sb = new StringBuffer();
        while (!queue.isEmpty() || pre != null) {
            if (queue.isEmpty() && pre != null) {
                return "";
            }
            Character poll = queue.poll();
            sb.append(poll);
            counts[poll - 'a']--;
            if (pre != null) {
                queue.offer(pre);
                pre = null;
            }
            if (counts[poll - 'a'] != 0) {
                pre = poll;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString r = new ReorganizeString();
        System.out.println(r.reorganizeString("aab"));
        System.out.println(r.reorganizeString1("aab"));
    }


    public String reorganizeString1(String s) {
        StringBuffer sb = new StringBuffer();
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });
        for (char i = 'a'; i <='z'; i ++) {
            if (counts[i - 'a'] > 0) {
                queue.offer(i);
            }
        }
        Character pre = null;
        while (!queue.isEmpty() || pre != null) {
            if (queue.isEmpty()) {
                return "";
            }
            Character poll = queue.poll();
            sb.append(poll);
            counts[poll - 'a']--;
            if (pre != null) {
                queue.offer(pre);
                pre = null;
            }
            if (counts[poll - 'a'] > 0) {
                pre = poll;
            }
        }
        return sb.toString();
    }
}
