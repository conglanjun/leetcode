package sort;

import java.util.Arrays;
import java.util.List;

public class HeapSortTopK {

    public void sift(int[] li, int low, int high) {
        int i = low;
        int j = 2 * i + 1;
        int tmp = li[low];
        while (j <= high) {
            if (j + 1 <= high && li[j] > li[j + 1]) {
                j++;
            }
            if (tmp > li[j]) {
                li[i] = li[j];
                i = j;
                j = 2 * i + 1;
            }else{
                break;
            }
        }
        li[i] = tmp;
    }

    public int[] topK(int[] li, int k){
        int[] heap = new int[k];
        for (int i = 0; i < k; ++i) {
            heap[i] = li[i];
        }
        // creat heap
        for (int i = (heap.length - 2) / 2; i > -1; --i) {
            sift(heap, i, k - 1);
        }
        for (int i = k; i < li.length; ++i) {
            if (li[i] > heap[0]) {
                heap[0] = li[i];
                sift(heap, 0, k - 1);
            }
        }
        for (int i  = k - 1; i > -1; --i) {
            int tmp = heap[0];
            heap[0] = heap[i];
            heap[i] = tmp;
            sift(heap, 0, i - 1);
        }
        return heap;
    }

    public void heapSort(int[] li) {
        // creat heap
        for (int i = (li.length - 2) / 2; i > -1; --i) {
            sift(li, i, li.length - 1);
        }
        // sort
        for (int i = li.length - 1; i > -1; --i) {
            int tmp = li[0];
            li[0] = li[i];
            li[i] = tmp;
            sift(li, 0, i - 1);
        }
    }

    public void printHeap(int[] li){
        for (int i = 0; i < li.length; ++i) {
            System.out.print(li[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] li = {4, 2, 1, 3, 6, 8, 12, 11, 5, 7, 9, 13, 10};
        HeapSortTopK s = new HeapSortTopK();
//        s.printHeap(li);
//        s.heapSort(li);
//        s.printHeap(li);
        s.printHeap(li);
        int[] ints = s.topK(li, 10);
        s.printHeap(ints);
    }
}
