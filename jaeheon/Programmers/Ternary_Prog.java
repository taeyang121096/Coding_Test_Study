package Programmers;

import java.util.*;

class Ternary_prog {
    public int solution(int n) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n != 0){
            list.add(n%3);
            n/=3;
        }
        
        // for(int i = 0; i < list.size(); i++){
        //     System.out.println(list.get(i));
        // }
        
        int tmp = 1;
        for(int i = list.size() - 1; i >=0; i--){
            answer += list.get(i)*tmp;
            tmp*=3;
        }
        
        return answer;
    }
}