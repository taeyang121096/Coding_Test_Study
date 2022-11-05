package SWEA.D3.day1;

import java.io.*;
import java.util.*;

public class SW_15230 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            char start = 97; // 'a'
            int cnt = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(start == c){
                    cnt++;
                } else {
                    break;
                }
                start++;
            }
            System.out.println("#" + (i+1) + " " + cnt);
        }
    }
}
