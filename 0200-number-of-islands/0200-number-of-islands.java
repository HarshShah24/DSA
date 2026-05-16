class Solution {
    public int numIslands(char[][] grid) {
        
        int result = 0;
        final Set<String> visited = new HashSet<>();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == '1' && !visited.contains( i + "-" + j)){ //Recursively check left,right,top,bottom
                    spanIsland(grid,i,j,visited);
                    result++;
                }
            }
        }

        return result;

    }

    public void spanIsland(char[][] grid, int row, int col, Set<String> visited){
        if(row >= 0 && col >= 0 && row < grid.length && col < grid[row].length && !visited.contains(row + "-" + col) && grid[row][col] == '1'){
            visited.add(row + "-" + col);
            spanIsland(grid,row+1,col,visited);
            spanIsland(grid,row-1,col,visited);
            spanIsland(grid,row,col+1,visited);
            spanIsland(grid,row,col-1,visited);
        }
    }

}