import java.util.*;
import java.io.*;

class Solution {
    static class Node implements Comparable<Node> {
        int num, cnt;
        
        Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
        
        @Override 
        public int compareTo(Node o) {
            return Integer.compare(o.cnt, this.cnt);
        }
    }
    public int[] solution(String s) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // s 어떻게 숫자만 가지고 갈지 부터 고민
        String num = "";
        s = s.substring(1, s.length()-1);
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                num+=c;
            } else if(c == ',' || c == '}') {
                if(num.length() == 0) continue;
                
                int rnum = Integer.parseInt(num);
                hm.put(rnum, hm.getOrDefault(rnum, 0) + 1);
                num = "";
            }
        }
        for(int k : hm.keySet()) {
            pq.add(new Node(k, hm.get(k)));
        }
        
        int n = hm.size();
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            answer[i] = pq.poll().num;
        }
        return answer;
    }
}