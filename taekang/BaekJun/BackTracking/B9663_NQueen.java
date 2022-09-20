package BaekJun.BackTracking;

import java.io.*;

public class B9663_NQueen {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static boolean[] isCan;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        arr = new int[T];
        isCan = new boolean[T];

        nQueen(T, 0, 1);
    }

    /**
     * 2차원 배열 ?? arr[1] = 6번째 칸 ? 이런식으로 구현하는건 어때 ?
     * ex) 구글링 해 8x8 퀸 해답중 하나를 골라와서 저런식으로 구현하면 arr = {8, 2, 5, 3, 1, 7, 4, 6} ?과 같이 구할 수 있나 ?
     * 그럼 초기상태는 뭘까 ? index 가 0인 상태이려나 ? index 는 1,2,3,4,5,6,7,8 이라고 생각하자, arr[select] = index
     * 그럼 초기상태는 index 가 1인 상태이겠네, select 를 반영해서 해보자, select 는 선택되었을 떄, 선택되지 않았을 때를 구분할 수 있다.
     * 메소드의 종료조건이 뭘까 ? 1. index 가 배열의 크기를 넘어갔을 때 밖에는 없을 것 같은데? 나중에 필요하면 더 생각해 보도록 하자
     * 규칙이뭐냐, 상하좌우대각선까지 겹치지 않게 하는건데? 배열의 처음과 마지막을 제외하곤 상하좌우대각선까지 없어야하는군
     * 앞에서 사용한 boolean 배열을 한번 사용해보자, 만약 위 arr 로 예를 들면? arr[1] = 2일 때는 일단 arr[0]이랑 안겹쳐서 들어왔을 테고,
     * arr[2] 에 올 것들을? 정하려면, 대각선 좌우 따지면,, 1,2,3을 못오겠네 ?그럼 i-1, i, i+1의 위치에 못온다고 생각하면 되겠네,
     *
     */

    public static void nQueen(int T, int select, int index) {
        if(index > T) {
            return;
        }

        /**
         * 8, 0, 1
         * i = 0, arr[0] = 1이었어, 다음으로 가, arr[1] = 2 안돼, 3 안돼, 4 돼 4골라, arr[1] = 4
         * arr[select] = index; 에서 arr[0] = 1이 되겠지.. 그리고 다음으로 넘어가면?
         * isCan = {t, t, f, f, f, f, f, f}
         * nQueen(8, 1, 2) 에선 arr[1] = index 를 구해야함 ,, 가능한지 아닌지를 따지려면 ?
         *
         */

        for (int i = 0; i < T; i++) {
            if (isCan[i] && i == 0){
                isCan[i] = true;
                isCan[i + 1] = true;
                // 선택되었다면
                arr[select] = index;
                nQueen(T, select + 1, index + 1);
            }
            // isCan[i] 가 false 여야 조건문이 실행
            else if (!isCan[i] && i > 0 && i < T - 1) {

            } else {

            }
        }
    }
}
