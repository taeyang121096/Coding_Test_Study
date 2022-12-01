package Programmers.lv2;
import java.util.*;
public class DeliveryBox {
    public static void main(String[] args) {
        int answer = 0;
        Deque<Integer> main = new ArrayDeque<>();
        Stack<Integer> assistant = new Stack<>();
        int[] order = {3,5,4,2,1};
        for(int i = 1; i <= order.length; i++){
            main.offer(i);
        }

        while(true){
            int num = main.poll();
            if(num != order[0]){
                assistant.add(num);
            } else {
                answer++;
                break;
            }
        }

        // 둘을 비교 해야지, 1. 주 컨테이너에서 확인, 2. 보조 컨테이너에서 확인
        for(int i = 1; i < order.length; i++){
            boolean flag = false;
            if(!main.isEmpty() && main.peek() == order[i]){
                answer++;
                main.poll();
                flag = true;
            } else if (!assistant.isEmpty() && assistant.peek() == order[i]){
                answer++;
                assistant.pop();
                flag = true;
            } else if (!main.isEmpty() && main.peek() != order[i]){
                assistant.add(main.poll());
                flag = true;
                i--;
            }

            if(!flag) break;
        }

        // while(!main.isEmpty()){
        //     System.out.println(main.poll());
        // }
        // while(!assistant.isEmpty()){
        //     System.out.println(assistant.pop());
        // }
        System.out.println(answer);
    }
}
