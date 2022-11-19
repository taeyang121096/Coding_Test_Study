package SWExpertAcademy;

import java.util.*;
import java.io.*;

public class SW_13428 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			String num = br.readLine();
            char[] ch = num.toCharArray();
            int min = Integer.parseInt(num);
            int max = min;
            for(int i = 0; i < ch.length - 1; i++) {
                for(int j = i + 1; j < ch.length; j++) {
                    char tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                    if(ch[0] != '0') {
                        min = Math.min(min, Integer.parseInt(String.valueOf(ch)));
                        max = Math.max(max, Integer.parseInt(String.valueOf(ch)));
                    }
                    tmp = ch[i];
                    ch[i] = ch[j];
                    ch[j] = tmp;
                }
            }
            sb.append("#").append(t).append(" ").append(min).append(" ").append(max).append("\n");
		}
		System.out.println(sb.toString());
	}
}
