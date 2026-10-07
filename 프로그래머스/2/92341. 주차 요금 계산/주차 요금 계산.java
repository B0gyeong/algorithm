import java.util.*;

class Solution {
    public class Parking implements Comparable<Parking> {
        int fee, h, m, totalT;
        String carNum;
        boolean isDone;
        
        Parking(int h, int m, String carNum) {
            this.fee = 0;
            this.h = h;
            this.m = m;
            this.totalT = 0;
            this.carNum = carNum;
            this.isDone = false;
        }
        
        @Override
        public int compareTo(Parking o) {
            return Integer.parseInt(this.carNum) - Integer.parseInt(o.carNum);
        }
    }
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, Parking> hm = new HashMap<>();
        PriorityQueue<Parking> pq = new PriorityQueue<>();
        
        for(String curr : records) {
            String[] currArr = curr.split(" ");
            String[] hmArr = currArr[0].split(":");
            int h = Integer.parseInt(hmArr[0]);
            int m = Integer.parseInt(hmArr[1]); 
            if(currArr[2].equals("IN")) {
                if(hm.containsKey(currArr[1])) {
                    Parking p = hm.get(currArr[1]);
                    p.h = h; p.m = m;
                    p.isDone = false;
                } else {
                    hm.put(currArr[1], new Parking(h, m, currArr[1]));
                }
            } else {
                Parking inTime = hm.get(currArr[1]);
                int duringT = (h - inTime.h)*60 + (m - inTime.m);
                
                inTime.totalT += duringT;
                inTime.isDone = true;
            }
        }
        
        for(String carNum : hm.keySet()) {
            Parking inTime = hm.get(carNum);
            if(!inTime.isDone) {
                int duringT = (23 - inTime.h)*60 + (59 - inTime.m);
                inTime.totalT += duringT;
                inTime.isDone = true;
            }
        }
        
        for(String carNum : hm.keySet()) {
            Parking inTime = hm.get(carNum);
            int time = inTime.totalT;
            if(time < fees[0]) {
                inTime.fee = fees[1];
            } else {
                int plusT = ((time - fees[0]) + fees[2] - 1) / fees[2]; 
                inTime.fee = fees[1] + plusT * fees[3];
            }
            pq.add(inTime);
        }
        
        int n = pq.size();
        int answer[] = new int[n];
        for(int i=0; i<n; i++) {
            Parking p = pq.poll();
            answer[i] = p.fee;
        }
        
        return answer;
    }
    
} 