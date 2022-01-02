import java.io.*;
import java.util.*;

// 백준 17413
public class WordFlip2_BOJ {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String index = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack <>();
        
        boolean flag = false; 
        
        for (int i = 0; i < index.length(); i++) {
            // '<'를 만나고, stack이 비어있지 않다면 모든 원소를 꺼내고 flag -> true
            if (index.charAt(i) == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                flag = true;
            }
            // '<'를 만나면, flag를 false로 입력 후 '>'저장
            else if (index.charAt(i) == '>') {
                flag = false;
                sb.append(index.charAt(i));
                continue;
            }

            // flag가 true면, '>'를 만나기 전까지 그대로 입력
            if (flag == true) {
                sb.append(index.charAt(i));
            }
            // flag가 false일 경우, 괄호 이외의 문자를 처리
            else if (flag == false) {
                // 해당 인덱스의 i번째 문자가 공백일 경우, 모든 원소를 POP수행 후 공백 추가
                if (index.charAt(i) == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    // 그외의 경우, Stack에 문자 추가
                    stack.push(index.charAt(i));
                }
            }

            // 반복문이 마지막 횟수일 때, 스택이 비어있지 않다면 원소 추가
            if (i == index.length() - 1) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }
}