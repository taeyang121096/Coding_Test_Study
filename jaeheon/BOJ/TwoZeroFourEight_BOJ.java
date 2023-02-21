package BOJ;

import java.util.*;
import java.io.*;

public class TwoZeroFourEight_BOJ {

    static int n;
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, arr);
        System.out.println(answer);
    }

    static void dfs(int depth, int[][] arr){
        if(depth == 5){
            answer = Math.max(answer, find(arr));
            return;
        }

        up(depth, copy(arr));
        down(depth, copy(arr));
        left(depth, copy(arr));
        right(depth, copy(arr));

    }

    static int find(int[][] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                max = Math.max(max, arr[i][j]);
            }
        }
        return max;
    }

    static int[][] copy(int[][] arr){
        int[][] tmp = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    static void left(int cnt, int[][] arr){             // 4  2  0
        for(int i = 0; i < arr.length; i++){            // 8  4  0
            int col = 0;                                // 16 8  0
            int tmp = 0;
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] != 0){
                    if(tmp != arr[i][j]){
                        tmp = arr[i][j];
                        arr[i][j] = 0;
                        arr[i][col] = tmp;
                        col++;
                    } else {
                        arr[i][col - 1] *= 2;
                        tmp = 0;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        dfs(cnt + 1, arr);
    }

    static void right(int cnt, int[][] arr){            // 0  2  4
        for(int i = 0; i < arr.length; i++){            // 0  4  8
            int col = arr.length - 1;                   // 0  8  16
            int tmp = 0;
            for(int j = arr.length - 1; j >= 0; j--){
                if(arr[i][j] != 0){
                    if(tmp != arr[i][j]){
                        tmp = arr[i][j];
                        arr[i][j] = 0;
                        arr[i][col] = tmp;
                        col--;
                    } else {
                        arr[i][col + 1] *= 2;
                        tmp = 0;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        dfs(cnt + 1, arr);
    }

    static void up(int cnt, int[][] arr){                   // 4  2  0      // 2  0  0
        for(int j = 0; j < arr.length; j++){                // 2  0  0      // 2  2  0
            int row = 0;                                    // 0  0  0      // 2  0  0
            int tmp = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i][j] != 0){
                    if(tmp != arr[i][j]){
                        tmp = arr[i][j];
                        arr[i][j] = 0;
                        arr[row][j] = tmp;
                        row++;
                    } else {
                        arr[row - 1][j] *= 2;
                        tmp = 0;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        dfs(cnt + 1, arr);
    }

    static void down(int cnt, int[][] arr){                 // 0  0  0      // 2  0  0
        for(int j = 0; j < arr.length; j++){                // 2  0  0      // 2  2  0
            int row = arr.length - 1;                       // 4  2  0      // 2  0  0
            int tmp = 0;
            for(int i = arr.length - 1; i >= 0; i--){
                if(arr[i][j] != 0){
                    if(tmp != arr[i][j]){
                        tmp = arr[i][j];
                        arr[i][j] = 0;
                        arr[row][j] = tmp;
                        row--;
                    } else {
                        arr[row + 1][j] *= 2;
                        tmp = 0;
                        arr[i][j] = 0;
                    }
                }
            }
        }
        dfs(cnt + 1, arr);
    }
}
