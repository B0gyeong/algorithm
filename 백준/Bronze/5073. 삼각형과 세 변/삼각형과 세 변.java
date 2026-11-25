import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String s = br.readLine();
            if(s.equals("0 0 0")) break;

            String[] lines = s.split(" ");
            int[] linesN = new int[3];
            for(int i=0; i<3; i++) {
                linesN[i] = Integer.parseInt(lines[i]);
            }
            Arrays.sort(linesN);

            if(linesN[0] + linesN[1] <= linesN[2]) {
                System.out.println("Invalid");
                continue;
            }

            if(lines[0].equals(lines[1])) {
                if(lines[1].equals(lines[2])) {
                    System.out.println("Equilateral");
                } else {
                    System.out.println("Isosceles");
                }
            } else {
                if(lines[1].equals(lines[2])) {
                    System.out.println("Isosceles");
                } else {
                    if(lines[0].equals(lines[2])) {
                        System.out.println("Isosceles");
                    } else {
                        System.out.println("Scalene");
                    }
                }
            }
        }
    }
}


