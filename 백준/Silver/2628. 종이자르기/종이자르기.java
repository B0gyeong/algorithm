import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int h = sc.nextInt();
        ArrayList<Integer> wlist = new ArrayList<>();
        ArrayList<Integer> hlist = new ArrayList<>();
        wlist.add(0);
        hlist.add(0);
        wlist.add(w);
        hlist.add(h);
        int cNum = sc.nextInt();
        for(int i=0; i<cNum; i++) {
        	int d = sc.nextInt();
        	int cLine = sc.nextInt();
        	if(d==0) {
        		hlist.add(cLine);
        	} else {
        		wlist.add(cLine);
        	}
        	
        }
        Collections.sort(hlist);
        Collections.sort(wlist);
        int wMax = 0;
        int hMax = 0;
        for(int i = 1; i < wlist.size(); i++) {
        	wMax = Math.max(wMax, wlist.get(i)-wlist.get(i-1));
        }
        for(int i = 1; i < hlist.size(); i++) {
        	hMax = Math.max(hMax, hlist.get(i)-hlist.get(i-1));
        }
        System.out.println(wMax*hMax);
        
    }
}