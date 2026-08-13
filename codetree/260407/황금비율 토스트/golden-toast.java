import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        LinkedList <Character> l = new LinkedList<>();
        String st2 = br.readLine();
        for(int i=0; i<n; i++){
            l.addLast(st2.charAt(i));
        }

        ListIterator <Character> it = l.listIterator(l.size());
        for(int i=0; i<m; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            char c1 = st3.nextToken().charAt(0);
            if(c1 =='L' ){
                if(it.hasPrevious()) it.previous();
            } else if(c1 =='R'){
                if(it.hasNext()) it.next();
            } else if(c1 =='D'){
                if(it.hasNext()) {
                    it.next();
                    it.remove();
                }
            } else {
                char c2 = st3.nextToken().charAt(0);
                it.add(c2);
            }
        }

        ListIterator <Character> itf = l.listIterator();
        while(itf.hasNext()){
            System.out.print(itf.next());
        }
    }
}