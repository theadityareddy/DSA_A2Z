public class p08linearSearch {
    public static int search(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i; // Return index if found
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int num = 4;

        int index = search(arr, num);
        System.out.println(index); // Output: 3
    }
}
