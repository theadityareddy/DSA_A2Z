public class p01findLargestElement {

    // Method to find the largest element in an array
    static int findLargestElement(int arr[]) {
      int max = arr[0]; // Assume first element is the largest initially
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] > max) {
          max = arr[i]; // Update max if a larger element is found
        }
      }
      return max; // Return the largest element
    }
  
    public static void main(String[] args) {
      // Sample array of integers
      int[] numbers = {23, 45, 67, 12, 89, 34};
  
      // Call method to find largest element
      int largest = findLargestElement(numbers);
  
      // Print the largest element
      System.out.println("The largest element is: " + largest);
    }
  }
  