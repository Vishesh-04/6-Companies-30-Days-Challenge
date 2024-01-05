/**2400. Number of Ways to Reach a Position After Exactly k Steps
You are given two positive integers startPos and endPos. Initially, you are standing at position startPos on an infinite number line. With one step, you can move either one position to the left, or one position to the right.

Given a positive integer k, return the number of different ways to reach the position endPos starting from startPos, such that you perform exactly k steps. Since the answer may be very large, return it modulo 109 + 7.

Two ways are considered different if the order of the steps made is not exactly the same.

Note that the number line includes negative integers.
**/

class Solution {
    int p = 1000000007;
    public int numberOfWays(int a, int b, int k) {
        if ((a - b - k) % 2 != 0) return 0;
        if (Math.abs(a - b) > k) return 0;
        long res = 1L;
        for (int i = 0; i < (b - a + k) / 2; ++i) {
            res = res * (k - i) % p;
            res = res * inv(i + 1) % p;
        }
        return (int)res;
    }
    private long inv(long a) {
        if (a == 1) return 1;
        return (p - p / a) * inv(p % a) % p;
    }
}