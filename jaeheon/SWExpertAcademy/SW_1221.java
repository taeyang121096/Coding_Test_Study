package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1221 {
	
	static String[] num = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			String trash = st.nextToken();
			int n = Integer.parseInt(st.nextToken());

			List<Integer> al = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < n; i++) {
				String str = st.nextToken();
				for(int j = 0; j < 10; j++) {
					if(num[j].equals(str)) {
						al.add(j);
					}
				}
			}
			Collections.sort(al);
			sb.append("#").append(t).append("\n");
			for(int i = 0; i < n; i++) {
				int k = al.get(i);
				sb.append(num[k]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
