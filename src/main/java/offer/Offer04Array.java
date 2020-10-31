package offer;

public class Offer04Array {

    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = array[i].length - 1;
        while (i < array.length && j > -1) {
            if (target == array[i][j]) {
                return true;
            } else if (target > array[i][j]) {
                ++i;
            } else if (target < array[i][j]) {
                --j;
            }
        }
        return false;
    }

}
