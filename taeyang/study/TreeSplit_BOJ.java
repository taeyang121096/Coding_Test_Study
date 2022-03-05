import java.io.*;
import java.util.*;

public class TreeSplit_BOJ {
    //    높이 h 0 ~  10억
//    큰나무는 위 부분 작은 나무는 안잘림
//    나무 수 n 1 ~ 1000,000 100만
//    높이의 최댓값 -> m 1 ~ 20억
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long l = 0;
        long r = arr[arr.length - 1];


        while (l <= r) {
            long mid = (l + r) / 2;
            long tree = 0;
            for (int i : arr) {
                if (i - mid > 0)
                    tree += i - mid;
            }
            if (tree >= m) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }
}
