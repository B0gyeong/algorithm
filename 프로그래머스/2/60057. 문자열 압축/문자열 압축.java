import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        int n = s.length();
        int answer = n;
        
        for(int w=1; w <= n/2; w++) {
            int temp = repeatChar(s, w);
            answer = Math.min(answer, temp);
        }

        return answer;
    }
    
    public int repeatChar(String s, int w) {
        StringBuilder sb = new StringBuilder();
        String base = s.substring(0, w);
        int cnt = 1;
        
        for(int i=w; i < s.length(); i+=w) {
            if(i+w > s.length()) {
                if(cnt > 1) sb.append(cnt);
                sb.append(base);
                sb.append(s.substring(i));
                base = "";
                break;
            }
            
            String comp = s.substring(i, i+w);
            if(base.equals(comp)) {
                cnt++;
            } else {
                if (cnt > 1) sb.append(cnt);
                sb.append(base);
                base = comp;
                cnt = 1;
            }
        }
        
        if(!base.isEmpty()){
            if(cnt>1) sb.append(cnt);
            sb.append(base);
        }
        
        return sb.length();
    }
}