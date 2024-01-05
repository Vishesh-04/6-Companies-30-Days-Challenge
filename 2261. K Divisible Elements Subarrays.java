
/**2261. K Divisible Elements Subarrays
 * Given an integer array nums and two integers k and p, return the number of distinct subarrays, which have at most k elements that are divisible by p.

Two arrays nums1 and nums2 are said to be distinct if:

They are of different lengths, or
There exists at least one index i where nums1[i] != nums2[i].
A subarray is defined as a non-empty contiguous sequence of elements in an array.
 */

import java.util.*;

class K_Divisible_Elements_Subarrays {
    public static int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        Set<Long> ways = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            long hc = 1;
            for (int j = i; j < n; j++) {
                hc = 199L * hc + nums[j];
                if (nums[j] % p == 0)
                    cnt++;
                if (cnt <= k) {
                    ways.add(hc);
                }
            }
        }
        return ways.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size of Arrays");
        int n = sc.nextInt();
        System.out.println("Enter value of k");
        int k = sc.nextInt();
        System.out.println("Enter value of p");
        int p = sc.nextInt();
        int nums[] = new int[n];
        System.out.println("Enter Element of Arrays");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        int res = countDistinct(nums, k, p);
        System.out.println("Enter the Result is :- "+res);
    }
}