package SWEA;

import java.io.*;
import java.util.*;

public class SW_1225 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            Deque<Integer> q = new ArrayDeque<>();
            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < str.length; i++) {
                q.offer(Integer.parseInt(str[i])); //
            }
            // 값이 0 이 되어 들어가는 순간.

            int j = 1;
            while (true) {
                int num = q.pollFirst() - j; // num - j
                if(num <= 0) { //
                    num = 0; // 0
                    q.offerLast(num);
                    break;
                }else {
                    q.offerLast(num); //
                }

                j++; // 6
                if(j > 5){
                    j = 1;
                }
            }

            System.out.print("#" + N + " ");
            while(!q.isEmpty()){
                System.out.print(q.pollFirst() + " ");
            }
            System.out.println();
        }
    }
}
