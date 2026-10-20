import java.util.*;

class Solution {
    static class Truck {
        int remainT, weight;
        
        Truck(int remainT, int weight) {
            this.remainT = remainT;
            this.weight = weight;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Truck> bq = new LinkedList<>();
        Queue<Integer> wq = new LinkedList<>();
        for(int n : truck_weights) {
            wq.add(n);
        }
        int bridgeW = 0;
        
        while(!wq.isEmpty() || !bq.isEmpty()) {
            answer++;
            if(!bq.isEmpty()) {
                int bqn = bq.size();
                for(int i=0; i<bqn; i++) {
                    Truck curr = bq.poll();
                    curr.remainT--;
                    bq.add(curr);
                }
                if(bq.peek().remainT == 0) {
                    Truck ft = bq.poll();
                    bridgeW -= ft.weight;
                }
            }
            
            if(!wq.isEmpty() && bridgeW + wq.peek() <= weight) {
                int wft = wq.poll();
                bq.add(new Truck(bridge_length, wft));
                bridgeW += wft;
                
            }
        }
        
        return answer;
    }
}