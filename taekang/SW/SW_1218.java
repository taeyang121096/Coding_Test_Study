package SW;

import java.util.*;
import java.io.*;

public class SW_1218 {
    public static int len;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int T = 1; T <= 10; T++) {
            len = Integer.parseInt(br.readLine()); // 182
            String str = br.readLine();

            if(isGwalHo(str)){
                System.out.println("#" + T + " " + 1);
            } else {
                System.out.println("#" + T + " " + 0);
            }
        }
    }

    private static boolean isGwalHo(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if(str.charAt(i) == '{'){
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == '['){
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == '('){
                stack.push(str.charAt(i));
            } else if(str.charAt(i) == '<'){
                stack.push(str.charAt(i));
            }else if(str.charAt(i) == '}'){
                if(stack.peek() == '{'){
                    stack.pop();
                } else
                    stack.push(str.charAt(i));
            } else if(str.charAt(i) == ']' && !stack.isEmpty()){
                if(stack.peek() == '['){
                    stack.pop();
                } else
                    stack.push(str.charAt(i));
            } else if(str.charAt(i) == ')'  && !stack.isEmpty()){
                if(stack.peek() == '('){
                    stack.pop();
                } else
                    stack.push(str.charAt(i));
            } else if(str.charAt(i) == '>'  && !stack.isEmpty()){
                if(stack.peek() == '<'){
                    stack.pop();
                } else
                    stack.push(str.charAt(i));
            }

        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}
