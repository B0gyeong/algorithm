import java.util.*;
import java.io.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int id, x, dist;
        Node prev, next;

        Node(int id, int x, int dist) {
            this.id = id;
            this.x = x;
            this.dist = dist;
            this.prev = this.next = null;
        }

        @Override public int compareTo(Node o) {
            if(this.dist != o.dist) {
                return o.dist - this.dist;
            }

            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        HashMap<Integer, Node> hm = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        Node head = new Node(0, 1, 0);
        Node tail = new Node(-1, 0, 0);
        int N_val = 0;
        int count = 0;

        for(int i=0; i<Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            
            if(order == 100) {
                N_val = Integer.parseInt(st.nextToken());
                tail.x = N_val;
                int M = Integer.parseInt(st.nextToken());
                Node curr = head;
                hm.put(0, head);
                hm.put(-1, tail);
                
                for(int j=1; j<=M; j++) {
                    int L = Integer.parseInt(st.nextToken());
                    Node addNode = new Node(j, L, 0);
                    hm.put(j, addNode);
                    link(curr, addNode, pq);
                    curr = addNode;
                }
                count = M;
                link(curr, tail, pq);

            } else if (order == 200) {
            	Node maxNode = getValidInternalNode(pq, hm);
            	
            	int L = maxNode.dist;
            	int newX = (maxNode.x + maxNode.next.x + 1) /2;
            	
            	count++;
            	Node addNode = new Node(count, newX, 0);
            	hm.put(count, addNode);
            	
            	Node nextNode = maxNode.next;
            	link(maxNode, addNode, pq);
                link(addNode, nextNode, pq);
            	
            } else if (order == 300) { 
            	int delId = Integer.parseInt(st.nextToken());
                Node delNode = hm.get(delId);
                Node p = delNode.prev;
                Node n = delNode.next;
                
                link(p, n, pq);
                hm.remove(delId);

            } else {
            	int internalMax = 0;
                Node maxNode = peekValidInternalNode(pq, hm);
                if(maxNode != null) internalMax = maxNode.dist;

                int edge1 = (hm.get(0).next.id != -1) ? (hm.get(0).next.x - 1) * 2 : 0;
                int edge2 = (hm.get(-1).prev.id != 0) ? (N_val - hm.get(-1).prev.x) * 2 : 0;
                
                System.out.println(Math.max(internalMax, Math.max(edge1, edge2)));
            	
            }
        }
    }

	private static Node getValidInternalNode(PriorityQueue<Node> pq, HashMap<Integer, Node> hm) {
		while(!pq.isEmpty()) {
			Node top = pq.poll();
			Node real = hm.get(top.id);
			if(real != null && real.dist == top.dist && real.x == top.x && real.next != null && real.next.id > 0) {
				return real;
			}
		}
		return null;
	}

	private static void link(Node p, Node n, PriorityQueue<Node> pq) {
		p.next = n;
		n.prev = p;
		p.dist = n.x - p.x;
		if(p.id > 0 && n.id > 0) {
			pq.add(new Node(p.id, p.x, p.dist));
		}
		
	}
	
	private static Node peekValidInternalNode(PriorityQueue<Node> pq, HashMap<Integer, Node> hm) {
		while(!pq.isEmpty()) {
			Node top = pq.peek();
			Node real = hm.get(top.id);
			if(real != null && real.dist == top.dist && real.x == top.x && real.next != null && real.next.id > 0) {
				return real;
			}
			pq.poll();
		}
		return null;
	}
}