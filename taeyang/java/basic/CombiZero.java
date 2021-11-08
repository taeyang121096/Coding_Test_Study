package basic;

import java.util.*;
public class CombiZero {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String []num = sc.nextLine().split(" ");
        int n = Integer.parseInt(num[0]);
        int m = Integer.parseInt(num[1]);
        int k = n-m;

        int five =count5(n) - count5(m)- count5(k);
        int two =count2(n)-count2(m)-count2(k);

        System.out.println(Math.min(two,five));
    }
    static int count2(int val){
        int count = 0;
        while(val/2!=0){
            count += val/2;
            val /= 2;
        }
        return count;
    }
    static int count5(int val){
        int count = 0;
        while(val/5!=0){
            count += val/5;
            val /= 5;
        }
        return count;
    }
}
