import java.io.*;
import java.util.*;
public class Boj_13305 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] distance = new int[N-1];
		int[] cost = new int[N];
		
		for(int i = 0; i<N-1; i++) {
			distance[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long count = 0;
		long min = Integer.MAX_VALUE;
		
		for(int i = 0; i<N-1; i++) {
			min = Math.min(min, cost[i]);
			count += min*distance[i];
		}
		System.out.println(count);
	}
}
