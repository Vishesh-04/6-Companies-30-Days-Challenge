/**   661. Image Smoother
 * An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell 
 * and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). 
 * If one or more of the surrounding cells of a cell is not present, 
 * we do not consider it in the average (i.e., the average of the four cells in the red smoother).
 */

import java.util.*;

class Image_Smoother {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Row Size of Array");
        int r = sc.nextInt();
        System.out.println("Enter Col Size of Array");
        int c = sc.nextInt();
        int img [][] = new int [r][c];
        System.out.println("Enter Elements of Array");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                img[i][j] = sc.nextInt();
            }
        }
        int res [][] = new int [r][c];
        Solution obj = new Solution();
        res = obj.imageSmoother(img);
        System.out.println("Modified Image: ");
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }
    }
}
class Solution {
 int[][] imageSmoother(int[][] img) {
        int res[][] = new int[img.length][img[0].length];
        for(int i = 0; i < img.length; i++) {
            for(int j = 0; j < img[0].length; j++) {
                res[i][j] = smoothen(img, i, j);
            }
        }
        return res;
    }
    int smoothen(int[][] img, int x, int y) {
        int m = img.length; 
        int n = img[0].length;
        int sum = 0;
        int count = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                sum += img[nx][ny];
                count++;
            }
        }
        return sum/count;
        
    }
}