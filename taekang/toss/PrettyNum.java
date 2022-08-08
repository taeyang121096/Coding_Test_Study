package toss;

import java.util.*;

public class PrettyNum {
    public static void main(String[] args) {
        String s = "12222333"; // 223
        int answer = 0;
        String tmp = "";
        int max = -1;
        char c = ' ';
        // tmp = 22, c = 2  // (2233) i = 5
        for(int i = 0; i < s.length() - 1; i++){
            if(tmp.length() == 2){
                if(s.charAt(i) == s.charAt(i+1) && c == s.charAt(i+1)){
                    tmp += s.charAt(i+1);
                    max = Math.max(max, Integer.parseInt(tmp));
                    tmp = "";
                    c = ' ';
                }
                tmp = "";
            } else {
                if(s.charAt(i) == s.charAt(i+1)){
                    tmp += s.charAt(i); // 2
                    tmp += s.charAt(i+1);  // 2
                    c = s.charAt(i);
                }
            }
        }

        if(max < 0)
            System.out.println(-1);
        else
            System.out.println(max);
    }
}
