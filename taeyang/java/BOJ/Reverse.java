package basic;

import java.util.*;
import java.io.*;
public class Reverse  {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[]args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<t;i++){
            String[] str = sc.nextLine().split(" ");
            StringBuilder sb = new StringBuilder();
            for(String st : str){
                StringBuilder tmp = new StringBuilder(st);
                sb.append(tmp.reverse()+" ");
            }
            list.add(sb.toString());
        }
        for(String ans : list)
            System.out.println(ans);

    }
}
