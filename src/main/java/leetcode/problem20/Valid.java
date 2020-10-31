package leetcode.problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid {

    private Map<Character, Character> map = new HashMap<>();
    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (!map.containsKey(chars[i])) {
                stack.add(chars[i]);
            } else if (stack.empty() || stack.pop() != map.get(chars[i])) {
                return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Valid v = new Valid();
        boolean valid = v.isValid("()");
        System.out.println(valid);
    }

}
