package SWEA;

import java.io.*;

public class SW_1220 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int T = 1; T <= 10; T++) {
            int N = Integer.parseInt(br.readLine()); // 100
            int[][] map = new int[100][100];
            for (int i = 0; i < 100; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }

            int cnt = 0;
            boolean flag = false;
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    if(map[j][i] == 1){
                        flag = true;
                    } else if(map[j][i] == 2){
                        if(flag){
                            flag = false;
                            cnt++;
                        }
                    }
                }
                flag = false;
            }

            System.out.println("#" + T +" " +cnt);

//            for (int i = 0; i < 100; i++) {
//                for (int j = 0; j < 100; j++) {
//                    System.out.print(map[i][j]+ " ");
//                }
//                System.out.println();
//            }
        }
    }
}
