import java.util.*;
class Solution {
    
    class Point{
        int r,c,cnt;
        
        Point(int r, int c,int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static int[][] Board;
    static int max = Integer.MAX_VALUE;
//     상하좌우 0 => 행 1=>열
    static final int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
    
    int bfs(Point src, Point dst){
        
        boolean[][] visit = new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        
        q.offer(src);
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            if(cur.r == dst.r && cur.c == dst.c)
                return cur.cnt;
            
            for(int i = 0;i<4;i++){
                int row = cur.r+dir[i][0];
                int col = cur.c+dir[i][1];
                
                if(row<0||row>3||col<0||col>3) continue;
//                 한칸 씩 움직이는거 ㅇㅋ??
                if(!visit[row][col]){
                    visit[row][col]=true;
                    q.offer(new Point(row,col,cur.cnt+1));
                }
                
//                 이제 컨트롤을 봐야 여기서 왜 j=2 냐면 
                for(int j = 0;j<2;j++){
//                     다른 카드를 만나면 거기가 마지막이니까 더이상 움직이면 안되서 break
                    if(Board[row][col] != 0) break;
//                     지금 보면 dir[i]~~ 는 무조건 앞에 정해진 방향으로만 갈거니까 그렇게 더하는건데
//                     여기서 보드를 넘어가면 안되니까 끝까지 오면 또 break ㅇㅇ 그러니까 for문을 최대로 한거야
                    if(row+dir[i][0] <0|| row+dir[i][0]>3|| col+dir[i][1] <0 || col+dir[i][1]>3) break;
                    row += dir[i][0];
                    col += dir[i][1];
                }
                if(!visit[row][col]){
                    visit[row][col]=true;
                    q.offer(new Point(row,col,cur.cnt+1));
                }
                
            }
            
            
            
            
            
        }
        return max;
        
        
    }
    
    
    
    int permutate(Point src){
        int ret = max;
        for(int num = 1; num<=6;num++){
            List<Point> card = new ArrayList<>();
            
            for(int i = 0;i<4;i++)
                for(int j = 0;j<4;j++){
                    if(Board[i][j] == num){
                        card.add(new Point(i,j,0));
                    }
                }
            
            if(card.isEmpty()) continue;
            
            int one = bfs(src, card.get(0)) + bfs(card.get(0),card.get(1))+2;
            int two = bfs(src, card.get(1)) + bfs(card.get(1),card.get(0))+2;
            
            for(int i = 0;i<2;i++)
                Board[card.get(i).r][card.get(i).c] = 0;
            
            ret = Math.min(ret, one + permutate(card.get(1)));
            ret = Math.min(ret, two + permutate(card.get(0)));
            
            for(int i = 0;i<2;i++)
                Board[card.get(i).r][card.get(i).c] = num;
        }   
        if(ret == max)
            return 0;
        return ret;
    }
    
    public int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Point(r,c,0));
    }
}