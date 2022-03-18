package Sujong;

import java.io.*;
import java.util.*;

public class CountWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().split(" ");
        int cnt = 0;
        for(String w : word){
            if(w.equals("")) {
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
