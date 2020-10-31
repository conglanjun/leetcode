package examin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataClass {

    public int numberAdd(int num){
        String hexStr = Integer.toHexString(num);
        int len = hexStr.length();
        int head = len;
        int sum = 0;
        while (len > 0) {
            if (len > 1) {
                String subS = hexStr.substring(head - 2, len);
                sum += Integer.decode("0x" + subS);
                head -= 2;
                len -= 2;
            } else if (len == 1) {
                String subS = hexStr.substring(head - 1, len);
                sum += Integer.decode("0x" + subS);
                break;
            }
        }
        return sum;
    }

    public Map<Integer, Integer> dataToClass(int c, int b, int[] a) {
        int[] count = new int[a.length];
        int[] mod = new int[a.length];
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < a.length; ++i) {
            int fourBit = numberAdd(a[i]);
            mod[i] = fourBit % b;
            if(fourBit % b < c) {
                count[i] = 1;
                res.put(mod[i], res.getOrDefault(mod[i], 0) + 1);
            } else {
                count[i] = 0;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {256,257,258,259,260,261,262,263,264,500};
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int b = sc.nextInt();
//        int[] a = new int[10];
//        for (int i = 0; i < 10; ++i) {
//            a[i] = sc.nextInt();
//        }
        DataClass d =  new DataClass();
        Map<Integer, Integer> res = d.dataToClass(c, b, a);
        int max = 0;
        int type = -1;
        for (int key: res.keySet()) {
            if (res.get(key) > 0) {
                type = key;
                max = res.get(key);
            }
        }
        System.out.println(max);
    }

}
