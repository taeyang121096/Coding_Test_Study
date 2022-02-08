package BaekJun;

import java.io.*;

public class B15684_ladder {
    public static void main(String[] args) throws IOException{
        /**
         * 1 <= 가로선 <= H, 1 <= 세로선 <= N-1 ==> b번 세로선과 b+1번 세로선을 a번 점선 위치에서 연결했다는 의미이다.
         * 가장 위 점선의 번호는 1번이고, 아래로 내려갈 때마다 +1, 세로선은 가장 왼쪽이 1번, 오른쪽으로 갈 때마다 +1
         * ㅡ
         *      ㅡ
         *   ㅡ
         *          ㅡ
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 첫 번째 줄을 해결하는 부분
        String input = br.readLine();
        String[] s = input.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int H = Integer.parseInt(s[2]);

        // 간선의 정보를 저장하는 배열
        int[] a_info = new int[M]; // {1,3,2,5,5}
        int[] b_info = new int[M]; // {1,2,3,1,4}

        if (M == 0) {
            System.out.println(0);
            return;
        }

        // 입력 두 번째 줄을 해결하는 부분
        for (int i = 0; i < M; i++) {
            String input2 = br.readLine();
            String[] s1 = input2.split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            a_info[i] = a;
            b_info[i] = b;
        }
    }
}
