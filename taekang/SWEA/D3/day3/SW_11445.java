package SWEA.D3.day3;

import java.io.*;
import java.util.*;

public class SW_11445 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String P = br.readLine();
            String Q = br.readLine();
            String s = P + "a";
            System.out.print("#" + tc + " ");
            if (s.equals(Q)) {
                System.out.println("N");
            } else {
                System.out.println("Y");
            }
        }
    }
}
