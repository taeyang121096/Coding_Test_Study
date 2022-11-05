package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_13218 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int num = Integer.parseInt(br.readLine());
            System.out.print("#" + t + " ");
            if (num < 3) {
                System.out.println(0);
            } else {
                System.out.println(num/3);
            }
        }
    }
}
