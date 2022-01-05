package BaekJun;

import java.io.*;

public class B11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(br.readLine());

        /**
         * f(2) = 1 + 1 + 1 = 3번
         * f(3) = f(2) + 1 + f(2) = 7번
         * f(4) = f(3) + 1 + f(3) = 15번
         * f(5) = f(4) + 1 + f(4) = 31번
         * ...
         * 따라서 f(n) = 2^n - 1의 점화식을 구할 수 있음.
         */

        // 두 번째 줓부터는 출력이므로 수행과정의 총 합을 출력해 준다.
        bw.write((Math.round((Math.pow(2, number) - 1)) + "\n"));

        // hanoi의 재귀함수
        hanoi(number, 1, 2, 3);

        bw.flush();
        bw.close();
    }

    // 규칙은 발견했는데 알고리즘 작성에 어려움이 있어서 이 부분은 참고하여 작성하였습니다.
    public static void hanoi(int number, int first, int second, int third) throws IOException {
        if(number == 1) {
            bw.write(first + " " + third + "\n");
            return;
        }

        // 묶음을 A에서 B로 옮기는 작업
        hanoi(number - 1, first, third, second);
        // 맨 왼쪽에 남은 한개를 맨 오른쪽으로 옮기는 작업
        bw.write(first + " " + third+"\n");
        // 묶음을 B에서 C로 옮기는 작업
        hanoi(number - 1, second, first, third);
    }
}
