package leetcode.p13RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(romans[i], nums[i]);
        }
        char[] chars = s.toCharArray();
        char pre = ' ';
        int preValue = 0;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (!map.containsKey(pre + "" + current)) {
                int value = map.get(String.valueOf(current));
                pre = current;
                result += value;
                preValue = value;
            } else {
                int value = map.get(pre + "" + current);
                result -= preValue;
                result += value;
                pre = ' ';
                preValue = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger r = new RomanToInteger();
        System.out.println(r.romanToInt("IV"));
    }
}
