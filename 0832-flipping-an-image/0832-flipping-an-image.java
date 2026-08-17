class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image.length;
        int n = image[0].length;
        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = image[i][n-1-j];
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(result[i][j] == 0){
                    result[i][j] = 1;
                }else {
                    result[i][j] = 0;
                }
            }
        }
        return result;
    }
}