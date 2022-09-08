import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Log {
    /*
    10 11 12 13 14 15
     13  12 11 10 11 12
    2 4 5 7 9
    6
    1 2 3 4 5
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0;i<test;i++){
            int num = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int[] first = new int[num];
            int[] ans = new int[num];
            int idx = 0;
            int head = 0;
            int tail = num-1;
            int answer = 0;
            while(st.hasMoreTokens()){
                int val = Integer.parseInt(st.nextToken());
                first[idx++] = val;
            }
            idx = 0;
            Arrays.sort(first);
            while(head <= tail){
                if(idx %2 ==0){
                    ans[head++] = first[idx++];
                }else{
                    ans[tail--] = first[idx++];
                }
            }

            for(int j = 0;j<num;j++){
                if(j+1 < num) {
                    answer = Math.max(answer, Math.abs(ans[j] - ans[j + 1]));
                }else{
                    answer = Math.max(answer, Math.abs(ans[j] - ans[0]));
                }
            }
            System.out.println(answer);

        }
    }
}
