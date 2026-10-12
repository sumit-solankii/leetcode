class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[31];
        int mod = 1_000_000_007;
       for (int num : nums) {
        for (int i = 0; i < 31; i++) {
            if (((num >> i) & 1) == 1) {
                count[i]++;
            }
        }
    }

    long ans = 0;

    for (int i = 0; i < k; i++) {
        long num = 0;

        for (int j = 0; j < 31; j++) {
            if (count[j] > 0) {
                num |= (1L << j);
                count[j]--;
            }
        }

        ans = (ans + num * num) % mod;
    }

    return (int) ans; 
    }
}