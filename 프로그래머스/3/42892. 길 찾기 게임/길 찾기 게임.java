import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int num;
        int x, y;
        Node left, right;

        Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
 
        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.y, this.y);
        }
    }
    int idx;
 
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<n; i++) {
            nodes.add(new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]));
        }
        Collections.sort(nodes);
 
        for(int i=1; i<n; i++) {
            insertNode(nodes.get(0), nodes.get(i));
        }
                      
        int[] preorder = new int [n];
        int[] postorder = new int [n];
        
        idx = 0;
        preOrder(nodes.get(0), preorder);
        idx = 0;
        postOrder(nodes.get(0), postorder);
        answer[0] = preorder;
        answer[1] = postorder;
 
        return answer;
    }
                      
    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
        
        return;
    }
                      
    public void preOrder(Node node, int[] arr) {
        if(node == null) return;
        arr[idx++] = node.num;
        preOrder(node.left, arr);
        preOrder(node.right, arr);
    }
    
    public void postOrder(Node node, int[] arr) {
        if(node == null) return;
        postOrder(node.left, arr);
        postOrder(node.right, arr);
        arr[idx++] = node.num;
    }
}