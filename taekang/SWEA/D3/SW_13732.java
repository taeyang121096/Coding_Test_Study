package SWEA.D3;

import java.io.*;
import java.util.*;

public class SW_13732 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<int[]> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                // . -> 0 # -> 1
                String str = br.readLine();
                for (int k = 0; k < N; k++) {
                    if (str.charAt(k) == '#') {
                        list.add(new int[]{j, k});
                    }
                }
            }

            int[] a = list.get(0);
            int[] b = list.get(list.size() - 1);

            int x1 = b[0] - a[0] + 1;
            int y1 = b[1] - a[1] + 1;

            System.out.print("#" + i + " ");

            if (x1 * y1 != list.size() || x1 != y1) {
                System.out.println("no");
            } else {
                boolean flag = false;
                for (int[] in : list) {
                    int x = in[0];
                    int y = in[1];
                    if (!(x >= a[0] && x <= b[0] && y >= a[1] && y <= b[1])) {
                        System.out.println("no");
                        flag = true;
                        break;
                    }
                }
                if(!flag) System.out.println("yes");
            }
        }
    }
}
