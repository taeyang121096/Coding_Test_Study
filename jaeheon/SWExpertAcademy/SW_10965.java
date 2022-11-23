package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_10965 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());
			Map<Integer, Integer> hm = new HashMap<>();
			int i = 2;
			int ans = 1;
			while(i <= Math.sqrt(n)) {
				if(n % i == 0) {
					hm.put(i, hm.getOrDefault(i, 0) + 1);
					n /= i;
					i = 2;
				} else {
					i++;
				}
			}
			if(i > Math.sqrt(n)) {
				hm.put(n, hm.getOrDefault(n, 0) + 1);
			}
			
			for(int key : hm.keySet()) {
				if(hm.get(key) % 2 == 1) {
					ans *= key;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb.toString());
	}

}
