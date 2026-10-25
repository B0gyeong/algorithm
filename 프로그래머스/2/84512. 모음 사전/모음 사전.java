import java.util.*;

class Solution {
    HashMap<String, Integer> hm = new HashMap<>();
    StringBuilder st = new StringBuilder();
    String[] chars = {"A","E","I","O","U"};
    int idx = 0;
    public int solution(String word) {
        dfs();
        int answer = hm.get(word);
        return answer;
    }
    
    public void dfs() {
        hm.put(st.toString(), idx++);
        
        if(st.length() >= 5) {
            return;
        }
        
        for(int i=0; i<5; i++) {
            st.append(chars[i]);
            dfs();
            st.deleteCharAt(st.length()-1);
        }
    }
}