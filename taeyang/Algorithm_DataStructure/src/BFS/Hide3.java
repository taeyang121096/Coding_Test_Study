package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hide3 {
    static int time;
    static void bfs(int[] loc,int k){
        Queue<int[]> q = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        q.offer(loc);
//      bfs -> 우선순위 큐로 구현
        while(!q.isEmpty()){
            int[] nLoc = q.poll();

            if(nLoc[0] == k) {
                time = nLoc[1];
                break;
            }
            if(nLoc[0]-1 >= 0){
                q.offer(new int[]{nLoc[0]-1,nLoc[1]+1});
            }
            if(nLoc[0]+1 <= 100000){
                q.offer(new int[]{nLoc[0]+1,nLoc[1]+1});
            }
            if(nLoc[0]*2 <= 100000 && nLoc[0]*2 < k){
                q.offer(new int[]{nLoc[0]*2,nLoc[1]+0});
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        time = 0;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(new int[]{n,0},k);
        System.out.println(time);
    }
}
