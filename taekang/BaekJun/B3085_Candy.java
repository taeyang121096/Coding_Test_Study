package BaekJun;

import java.io.*;

public class B3085_Candy {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String arr[][] = new String[N][N];

        // 2차원 배열에 정렬
        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            String[] split = input.split("");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = split[j];
            }
        }

        
    }
}
