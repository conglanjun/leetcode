package leetcode.problem1189;

// a b c d e f g h i j k l m n o
public class MaxNumberBalloon {
    public int maxNumberOfBalloons(String text) {
        int[] counts = new int[26];
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i) - 'a']++;
        }
        // b
        int min = counts[1];
        // a
        min = Math.min(min, counts[0]);
        // l 11
        min = Math.min(min, counts[11] / 2);
        // o 14
        min = Math.min(min, counts[14] / 2);
        // n 13
        min = Math.min(min, counts[13]);
        return min;
    }
}
