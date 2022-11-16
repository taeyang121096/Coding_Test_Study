package SWEA.D3.day3;

import java.io.*;
import java.util.*;

/**
 * aba
 * ababa -> aba ababa baba aba
 * 홀수 일때는, 가운데 하나 빼고 왼오 왼오 똑같으면 됨
 * 짝수 일 때는 왼오왼오 똑같으면 됨
 */
public class SW_8840 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            long N = Integer.parseInt(br.readLine());
            long num = (N - 1) / 2;
            System.out.println("#" + tc + " " + (num * num));
        }
    }
}
