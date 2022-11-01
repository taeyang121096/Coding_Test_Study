package SWEA;

import java.io.*;

public class SW_1213 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine(); // ti
            String compare_str = br.readLine(); // 긴 문장
            int cnt = 0;
            int len = str.length();
            for (int j = 0; j <= compare_str.length() - len; j++) {
                if(str.equals(compare_str.substring(j, j + len))){
                    cnt++;
                }
//                System.out.println(compare_str.substring(j, j+len));
            }
            System.out.println("#" + N + " " + cnt);
        }
    }
}