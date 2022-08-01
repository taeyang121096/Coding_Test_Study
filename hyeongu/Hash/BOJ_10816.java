import java.io.*;
import java.util.*;

public class Boj_10816 {
	public static void main(String[] args) throws IOException{
		HashMap<Integer,Integer> hm = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(hm.containsKey(tmp)) {
				sb.append(hm.get(tmp) + " ");
			}
			else {
				sb.append(0 + " ");
			}
		}
		System.out.println(sb.toString());
	}
}