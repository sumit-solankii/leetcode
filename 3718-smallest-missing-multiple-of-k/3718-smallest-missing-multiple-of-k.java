class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = k;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            while(n == nums[i]){
                n += k;
            }
        }
        return n;
    }
}