package basic;

import java.util.*;
import java.io.*;
public class Lotto {

    static int[] num;
    static void make(int start,int level,int[]tmp){
        if(level == 6){
            for(int i = 0;i<6;i++)
                System.out.print(tmp[i]+" ");
            System.out.println();
            return;
        }
        for(int i = start;i<num.length;i++){
            tmp[level] = num[i];
            make(i+1,level+1,tmp);
        }
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] number = br.readLine().split(" ");
            int n = Integer.parseInt(number[0]);
            if(n == 0)
                break;
            num = new int[n];
            for(int i = 0;i<n;i++)
                num[i] = Integer.parseInt(number[i+1]);
            make(0,0,new int[6]);
            System.out.println();
        }


    }
}
