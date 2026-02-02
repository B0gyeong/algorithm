import java.util.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			boolean finish = false;
			int aNum = sc.nextInt();
			Integer [] aArr = new Integer [aNum];
			for(int a=0; a<aNum; a++) {
				aArr[a] = sc.nextInt();
			}
			Arrays.sort(aArr, Collections.reverseOrder());
			int bNum = sc.nextInt();
			Integer[] bArr = new Integer[bNum];
			for(int b=0; b<bNum; b++) {
				bArr[b] = sc.nextInt();
			}
			Arrays.sort(bArr, Collections.reverseOrder());
			for(int c=0; c<Math.min(aNum,bNum); c++) {
				if(aArr[c]>bArr[c]) {
					System.out.println("A");
					finish = true;
					break;
					
				} else if(aArr[c]<bArr[c]) {
					System.out.println("B");
					finish = true;
					break;
				}
			}
			if(!finish) {
				if(aNum>bNum) {
					System.out.println("A");
				} else if(aNum<bNum) {
					System.out.println("B");
				} else {
					System.out.println("D");
				}
			}
		}
		
	}

}
