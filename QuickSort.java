import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {16, 8, 13, 2, 9, 15, 4, 12, 24};
        System.out.println("Original array: " + Arrays.toString(arr));
        quickSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    static void quickSort(int[] arr) {
        myQuickSort(arr, 0, arr.length - 1);
    }

    static void myQuickSort(int[] arr, int first, int last) {
        if (first >= last) return;
        int split = partition(arr, first, last);
        myQuickSort(arr, first, split); // Sort the left half
        myQuickSort(arr, split + 1, last); // Sort the right half
    }

    private static int partition(int[] arr, int first, int last) {
        int pivot = arr[(first + last) / 2];
        int i = first - 1; // index going from left to right
        int j = last + 1; // index going from right to left
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i < j)
                swap(arr, i, j);
            else
                return j; // j is the index of the end of the left subarray
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
