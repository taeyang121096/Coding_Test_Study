//import java.util.*;
//class Solution
//{
//    public int solution(String s)
//    {
//        int answer = -1;
//        Stack<Character> stack = new Stack<>();
//
//        char[] arr = s.toCharArray();
//
//        for(char c : arr){
//            if(!stack.isEmpty() && (stack.peek() == c)) stack.pop();
//            else stack.push(c);
//        }
//        if(stack.size() == 0)
//            return 1;
//        else
//            return 0;
//    }
//}