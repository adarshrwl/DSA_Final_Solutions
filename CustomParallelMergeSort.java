import java.util.Arrays;

public class CustomParallelMergeSort {

    public static void main(String[] args) {
        int[] numbers = { 5, 2, 9, 1, 5, 6 };
        customParallelMergeSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void customParallelMergeSort(int[] numbers) {
        customParallelMergeSort(numbers, 0, numbers.length - 1);
    }

    private static void customParallelMergeSort(int[] numbers, int low, int high) {
        if (low < high) {
            if (high - low <= 1000) {
                simpleMergeSort(numbers, low, high);
            } else {
                int mid = (low + high) / 2;
                Thread leftSort = new Thread(() -> customParallelMergeSort(numbers, low, mid));
                Thread rightSort = new Thread(() -> customParallelMergeSort(numbers, mid + 1, high));
                leftSort.start();
                rightSort.start();
                try {
                    leftSort.join();
                    rightSort.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(numbers, low, mid, high);
            }
        }
    }

    private static void simpleMergeSort(int[] numbers, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            simpleMergeSort(numbers, low, mid);
            simpleMergeSort(numbers, mid + 1, high);
            merge(numbers, low, mid, high);
        }
    }

    private static void merge(int[] numbers, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (numbers[i] <= numbers[j]) {
                temp[k++] = numbers[i++];
            } else {
                temp[k++] = numbers[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = numbers[i++];
        }

        while (j <= high) {
            temp[k++] = numbers[j++];
        }

        System.arraycopy(temp, 0, numbers, low, temp.length);
    }
}
