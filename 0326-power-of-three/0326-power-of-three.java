class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        long ans = 1;
        while(ans <= n){
            if(n == ans){
                return true;
            }
            ans = ans * 3;
        }
        return false;
    }
}