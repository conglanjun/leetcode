package leetcode.problem28;

public class FindFirstOccurrence {
    public int strStr(String haystack, String needle) {
        int hayStrLen = haystack.length();
        int needStrLen = needle.length();
        for (int i = 0; i <= hayStrLen - needStrLen; i++) {
            int firstIndex = i;
            int secondIndex = 0;
            while (secondIndex < needStrLen && haystack.charAt(firstIndex) == needle.charAt(secondIndex)) {
                firstIndex++;
                secondIndex++;
            }
            if (secondIndex == needStrLen) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindFirstOccurrence f = new FindFirstOccurrence();
        int i = f.strStr("hello", "ll");
        System.out.println(i);
    }
}
