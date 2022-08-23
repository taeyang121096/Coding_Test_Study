package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1225 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; t++) {
			int n = Integer.parseInt(in.readLine());
			
			Queue<Integer> q = new ArrayDeque<>();
			st = new StringTokenizer(in.readLine());
			
			for(int i=0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
            
			int now = -1;
			boolean flag = false;
            
			while(true) {
				for(int i = 1; i <= 5;i++) {
					now = q.poll();
					now -= i;
					
					if(now <= 0) {
						now = 0;
						q.offer(now);
						flag = true;
						break;
					}
					q.offer(now);
					
				}
				if(flag) {
					break;
				}
			}
			
			sb.append("#").append(t).append(" ");
			while(!q.isEmpty()) {
				sb.append(q.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}