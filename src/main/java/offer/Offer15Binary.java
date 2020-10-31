package offer;

public class Offer15Binary {

    public int hammingWeight(int n) {
        int sum = 0;
        while(n!=0){
            sum += (n&1);
            n = n>>>1;//无符号右移
        }
        return sum;
    }
}
