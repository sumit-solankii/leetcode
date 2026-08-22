class Solution {
    public boolean check(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[(i + 1) % nums.length]){
                result++;
            }
        }
        if(result > 1){
            return false;
        }
        return true;
    }
}