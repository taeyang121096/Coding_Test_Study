package BaekJun;

import java.io.*;

public class B14719_rain {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] str = input.split(" ");
        int H = Integer.parseInt(str[0]); // H
        int w = Integer.parseInt(str[1]);
        String input2 = br.readLine();
        String[] str2 = input2.split(" ");

        int[] size = new int[str2.length];
        for(int i = 0; i < str2.length; i++)
            size[i] = Integer.parseInt(str2[i]);

        int answer = 0;

        for (int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for (int j = 0; j < i; j++) {
                left = Math.max(size[j], left);
            }

            for(int j = i+1; j < w; j++) {
                right = Math.max(size[j], right);
            }

            while (left < right) {

            }
        }

    }
}
