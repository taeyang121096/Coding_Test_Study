package BaekJun;

import java.io.*;
import java.util.*;

public class B9012_Gwalho {
    static Stack<Character> stack = new Stack<>();

    static boolean isVPS(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(input.charAt(i));
            } else if (input.charAt(i) == ')' && stack.isEmpty()){
                return false;
            } else if (input.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            if(isVPS(input)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            while (!stack.isEmpty()) {
                stack.pop();
            }
        }
    }
}
