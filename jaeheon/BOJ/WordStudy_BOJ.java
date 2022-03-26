package BOJ;

import java.io.*;
import java.util.*;

// 백준 1157 단어공부

// 단어에서 가장 많이 사용된 알파벳을 대문자로 출력
// 가장 많이 사용된 알파벳이 여러개면 ? 출력

public class WordStudy_BOJ {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		int[][] alphabet = new int[26][2];
		
		for(int i = 0; i < 26; i++) {
			alphabet[i][1] = i;
		}
		
		for(int i = 0; i < str.length(); i++) {
			alphabet[str.charAt(i) - 'A'][0]++;
		}
		
		Arrays.sort(alphabet, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) {
					return 1;
				} else if(o1[0] < o2[0]){
					return -1;
				} else {
					return 0;
				}
			}
		});
//		System.out.println(alphabet[25][0] + " " + alphabet[25][1]);
		
		if(alphabet[24][0] == alphabet[25][0]) {
			System.out.println('?');
		} else {
			System.out.println((char)(alphabet[25][1] + 'A'));
		}
		
	}
}
