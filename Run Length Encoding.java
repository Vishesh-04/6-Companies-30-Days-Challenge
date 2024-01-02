/**  Run Length Encoding
 * Given a string, Your task is to  complete the function encode that returns the run length encoded string for the given string.
eg if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6″.
You are required to complete the function encode that takes only one argument the string which is to be encoded and returns the encoded string.**/

import java.util.*;
class Run_Length_Encoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = encode(str);
        System.out.println("The Result is :- "+res);
        sc.close();
    }
	public static String encode(String str)
	{
        //   int l = str.length(),f=0;
        //   String n = new String();
        //   int j=0;
        //   char c1;
        //   for(int i = 0; i < l; i++){
        //       c1 = str.charAt(i);
        //       for( j = i; j < l; j++){
        //           char c2 = str.charAt(j);
        //           if(c1 != c2){
        //               i=j;
        //               n=n+c1+f;
        //               f=0;
        //               break;
        //           }
        //           f++;  
        //       }
        //   }
        //   n=n+str.charAt(l-1)+f;
        //   return n;
          
          char array[] = new char[str.length()];
          array = str.toCharArray();
          int count = 1;
          char prev = array[0];
          String s = "";
          for(int i = 1;i < array.length;i++){
              if(prev!=array[i]){
                  s = s + prev + count;
                  count = 1;
                  prev = array[i];
              }
              else{
                  count++;
              }
          }
          s = s + prev + count;
          return s;
	}
 }