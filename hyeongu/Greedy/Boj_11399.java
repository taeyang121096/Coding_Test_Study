import java.io.*;
import java.util.*;
public class Boj_11399 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i = 0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int count = 0;
		int tmp = 0;
		for(int i = 0; i<N; i++) {
			tmp += arr[i];
			count += tmp;
		}
		System.out.println(count);
	}
}
