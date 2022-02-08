package Programmers;

import java.util.*;

public class Development {
    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();

        // 7 2 9
        for(int i = 0; i < progresses.length; i++){
            deque.offer((100 - progresses[i]) / speeds[i]) ;
        }
        while(!deque.isEmpty()){
            int day = deque.peek();
            int count = 0;

            while(!deque.isEmpty() && day >= deque.peek()){
                count++;
                deque.poll();
            }
            System.out.println(count);
            list.add(count);
        }

        Integer[] answer = list.toArray(new Integer[list.size()]);
    }
}
