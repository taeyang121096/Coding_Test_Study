package Programmers;

import java.util.*;

public class WallPaper_Prog {
	static int n, m;
	static int minX = Integer.MAX_VALUE;
	static int minY = Integer.MAX_VALUE;
	static int maxX = Integer.MIN_VALUE;
	static int maxY = Integer.MIN_VALUE;

	public int[] solution(String[] wallpaper) {
		int[] answer = new int[4];
		n = wallpaper.length;
		m = wallpaper[0].length();

		for (int i = 0; i < n; i++) {
			String str = wallpaper[i];
			for (int j = 0; j < m; j++) {
				char ch = str.charAt(j);
				if (ch == '#') {
					minX = Math.min(i, minX);
					minY = Math.min(j, minY);
					maxX = Math.max(i, maxX);
					maxY = Math.max(j, maxY);
				}
			}
		}

		answer[0] = minX;
		answer[1] = minY;
		answer[2] = maxX + 1;
		answer[3] = maxY + 1;

		return answer;
	}
}
