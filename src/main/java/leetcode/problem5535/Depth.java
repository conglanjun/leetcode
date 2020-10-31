package leetcode.problem5535;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Depth {

    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int maxSize = 0;
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                queue.add(chars[i]);
                if (maxSize < queue.size()) {
                    maxSize = queue.size();
                }
            } else if (chars[i] == ')') {
                queue.poll();
            }
        }
        if (queue.size() != 0) return 0;
        return maxSize;
    }

    public static void main(String[] args) {
        Depth d = new Depth();
        int i = d.maxDepth("(1+(2*3)+((8)/4))+1");
        System.out.println(i);
    }

}
