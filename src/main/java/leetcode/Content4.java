package leetcode;

public class Content4 {

    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        String bs = Integer.toBinaryString(n);
        
        return 0;
    }

}
