package Programmers;

//m, n -> 1~100 자연수 둘다 1인 경우는 없음
//물에 잠긴 지역 0~10 -> -1으로 초기화
//집과 학교는 물에 잠기지 않음(1,1)(m,n)
//최단 경로의 개수를 1,000,000,007로 나눈 나머지

//* 1 1 1
//1 P 1 2
//1 1 2 4

//1 1 1 1
//1 2 3 4
//1 3 6 10

class GoToSchool_Prog {
 public int solution(int m, int n, int[][] puddles) {
     int answer = 0;
     int size = 1000000007;
     int[][] map = new int[m][n];
     map[0][0] = 1;
     
     //웅덩이
     for(int[] tmp : puddles){
         map[tmp[0]-1][tmp[1]-1] = -1;
     }
     
     for(int i = 0; i < m; i++) {
         for(int j = 0; j < n; j++) {
             if(map[i][j] == -1) { // 웅덩이
                 map[i][j] = 0; // 0으로 바꿔줌 -> 덧셈에 방해 안되게
                 continue;
             }
             if(i != 0) {
                 map[i][j] = (map[i-1][j] + map[i][j]) % size;
             }
             if(j != 0) {
                 map[i][j] = (map[i][j-1] + map[i][j]) % size;
             }
         }
     }
     
     answer = map[m-1][n-1];
     
     return answer;
 }
}
