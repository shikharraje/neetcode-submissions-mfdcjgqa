class Solution
{
    int[][] directions = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    int[][] grid;

    public int maxAreaOfIsland(int[][] grid)
    {
        this.grid = grid;
        int area = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1)
                    area = Math.max(area, doDFS(i, j));
            }
        }
        return area;
    }

    private int doDFS(int x, int y)
    {
        if(x < 0 || x >= this.grid.length || y < 0 || y >= this.grid[0].length || this.grid[x][y] == 0 || this.grid[x][y] == 2)
            return 0;
        else
        {
            this.grid[x][y] = 2;
            int currentArea = 1;
            for(int[] direction : this.directions)
            {
                int newx = x + direction[0];
                int newy = y + direction[1];
                currentArea += doDFS(newx, newy);
            }
            return currentArea;
        }
    }
}
