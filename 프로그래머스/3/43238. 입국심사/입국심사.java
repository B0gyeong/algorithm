import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        int judgeN = times.length;
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) n * times[judgeN-1];
        long ans = 0;
        
        while(left <= right) {
            long mid = (left + right)/2;
            
            long cnt = 0;
            for(int i=0; i<judgeN; i++) {
                cnt += (mid / times[i]);
            }
            
            if(cnt>=n) {
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return ans;
    }
}