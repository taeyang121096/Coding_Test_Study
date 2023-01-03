package Programmers.lv2;

import java.io.*;
import java.util.*;

public class sameCantorBeatString {
    /**
     * 4 30 118 => 39
     * 3 1 125 => 64
     * 4 27 68 => 15

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 4;
        long l = 27;
        long r = 68;
        int answer = 0;

        for(long i = l-1; i < r; i++){
            String str = Long.toString(i, 5);
            if(!str.contains("2")){ //
                answer++;
            }
        }

        System.out.println(answer);
    }
}
