class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
            String ans = "";
            for(int i = 0; i < s.length(); i++){
                int ones = 0;
                for(int j = i; j < s.length(); j++){
                    if(s.charAt(j) == '1'){
                        ones++;
                    }
                    if(ones == k){
                        String temp = s.substring(i, j + 1);
                        if(ans.equals("") || temp.length() < ans.length() || (temp.length() == ans.length() && temp.compareTo(ans) < 0)){
                            ans = temp;
                        }
                        break;
                    }
                }
            }
        
        return ans;
    }
}