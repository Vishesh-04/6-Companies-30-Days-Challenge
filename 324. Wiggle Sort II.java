/*  324. Wiggle Sort II
 * Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 */

import java.util.*;
class Wiggle_Sort {
    public static void wiggleSort(int[] nums) {
        int n=nums.length-1;
       int[] newarr=Arrays.copyOf(nums,nums.length);
       Arrays.sort(newarr);
        for(int i=1;i<nums.length;i+=2)
            nums[i]=newarr[n--];
        for(int i=0;i<nums.length;i+=2)
            nums[i]=newarr[n--];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the Size of Array");
        int n = sc.nextInt();
        int nums[] = new int [n];
        System.out.println("Enter Elements of Array");
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        wiggleSort(nums);
        System.out.println("The Result is :- ");
        for (int i : nums) {
            System.out.print(i + ",");
        }
    }
}