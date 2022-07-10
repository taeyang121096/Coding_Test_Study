package Programmers;

import java.util.*;

public class Country124 {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int n = 10;
        String answer = "";
        recur(n);
//         System.out.println(list.size());

        for(int i = list.size()-1; i >= 0; i--){
            if(list.get(i) == 1){
                answer += "1";
            } else if (list.get(i) == 2){
                answer += "2";
            } else if (list.get(i) == 0){
                answer += "4";
            }
        }
        System.out.println(answer);
    }
    static public void recur(int n){
        if(n < 3){
            return;
        } else {
            int share = n / 3;
            int remainder = n % 3;
            list.add(remainder);
            recur(share);
        }
    }
}
