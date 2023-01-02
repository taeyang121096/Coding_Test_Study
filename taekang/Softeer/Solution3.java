package Softeer;

import java.io.*;
import java.util.*;

public class Solution3 {
    /**
     * 찾은 반례 -> DDDDDDAD -> 문제점 -> 코드 진행 방식으로 가면 연속된것이 최대 3개로 잘리는데, 이가 계속되다가 a만
     * -> 개선방향은 어떻게 되어야 하는가 ?
     * DAAADCACD -> AAADDDCAC, 6+10 -> AAAADDDCC, 8 -> 24
     * DAAADCACD -> DDDAAACAC, 14+6 + 2 -> 22
     * DAAAADCACD -> 16+8+2
     * AAAADDDCAC -> 16+6 -> 8 30
     */
    public static char[] alp = {'A', 'B', 'C', 'D'};
    public static char[] choice;
    public static boolean[] visited;
    public static String str;
    public static int min = Integer.MAX_VALUE;

    public static void dfs(int idx) {
        if (idx == 4) {
            min = Math.min(min, getMoveCnt(choice));
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (!visited[i]) {
                visited[i] = true;
                choice[idx] = alp[i];
                dfs(idx + 1);
                visited[i] = false;
            }
        }
    }

    private static int getMoveCnt(char[] choice) {
        int answer = 0;
        HashMap<Character, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                Deque<Integer> q = new ArrayDeque<>();
                q.offer(i);
                map.put(c, q);
            } else {
                Deque<Integer> ints = map.get(c);
                ints.offer(i);
                map.put(c, ints);
            }
        }

        // D -> 0 3 || A -> 1 2 5 -> 2 5 || C -> 4 6
        int start = 0; //
        int end = 0; //
        for (int i = 0; i < choice.length; i++) { // A B C D
            Deque<Integer> queue = new ArrayDeque<>();
            if (map.containsKey(choice[i])) {
                queue = map.get(choice[i]);
            }
            while (!queue.isEmpty() && queue.size() != 1) {
                int a = queue.poll(); // 1
                int b = queue.poll(); // 2
                // 만약 start 보다 a 가 작으면
                if (a + 1 == b) {
                    // 제 코드가 발생하는 부분
                    if (queue.size() > 0) {
//                        int c = queue.poll(); // 5
//                        if (b >= start && b < end) {
//                            b++; // 3
//                        }
//                        if (b + 1 != c) {
//                            int mid = (b + c) / 2; // mid 4
//                            start = mid; // 4
//                            end = c; // 5
//                            answer += (c - mid) * 2; //
//                            queue.offerFirst(c); // 5
//                            queue.offerFirst(mid); // 4
//                        }
                        // -> 코드 변경
                        if (b >= start && b < end) {
                            b++; // 3
                        }
                        queue.offerFirst(b);
                    }
                } else {
                    int next = a + 1; // 2 5 -> 3
                    if (a >= start && a < end) {
                        a++;
                    }
                    if (a + 1 != b) { // 5 6
                        start = next; // 3
                        end = b; // 5
                        answer += (b - start) * 2;
                        // 여기서 넣는 방법이 오류가 있을 수도있음, 비어있는 큐라면 0,1이 들어가겠지만 비어있지 않다면 5 ,0,1 같이 들어갈수 있어서
                        queue.offerFirst(next); // 1
                        queue.offerFirst(a); // 0
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        //  ArrayList 나 배열을 선언해서 옮겨지는 것들의 범위에 해당하는 값들을 ++해준다
        // 만약 자료구조를 다른걸 사용하겠다 -> int[] 나 ArrayList 를 value 로 사용해서, 범위에 해당하는 애들 값을 ++해준다

        choice = new char[4];
        visited = new boolean[4];
        // 조합 24개
        // A -> 3
        // B
        // D -> 2
        // C -> 2
//        str = "DAADCAC";

//        str = "DAAD";
//        str = "DAAADDD"; // -> 반례
//        str = "DAAADDDBCCCBBB"; // -> 반례 왼쪽으로 몰지, 오른쪽 으로 몰지.. 둘중 하난데 왼쪽으로만 몬다고 생각했기 때문에 반례가 발생
//        str = "DDDDDDAD"; // -> 코드 진행 방식으로 가면 연속된것이 최대 3개로 잘리는데, 이가 계속되다가 a만
//        str = "DDDDAD";
//        str = "DDDDDAD";
//        str = "DDDAD";
        str = "ABBABBCABC";
        dfs(0);
        //  A -> 2 3 5 || C ->  || D -> 0 1, N -> 10만
        // start end 다음에 진행 할 것들이 만약 start end 범위내에 있다면 값을 더해주어야 한다, 자리를 옮겼기 때문
        System.out.println(min);
    }
}
