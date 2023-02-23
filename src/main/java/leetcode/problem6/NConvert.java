package leetcode.problem6;

/**
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 */
public class NConvert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }
        int sIndex = 0;
        int row = 0;
        while(sIndex < s.length()) {
            while (row < numRows && sIndex < s.length()) {
                sbs[row++].append(s.charAt(sIndex++));
            }
            if (sIndex == s.length()) {
                break;
            }
            row -= 2;
            while(row >=0 && sIndex < s.length()) {
                sbs[row--].append(s.charAt(sIndex++));
            }
            row += 2;
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < sbs.length; i++) {
            ans.append(sbs[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        NConvert nc = new NConvert();
        System.out.println(nc.convert("PAYPALISHIRING", 3));
    }
}
