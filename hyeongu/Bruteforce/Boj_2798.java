import java.io.*;
import java.util.*;

public class Boj_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int answer = 0;
        for(int i = 0; i<N; i++) {
        	for(int j = i+1; j<N; j++) {
        		for(int k = j+1; k<N; k++) {
        			int sum = arr[i] + arr[j] + arr[k];
        			if(sum<=M && answer < sum) {
        				answer = sum;
        			}
        		}
        	}
        }
        System.out.println(answer);
    }
}