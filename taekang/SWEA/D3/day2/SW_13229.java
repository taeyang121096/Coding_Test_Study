package SWEA.D3.day2;

import java.io.*;
import java.util.*;

public class SW_13229 {
    private static String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String d = br.readLine();
            int idx = -1;
            for (int i = 0; i < day.length; i++) {
                if (day[i].equals(d)) {
                    idx = i;
                }
            }
            System.out.print("#" + t + " ");
            if (idx == 6) {
                System.out.println(7);
            } else {
                System.out.println(7 - idx - 1);
            }
        }
    }
}
