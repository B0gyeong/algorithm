class Solution {
    static int answer, n;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        answer = 0;
        
        dfs(0, 0, target, numbers);
        
        return answer;
        
    }
    
    public void dfs(int idx, int sum, int target, int[] numbers) {
        if(idx==n) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(idx+1, sum+numbers[idx], target, numbers);
        dfs(idx+1, sum-numbers[idx], target, numbers);
    }
    
}

