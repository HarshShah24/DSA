class Solution {
    public int numIslands(char[][] grid) {
        
        int result = 0;


        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1'){ 
                    spanIsland(grid,i,j);
                    result++;
                }
            }
        }

        return result;

    }

    public void spanIsland(char[][] grid, int row, int col){
        if(row >= 0 && col >= 0 && row < grid.length && col < grid[row].length && grid[row][col] == '1'){
            grid[row][col] = '0';
            spanIsland(grid,row+1,col);
            spanIsland(grid,row-1,col);
            spanIsland(grid,row,col+1);
            spanIsland(grid,row,col-1);
        }
    }

}