import java.io.*;
import java.util.*;
public class Boj_1946 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			for(int i = 0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
			}
			int count = 1;
			int min = arr[0];
			
			for(int i = 1; i<N; i++) {
				if(min>arr[i]) {
					count++;
					min = arr[i];
				}
			}
			System.out.println(count);
		}
	}
}