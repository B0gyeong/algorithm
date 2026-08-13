import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
    int x, y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair p){
        int a = p.x + p.y;
        int b = this.x + this.y;

        if(a != b) {
            return b - a;
        }
        
        if(p.x != this.x) {
            return this.x - p.x;
        }

        return this.y - p.y;
    }
}

public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            pq.add(new Pair(x, y));
        }

        for(int i=0; i<M; i++){
            Pair p = pq.poll();
            pq.add(new Pair(p.x + 2, p.y + 2));
        }

        Pair pa = pq.poll();
        System.out.println(pa.x + " " + pa.y);

    }
}