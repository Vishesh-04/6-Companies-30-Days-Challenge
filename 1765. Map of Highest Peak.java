/*1765. Map of Highest Peak
You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them. **/ 

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;

        int[][] matrix = new int[n][m];
        for(int[] row: matrix){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Queue<Pair> qu = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isWater[i][j] == 1){
                    matrix[i][j] = 0;
                    qu.add(new Pair(i, j));
                }
            }
        }
        
        while(!qu.isEmpty()){
            Pair curr = qu.poll();
            int r = curr.first;
            int c = curr.second;

            int[] dr = {1, 0, -1, 0};
            int[] dc = {0, 1 ,0, -1};

            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && matrix[nr][nc] > 1+matrix[r][c]){
                    matrix[nr][nc] = 1 + matrix[r][c];
                    qu.add(new Pair(nr, nc));
                }
            }
        }
        return matrix;
    }
}
class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;

    }
}