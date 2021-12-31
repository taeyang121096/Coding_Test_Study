package basic;

import java.util.*;

public class Sign {
    static boolean check[];
    static int n;
    static String sign;
    static ArrayList<String>list = new ArrayList<>();
    static void make(int level,int[]tmp){
        if(level == n+1){
            String str = "";
            for(int i = 0;i<n+1;i++)
                str += String.valueOf(tmp[i]);
            list.add(str);
            return;
        }
        for(int i = 0;i<10;i++){
            if(check[i])
                continue;
            if(level != 0){
                if(sign.charAt(level-1) == '<' && tmp[level-1]>i)
                    continue;
                else if(sign.charAt(level-1) == '>' && tmp[level-1]<i)
                    continue;
            }
            tmp[level] = i;
            check[i] = true;
            make(level+1,tmp);
            check[i]= false;
        }
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        check = new boolean[10];
        sign = sc.nextLine().replace(" ","");
        make(0,new int[n+1]);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
    }
}
