import java.io.*;
import java.util.*;

public class 치킨배달4207 {
    public static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int poleNum;
    public static int homeNum;
    public static Node[] selectedPoleArr;
    public static ArrayList<Node> homeArr;
    public static ArrayList<Node> poleArr;
    public static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        homeArr = new ArrayList<>();
        poleArr = new ArrayList<>();

        for (int r=0; r<N; r++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++) {
                int num = Integer.parseInt(st2.nextToken());
                if(num == 1) {
                    homeArr.add(new Node(r,c));
                } else if(num == 2){
                    poleArr.add(new Node(r,c));
                }
            }
        }
        poleNum = poleArr.size();
        homeNum = homeArr.size();
        answer = Integer.MAX_VALUE;

        for(int r=1; r<=M; r++) {
            selectedPoleArr = new Node[r];
            comb(0, 0,r);
        }

        System.out.println(answer);
    }

    public static void comb(int k, int s, int R) {
        if(k == R) {
            answer = Math.min(answer, calcPoleDist());
            return;
        }
        for(int i=s; i<poleNum; i++) {
            selectedPoleArr[k] = poleArr.get(i);
            comb(k+1, i+1, R);
        }
    }

    public static int calcPoleDist(){
        int minAllHome = 0;
        for(int i=0; i<homeNum; i++) {
            Node curr = homeArr.get(i);
            int minOneHome = Integer.MAX_VALUE;
            for(int j=0; j<selectedPoleArr.length; j++){
                minOneHome = Math.min(minOneHome, calcDist(curr, selectedPoleArr[j]));
            }
            minAllHome += minOneHome;
        }
        return minAllHome;
    }

    public static int calcDist(Node A, Node B) {
        return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
    }
}
