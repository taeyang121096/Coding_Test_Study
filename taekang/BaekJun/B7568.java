package BaekJun;

import java.io.*;

public class B7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 줄에 입력되는 String을 int로 형변환하여 입력받음
        int T = Integer.parseInt(br.readLine());
        // 키와 몸무게를 저장할 2차원 배열 선언, 초기화
        int[][] info = new int[T][2];

        // 입력받은 키와 몸무게의 String 데이터를 int로 형변환하여 2차원 배열에 값을 저장
        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            String[] arr = input.split(" ");

            for (int j = 0; j < arr.length; j++) {
                info[i][j] = Integer.parseInt(arr[j]);
            }
        }

        // 중첩 반복문을 통한 완전탐색 실행

        // arr[i][0] 과 arr[i][1]을 기준으로 하나씩 증가시켜가며 반복문 실행
        for (int i = 0; i < info.length; i++) {
            int rank = 1;

            // 기준인 배열을 두고 하나씩 배열의 INDEX를 늘려가며 반복문 실행, i와j가 같은 경우는 무시하고 continue함
            // and를 사용하여 키와 몸무게 둘다 기준보다 클 경우 rank 값을 늘려줌
            for (int j = 0; j < info.length; j++) {
                if(i == j)
                    continue;
                if ((info[i][0] < info[j][0]) && (info[i][1] < info[j][1])) {
                    rank++;
                }
            }
            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
