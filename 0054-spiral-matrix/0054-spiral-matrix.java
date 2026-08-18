class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int startingrow = 0;
        int endingrow = m - 1;
        int startingcol = 0;
        int endingcol = n - 1;
        while(startingrow <= endingrow && startingcol <= endingcol){
            for(int col = startingcol; col <= endingcol; col++){
                result.add(matrix[startingrow][col]);
            }
            startingrow++;
            for(int row = startingrow; row <= endingrow; row++){
                result.add(matrix[row][endingcol]);
            }
            endingcol--;
            if(startingrow <= endingrow){
                for(int col = endingcol; col >= startingcol; col--){
                result.add(matrix[endingrow][col]);
            }
            endingrow--;
            }
            
            if(startingcol <= endingcol){
                for(int row = endingrow; row >= startingrow; row--){
                result.add(matrix[row][startingcol]);
            }
            startingcol++;
            }
            
        }
        return result;
    }
}