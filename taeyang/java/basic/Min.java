package basic;

import java.util.*;
public class Min {

//    t = 1000
//    45000
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.nextLine());
        for(int i = 0;i<t;i++){
            String []num = sc.nextLine().split(" ");
            int f = Integer.valueOf(num[0]);
            int s = Integer.valueOf(num[1]);
            calc(f,s);
            System.out.println(max);
            max = 1;
            min = 1;
        }
    }
    static int max=1;
    static int min =1;
    static void calc(int f,int s){
        boolean flag = false;
        for(int i = 2;i<=10000;i++){
            if(i > f || i>s)
                break;
            if(f%i == 0 && s%i==0){
                min *= i;
                calc(f/i,s/i);
                flag = true;
                break;
            }
        }
        if(!flag)
            max = f*s*min;
    }
}
