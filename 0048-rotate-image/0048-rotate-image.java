class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

       for(int i = 0; i < m; i++){ //i = row; j = col;
        for(int j = i + 1; j < m; j++){ // transpose(swap)
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
       } 
       for(int row = 0; row < m; row++){
        int startcol = 0;
        int endcol = m-1;
        while(startcol <= endcol){
            int temp = matrix[row][startcol];
            matrix[row][startcol] = matrix[row][endcol];
            matrix[row][endcol] = temp;

            startcol++;
            endcol--;
        }
       }
       
    }
}