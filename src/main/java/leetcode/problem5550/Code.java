package leetcode.problem5550;

public class Code {

    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        if (k == 0) return res;
        for (int i = 0; i < code.length; ++i) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; ++j) {
                    int index = (i + j) % len;
                    sum += code[index];
                }
            } else if (k < 0) {
                for (int j = -1; j >= k; --j) {
                    int index = (j + len + i) % len;
                    sum += code[index];
                }
            }
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] code = {5,2,2,3,1};
        Code c = new Code();
        c.decrypt(code, 3);
    }

}
