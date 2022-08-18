package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_1213 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < 10; t++) {
			int tc = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String sen = br.readLine();
			
			int cnt = 0;
			for(int i = 0; i < sen.length() - str.length() + 1; i++) {
				if(str.charAt(0) == sen.charAt(i)) {
					for(int j = 1; j < str.length(); j++) {
						if(str.charAt(j) != sen.charAt(j + i)) {
							break;
						}
						if(j == str.length() - 1) {
							cnt++;
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
