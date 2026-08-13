import java.util.*;
import java.io.*;

public class Main {
    public static class Node {
        String str;
        Node prev, next;

        Node(String str) {
            this.str = str;
            this.prev = this.next = null;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        Node curr = new Node(str);
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 1) {
                String addStr = st.nextToken();
                Node addNode = new Node(addStr);
                addNode.next = curr;
                addNode.prev = curr.prev;

                if(addNode.prev != null) {
                    addNode.prev.next = addNode;
                }
                if(addNode.next != null) {
                    addNode.next.prev = addNode;
                }

            } else if(num == 2) {
                String addStr = st.nextToken();
                Node addNode = new Node(addStr);
                addNode.prev = curr;
                addNode.next = curr.next;

                if(addNode.prev != null) {
                    addNode.prev.next = addNode;
                }
                if(addNode.next != null) {
                    addNode.next.prev = addNode;
                }

            } else if(num == 3) {
                if(curr.prev != null) {
                    curr = curr.prev;
                }

            } else {
                if(curr.next != null) {
                    curr = curr.next;
                }
            }

            System.out.print((curr.prev != null ? curr.prev.str : "(Null)") + " " + curr.str +   " " + (curr.next != null ? curr.next.str : "(Null)") );
            System.out.println();
        }
    }
}