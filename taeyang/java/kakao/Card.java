/* Ä«µå Â¦ ¸ÂÃß±â*/
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
    int [][] Board;
//     »óÇÏÁÂ¿ì
    static final int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
        
    int bfs(Point src, Point dst){
        boolean[][] visited = new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()){
            Point curr = q.poll();
            if(curr.r == dst.r && curr.c == dst.c)
                return curr.cnt;
            
            for(int i = 0;i<4;i++){
                int row = curr.r+dir[i][0], col = curr.c+dir[i][1];
                if(row<0||row>3||col<0||col>3) continue;
                
                if(!visited[row][col]){
                    visited[row][col]=true;
                    q.offer(new Point(row,col,curr.cnt+1));
                }
                
                for(int j = 0;j<4;j++){
                    if(Board[row][col] != 0) break;
                    if(row+dir[i][0] <0 || row+dir[i][0] >3 ||col+dir[i][1] <0 || col+dir[i][1]>3) break;
                    row += dir[i][0];
                    col += dir[i][1];
                }
                if(!visited[row][col]){
                    visited[row][col]=true;
                    q.offer(new Point(row,col,curr.cnt+1));
                }
                
            }
        }
        return Integer.MAX_VALUE;
    }
    
    int permutate(Point src){
        int ret = Integer.MAX_VALUE;
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
            ret = Math.min(ret, one + permutate(card.get(0)));
            
            for(int i = 0;i<2;i++)
                Board[card.get(i).r][card.get(i).c] = num;
        }   
        if(ret == Integer.MAX_VALUE)
            return 0;
        return ret;
    }
    
    public int solution(int[][] board, int r, int c) {
        Board = board;
        return permutate(new Point(r,c,0));
    }
}