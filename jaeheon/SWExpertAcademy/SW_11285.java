package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_11285 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = 10;
				double tmp = Math.sqrt((x*x) + (y*y));
				for(int j = 20; j <= 200; j+=20) {
					if(tmp <= j) {
						answer += cnt;
						break;
					}
					cnt--;
				}
			}
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}
