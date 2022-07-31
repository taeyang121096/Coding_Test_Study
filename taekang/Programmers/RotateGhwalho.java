//package Programmers;
//
//import java.util.*;
//
//public class RotateGhwalho {
//    public static void main(String[] args) {
//        int answer = 0;
////        String s = "[](){}";
//
//        for(int i = 0; i<s.length(); i++){
//            Deque<Character> q = new ArrayDeque<>();
//            for(int j = 0; j<s.length(); j++){
//                q.offer(s.charAt(j));
//            }
//            for(int k = 0; k < i; k++){
//                q.offerLast(q.poll());
//            }
//            if(check(q)){
//                answer++;
//            }
//        }
//
//        System.out.println(answer);
//    }
//
//    static public boolean check(Deque<Character> q) {
//       Stack<Character> stack = new Stack<>();
//        while(!q.isEmpty()){
//            switch(q.peek()){
//                case '[':
//                case '{':
//                case '(':
//                    stack.push(q.poll());
//                    break;
//                case ']':
//                    if(!stack.isEmpty()){
//                        if(Character.compare(stack.peek(), '[') == 0){
//                            stack.pop();
//                            q.poll();
//                            break;
//                        }
//                    }
//                    return false;
//                case '}':
//                    if(!stack.isEmpty()){
//                        if(Character.compare(stack.peek(), '{') == 0){
//                            stack.pop();
//                            q.poll();
//                            break;
//                        }
//                    }
//                    return false;
//                case ')':
//                    if(!stack.isEmpty()){
//                        if(Character.compare(stack.peek(), '(') == 0){
//                            stack.pop();
////                            System.out.print(q.peek());
//                            q.poll();
//                            break;
//                        }
//                    }
//                    return false;
//                }
//        }
//
//        return true;
//    }
//}
