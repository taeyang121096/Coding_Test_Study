import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Stack_BOJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 명령어 개수
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        String command;


        // 명령어 개수만큼 반복
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            command = tmp[0];

            // 정수를 스택에 추가
            if (command.equals("push")) {
                stack.push(Integer.parseInt(tmp[1]));
                // System.out.println(stack);
            }
            // 스택에 가장 위에 잇는 정수를 빼고, 그 수를 출력, 없으면 -1 출력
            else if (command.equals("pop")) {
                if (stack.size() > 0) {
                    System.out.println(stack.pop());
                } else if (stack.size() == 0) {
                    System.out.println(-1);
                }
            }
            // 스택에 들어있는 정수의 개수
            else if (command.equals("size")) {
                System.out.println(stack.size());
            }
            // 스택이 비어 있으면 1, 아니면 0
            else if (command.equals("empty")) {
                if (stack.size() == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            // 스택의 가장 위에 있는 정수를 출력, 없으면 -1
            else if (command.equals("top")) {
                if (stack.size() > 0) {
                    System.out.println(stack.peek());
                } else if (stack.size() == 0) {
                    // System.out.println(stack.contains(3));
                    System.out.println(-1);
                }
            }
        }
    }
}

