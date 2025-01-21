package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslandsBFS {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rLen = grid.length;
        int clen = grid[0].length;

        int numIslands = 0;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < clen; j++) {
                if(grid[i][j] == '1'){
                    numIslands++;
                    searchHelperBFS(grid, i, j);
                }
            }
        }
        return  numIslands;
    }

    private void searchHelperBFS(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[]{i,j});
       grid[i][j] = '0'; //Node is visited

        int[][] dirs = new int[][]{{-1,0}, {0, -1}, {1, 0}, {0,1}};
        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            for (int[] dir: dirs){
                int newRow = cell[0]+dir[0];
                int newCol = cell[1]+dir[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol]=='1'){
                    queue.add(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }
    public static void main(String[] args) {
        CountIslandsBFS solution = new CountIslandsBFS();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid));
    }
}
