/*  1823. Find the Winner of the Circular Game
 * There are n friends that are playing a game. The friends are sitting in a circle and are numbered from 1 to n in clockwise order. More formally, moving clockwise from the ith friend brings you to the (i+1)th friend for 1 <= i < n, and moving clockwise from the nth friend brings you to the 1st friend.

The rules of the game are as follows:

Start at the 1st friend.
Count the next k friends in the clockwise direction including the friend you started at. The counting wraps around the circle and may count some friends more than once.
The last friend you counted leaves the circle and loses the game.
If there is still more than one friend in the circle, go back to step 2 starting from the friend immediately clockwise of the friend who just lost and repeat.
Else, the last friend in the circle wins the game.
Given the number of friends, n, and an integer k, return the winner of the game.
 */
import java.util.*;
class Find_the_Winner_of_the_Circular_Game{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Value of n");
        int n = sc.nextInt();
        System.out.println("Enter the Value of k");
        int k = sc.nextInt();
        Sol ob = new Sol();
        int res = ob.findTheWinner(n, k);
        System.out.println("The Result is :- "+res);
        sc.close();
    }
}
class Sol {
    public int findTheWinner(int n, int k){
        ArrayList <Integer> num = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            num.add(i);
        }
        k=k-1;
        int a = 0;
        if(n==1){
            return 1;
        }
        do{
            a=(a+k)%n;
            n--;
            num.remove(a);
        }while(num.size()>1);
        return num.get(0);
    }
}