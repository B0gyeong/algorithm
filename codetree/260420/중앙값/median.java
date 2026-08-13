import java.util.*;
import java.io.*;

public class Main {
    public static class MedianQueue {
        PriorityQueue<Integer> leftQ = new PriorityQueue<>();
        PriorityQueue<Integer> rightQ = new PriorityQueue<>();

        public void addNumber(int num){
            leftQ.add(-1 * num);
            rightQ.add(-1 * leftQ.poll());

            if(leftQ.size() < rightQ.size()) {
                leftQ.add(-1 * rightQ.poll());
            }
        }

        public int getMid() {
            return -1 * leftQ.peek();
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            int M = Integer.parseInt(br.readLine());

            int [] arr = new int [M];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            MedianQueue mq = new MedianQueue();
            for(int i=0; i<M; i++){
                mq.addNumber(arr[i]);
                if((i+1)%2 == 1){
                    System.out.print(mq.getMid() + " ");
                }
            }
            System.out.println();
        }
    }
}