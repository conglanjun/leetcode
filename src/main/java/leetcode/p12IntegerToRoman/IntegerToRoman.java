package leetcode.p12IntegerToRoman;

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            if (num >= nums[i]) {
                int count = num / nums[i];
                for (int j = 0; j < count; j++) {
                    result.append(romans[i]);
                }
                num %= nums[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman itr = new IntegerToRoman();
        System.out.println(itr.intToRoman(4));
    }
}
