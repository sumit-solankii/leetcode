class Solution {
public:
    double minPrice(vector<int>& prices, vector<int>& discounts) {
        sort(prices.begin(), prices.end(), greater<int>());
        sort(discounts.begin(), discounts.end(), greater<int>());
        double ans = 0;
        int  n = min(prices.size(), discounts.size());
        for(int i = 0; i < n; i++){
            ans += prices[i] * (100 - discounts[i]) / 100.0;
        }
        for(int i = n; i < prices.size(); i++){
            ans += prices[i];
        }
        return ans;

    }
};