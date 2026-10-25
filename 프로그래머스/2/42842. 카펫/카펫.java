class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int r = 0; int c = 0;
        boolean[] visited = new boolean[yellow+1];
        
        for(int i=1; i<=yellow; i++) {
            if(yellow % i == 0) {
                visited[i] = true;
                visited[yellow/i] = true;
                if(i*2 + (yellow/i)*2 +4 == brown) {
                    r = Math.max(i, yellow/i);
                    c = Math.min(i, yellow/i);
                    return new int[] {r+2, c+2};
                }
            }
        }
        
        return answer;
    }
}