package Programmers;

//n : 조건의 개수  1 <= n <= 100
//data : n개의 원소로 구성된 문자열 배열(N~F=0 같은거)
//모든 조건을 만족하는 경우의 수


class TakeAPicture_Prog {
 private int answer = 0;
 private String[] people = {"A", "C", "F", "J", "M", "N", "R", "T"};
 
 public void dfs(String person, boolean[] visit, String[] data){
     if(person.length() == 8){
         if(check(person, data)){
             answer++;
         }
         return;
     }

     for(int i = 0; i < 8; i++){            
         if(!visit[i]){
             visit[i] = true;
             String str = person + people[i];
             dfs(str, visit, data);
             visit[i] = false;
         }
     }
 }
 
 public boolean check(String person, String[] data){
     for(String tmp : data){
         int p1 = person.indexOf(tmp.charAt(0));
         int p2 = person.indexOf(tmp.charAt(2));
         char op = tmp.charAt(3);
         int distance = tmp.charAt(4) - '0';
         if(op == '='){
             if(!(Math.abs(p1 - p2) == distance + 1)){
                 return false;
             }
         } else if(op == '>'){
             if(!(Math.abs(p1 - p2) > distance + 1)){
                 return false;
             }
         } else if(op == '<'){
             if(!(Math.abs(p1 - p2) < distance + 1)){
                 return false;
             }
         }
     }
     return true;
 }
 
 public int solution(int n, String[] data) {
     boolean[] visit = new boolean[8];
     dfs("", visit, data);
     return answer;
 }
}