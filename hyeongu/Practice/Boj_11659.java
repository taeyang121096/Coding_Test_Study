import java.io.*;
import java.util.*;

public class Boj_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<N+1; i++) {
        	arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        
        while(M-- > 0) {
        	st = new StringTokenizer(br.readLine());
        	int i = Integer.parseInt(st.nextToken());
        	int j = Integer.parseInt(st.nextToken());
        	int answer = arr[j] - arr[i-1];
        	sb.append(answer + "\n");
        }
        System.out.println(sb.toString());
    }
}