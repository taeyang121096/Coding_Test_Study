import java.util.*;
import java.io.*;

//백준 10799번 쇠막대기

// 괄호 -> 스택사용 하지만 deque
// ( : push        ) : pop
// '(' : 스택에 넣어줌, ')' : 1. 레이저 절단(스택 사이즈)   2. 막대 끝(막대 개수 +1)
// () ((( () 3단으로 쌓아 올렸기 때문에 스택에 남아 있는 '(((' 3조각이 생긴다
// () ((( () () 레이저 절단 한번 더. 마찬가지로 스택엔 3조각이 남아 있기에  3조각이 더 생긴다 
// ......
// 이전 항이 '('라면 레이저 절단이므로 사이즈만큼 그래도 추가 더함
// ')' 다음에 ')'이 나오면 막대의 끝이라는 거니까 발견할 때마다 1씩 더해줌

public class Stick_BOJ {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder(br.readLine());

        Deque<Character> stack = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            char val = str.charAt(i);

            // '(' : push
            if (val == '(') {
                stack.push(val);
            } else { // ')' : 1. 레이저 절단(스택 사이즈)   2. 막대 끝(막대 개수 +1)
                stack.pop();
                if (str.charAt(i - 1) == '(') { // 이전 항이 '('라면 레이저 절단이므로 스택 사이즈만큼 조각이 생기니까 추가 더함
                    result += stack.size();
                } else {
                    result++; // ')' 다음에 ')'이 나오면 막대의 끝이라는 거니까 발견할 때마다 1씩 더해줌
                }
            }
        }
        System.out.println(result);
    }
}