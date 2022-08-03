import java.io.*;
import java.util.*;
public class Boj_11047 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		
		while( N-- > 0 ) {
			if(K/arr[N]>0) {
				count += K/arr[N];
				K = K % arr[N];
			}
			if(K==0) {
				break;
			}
		}
		System.out.println(count);
	}
}
