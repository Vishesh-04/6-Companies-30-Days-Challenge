/**2343. Query Kth Smallest Trimmed Number
You are given a 0-indexed array of strings nums, where each string is of equal length and consists of only digits.

You are also given a 0-indexed 2D integer array queries where queries[i] = [ki, trimi]. For each queries[i], you need to:

Trim each number in nums to its rightmost trimi digits.
Determine the index of the kith smallest trimmed number in nums. If two trimmed numbers are equal, the number with the lower index is considered to be smaller.
Reset each number in nums to its original length.
Return an array answer of the same length as queries, where answer[i] is the answer to the ith query.**/

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    int n = queries.length, j = 0;
        int[] ans = new int[n];
        Map<Integer, String[][]> trimmed = new HashMap<>();
        for (int[] q : queries) {
            int k = q[0] - 1;
            int trim = q[1];
            if (!trimmed.containsKey(trim)) {
                String[][] arr = new String[nums.length][2];
                int i = 0;
                for (String num : nums) {
                    int sz = num.length();
                    arr[i] = new String[]{num.substring(sz - trim), "" + i++};
                }
                Arrays.sort(arr, Comparator.comparing(a -> a[0]));
                trimmed.put(trim, arr);
            }
            ans[j++] = Integer.parseInt(trimmed.get(trim)[k][1]);
        }
        return ans;      
    }
}