package Programmers;

import java.util.*;

public class RotateGhwalho {
    public static void main(String[] args) {
        int answer = 0;
        String s = "[](){}";
        for (int i = 0; i < s.length(); i++) {
            int N = s.length() - i; // 7
            String str = s.substring(i + 1) + s.substring(0, i + 1);
            if (isCorrectString(str)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static public boolean isCorrectString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        // }]()[{
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                if (stack.peek() == '[' && arr[i] == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && arr[i] == '}') {
                    stack.pop();
                } else if (stack.peek() == '(' && arr[i] == ')') {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
