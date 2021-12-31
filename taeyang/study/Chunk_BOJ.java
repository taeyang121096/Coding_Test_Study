

import java.io.*;
public class Chunk_BOJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chunk = new int[n][2];
        for(int  i = 0;i<n;i++){
            String[] wh = br.readLine().split(" ");
            chunk[i][0] = Integer.parseInt(wh[0]);
            chunk[i][1] = Integer.parseInt(wh[1]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            int cnt = 0;
            for(int j = 0;j<n;j++) {
                if(i == j)
                    continue;
                if(chunk[i][0] < chunk[j][0] && chunk[i][1] < chunk[j][1])
                    cnt++;
            }
            sb.append(String.valueOf(cnt+1)+" ");
        }
        System.out.println(sb.toString());
    }
}
