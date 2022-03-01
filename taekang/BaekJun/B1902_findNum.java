package BaekJun;

import java.io.*;
import java.util.*;

public class B1902_findNum {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] N_list = new int[N];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] str = input.split(" ");
            N_list[i] = Integer.parseInt(str[i]);
        }
        
    }
}
