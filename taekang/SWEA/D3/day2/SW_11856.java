package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_11856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String str = br.readLine();

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            if (map.size() == 2) {
                boolean flag = false;
                for (Character cr : map.keySet()) {
                    if (map.get(cr) != 2) {
                        flag = true;
                        break;
                    }
                }
                if (flag) System.out.println("#" + tc + " No");
                else System.out.println("#" + tc + " Yes");
            } else {
                System.out.println("#" + tc + " No");
            }

        }
    }
}
