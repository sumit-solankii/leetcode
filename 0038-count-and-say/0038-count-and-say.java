class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {

            String temp = "";

            int j = 0;

            while (j < s.length()) {

                int count = 0;
                char digit = s.charAt(j);

                while (j < s.length() && s.charAt(j) == digit) {
                    count++;
                    j++;
                }

                temp += count;
                temp += digit;
            }

            s = temp;
        }

        return s;
    }
}