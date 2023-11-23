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

/*
Initial Array
{16, 8, 13, 2, 9, 15, 4, 12, 24}

First Call to myQuickSort
Range: Entire array (first = 0, last = 8)
Pivot: Middle element, 9 (element at index 4)
Partitioning: Rearrange the array so that elements less than 9 are on the left, and those greater are on the right.
Result of Partitioning: One possible partitioned array could be {2, 8, 4, 9, 24, 15, 13, 12, 16} (exact arrangement can vary)
Pivot Position: The index where 9 is placed, let's say 3 for this example.

Recursive Call 1 (Left of Pivot)
Range: Indices 0 to 2 ({2, 8, 4})
Pivot: 8 (middle element)
Partitioning: Rearrange the subarray.
Result: {2, 4, 8}
Pivot Position: 2

Recursive Call 2 (Right of Pivot)
Range: Indices 4 to 8 ({24, 15, 13, 12, 16})
Pivot: 13 (middle element)
Partitioning: Rearrange the subarray.
Result: {12, 13, 24, 15, 16}
Pivot Position: 5

Recursive Call 2.1 (Left of New Pivot in Right Half)
Range: Indices 4 to 4 ({12})
Result: Single element, no change.
Recursive Call 2.2 (Right of New Pivot in Right Half)
Range: Indices 6 to 8 ({24, 15, 16})
Pivot: 15 (middle element)
Partitioning: Rearrange the subarray.
Result: {15, 16, 24}
Pivot Position: 7

Final Sorted Array
Combining all the parts together, the array is now fully sorted:
{2, 4, 8, 9, 12, 13, 15, 16, 24}
 */
