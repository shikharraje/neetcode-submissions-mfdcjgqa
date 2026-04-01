class Solution
{
    int[][] directions = new int[][]{
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    char[][] grid;

    public int numIslands(char[][] grid)
    {
        this.grid = grid;
        int counter = 0;
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    counter++;
                    doDFS(i, j);
                }
            }
        }
        return counter;
    }

    private void doDFS(int x, int y)
    {
        if(x < 0 || x >= this.grid.length || y < 0 || y >= this.grid[0].length || this.grid[x][y] == '0' || this.grid[x][y] == '2')
            return;
        else
        {
            this.grid[x][y] = '2';
            for(int[] direction : this.directions)
            {
                int newx = x + direction[0];
                int newy = y + direction[1];
                doDFS(newx, newy);
            }
        }
    }
}
