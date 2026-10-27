class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        unordered_map<int, int> freq;

        for (int num : arr1) {
            freq[num]++;
        }

        vector<int> ans;

        for (int num : arr2) {
            while (freq[num] > 0) {
                ans.push_back(num);
                freq[num]--;
            }
        }

        vector<int> remaining;

        for (auto& p : freq) {
            while (p.second > 0) {
                remaining.push_back(p.first);
                p.second--;
            }
        }

        sort(remaining.begin(), remaining.end());

        for (int num : remaining) {
            ans.push_back(num);
        }

        return ans;
    }
};