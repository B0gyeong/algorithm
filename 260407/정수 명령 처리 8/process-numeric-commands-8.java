import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> l = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String inst = st.nextToken();
            if(inst.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                l.addLast(num);
            } else if(inst.equals("push_front")){
                int num = Integer.parseInt(st.nextToken());
                l.addFirst(num);
            } else if(inst.equals("pop_front")){
                int num = l.pollFirst();
                System.out.println(num);
            } else if(inst.equals("pop_back")){
                int num = l.pollLast();
                System.out.println(num);
            } else if(inst.equals("size")){
                System.out.println(l.size());
            } else if(inst.equals("empty")){
                if(l.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if(inst.equals("front")){
                System.out.println(l.peekFirst());
            } else {
                System.out.println(l.peekLast());
            }
        }

    }
}