package BaekJun;

import java.io.*;
import java.util.StringTokenizer;

public class B15649_NAndM1 {

    static Integer N, M;
    static int[] arr;
    static boolean[] isUsed;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 4
        M = Integer.parseInt(st.nextToken()); // 2

        isUsed = new boolean[N];
        arr = new int[M];
        find(N, M, 0);
    }

    // find(4,2,0)
    /**
     * 자바 순열/조합
     * 첫 번째 반복
     * - M != index ( 2 != 0)
     * i = 1; isUsed = {f, f, f, f, f};
     * !isUsed[1] = !f= t, 조건문 실행, isUsed[1] = T, isUsed = {f, t, f, f, f}, arr[0] = 1;
     * 여기서 find(N, M, 1)이 실행 다음은 find(N, M, 1)의 차례,
     * - M != index ( 2 != 1), 또 반복문을 실행, i = 1, isUsed[1] = !t = f, 조건문 부합 x하여 실행하지 않음
     * i = 2, isUsed[2] = !f = t, arr[1] = 2, find(N, M, 2)
     * 그런데, index 가 M과 같아져 arr 의 배열을 출력하고 return 함. arr = {1, 2} 그러면 다음 반복문,
     * i = 3, isUsed[3] = !f = t, arr[1] = 3, find(N, M, 2)
     * 그런데, index 가 M과 같아져 arr 의 배열을 출력하고 return 함. arr = {1, 3}
     * i = 4, isUsed[4] = !f = t, arr[1] = 4, find(N, M, 2)
     * 그런데, index 가 M과 같아져 arr 의 배열을 출력하고 return 함. arr = {1, 4}
     *
     * 그럼 다시 맨 처음으로 돌아가 isUsed[1]이 false 가 되고, i = 2로 실행 되어, 같은 내용을 반복한다.
     * 그럼 arr[0] = 2인 상태에서, i=1~4를 반복하면 isUsed[2] = true 이므로 2는 출력되지 않고 1,3,4를 반복한다.
     */

    public static void find(Integer N, Integer M, Integer index) {
        // 종료조건을 먼저 생각을해라
        if (M == index) {
            for (int in : arr) {
                System.out.print(in + " ");
            }
            System.out.println();
            return;
        }

        if (index > N) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[index] = i + 1;
                find(N, M, index + 1);
                isUsed[i] = false;
            }
        }
    }
}
