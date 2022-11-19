package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_14692 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int i = 1; i <= tc; i++) {
			int n = Integer.parseInt(br.readLine());
			
			
			if(n % 2 == 0) {
				sb.append("#").append(i).append(" ").append("Alice");
			} else {
				sb.append("#").append(i).append(" ").append("Bob");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
