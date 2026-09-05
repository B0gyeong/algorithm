import java.util.*;

class Solution {
    static int[] feeList;
    public int[] solution(int[] fees, String[] records) {
        feeList = fees;
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> timeMap = new HashMap<>();
        for(String curr : records) {
            StringTokenizer st = new StringTokenizer(curr);
            String time = st.nextToken();
            String num = st.nextToken();
            String type = st.nextToken();
            
            String[] timeSplit = time.split(":");
            int h = Integer.parseInt(timeSplit[0]);
            int m = Integer.parseInt(timeSplit[1]);
            int sumM = h * 60 + m;
    
            if(type.equals("IN")) {
                hm.put(num, sumM);
            } else {
                int startM = hm.remove(num);
                int duringM = sumM - startM;
                timeMap.put(num, timeMap.getOrDefault(num, 0) + duringM);
            }
        }
        
        for(String key : hm.keySet()) {
            int startM = hm.get(key);
            int endM = 23 * 60 + 59;
            int duringM = endM - startM;
            timeMap.put(key, timeMap.getOrDefault(key, 0) + duringM);
        }
        
        List<String> finalList = new ArrayList<>(timeMap.keySet());
        Collections.sort(finalList);
        
        int[] answer = new int[finalList.size()];
        for(int i=0; i<finalList.size(); i++) {
            answer[i] = calPrice(timeMap.get(finalList.get(i)));
        }
        return answer;
    }
    public int calPrice(int sumM) {
        if(sumM <= feeList[0]) {
            return feeList[1];
        } else {
            return feeList[1] + (int) Math.ceil((double)(sumM - feeList[0]) / feeList[2]) * feeList[3];
        }
    }
}