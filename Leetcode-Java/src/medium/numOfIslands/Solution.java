package medium.numOfIslands;

public class Solution {

    public int numIslands(char[][] grid) {
        int countOfIslands = 0;
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                char cell = grid[m][n];
                if(grid[m][n] == '1'){
                    eraseIsland(grid, m, n);
                    countOfIslands++;
                }
            }
        }

        return countOfIslands;
    }

    private void eraseIsland(char[][] grid, int m, int n) {
        if(m < 0 || n < 0 ||
                m >= grid.length || n >= grid[m].length ||
                grid[m][n] == '0'){
            return;
        }

        grid[m][n] = '0';

        eraseIsland(grid, m + 1, n);
        eraseIsland(grid, m - 1, n);
        eraseIsland(grid, m, n + 1);
        eraseIsland(grid, m, n - 1);
    }


}
