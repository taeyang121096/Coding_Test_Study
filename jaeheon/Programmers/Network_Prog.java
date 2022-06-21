package Programmers;

//n = 컴퓨터의 개수
//computers 연결에 대한 정보가 담긴 2차원 배열
//computers[i][j] = 1 -> i, j 연결


class Network_Prog {
 
 static void dfs(int[][] computer, int i, boolean[] visit){
     visit[i] = true;
     for(int j = 0; j < computer[0].length; j++){
         if(!visit[j] && computer[i][j] == 1){
             dfs(computer, j, visit);
         }
     }
 }
 
 public int solution(int n, int[][] computers) {
     int answer = 0;
     
     boolean[] visit = new boolean[n];
     for(int i = 0; i < n; i++){
         if(!visit[i]){
             dfs(computers, i, visit);
             answer++;
         }
     }
     
     return answer;
 }
}