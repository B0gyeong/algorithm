import java.util.*;
import java.io.*;

public class Main {
    public static class Person {
        int a, t, num;

        Person(int a, int t, int num){
            this.a = a;
            this.t = t;
            this.num = num;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Person> totalpq = new PriorityQueue<>((n1, n2) -> n1.a - n2.a);
        PriorityQueue<Person> waitpq = new PriorityQueue<>((n1, n2) -> n1.num - n2.num);

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            totalpq.add(new Person(a, t, i));
        }

        int currT = 0;
        int result = 0;
        while(!totalpq.isEmpty()){
            Person curr = totalpq.poll();
            currT = curr.a;
            while(true) {
                if(!totalpq.isEmpty() && totalpq.peek().a < currT + curr.t) {
                    waitpq.add(totalpq.poll());
                } else {
                    break;
                }
            }
            currT += curr.t;
            while(!waitpq.isEmpty()){
                Person wperson = waitpq.poll();
                result = Math.max(result, currT-wperson.a);
                while(true) {
                    if(!totalpq.isEmpty() && totalpq.peek().a < currT + wperson.t) {
                        waitpq.add(totalpq.poll());
                    } else {
                        break;
                    }
                }
                currT+=wperson.t;
            }

        }

        System.out.println(result);

    }
}