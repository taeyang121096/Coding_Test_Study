package SWEA;

import java.io.*;
import java.util.*;

public class SW_1222 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            Deque<Integer> num = new ArrayDeque<>();
            Deque<Character> ope = new ArrayDeque<>();

            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c >= '0' && c <= '9'){
                    num.offer(c-48);
                } else {
                    ope.offer(c);
                }
            }
            int sum = 0;

            while (!ope.isEmpty()) {
                ope.pop(); //
                int a = num.pollFirst(); //
                int b = num.pollFirst(); //
                num.offerFirst(a + b); //
            }
            System.out.println("#" + T + " " + num.pop());
        }
    }
}
