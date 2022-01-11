package Programmers;

import java.util.*;

public class plus_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();


        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < number; i++){
            String input = scan.next();

            // input에 push가 포함되어있으면 새로운 scan으로 숫자를 입력받음
            if (input.contains("push")) {
                int input_num = scan.nextInt();
                stack.push(input_num);
            } else if (input.equals("top")) {
                // stack이 비어있지 않으면 peek
                if(!stack.empty())
                    System.out.println(stack.peek());
                else
                    System.out.println("-1");
            } else if (input.equals("size")) {
                System.out.println(stack.size());
            } else if (input.equals("empty")) {
                // stack이 비어있으면 1, 아니면 0 출력
                if(stack.empty())
                    System.out.println("1");
                else
                    System.out.println("0");
            } else if (input.equals("pop")) {
                // stack이 비어있지 않으면 pop
                if(!stack.empty())
                    System.out.println(stack.pop());
                else
                    System.out.println("-1");
            }

        }
    }
}
