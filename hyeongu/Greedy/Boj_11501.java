import java.io.*;
import java.util.*;
public class Boj_11501 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			long answer = 0;
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = N-1; i>=0; i--) {
				if(max<arr[i]) {
					max = arr[i];
				}
				else {
					answer += max - arr[i];
				}
			}
			sb.append(answer+ "\n");
		}
		System.out.print(sb);
	}
}