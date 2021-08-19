/**
 * 2021 KAKAO BLIND RECRUITMENT 카드 짝 맞추기
 */
import java.util.*;
public class card { 
class Solution {
    
    int[][] Board;
    int max = Integer.MAX_VALUE;
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    
    class Point{
        int r,c,cnt;
        Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    int bfs(Point start, Point distance){
        boolean[][] visit= new boolean[4][4];
        Queue<Point> q = new LinkedList<>();
        
        q.offer(start);
        while(!q.isEmpty()){
            Point tmp = q.poll();
            
            if(tmp.r == distance.r && tmp.c == distance.c)
                return tmp.cnt;
            
            for(int i=0; i<4; i++){
                int x = tmp.r + dx[i];
                int y = tmp.c + dy[i];
                
                if(x<0 || x>3 || y<0 || y>3) continue;
                
                if(!visit[x][y]){
                    visit[x][y]=true;
                    q.offer(new Point(x,y,tmp.cnt+1));
                }
           
            
            for(int j=0; j<2; j++){
                if(Board[x][y] != 0) break;
                
                if(x+dx[i]<0 || x+dx[i]>3 || y+dy[i]<0 || y+dy[i]>3) break;
                x+=dx[i];
                y+=dy[i];
            }
            if(!visit[x][y]){
             visit[x][y]=true;
             q.offer(new Point(x,y,tmp.cnt+1));   
            }
        }
    }
        return max;
    }
    
    int CardGame(Point p){    
        int tmp =max;
        for(int num=1; num<=6; num++){
            List<Point> card = new ArrayList<>();
            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    if(Board[i][j]==num){
                        card.add(new Point(i,j,0));
                    }
                } 
            }
            if(card.isEmpty()) continue;
            
            int one= bfs(p,card.get(0)) + bfs(card.get(0),card.get(1))+2;
            int two= bfs(p,card.get(1)) + bfs(card.get(1),card.get(0))+2;
            
            for(int i=0; i<2; i++){
                Board[card.get(i).r][card.get(i).c]=0;
            }
            tmp = Math.min(tmp ,one+ CardGame(card.get(1)));
            tmp = Math.min(tmp, two+ CardGame(card.get(0)));
            
            for(int i=0; i<2; i++){
                Board[card.get(i).r][card.get(i).c]=num;
            }
        }
        if(tmp==max) return 0;
        return tmp;
    }

    public int solution(int[][] board, int r, int c) {
        
        Board = board;
    
        return CardGame(new Point(r,c,0));
    }
}
}
