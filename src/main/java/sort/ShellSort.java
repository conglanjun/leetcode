package sort;

public class ShellSort {

    public void insertSortGap(int[] li, int gap) {
        for (int i = gap; i < li.length; ++i) {
            int tmp = li[i];
            int j = i - gap;
            while (j >=0 && li[j] > tmp) {
                li[j + gap] = li[j];
                j -= gap;
            }
            li[j + gap] = tmp;
        }
    }

    public void shellSort(int[] li) {
        int d = li.length / 2;
        while (d >= 1) {
            insertSortGap(li, d);
            d /= 2;
        }
    }

    public void print(int[] li){
        for (int i = 0; i < li.length; ++i) {
            System.out.print(li[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] li = {5, 4, 1, 6, 8, 2, 3, 9, 7};
        ShellSort ss = new ShellSort();
        ss.print(li);
        ss.shellSort(li);
        ss.print(li);
    }

}
