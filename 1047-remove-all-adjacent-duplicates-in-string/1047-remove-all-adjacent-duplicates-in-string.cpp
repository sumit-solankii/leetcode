class Solution {
public:
    string removeDuplicates(string s) {
        stack<char> st;
        for(int i = 0; i < s.size(); i++){
            char c = s[i];
            if(c >= 'a' && c <= 'z'){
                if(!st.empty() && st.top() == c){
                    st.pop();
                }
                else{
                    st.push(c);
                }
                
            }
        }
        string result = "";
        while(!st.empty()){
            result += st.top();
            st.pop();
        }
    reverse(result.begin(), result.end());
    return result;
    }
};