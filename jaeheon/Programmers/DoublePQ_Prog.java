package Programmers;
// I 숫자 -> 삽입
// D 1 최대 삭제
// D -1 최소 삭제
// operation 1 ~ 1000000
// answer -> 최대 최소 반환

import java.util.*;
class DoublePQ_Prog {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        PriorityQueue<Integer> pqmax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqmin = new PriorityQueue<>();
        
        for(String oper : operations){
            String[] str = oper.split(" ");
            
            if(str[0].equals("I")){
                pqmax.add(Integer.parseInt(str[1]));
                pqmin.add(Integer.parseInt(str[1]));
            } 
            else if(str[0].equals("D") && !pqmax.isEmpty() && !pqmin.isEmpty()){
                if(str[1].equals("1")){
                    int max = pqmax.peek();
                    pqmax.remove(max);
                    pqmin.remove(max);
                }
                else{
                    int min = pqmin.peek();
                    pqmax.remove(min);
                    pqmin.remove(min);
                }
            }
        }
        
        if(!pqmax.isEmpty() && !pqmin.isEmpty()){
            answer[0] = pqmax.peek();
            answer[1] = pqmin.peek();
        }
        
        return answer;
    }
}