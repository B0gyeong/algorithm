import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String comPlayer : completion) {
            hm.put(comPlayer, hm.getOrDefault(comPlayer,0)+1);
        }
        
        for(String player: participant) {
            if(!hm.containsKey(player) || hm.get(player) == 0) {
                return player;
            }
            
            hm.put(player, hm.get(player)-1);
        }
        
        String answer = "";
        return answer;
    }
}