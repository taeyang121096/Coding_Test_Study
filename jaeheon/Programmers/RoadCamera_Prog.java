package Programmers;

//시각점 오름차순 -> 끝나는 지점 오름차순

import java.util.*;

class RoadCamera_Prog {
 public int solution(int[][] routes) {
     int answer = 0;
     
     Arrays.sort(routes, new Comparator<int[]>(){
         public int compare(int[] o1, int[] o2){
             if(o1[1] > o2[1]){
                 return 1;
             } else{
                 return -1;
             }
         }
     });
     
     int end = -30001;
     
     for(int i = 0; i < routes.length; i++){
         if(end < routes[i][0]){
             answer++;
             end = routes[i][1];
         }
     }
     
     return answer;
 }
}