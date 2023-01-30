import java.io.*;
import java.util.*;

public class BOJ_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] fact = new boolean[N];
        boolean[] party = new boolean[M];
        int[][] arr = new int[M][];
        int answer = M;

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        if(cnt > 0){
            for(int i = 0; i < cnt; i++){
                fact[Integer.parseInt(st.nextToken()) - 1] = true;
            }
        }
        else{
            System.out.print(answer);
            return;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = new int[tmp];

            for(int j = 0; j < tmp; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            if(party[i]) continue;
            boolean flag = false;
            for(int j = 0; j < arr[i].length; j++){
                if(fact[arr[i][j] - 1]){
                    flag = true;
                    party[i] = true;
                    answer--;
                    break;
                }
            }
            if(flag){
                for(int j = 0; j < arr[i].length; j++){
                    fact[arr[i][j] - 1] = true;
                }
                i = -1;
            }
        }
        System.out.print(answer);
    }
}
