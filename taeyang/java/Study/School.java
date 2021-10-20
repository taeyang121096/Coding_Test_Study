import java.util.*;
import java.io.*;

public class School {
    static int[][] mat;
    static int n;
    static HashMap<Integer, int[]> map = new LinkedHashMap<Integer, int[]>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        mat = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map.put(Integer.valueOf(st.nextToken()), new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        for (int key : map.keySet()) {
            check(key);
            for(int[] l : mat){
                for(int i : l){
                    System.out.print(i+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }

    static int[][] dist = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


    static void check(int key) {
        int[] tmp = map.get(key);
        s.clear();
        f.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    first(i, j, tmp);
            }
        }

        if (f.size() == 1) {
            int[] rc = f.get(0);
            mat[rc[0]][rc[1]] = key;
        } else {
            second();
            if(s.size() == 1){
                int[] rc = s.get(0);
                mat[rc[0]][rc[1]] = key;
            }else{
                Collections.sort(s,new Comparator<int[]>(){
                   @Override
                   public int compare(int[] o1, int[]o2){
                       if(o1[0] == o2[0]){
                           return o1[1] > o2[1] ? 1:-1;
                       }
                       return o1[0] > o2[0] ? 1:-1;
                    }
                });
                int[] rc = s.get(0);
                mat[rc[0]][rc[1]] = key;
            }
        }
    }

    static ArrayList<int[]> f = new ArrayList<>();
    static ArrayList<int[]> s = new ArrayList<>();

    static void first(int row, int col, int[] tmp) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nr = row + dist[i][0];
            int nc = col + dist[i][1];
            if (nr >= 0 && nc >= 0 && nr < n && nc < n && mat[nr][nc] != 0) {
                for (int val : tmp) {
                    if (val == mat[nr][nc]) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        if (max < cnt) {
            max = cnt;
            f.clear();
            f.add(new int[]{row, col});
        } else if (max == cnt) {
            f.add(new int[]{row, col});
        }
    }

    static void second() {
        int max = 0;
        for (int[] rc : f) {
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nr = rc[0] + dist[i][0];
                int nc = rc[1] + dist[i][1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && mat[nr][nc] == 0) {
                    cnt++;
                }
            }
            if(max<cnt){
                max = cnt;
                s.clear();
                s.add(new int[]{rc[0],rc[1]});
            }
            else if(max == cnt){
                s.add(new int[]{rc[0],rc[1]});
            }
        }
    }
}
