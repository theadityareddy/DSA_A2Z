/**
 * Problem: Count the number of subarrays in the given array whose XOR is equal to k.
 *
 * Key Idea (Prefix XOR + HashMap):
 * ----------------------------------
 * Let:
 *  - `xr` be the prefix XOR from index 0 to i (i.e., a[0] ^ a[1] ^ ... ^ a[i])
 *  - `x` be some prefix XOR that occurred earlier in the array
 *
 * If:
 *   xr ^ x = k  →  then the XOR of the subarray between (after x to i) is equal to k
 *
 * By rearranging:
 *   x = xr ^ k
 *
 * So, for each index `i`, we compute:
 *   1. Current prefix XOR → xr = xr ^ a[i]
 *   2. Find how many times prefix XOR `xr ^ k` has occurred before.
 *      Because each occurrence indicates a subarray ending at index `i` with XOR = k.
 *   3. Update the count and store current prefix XOR in the map for future checks.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.*;

public class p34findSubarraysWithXorK {

    public static int subarraysWithXorK(int []a, int k) {
        int n = a.length; //size of the given array.
        int xr = 0;
        Map<Integer, Integer> mpp = new HashMap<>(); //declaring the map.
        mpp.put(xr, 1); //setting the value of 0.
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            // prefix XOR till index i:
            xr = xr ^ a[i];

            //By formula: x = xr^k:
            int x = xr ^ k;

            // add the occurrence of xr^k
            // to the count:
            if (mpp.containsKey(x)) {
                cnt += mpp.get(x);
            }

            // Insert the prefix xor till index i
            // into the map:
            if (mpp.containsKey(xr)) {
                mpp.put(xr, mpp.get(xr) + 1);
            } else {
                mpp.put(xr, 1);
            }
        }
        
        return cnt;
    }

    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }
}


