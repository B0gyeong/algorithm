import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int n = progresses.length;
        for(int i=0; i<n; i++) {
            int day = (99-progresses[i])/speeds[i]+1;
            q.add(day);
        }
        
        int base = -1;
        int cnt = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        while(!q.isEmpty()) {
            base = q.poll();
            cnt = 1;
            while(!q.isEmpty()) {
                if(q.peek() <= base) {
                    cnt++;
                    q.poll();
                } else {
                    ans.add(cnt);
                    base = -1;
                    break;
                }
            }
        }
        if(base != -1) {
            ans.add(cnt);
        }
        
        int ansN = ans.size();
        int[] ansList = new int[ansN];
        for(int i=0; i<ansN; i++) {
            ansList[i] = ans.get(i);
        }
        
        return ansList;
    }
    
}