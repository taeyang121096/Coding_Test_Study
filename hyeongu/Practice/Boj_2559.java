import java.io.*;
import java.util.*;

public class Boj_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int sum = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	if(i<K) {
        		sum += arr[i];
        	}
        }
        
        int max = sum;
        for(int i = K; i<N; i++) {
        	sum = sum + arr[i] - arr[i-K];
        	max = Math.max(sum , max);
        }
        
        System.out.println(max);
    }
}