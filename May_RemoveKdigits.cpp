class Solution {
public:
    string removeKdigits(string num, int k) {        
        std::stack<char> s;
        int count = k;
        for (char c : num) {
            while (!s.empty() && s.top() > c && count) {
                s.pop();
                count--;
            } 
            s.push(c);
        }
        int size = (int) s.size();
        std::string answer(size, '0');
        for (int i = size - 1; i >= 0; i--) {
            answer[i] = s.top();
            s.pop();
        }
        int cursor = 0, keep = num.length() - k;
        while (cursor < keep && answer[cursor] == '0') {
            cursor++;
        }
        return cursor == keep ? "0" : answer.substr(cursor, keep - cursor);
    } 
};
