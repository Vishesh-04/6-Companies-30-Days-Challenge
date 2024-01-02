/**  Number following a pattern
Given a pattern containing only I's and D's. I for increasing and D for decreasing. 
Devise an algorithm to print the minimum number following that pattern. 
Digits from 1-9 and digits can't repeat.**/

import java.util.*;
class Number_following_a_pattern {
    static String printMinNumberForPattern(String S){
        StringBuffer ans= new StringBuffer();
        int cnt=2;
        int pos=0;
        ans.append('1');
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i)=='I'){
                ans.append(cnt);
                cnt++;
                pos=ans.length()-1;
            }
            else{
                ans.insert(pos,cnt);
                cnt++;
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string pattern:");
        String s = sc.nextLine();
        String a = printMinNumberForPattern(s);
        System.out.println("The minimum number following the given pattern is : "+a);
        sc.close();
    }
}
