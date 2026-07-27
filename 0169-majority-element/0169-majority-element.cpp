class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int majorElement = nums.size() / 2;
        for(int val : nums){
            int freq = 0;
            for(int el : nums){
                if(el == val){
                    freq++;
                }
                if(freq > majorElement){
                    return val;
                }
            }
        }
        return 0;
    }
};