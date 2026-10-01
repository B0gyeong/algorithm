import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        int N = nums.length;
        for(int num : nums) {
            set.add(num);
        }
        
        int answer = Math.min(N/2, set.size());
        return answer;
    }
}