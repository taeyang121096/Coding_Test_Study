package Programmers;

//노래를 두개씩 모아 수록
//plays에서 많이 재생된 장르
//장르에 속한 곡이 하나일수도 있음

import java.util.*;

class BestAlbum_Prog {
 public int[] solution(String[] genres, int[] plays) {
     ArrayList<Integer> answertmp = new ArrayList<>();
     
     HashMap<String, Integer> hm = new HashMap<>();

     for(int i = 0; i < genres.length; i++){
         if(!hm.containsKey(genres[i])){
             hm.put(genres[i], plays[i]);
         } else {
             hm.put(genres[i], hm.get(genres[i]) + plays[i]);
         }
     }
     
     ArrayList<String> al = new ArrayList<>(hm.keySet());
     Collections.sort(al, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
     
//      for (int i = 0; i < al.size(); i++) {
//          System.out.println(al.get(i));
//      }
     
//      for(String str : hm.keySet()){
//          System.out.println(str + " " +hm.get(str));
//      }
     
     for(String str : al){
         HashMap<Integer,Integer> tmp = new HashMap<>();
         for(int i = 0; i < plays.length; i++){
             if(str.equals(genres[i])){
                 tmp.put(i, plays[i]);
             }
         }
         ArrayList<Integer> altmp = new ArrayList<>(tmp.keySet());
         Collections.sort(altmp, (o1, o2) -> (tmp.get(o2).compareTo(tmp.get(o1))));
         int cnt = 0;
         
         for(int i : altmp){
             if(cnt > 1){
                 break;
             } else {
                 answertmp.add(i);
                 cnt++;
             }
         }
     }
     
     // for(int i = 0; i < plays.length; i++){
     //     System.out.println(tmp.get(i));
     // }
     int[] answer = new int[answertmp.size()];
     
     for(int i = 0; i < answertmp.size(); i++){
         answer[i] = answertmp.get(i);
     }
     
     return answer;
 }
}