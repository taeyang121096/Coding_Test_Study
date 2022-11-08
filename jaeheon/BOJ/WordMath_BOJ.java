package BOJ;

import java.io.*;
import java.util.*;

public class WordMath_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Integer[] alphabet = new Integer[26];
		Arrays.fill(alphabet, 0);
		int answer = 0;
		int val = 9;
		
		// 100a + 10a + a 길이 3 -> 100 -> 3-1제곱
 		for(int i = 0; i < n; i++) {
			char[] ch = br.readLine().toCharArray();
			
			int pow = (int)Math.pow(10, ch.length - 1);
			for(int j = 0; j < ch.length; j++) {
				alphabet[ch[j] - 'A'] += pow;
				pow /= 10;
			}
			
		}
 		
 		Arrays.sort(alphabet, Collections.reverseOrder());
 		
// 		for(int i = 0; i < alphabet.length; i++) {
// 			System.out.print(alphabet[i] + " ");
// 		}
 		
 		for(int i = 0; i < alphabet.length; i++) {
 			if(val == 0) {
 				break;
 			}
 			answer += alphabet[i] * val;
 			val--;
 		}
 		System.out.println(answer);
	}
}
