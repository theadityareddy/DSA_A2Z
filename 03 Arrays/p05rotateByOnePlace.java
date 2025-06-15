public class p05rotateByOnePlace {
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1, 2, 3, 4, 5};

        solve(arr, n); // Call method to rotate array
    }

    // Method to rotate array elements to the left by one place
    private static void solve(int[] arr, int n) {
        if (arr.length == 0) {
            System.out.println("The array is empty");
            return;
        }

        if (arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }

        int temp = arr[0]; // Store the first element

        // Shift all elements one position to the left
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }

        arr[n - 1] = temp; // Place first element at the end

        // Print the rotated array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
