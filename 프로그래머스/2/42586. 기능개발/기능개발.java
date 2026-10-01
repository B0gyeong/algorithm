import java.util.*;

class Solution {
    public class Node {
        int pro, speed;
        
        Node(int pro, int speed) {
            this.pro = pro;
            this.speed = speed;
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        int N = progresses.length;
        Queue<Node> q = new LinkedList<>();
        
        for(int i=0; i<N; i++) {
            q.offer(new Node(progresses[i], speeds[i]));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            int pro = curr.pro;
            int s = curr.speed;
            
            int d;
            if((100-pro)%s == 0) {
                d = (100-pro)/s;
            } else {
                d = (100-pro)/s + 1;
            }
            
            int cnt = 1;
            while(!q.isEmpty()) {
                Node next = q.peek();
                if(next.pro + (next.speed * d) >= 100) {
                    cnt++;
                    q.poll();
                }
                else break;
            }
            answer.add(cnt);
        }
        
        int[] arrans = answer.stream().mapToInt(Integer::intValue).toArray();
        return arrans;
    }
}