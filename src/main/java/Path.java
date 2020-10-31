public class Path {

    // 左上开始  n*m    求最大路径的值
    /**
     * 3 * 4
     *
     * 1 0 3 1
     * 1 1 3 0
     * 2 0 1 2
     */
    public int getMax(int[][] p){
        if (p == null || p.length == 0 || p[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[p.length + 1][p[0].length + 1];
        for (int i = 1; i < p.length; ++i) {
            for (int j = 1; j < p[0].length; ++j) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + p[i][j];
            }
        }
        sop(dp);
        return 0;
    }

    public static void sop(int[][] arr){//dayin打印二维数组的
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] l0 = {0,0,0,0,0};
        int[] l1 = {0,1,0,3,1};
        int[] l2 = {0,1,1,3,0};
        int[] l3 = {0,2,0,1,2};
        int[][] p = new int[4][];
        p[0] = l0;
        p[1] = l1;
        p[2] = l2;
        p[3] = l3;
        Path path = new Path();
        int max = path.getMax(p);
        System.out.println(max);
    }

}
