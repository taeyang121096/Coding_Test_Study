package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumberSum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        투포인터  -> head   tail -> 중견기업 단골 문제다
//        1초 -> 몇번 컴퓨터가 10억
//        int -> 21억

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] number = new int[n];
        int ans = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) number[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int sum = 0;
//        투포인터인 이유 -> 슬라이딩 윈도우 ->
        while (left <= right) {
            if (sum >= m) {
                sum -= number[left];
                left++;
            } else if (right >= n) {
                break;
            } else {
                sum += number[right];
                right++;
            }
            if (sum == m)
                ans++;
        }

//        head : 4 tail :6 -> 6
        System.out.println(ans);

    }
}
