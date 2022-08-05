import java.io.*;
import java.util.*;
public class Boj_1449 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int count = 0;
		
		int[] arr = new int[1001];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i<N; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		
		for(int i = 0; i<1001; i++) {
			if(arr[i]>0) {
				count++;
				i += L-1;
			}
		}
		System.out.println(count);
	}
}
