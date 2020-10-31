package offer;

public class Offer17 {

    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; ++i) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer17 o = new Offer17();
        int[] ints = o.printNumbers(2);
        for (int i = 0; i < ints.length; ++i) {
            System.out.print(ints[i] + ", ");
        }
    }

}
