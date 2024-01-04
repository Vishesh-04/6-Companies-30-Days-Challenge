/**519. Random Flip Matrix
There is an m x n binary grid matrix with all the values set 0 initially. Design an algorithm to randomly pick an index (i, j) where matrix[i][j] == 0 and flips it to 1. All the indices (i, j) where matrix[i][j] == 0 should be equally likely to be returned.

Optimize your algorithm to minimize the number of calls made to the built-in random function of your language and optimize the time and space complexity.

Implement the Solution class:

Solution(int m, int n) Initializes the object with the size of the binary matrix m and n.
int[] flip() Returns a random index [i, j] of the matrix where matrix[i][j] == 0 and flips it to 1.
void reset() Resets all the values of the matrix to be 0. **/


class Solution {

int m,n,i,j;
    public Solution(int m, int n) {
        this.n=n;
        this.m=m;
        i=0;
        j=0;
    }
    
    public int[] flip() {
         j++;
        if(j==n){
            j=0;
            i++;
        }
        if(i==m){
            i=0;
            j=0;
        }

             
        return new int[]{i,j};
    }
    
    public void reset() {
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */