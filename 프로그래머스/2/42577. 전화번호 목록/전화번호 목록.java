import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int n = phone_book.length;
        Arrays.sort(phone_book);
        for(int i=0; i<n-1; i++) {
            int front_n = phone_book[i].length();
            int back_n = phone_book[i+1].length();
            if(front_n >= back_n) {
                continue;
            }
            String back = phone_book[i+1].substring(0,front_n);
            
            if(phone_book[i].equals(back)) {
                return false;
            }
        }
        
        return true;
    }
}