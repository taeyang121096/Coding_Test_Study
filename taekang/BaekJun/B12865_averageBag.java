package BaekJun;

import java.io.*;

public class B12865_averageBag {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] str = input.split(" ");
        int N = Integer.parseInt(str[0]); // 물품의 수
        int K = Integer.parseInt(str[1]); // 준서가 버틸 수 있는 무게
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            String input2 = br.readLine();
            String[] arr2 = input2.split(" ");
            int W = Integer.parseInt(arr2[0]);
            int V = Integer.parseInt(arr2[1]);
            arr[i][0] = W;
            arr[i][1] = V;
        }

        int max = -9999;
        for (int i = 0; i < N; i++) { //
            int rest = K;
            int sum = 0;
            rest -= arr[i][0]; // K에서 빼기
            sum += arr[i][1]; //
            for (int j = i; j < N; j++) {
                if(rest < arr[j][0]){
                    continue;
                } else {
                    rest -= arr[j][0];
                    sum += arr[j][1];
                }
            }
            if(max > sum)
                max = max;
            else
                max = sum;
        }
        System.out.println(max);
    }
}
