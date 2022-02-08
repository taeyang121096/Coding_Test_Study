package BaekJun;

import java.io.*;

public class B14501_bye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N ];
        int[] P = new int[N ];
        int[] result = new int[N];
        //  1 일때, 2 일때, ...n 일때 가능한 것들 중 max를 구하고
        //  그 중에서도 max 를 구하면 되지 않을까 ?
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");
            T[i] = Integer.parseInt(split[0]);
            P[i] = Integer.parseInt(split[1]);
        }

        // 어짜피 일차에 해당하는 값은 하나만 나오기 마련이다.
        // ex) 1일차부터 시작했을때 도 결과가 하나, 2일차부터 시작했을 때도 결과가 하나
        // 그렇게 해당 일차마다 나온 결과 중에서 max 값을 구하면 되지 않나 ?

    }
}

