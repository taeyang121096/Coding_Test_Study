package Programmers;

import java.util.*;

public class MakeString_devc {
    public static void main(String[] args) {
        String answer = "";
        String src = "010101"; // 000 1 0 1 0 1 // 0CAAAAA
        // 1 = A ~ 26 = Z
        Queue<Character> q = new ArrayDeque<>();
        for (int i = 0; i < src.length(); i++) {
            q.offer(src.charAt(i));
        }

        answer += q.peek(); // 1
        char tmp = q.peek(); // 1
        int cnt = 0; // 1

        while(!q.isEmpty()){
            char c = q.poll(); //
            if(tmp == c){ //
                cnt++; //
                if(q.isEmpty()){
                    answer += getChar(cnt);
                }
            } else { //
                if(q.isEmpty()){
                    answer += getChar(cnt);
                    cnt = 1;
                    // 어짜피 마지막 한개만 남은것이기 때문이다
                    answer += getChar(cnt);
                } else {
                    tmp = c; //
                    answer += getChar(cnt);
                    cnt = 1;
                }
            }
        }
        System.out.println(answer);
    }

    public static Character getChar(int i) {
        return ((char) (i + 64));
    }

}
