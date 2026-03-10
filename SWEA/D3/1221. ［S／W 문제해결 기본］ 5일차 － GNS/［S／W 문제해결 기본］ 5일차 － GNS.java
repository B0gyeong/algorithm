import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			String firstLine = br.readLine();
			StringTokenizer st1 = new StringTokenizer(firstLine, " ");
			String tcNum = st1.nextToken(); // "#1"
			int L = Integer.parseInt(st1.nextToken());
			
			String secondLine = br.readLine();
			StringTokenizer st2 = new StringTokenizer(secondLine, " ");
			int wordInt [] = new int [L];
			for(int i=0; i<L; i++) {
				wordInt[i] = convertInt(st2.nextToken());
			}
			
			Arrays.sort(wordInt);
			
			sb.append(tcNum).append("\n");
			
			for(int i=0; i<L; i++) {
				sb.append(convertStr(wordInt[i])).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	private static Object convertStr(int num) {
		switch (num) {
		case 0:
			return "ZRO";
		case 1:
			return "ONE";
		case 2:
			return "TWO";
		case 3:
			return "THR";
		case 4:
			return "FOR";
		case 5:
			return "FIV";
		case 6:
			return "SIX";
		case 7:
			return "SVN";
		case 8:
			return "EGT";
		default:
			return "NIN";
		}
	}

	private static int convertInt(String st) {
		switch (st) {
		case "ZRO":
			return 0;
		case "ONE":
			return 1;
		case "TWO":
			return 2;
		case "THR":
			return 3;
		case "FOR":
			return 4;
		case "FIV":
			return 5;
		case "SIX":
			return 6;
		case "SVN":
			return 7;
		case "EGT":
			return 8;
		default:
			return 9;
		}
	}
}
			
			
