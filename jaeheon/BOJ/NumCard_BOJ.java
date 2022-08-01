package BOJ;

// 백준 10816 숫자카드2
// containskey!!


import java.io.*;
import java.util.*;

public class NumCard_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			hm.put(tmp, hm.getOrDefault(tmp, 0) + 1);
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(hm.containsKey(key)) {
				sb.append(hm.get(key)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
