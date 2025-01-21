package graphs;

public class CountIslandsDFS {
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
                    searchHelperDFS(grid, i, j);
                }
            }
        }
        return  numIslands;
    }

    private void searchHelperDFS(char[][] grid, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;

        if(i < 0 || i >= row || j < 0 || j >= col || grid[i][j] =='0'){
            return;
        }
        grid[i][j] = '0';
        searchHelperDFS(grid, i-1, j);
        searchHelperDFS(grid, i+1, j);
        searchHelperDFS(grid, i, j-1);
        searchHelperDFS(grid, i, j+1);
    }
    public static void main(String[] args) {
        CountIslandsDFS solution = new CountIslandsDFS();
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + solution.numIslands(grid));
    }
}
