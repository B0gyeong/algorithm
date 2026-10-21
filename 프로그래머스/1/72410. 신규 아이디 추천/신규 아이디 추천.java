import java.util.*;

class Solution {
    public String solution(String new_id) {
        String lowerS = new_id.toLowerCase();
        int n = lowerS.length();
        Queue<Character> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            char c = lowerS.charAt(i);
            if(!Character.isLetterOrDigit(c)) {
                if(c != '-' && c != '_' && c != '.') {
                    continue;
                }
            }
            q.add(c);
        }

        String answer = "";
        while (!q.isEmpty()) {
            char curr = q.poll();
            if(curr == '.') {
                while(!q.isEmpty() && q.peek() == '.') {
                    q.poll();
                }
            }
            answer += curr;
        }
        
        if(answer.length() > 0 && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') {
            answer = answer.substring(0, answer.length()-1);
        }
        
        if(answer.length() == 0) {
            answer = "a";
        } 
        
        n = answer.length();
        if (n >= 16) {
            answer = answer.substring(0,15);
            if(answer.charAt(14) == '.') answer = answer.substring(0,14);
        } else if (n <= 2) {
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
        }
        
        return answer;
    }
}