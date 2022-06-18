package DataStructure;

import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
//        구현체
        Stack<Integer> stack = new Stack<>();

//        crud

//      c
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
//        r
        System.out.println(stack.peek());
        System.out.println(stack.pop());

//        d
        stack.clear();
        if(stack.isEmpty()){
            System.out.println("wow empty");
        }
//        그 외의 코딩 문제 편한거
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.contains(4));
        System.out.println(stack.indexOf(4));
        System.out.println(stack.lastIndexOf(3));


    }
}
