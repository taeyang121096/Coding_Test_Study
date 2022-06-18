package DataStructure;

import java.util.*;

public class Queues {
    public static void main(String[] args) {
//        구현체
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new ArrayDeque<>();
//         bfs 할 때 우선순위 쓰면좋고 -> 진짜 자주 쓰면 시간 복잡도를 줄일 수가 있어서 -> 우선순위 큐는 좀 알아두면 좋겠다.
        Queue<Integer> q3 = new PriorityQueue<>();

//        c
        q2.offer(1);
        q2.offer(2);
        q2.offer(3);
//        r
        System.out.println(q2.peek());
        System.out.println(q2.poll());

//        d
        q2.remove(1);
        q2.clear();

        if(q2.isEmpty()){
            System.out.println("wow empty");
        }


    }
}
