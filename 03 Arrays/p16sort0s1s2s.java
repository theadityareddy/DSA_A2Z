import java.util.Arrays;

// Basic approach
class SolutionOne {
    public static void sortArray(int[] arr, int n) {
        int count0 = 0, count1 = 0, count2 = 0;

        // Count number of 0s, 1s and 2s
        for (int num : arr) {
            if (num == 0) count0++;
            else if (num == 1) count1++;
            else count2++;
        }

        // Overwrite array based on counts
        int index = 0;
        while (count0-- > 0) arr[index++] = 0;
        while (count1-- > 0) arr[index++] = 1;
        while (count2-- > 0) arr[index++] = 2;
    }

    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sortArray(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

// Dutch National Flag Algorithm
// Optimized Sol : 3 pointer approach (T.C. - O(n))
class SolutionTwo {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (arr[mid] == 0) {
                // swap arr[low] and arr[mid]
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                // move mid by 1 step
                mid++;
            } else {
                // swap arr[mid] and arr[high]
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }
}