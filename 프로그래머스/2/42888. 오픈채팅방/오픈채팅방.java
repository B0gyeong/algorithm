import java.util.*;

class Solution {
    static class Node {
        String state, id;
        
        Node(String state, String id) {
            this.state = state;
            this.id = id;
        }
    }
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        for(String s : record) {
            String[] sArry = s.split(" ");
            if(sArry[0].equals("Enter") || sArry[0].equals("Change")) {
                hm.put(sArry[1], sArry[2]);
            }
            if(sArry[0].equals("Enter") || sArry[0].equals("Leave")) {
                q.add(new Node(sArry[0], sArry[1]));
            }
        }

        int n = q.size();
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            Node curr = q.poll();
            if(curr.state.equals("Enter")) {
                answer[i] = hm.get(curr.id) + "님이 들어왔습니다.";
            } else {
                answer[i] = hm.get(curr.id) + "님이 나갔습니다.";
            }
        }        
        return answer;
    }
}