package leetcode.problem763;

import java.util.*;

public class Partition {

    // ababcbacadefegdehijhklij  [9,7,8]
//    public List<Integer> partitionLabels(String S) {
//        Set<String> set = new TreeSet<>((String o1, String o2) -> {
//                return o1.substring(o1.indexOf("_") + 1).compareTo(o2.substring(o2.indexOf("_") + 1));
//            }
//        );
//        List<Integer> res = new ArrayList<>();
//        int len = S.length();
//        for (int i = 0; i < len; ++i) {
//            char c = S.charAt(i);
//            set.add(i + "_" + c);
//        }
//        String[] strs = new String[set.size()];
//        set.toArray(strs);
//        Arrays.sort(strs, (String o1, String o2) -> {
//                return Integer.parseInt(o1.substring(0, o1.indexOf("_"))) > Integer.parseInt(o2.substring(0, o2.indexOf("_"))) ? 1 : -1;
//            });
//        int start = 0, end = 0;
//        for (String key: strs) {
//            int index = Integer.parseInt(key.split("_")[0]);
//            int lastIndex = S.lastIndexOf(key.split("_")[1]);
//            if (index <= end) {
//                if (lastIndex > end) {
//                    end = lastIndex;
//                }
//            } else {
//                res.add(end - start + 1);
//                start = index;
//                end = lastIndex;
//            }
//        }
//        res.add(end - start + 1);
//        return res;
//    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); ++i) {
            map.put(S.charAt(i), i);
        }
        int scanMaxPos = 0;
        int start = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            int maxPos = map.get(S.charAt(i));
            scanMaxPos = Math.max(scanMaxPos, maxPos);
            if (i == scanMaxPos) {
                res.add(scanMaxPos - start + 1);
                start = scanMaxPos + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        List<Integer> li = p.partitionLabels("eccbbbbdec");
        System.out.println(li);
    }

}
