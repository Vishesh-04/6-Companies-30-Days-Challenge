/**   Find Missing And Repeating
Given an unsorted array Arr of size N of positive integers. 
One number 'A' from set {1, 2,....,N} is missing and one number 'B' occurs twice in array. 
Find these two numbers. **/

import java.util.*;
class Find_Missing_And_Repeating {
    static int[] findTwoElement(int arr[], int n) {
        // code here
        int s1 =0,s2 = 0,k=0;
        Arrays.sort(arr);
        for(int i=1;i<=n;i++){
            s1+=i;
        }
        for(int i : arr){
            s2+=i;
        }
        for(int i=0;i<n-1;i++){
            if(arr[i]==arr[i+1]){
            k=arr[i];
            break;
            }
        }
        s2-=k;
        int a=s1-s2;
        int o[]={k,a};
        return o;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++ ){
            arr[i] = sc.nextInt();
        }
        int ans[] = new int[2];
        ans = findTwoElement(arr, n);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        }
        sc.close();
    }
}
