class Solution {
public:
    bool isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        
        int original = x;
        int n = 0;
        while(x !=0 ){
            int digit = x % 10;
            if (n > INT_MAX / 10 || (n == INT_MAX / 10 && digit > 7))
                return 0;

            if (n < INT_MIN / 10 || (n == INT_MIN / 10 && digit < -8))
                return 0;
            n = n * 10 + digit;
            x = x / 10;

        }
        // if (original  ==n){
        //     return true;
        // }else { 
        //     return false;
        // }
        return original == n;
    }
};