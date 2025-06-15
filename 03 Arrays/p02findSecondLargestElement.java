public class p02findSecondLargestElement {

    // Method to find the second largest element in the array
    static private int secondLargest(int[] arr, int n) {
        if (n < 2) {
            return -1; // Not enough elements
        }

        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large; // Update second largest
                large = arr[i];       // Update largest
            } else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i]; // New second largest found
            }
        }

        return second_large;
    }

    // Main method to test both functions
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5}; // Input array
        int n = arr.length;

        int sL = secondLargest(arr, n);

        System.out.println("Second largest is " + sL);
    }
}
