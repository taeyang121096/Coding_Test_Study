package Softeer;

import java.util.*;
import java.io.*;

public class Playfair_SOF {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String key = br.readLine();
		char[][] arr = new char[5][5];

		List<Character> al = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			if ('A' + i == 'J') {
				continue;
			}
			al.add((char) ('A' + i));
		}

		int row = 0;
		int col = 0;
		for (int i = 0; i < key.length(); i++) {
			char ch = key.charAt(i);
			if (al.contains(ch)) {
				arr[row][col] = ch;
				al.remove(Character.valueOf(arr[row][col]));
				col++;
			}
			if (col == 5) {
				col = 0;
				row++;
			}
		}

		for (int i = 0; i < al.size(); i++) {
			arr[row][col] = al.get(i);
			col++;
			if (col == 5) {
				col = 0;
				row++;
			}
		}

		// for(int i = 0; i < 5; i++){
		// for(int j = 0; j < 5; j++){
		// System.out.print(arr[i][j] + " ");
		// }
		// System.out.println();
		// }

		sb.append(str);
		int idx = 0;
		while (idx < sb.length() - 1) {
			if (sb.charAt(idx) == sb.charAt(idx + 1)) {
				if (sb.charAt(idx) == 'X') {
					sb.insert(idx + 1, 'Q');
				} else {
					sb.insert(idx + 1, 'X');
				}
			}
			idx += 2;
		}
		if (sb.length() % 2 == 1) {
			sb.append('X');
		}
		// System.out.println(sb.toString());

		idx = 0;
		while (idx < sb.length() - 1) {
			char first = sb.charAt(idx);
			char last = sb.charAt(idx + 1);

			int fr = 0;
			int fc = 0;
			int lr = 0;
			int lc = 0;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (first == arr[i][j]) {
						fr = i;
						fc = j;
					}
					if (last == arr[i][j]) {
						lr = i;
						lc = j;
					}
				}
			}

			if (fr == lr) {
				if (fc + 1 == 5) {
					fc = -1;
				}
				if (lc + 1 == 5) {
					lc = -1;
				}
				sb.setCharAt(idx, arr[fr][fc + 1]);
				sb.setCharAt(idx + 1, arr[lr][lc + 1]);
				idx += 2;
			} else if (fc == lc) {
				if (fr + 1 == 5) {
					fr = -1;
				}
				if (lr + 1 == 5) {
					lr = -1;
				}
				sb.setCharAt(idx, arr[fr + 1][fc]);
				sb.setCharAt(idx + 1, arr[lr + 1][lc]);
				idx += 2;
			} else {
				sb.setCharAt(idx, arr[fr][lc]);
				sb.setCharAt(idx + 1, arr[lr][fc]);
				idx += 2;
			}
		}
		System.out.println(sb.toString());
	}
}
