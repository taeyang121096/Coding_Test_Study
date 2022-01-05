package BaekJun;


import java.io.*;
import java.util.*;
public class B10799_IronStick {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> queue = new ArrayDeque<>();

        // 아래에서 위로 겹쳐 놓고
        // 자신보다 긴 쇠막대기 위에만 놓일 수 있음.
        // 각 쇠막대기를 자르는 레이저는 적어도 하나 존재.
        // 레이저는 어떤 쇠막대기의 양 끝점과 안겹침

        // 인접한 () 인지 아닌지

        String input = br.readLine();

        char[] arr = input.toCharArray();
        int result = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ')') {
                queue.pollLast();
                if (arr[i-1] == '(') { // 이전의 요소가 (이면 인접해있으므로 레이저
                    result += queue.size(); // 레이저가 한번 뚫으면 여태까지 스택에 쌓여있는 것들의 갯수만큼 쪼개지게 된다. 따라서 결과에
                    // 스택의 사이즈만큼을 더해주면 된다.
                } else { // 아니라면 막대임, 막대가 끝나므로 갯수하나를 더해주면 된다.
                    result += 1;
                }
            } else { // )가 아니라면 스택에 계속 추가
                queue.offer(arr[i]);
            }
        }

        System.out.println(result);
    }
}
