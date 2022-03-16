package Sujong;

import java.util.*;
import java.io.*;

//
// 1. 0 이면 -> 24
// 2. -45 해주면 됨
//
public class Alam {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");

        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);

        if(h ==0){
            h = 24;
//            로직

            if(m <45){
                h -= 1;
                m += 60;
            }
            m -= 45;
        }else{
            if(m <45){
                h-=1;
                m+=60;
            }
            m -= 45;
        }
        System.out.println(h+" "+m);

    }
}
