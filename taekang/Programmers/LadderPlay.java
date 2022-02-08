package Programmers;

import java.io.*;

public class LadderPlay {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] str = input.split(" ");
        int N = Integer.parseInt(str[0]); // 세로선의 개수
        int M = Integer.parseInt(str[1]); // 가로선의 개수
        int H = Integer.parseInt(str[2]); // 세로선마다 가로선을 놓을 수 있는 위치의 개수

        int[] a = new int[M]; // 가로선의 정보
        int[] b = new int[M]; // 세로선의 정보

        for (int i = 0; i < M; i++) {
            String input2 = br.readLine();
            String[] str2 = input2.split(" ");
            int a1 = Integer.parseInt(str2[0]);
            int b1 = Integer.parseInt(str2[1]);
            a[i] = a1;
            b[i] = b1;
        }


    }
}
