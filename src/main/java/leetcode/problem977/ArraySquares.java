package leetcode.problem977;

//input：[-4,-1,0,3,10]
//output：[0,1,9,16,100]
public class ArraySquares {

    public int[] sortedSquares(int[] A) {
        int firstPositive = 0;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] >= 0) {
                firstPositive = i;
                break;
            }
        }

        int firstNegative = firstPositive - 1;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            int afp = Integer.MAX_VALUE;
            int afn = Integer.MIN_VALUE;
            if (firstPositive >= 0 && firstPositive < A.length) {
                afp = A[firstPositive];
            }
            if (firstNegative >= 0 && firstNegative < A.length){
                afn = A[firstNegative];
            }
            if (firstNegative >= 0 && (afp * afp > afn * afn || afp == Integer.MAX_VALUE)) {
                res[i] = afn * afn;
                firstNegative--;
            } else if (firstNegative < 0 || (afp * afp <= afn * afn || afn == Integer.MIN_VALUE)) {
                res[i] = afp * afp;
                firstPositive++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ArraySquares a = new ArraySquares();
        int[] ints = a.sortedSquares(new int[]{-1,1});
        for (int i = 0; i < ints.length; ++i) {
            System.out.print(ints[i] + ", ");
        }
        System.out.println();
    }

}
