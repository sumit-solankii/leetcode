class Solution {
    public boolean isHappy(int n) {
        int[] arr = new int[1000];
        int count = 0;
        while(n != 1){
            for(int i = 0; i < count; i++){
                if(arr[i] == n){
                    return false;
                }
            }
            arr[count] = n;
            count++;
            int sum = 0;
            while(n > 0){
                int digit = n % 10;
                sum = sum + digit * digit;
                n = n / 10;
            }
            n = sum;
        }
        return true;
    }
}