import java.util.*;
import java.io.*;

public class Main {
    public static class Num implements Comparable<Num>{
        int num;
        
        Num(int num){
        	this.num = num;
        }

        public int compareTo(Num n){
            int a = Math.abs(this.num);
            int b = Math.abs(n.num);

            if(a != b){
                return a - b;
            }

            return this.num - n.num;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0){
                if(pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll().num);
                }
            } else {
                pq.add(new Num(num));
            }
            
        }

    }
}