package DataStructure;

import java.util.*;

public class Deques {
    public static void main(String[] args) {
        //        구현체
        Deque<Integer> deque = new ArrayDeque<>();

//        c
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offerFirst(4);
        deque.offerLast(5);
        deque.offerLast(6);
//        r
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());

//        d
        System.out.println(deque.removeLast());
        System.out.println(deque.removeFirst());
        deque.clear();

        if(deque.isEmpty()){
            System.out.println("wow empty");
        }

    }
}
