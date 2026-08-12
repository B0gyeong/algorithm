import java.util.*;
class Solution {
    static int N;
    static char[] numbersArr;
    static char[] t;
    static boolean[] visited;
    static Set<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        N = numbers.length();
        numbersArr = numbers.toCharArray();
        visited = new boolean[N];
        
        for(int r=1; r<=N; r++){
            t = new char[r];
            perm(0, r);
        }
        
        int answer = 0;
        for(int num : numberSet) {
            if(checkPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void perm(int k, int R) {
        if(k == R) {
            int num = Integer.parseInt(new String(t));
            numberSet.add(num);
            return;
        }
        
        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            
            t[k] = numbersArr[i];
            visited[i] = true;
            perm(k+1, R);
            visited[i] = false;
        }
    }
    
    static boolean checkPrime(int n) {
        if (n < 2) return false;

        for(int i=2; i*i<=n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
}