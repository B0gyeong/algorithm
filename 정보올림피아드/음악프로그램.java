import java.io.*;
import java.util.*;

public class 음악프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N+1];

        for(int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st2.nextToken());
            if (num == 0) continue;
            int prev = Integer.parseInt(st2.nextToken());
            for (int j = 1; j < num; j++) {
                int next = Integer.parseInt(st2.nextToken());
                graph.get(prev).add(next);
                inDegree[next]++;
                prev = next;
            }
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for(int next: graph.get(curr)) {
                inDegree[next]--;
                if(inDegree[next]==0) {
                    queue.offer(next);
                }
            }
        }

        if(result.size() != N) {
            System.out.println(0);
        } else {
            for(int n : result) {
                System.out.println(n);
            }
        }
    }
}
