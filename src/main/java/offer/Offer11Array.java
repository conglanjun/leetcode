package offer;

public class Offer11Array {

    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right = right - 1;
            }
        }
        return numbers[left];
    }

    public int minArray1(int[] numbers) {
        for (int i = 0;i < numbers.length - 1; ++i) {
            if (numbers[i] <= numbers[i + 1]) {
                continue;
            }
            return numbers[i + 1];
        }
        return numbers[0];
    }

}
