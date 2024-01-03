/**216. Combination Sum III
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.**/

import java.util.*;
class Combination_Sum_III {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int start, int k, int n, List<Integer> current, List<List<Integer>> result) {
        if (n < 0)
            return;
        if (current.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(i + 1, k, n - i, current, result);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Value of k");
        int k = sc.nextInt();
        System.out.println("Enter Value of n");
        int n = sc.nextInt();
        List<List<Integer>> result = new ArrayList<>();
        result = combinationSum3(k,n);
        System.out.println("The Result is :- "+result);
    }
}
