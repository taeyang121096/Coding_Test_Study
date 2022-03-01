package Programmers;
import java.util.*;

public class SheepAndWolf {
    static boolean[] check;
    static Stack<Integer> stack = new Stack<>(); // 만약 0 이면 스택에 넣고, 1이면 스택에서 0을 빼준다.
    static int[][] map;
    //0,0,1,1,1,0,1,0,1,0,1,1
    static void dfs(){
        // 종료 조건
        if(stack.isEmpty()){
            return;
        }

    }
    public static void main(String[] args) {
        int[] info = {0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1};
        int[][] edges = {{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}};

        check = new boolean[info.length]; // 방문 여부 체크 ??
        map = new int[edges.length + 1][edges.length + 1];

        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0]; // 0
            int y = edges[i][1]; // 1
            map[x][y] = map[y][x] = 1;
        }

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
