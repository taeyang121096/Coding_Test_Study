package Programmers;


//아래 : a에서 아래로 이동하면 z, b -> a
//정방향 -> 왼쪽
//a bcdefghijklm n opqrstuvwxyz a
//0      12     13      12      0
//a ~ n : 알파벳 - a번 위로 이동
//o ~ z : z - 알파벳 + 1번 아래로 이동


class Joystick_Prog {
 public int solution(String name) {
     int answer = 0;
     int len = name.length();
     int move = len - 1;
     
     for(int i = 0; i < len; i++){
         if(name.charAt(i) - 'A' > 'Z' - name.charAt(i)){
             answer += 'Z' - name.charAt(i) + 1;
         } else {
             answer += name.charAt(i) - 'A';
         }
         
         int next = i + 1;
         // 다음꺼부터 연속된 A가 있을때
         // 되돌아가는게 빠른지 확인함
         while(next < len && name.charAt(next) == 'A'){
             next++;
         }
         move = Math.min(move, 2*i + (len - next));
     }
     answer+=move;
 
     return answer;
 }
}
