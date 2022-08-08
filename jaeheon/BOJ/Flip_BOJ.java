package BOJ;

// 백준 1439 뒤집기

import java.io.*;
import java.util.*;

public class Flip_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st1 = new StringTokenizer(str, "0");
		StringTokenizer st0 = new StringTokenizer(str, "1");
		System.out.println(Math.min(st1.countTokens(), st0.countTokens()));
	}
}
