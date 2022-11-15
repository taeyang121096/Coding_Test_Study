package SWEA.D3.day3;

import java.io.*;
import java.util.*;

/**
 * D 만큼 데미지를 입힌다.
 * 레벨 L 에 따라 추가적인 데미지, 몬스터 n 번 다음 공격이 몬스터에게 입히는 데미지는
 */
public class SW_11387 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] str = br.readLine().split(" ");
            int D = Integer.parseInt(str[0]);
            double L = Double.parseDouble(str[1]);
            double N = Double.parseDouble(str[2]);
            double sum = 0;
            System.out.print("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                sum += D * (1 + i * L / 100);
            }
            System.out.println((int)sum);
        }
    }
}
