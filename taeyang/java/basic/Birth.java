package basic;

import java.util.*;
public class Birth {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int e = Integer.parseInt(str[0]);
        int s = Integer.parseInt(str[1]);
        int m = Integer.parseInt(str[2]);
        int E = 1;
        int S = 1;
        int M = 1;
        int count = 1;
        while(!((E==e) && (S == s)&&(M==m))){
            E++;
            S++;
            M++;
            if(E>15)
                E = 1;
            if(S>28)
                S = 1;
            if(M>19)
                M = 1;
            count++;
        }
        System.out.println(count);
    }
}
