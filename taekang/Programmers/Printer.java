package Programmers;

import java.util.*;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int[][] arr = new int[priorities.length][priorities.length];
        for(int i = 0; i < priorities.length; i++){
            arr[i][0] = 65 + i; // 65, 66, 67, 68
            arr[i][1] = priorities[i]; // 2, 1, 3, 2
        }
        // 2,1,3,2 -> 3221, 정렬
        // 119111 -> 911111, 정렬
        for(int i = 0; i <priorities.length; i++){
            queue.offer(priorities[i]);
        }

        // while(!queue.isEmpty()){
        //     System.out.println(queue.poll());
        // }

        for(int i = 0; i < priorities.length; i++){
            // i = 0, 3 == arr[0][1] x

            for(int j = 0; j < priorities.length; j++){
                if(queue.peek() == arr[j][1]){ // 인덱스를 알아야겠다..
                    System.out.println(queue.peek());
                    System.out.println((char)arr[j][0]);
                    queue.poll();
                }
            }
        }
    }
}
