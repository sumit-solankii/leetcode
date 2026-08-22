class Solution {
public:
    int calPoints(vector<string>& operations) {
        vector<int> score;
        for(int i = 0; i < operations.size(); i++){
            string op = operations[i];

            if(op == "+"){
                int last = score[score.size() - 1];
                int secondLast = score[score.size() - 2];
                score.push_back(last + secondLast);
            }
            else if(op == "D"){
                int last = score[score.size() - 1];
                score.push_back(last * 2);
            }
            else if(op == "C"){
                score.pop_back();
            }
            else{
                int num = stoi(op);
                score.push_back(num);
            }
        }

        int total = 0;
        for(int i = 0; i < score.size(); i++){
            total += score[i];
        }
        return total;
    }
};