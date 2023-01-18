import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[10001];
        int max = 0;
        int bag = 0;
        int answer = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            arr[P] += M;
            max = Math.max(max, P);
        }

        for(int i = max; i >= 0; i--){
            if(arr[i] == 0) continue;

            if(bag + arr[i] < W){
                bag += arr[i];
                answer += arr[i] * i;
            }
            else{
                answer += i * (W - bag);
                break;
            }
        }
        System.out.println(answer);
    }
}