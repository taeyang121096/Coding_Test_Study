import java.util.*;
import java.io.*;

public class Boj_1966 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i<T; i++) {
			Queue<int[]> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k<N; k++) {
				q.offer(new int[]{k, Integer.parseInt(st.nextToken())});
			}
			while(!q.isEmpty()) {
				int[] tmp = q.poll();
				boolean flag = false;
							
				for(int arr[]:q) {
					if(arr[1]>tmp[1]) {
						flag = true;
						break;
					}
				}
				if(!flag) {
					count++;
					if(tmp[0]==M) {
						break;
					}
				}
				else {
					q.offer(tmp);
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb);
	}
}