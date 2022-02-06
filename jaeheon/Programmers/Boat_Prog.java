package Programmers;

//사람 1 ~ 50000
//몸무게, 무게제한 40 ~ 240
//한번에 무게제한 만큼만 태울 수 있음

//50 70 80
//50 + 80 = 130 > 100
//50 + 70 = 120 > 100
//50 + 50 = 100 = 100
import java.util.*;

class Boat_Prog {
 public int solution(int[] people, int limit) {
     int answer = 0;
     
     Arrays.sort(people);
     
     int min = 0;
     
     for(int i = people.length - 1; i >= min; i--){
         if(people[i] + people[min] <= limit){
             min++;
         }
         answer++;
     }
     
     return answer;
 }
}