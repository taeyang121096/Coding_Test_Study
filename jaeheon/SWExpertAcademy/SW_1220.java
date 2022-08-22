package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1220 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[100][100];
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean flag = true;
			int cnt = 0;
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					if(arr[j][i] == 0) {
						continue;
					}
					if(arr[j][i] == 1) {
						flag = false;
					}
					if(!flag && arr[j][i] == 2) {
						flag = true;
						cnt++;
					}
				}
				flag = true;
			}
			sb.append("#").append(t).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
	}
}
