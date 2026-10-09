import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int tday = changeDay(today);
        
        HashMap<String, Integer> hm = new HashMap<>();
        for(String s : terms) {
            String[] temp = s.split(" ");
            hm.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        int n = privacies.length;
        List<Integer> answerList = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            String[] temp = privacies[i-1].split(" ");
            int startDay = changeDay(temp[0]);
            int deadDay = startDay + hm.get(temp[1])*28;
            if(deadDay <= tday) answerList.add(i);
        }
        
        int ansN = answerList.size();
        int[] answer = new int[ansN];
        for(int i=0; i<ansN; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public int changeDay(String day) {
        String[] tempd = day.split("\\.");
        int y = Integer.parseInt(tempd[0]) - 2000;
        int m = Integer.parseInt(tempd[1]);
        int d = Integer.parseInt(tempd[2]);
        return (28 * 12 * y) + (m * 28) + d;
    }
}