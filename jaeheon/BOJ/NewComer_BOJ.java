package BOJ;

import java.util.*;
import java.io.*;

public class NewComer_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			int min = Integer.MAX_VALUE;
			Map<Integer, Integer> hm = new HashMap<>();
			for(int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				hm.put(a, b);
			}
			
			Map<Integer, Integer> tm = new TreeMap<>(hm);
			for(int j : tm.keySet()) {
				if(min > tm.get(j)) {
					min = tm.get(j);
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
