package BOJ;

import java.util.*;
import java.io.*;

public class SortExceptRepeat_BOJ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Set<Integer> hs = new HashSet<>();
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		List<Integer> al = new ArrayList<>(hs);
		Collections.sort(al);
		for(int i : al) {
			sb.append(i).append(" ");
		}
		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
