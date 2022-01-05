package BaekJun;

import java.util.*;
import java.io.*;

public class B10866_Deque {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> queue = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            // push_front 일 때
            if(input.contains("push_front")){
                String[] arr = input.split(" ");
                queue.offerFirst(Integer.parseInt(arr[1]));
                // push_back 일 때
            } else if (input.contains("push_back")){
                String[] arr = input.split(" ");
                queue.offerLast(Integer.parseInt(arr[1]));
                // front 일 때
            } else if (input.equals("front")) {
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.peekFirst());
                //  back 일 때
            } else if (input.equals("back")){
                if (queue.isEmpty())
                    System.out.println(-1);
                else
                    System.out.println(queue.peekLast());
                // size 일 때
            } else if (input.equals("size")){
                System.out.println(queue.size());
            } else if (input.equals("empty")) {
                if(queue.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
                // pop_front 일 때
            } else if (input.contains("pop_front")){
                if (queue.isEmpty())
                    System.out.println(-1);
                else{
                    System.out.println(queue.pollFirst());
                }
                // pop_back 일 때
            } else if (input.contains("pop_back")) {
                if (queue.isEmpty())
                    System.out.println(-1);
                else{
                    System.out.println(queue.pollLast());
                }
            }
        }
    }
}
