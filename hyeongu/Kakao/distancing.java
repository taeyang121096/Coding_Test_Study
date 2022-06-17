import java.util.*;

class Solution {
    
//     대기실 5개 -> 5*5
//     멘해튼 거리 2 이하 앉지말아주세요 -> 3 까지는 되어야 한다.
//     단 파티션 존재 상관 x
//     파티션 -> x 빈테이블 -> o 응시자 -> p
//     거리두기 지키면 1 아니면 0
//     dir 상하좌우
//     bfs 를 통해서 depth 2 까지 하는데 p를 안만나면 통과
//     depth 2를 하는 도중 x를 만나도 통과
//     data structure queue -> 
//     1. p 를 만났을경우에 bfs를 하고 bfs -> 0일경우는 계속해주고, 1일경우에는 break를 해준다.
//     2. return list 로 할건데 -> add -> flag -> 를 해준다.
    static char[][] tmp;
    static int size = 5;
    static boolean[][] check;
    static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    
    static int bfs(int row,int col){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{row,col,0});
        while(!q.isEmpty()){
            int[] t = q.poll();
            int r = t[0];
            int c = t[1];
            int d = t[2];
            if(d > 2)
                continue;
            check[r][c] = true;
            
            if(tmp[r][c] == 'P' && d > 0 && d<=2){
                return 0;
            }
            
            if(tmp[r][c] == 'X')
                continue;
            
            for(int[] di : dir){
                int nr = r+di[0];
                int nc = c+di[1];
                int nd = d+1;
                if(nr>= 0 && nr<5 && nc>=0 && nc<5 && !check[nr][nc] ){
                    q.offer(new int[]{nr,nc,nd});
                }
            }
        }
        return 1;
        
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[size];
        List<Integer> ans = new ArrayList<>();
        
        for(int r = 0;r<5;r++){
            tmp = new char[5][5];
            for(int c = 0;c<5;c++ ){
                for(int i=0;i<5;i++){
                    tmp[c][i] = places[r][c].charAt(i);
                }
            }
            boolean flag = false;
            check = new boolean[5][5];
            for(int i = 0;i<5;i++){
                if(flag)
                    break;
                for(int j = 0;j<5;j++){
                    if(tmp[i][j] == 'P'){
                        if(bfs(i,j) == 0){
                            flag = true;
                            break;
                        }
                    }
                }
            }
            if(flag)
                ans.add(0);
            else
                ans.add(1);
            
        }
        
        for(int i = 0; i<size; i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}