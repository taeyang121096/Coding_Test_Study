import java.io.*;
import java.util.*;



class Location {
    int row, col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class MazeSearch {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int arr[][];
    static int isVisit[][];
    static int n, m;
    static Deque<Location> queue = new ArrayDeque<>();
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        isVisit = new int[n+1][m+1];

        // 입력 값을 배열에 초기화
        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Character.getNumericValue(input.charAt(j-1));
            }
        }
        bfs();
    }


    public static void bfs() {

        queue.add(new Location(1, 1));

        // 추가한 노드 방문처리
        isVisit[1][1] = 1;

        while (!queue.isEmpty()) {
            // 큐에서 노드를 poll
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            // 상하좌우 4방향 노드에 대한 작업
            for (int i = 0; i < 4; i++) {
                int x = row + dir[i][0];
                int y = col + dir[i][1];

                if (checkLocation(x, y)) {
                    queue.add(new Location(x, y));
                    isVisit[x][y] = isVisit[row][col] + 1;
                }
            }
        }
        System.out.println(isVisit[n][m]);
    }


    public static boolean checkLocation(int row, int col) {
        // 노드가 범위 밖인 경우
        if (row < 1 || row > n || col < 1 || col > m) return false;
        // 이미 방문한 노드인 경우
        if (isVisit[row][col] != 0 || arr[row][col] == 0) return false;
        return true;
    }
}