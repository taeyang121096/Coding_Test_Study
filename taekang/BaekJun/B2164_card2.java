package BaekJun;

import java.io.*;
import java.util.*;

public class B2164_card2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while (!deque.isEmpty()) {
            if(deque.size() == 1) {
                System.out.println(deque.poll());
                return;
            }
            else
                deque.poll();
            if(!deque.isEmpty())
                deque.offerLast(deque.poll());
        }
    }
}
