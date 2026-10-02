class Solution {
    static int cnt = 0;
    static int n, targetNum;
    public int solution(int[] numbers, int target) {
        n = numbers.length;
        targetNum = target;
        sol(0, 0, numbers);

        return cnt;
    }
    
    public void sol(int i, int sum, int[] numbers) {
        if(i == n) {
            if(targetNum == sum) cnt++;
            return;
        }
        
        sol(i+1, sum+numbers[i], numbers);
        sol(i+1, sum-numbers[i], numbers);
    }
}

