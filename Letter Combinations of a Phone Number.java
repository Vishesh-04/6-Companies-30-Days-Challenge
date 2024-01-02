
/**   17. Letter Combinations of a Phone Number
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters. **/

import java.util.*;
public class Letter_Combinations_of_a_Phone_Number {
    String [] arr = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        getLC(digits,res,new StringBuilder(),0);
        return res;
    }
    public static void getLC(String digits, List<String> res, StringBuilder s, int index){
        if(s.length()==digits.length()){
            res.add(s.toString());
            return;
        }
        String str = arr[digits.charAt(index)-'0'];
        for(int i=0; i< str.length();i++){
            s.append(str.charAt(i));
            getLC(digits,res,s,index+1);
            s.deleteCharAt(s.length()-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        List<String> res = letterCombinations(digits);
    }
}
