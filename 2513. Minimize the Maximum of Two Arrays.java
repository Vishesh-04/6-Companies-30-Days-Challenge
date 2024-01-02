/**             Leetcode 
 2513. Minimize the Maximum of Two Arrays 

We have two arrays arr1 and arr2 which are initially empty. You need to add positive integers to them such that they satisfy all the following conditions:

arr1 contains uniqueCnt1 distinct positive integers, each of which is not divisible by divisor1.
arr2 contains uniqueCnt2 distinct positive integers, each of which is not divisible by divisor2.
No integer is present in both arr1 and arr2.
Given divisor1, divisor2, uniqueCnt1, and uniqueCnt2, return the minimum possible maximum integer that can be present in either array. **/


import java.util.*;
class Minimize_the_Maximum_of_Two_arrays {
    public static int minimizeSet(int d1, int d2, int u1, int u2) {
        int g = d1; 
		for (int x = d2; x > 0; ) {
            int tmp = g; 
            g = x; 
            x = tmp % x; 
        }
		long l = 0, h = Integer.MAX_VALUE, mul = ((long) d1*d2/g); 
		while (l < h) {
			long mid = l + (h-l)/2;
			if (u1 <= mid-mid/d1 && u2 <= mid-mid/d2 && u1+u2 <= mid-mid/mul)
            h = mid; 
			else l = mid+1; 
		}
		return (int) l;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();
        int u1 = sc.nextInt();
        int u2 = sc.nextInt();
        int res = minimizeSet(d1,d2,u1,u2);
        System.out.println("The Result is :- "+res);
        sc.close();
    }
}