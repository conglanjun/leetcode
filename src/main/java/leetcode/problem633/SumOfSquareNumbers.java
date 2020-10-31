package leetcode.problem633;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        int sqrt = (int) Math.sqrt(c);
        int i = 0;
        int j = sqrt;
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum < c) {
                ++i;
            } else if (sum > c) {
                --j;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SumOfSquareNumbers s = new SumOfSquareNumbers();
        boolean b = s.judgeSquareSum(2);
        System.out.println(b);
    }

}
