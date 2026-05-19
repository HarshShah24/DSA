class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseCol(matrix);
    }

    public void transpose(int[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseCol(int[][] matrix){

        for(int row = 0; row < matrix.length; row++){
            int start = 0; 
            int end = matrix[row].length-1;
            while(start < end){
                int temp = matrix[row][start];
                matrix[row][start] = matrix[row][end];
                matrix[row][end] = temp;
                start++;
                end--;
            }
        }

    }
}