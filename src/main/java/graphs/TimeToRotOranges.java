package graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int row;
    int col;
    int time;

    Pair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class TimeToRotOranges {
    public int totalTimeToRotOranges(int[][] grid) {
        //If grid is null or length of grid is 0 return 0
        if (grid == null || grid.length == 0) {
            return -33;
        }
        int n = grid.length;
        int m = grid[0].length;

        //Create a queue for processing
        Queue<Pair> queue = new LinkedList<>();
        //Create n*m matrix to store rotten ones (2)
        int[][] visited = new int[n][m];
        int freshOrangeCount = 0;
        //Iterate over the grid and fill up the matrix and the queue
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                //Fill up visited with 2 as of grid
                if (grid[r][c] == 2) {
                    queue.add(new Pair(r, c, 0));
                    visited[r][c] = 2;
                    //ALl others fill up with 0
                } else {
                    visited[r][c] = 0;
                }
                //Count total fresh oranges (1)
                if (grid[r][c] == 1) {
                    freshOrangeCount++;
                }
            }
        }
        //create 4 sides of a co-ordinate
        int[] sidesRow = {-1, 0, 1, 0};
        int[] sidesCol = {0, 1, 0, -1};
        int totalTime = 0;
        int count = 0;
        //while there id item in the queue to process
        while (!queue.isEmpty()) {
            int r = queue.peek().row;
            int c = queue.peek().col;
            int t = queue.peek().time;
            totalTime = Math.max(totalTime, t);
            queue.remove();

            for (int i = 0; i < sidesRow.length; i++) {
                int newRow = r + sidesRow[i];
                int newCol = c + sidesCol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m
                        && visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    queue.add(new Pair(newRow, newCol, t + 1));
                    visited[newRow][newCol] = 2;
                    count++;
                }
            }

        }
        //Check if all oranges are rotten or not if not we failed to do so
        if (count != freshOrangeCount) {
            return -1;
        }
        //return total time
        return totalTime;
    }


    public static void main(String[] args) {
        TimeToRotOranges solution = new TimeToRotOranges();
        int[][] grid = {
                {0, 1, 2},
                {0, 1, 1},
                {2, 1, 1}};
        System.out.println("Time to rot oranges: " + solution.totalTimeToRotOranges(grid));
    }
}
