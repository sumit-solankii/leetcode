class Solution {
public:
    double myPow(double x, int n) {
        if(n == 0){
            return 1.0;
        }
        if(x == 1){
            return 1.0;
        }
        if(x == 0){
            return 0.0;
        }
        if(n == 1){
            return x;
        }
        if(x == -1 && n % 2 == 0){
            return 1;
        }
        if(x == -1 && n % 2 != 0){
            return -1;
        }
        long long power = n;
        if(power < 0){
            x = 1 / x;
            power = -power;
        }
        double ans = 1;
        while(power > 0){
            if(power % 2 == 1){
                ans *= x;
            }
            x *= x;
            power /= 2;
        }
        return ans;
    }
};