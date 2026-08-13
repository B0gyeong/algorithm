import java.util.*;
import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push_back")){
                int num = Integer.parseInt(st.nextToken());
                list.add(num);

            } else if (s.equals("pop_back")){
                list.remove(list.size()-1);

            } else if (s.equals("size")){
                System.out.println(list.size());

            } else {
                int num = Integer.parseInt(st.nextToken());
                System.out.println(list.get(num-1));
            }

        }
    }
}