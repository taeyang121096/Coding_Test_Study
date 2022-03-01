import java.io.*;
import java.util.*;
//
// 인접 : 상 하 좌 우 하루에 익힐 수 있는 토마토
//  최소로 빠르게 익는 일수
// n : row, m : col 2 ~ 1000
// 1 익음 0 안익음 -1 토마토 없음
// 시작 부터 모드 익었으면 0
// 토마토가 모두 익지 못하면 -1
// bfs 를 쓸거고 안익은거 카운팅을 해주걸고
// 익을 때마다 카운팅을 줄이면 되겟구나
public class Tomato_BOJ {

    static int cnt = 0;
    static int mat[][];
    static int day = 0;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static void bfs(List<int[]> first){
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] > o2[2] ? 1:-1;
            }
        });
        for(int[] tmp : first)
            q.offer(tmp);

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int[] d : dir){
                int nr = tmp[0] + d[0];
                int nc = tmp[1] + d[1];
                if(nr>=0 && nc >=0 && nr<mat.length && nc <mat[0].length && mat[nr][nc] ==0){
                    mat[nr][nc] = 1;
                    cnt--;
                    q.offer(new int[]{nr,nc,tmp[2]+1});
                    day = Math.max(day,tmp[2]+1);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        mat = new int[n][m];
        List<int[]> list = new ArrayList<>();

        for(int i = 0;i<n;i++){
            int idx = 0;
            st = new StringTokenizer(br.readLine()," ");
            while(st.hasMoreTokens()){
                mat[i][idx] = Integer.parseInt(st.nextToken());
                if(mat[i][idx] == 0) {
                    cnt++;
                }
                if(mat[i][idx] == 1) {
                    list.add(new int[]{i,idx,0});
                }
                idx++;
            }
        }
        if(cnt == 0){
            System.out.println(0);
        }else{
            bfs(list);
            if(cnt == 0)
                System.out.println(day);
            else
                System.out.println(-1);
        }

    }
}
