package BaekJun;

import java.io.*;
import java.util.*;

/**
 * 회의실, 사용하고자 하는 N개의 회의에 대해 회의실 사용표를 만들려고 함
 * 시작시간과 끝나는 시간이 있고, 각 회의가 겹치지 않게 .. 회의의 최대 개수
 * 끝나는 것과 동시에 다음회의가 시작될 수 있음
 * 시작하자마자 끝나는걳이 잇을수도있음
 */
public class B1931 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 11
        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" ");
            map[i][0] = Integer.parseInt(str[0]);
            map[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(map, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
//        int answer = 1;
//        int end = map[0][1];
//        for (int i = 1; i < N; i++) {
//            if(map[i][0] >= end) { //
//                end = map[i][1];
//                answer++;
//            }
//        }
//        System.out.println(answer);
    }
}
