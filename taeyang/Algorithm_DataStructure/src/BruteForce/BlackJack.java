package BruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BlackJack {
    static int[] card;
    static List<Integer> list = new ArrayList<>();

    //    brute force
    static void combi(int level, int start, int[] tmp) {
        if (level == 3) {
            list.add(Arrays.stream(tmp).sum());
            return;
        }
//        전체를 확인하면서 진행 했으므로 이게 브루트 포스이다.
        for (int i = start; i < card.length; i++) {
            tmp[level] = card[i];
            combi(level + 1, i + 1, tmp);
        }
    }

    public static void main(String[] args) throws IOException {
//        5장에서 3장을 뽑는데 -> nC3 -> 브루트 포스 알고리즘 사용 한거다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        card = new int[n];
        int index = 0;

        while (st.hasMoreTokens()) {
            card[index++] = Integer.parseInt(st.nextToken());
        }

        combi(0, 0, new int[3]);

        for(int val : list){
            if(val > m) {
                continue;
            }
            answer = Math.max(val,answer);
        }
        System.out.println(answer);

    }
}
