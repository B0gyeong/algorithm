class Solution {
    static int n, cnt;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        cnt = 0;
        sol(0, 0, numbers, target);
        return cnt;
    }
    
    public void sol(int idx, int sum, int[] numbers, int target) {
        if(idx == n) {
            if(sum == target) {
                cnt++;
            }
            return;
        }
        
        sol(idx+1, sum+numbers[idx], numbers, target);
        sol(idx+1, sum-numbers[idx], numbers, target);
    }
}

