package leetcode.NumberOfIslands;

/***
 *
 *Given an m x n 2D binary grid grid which represents a map of
 * '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent
 * lands horizontally or vertically. You may assume all four edges of the
 * grid are all surrounded by water.
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 *
 * */
public class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count +=1;
                    callBFS(grid, i , j);
                }

            }

        }
        return count;
    }



    private void callBFS(char[][] grid, int i, int j) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j]== '0')
            return;
        grid[i][j] = '0';
        callBFS(grid, i+1, j); //up
        callBFS(grid, i-1, j); //down
        callBFS(grid, i, j+1); //right
        callBFS(grid, i, j-1); //left
    }
}



















