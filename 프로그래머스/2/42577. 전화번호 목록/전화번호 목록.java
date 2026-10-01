import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int N = phone_book.length;
        Arrays.sort(phone_book);
        for(int i=0; i<N-1; i++) {
            int ileng = phone_book[i].length();
            if(ileng > phone_book[i+1].length()) continue;
            
            for(int j=0; j<ileng; j++) {
                if(phone_book[i].charAt(j) != phone_book[i+1].charAt(j)) break;
                
                if(j==ileng-1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}