package School;

import basic.Str;

import java.util.Scanner;
import java.io.*;
import java.util.StringTokenizer;

public class NCstr {

    static StringBuilder sb = new StringBuilder("1");
    static void make(){
        StringBuilder tmp= new StringBuilder();
        for(char c : sb.toString().toCharArray()){
            if(c == '1')
                tmp.append('0');
            else
                tmp.append('1');
        }
        sb.append(tmp.toString());

    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 1;i<=20;i++){
            make();
        }
        StringBuilder ans = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] num = br.readLine().split(" ");
        for(int i = 0;i<n;i++){
            ans.append(sb.charAt(Integer.parseInt(num[i])-1));
        }

        System.out.println(ans.toString());

    }
//    public static void main(String[]args){
//        int n = Integer.MAX_VALUE;
//
//        System.out.println(Integer.toBinaryString(n));
//
//    }
}
