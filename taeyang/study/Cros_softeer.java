import java.util.*;
import java.io.*;

public class Cros_softeer {


    // A 상 - 하
// B 우 - 좌
// C 하 - 상
// D 좌 - 우
//  오른쪽에 차량이 있으면 대기 1초에 한대씩 움직일 수 있다
//  n대의의 차량이 교차로 통과
//  t 초 때 w 위치에 진입
//  A -> D , B -> A, D -> C, C -> B

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, List<Character>> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        int first = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int time = Integer.parseInt(st.nextToken());
            if (i == 0)
                first = time;
            char c = st.nextToken().charAt(0);
            if (map.containsKey(time)) {
                map.get(time).add(c);
            } else {
                List<Character> list = new ArrayList<>();
                list.add(c);
                map.put(time, list);
            }

        }
        int time = first;
        // int time = first;
        // Deque<Character> q = new ArrayDeque<>();
        // for(char c : map.get(first)){
        //         q.offer(c);
        // }
        // while(!q.isEmpty()){
        //     if(time == -1){

        //     }
        // }

        for (int key : map.keySet()) {
            if (time == -1) {
                for (int i = 0; i < map.get(key).size(); i++) {
                    System.out.println(-1);
                }
                continue;
            }
            if (time != -1 && key > time)
                time = key;
            Deque<Character> q = new ArrayDeque<>();
            for (char c : map.get(key)) {
                q.offer(c);
            }
            int size = q.size();
            int cnt = 0;
            while (!q.isEmpty()) {
                if (cnt != 0 && q.size() == size) {
                    for (int i = 0; i < q.size(); i++) {
                        System.out.println(-1);
                    }
                    time = -1;
                    break;
                }
                List<Character> list = new ArrayList<>();
                for (char c : q) {
                    if (c == 'A') {
                        if (q.contains('D'))
                            continue;
                        list.add(c);

                    } else if (c == 'B') {
                        if (q.contains('A'))
                            continue;
                        list.add(c);
                    } else if (c == 'C') {
                        if (q.contains('B'))
                            continue;
                        list.add(c);
                    } else if (c == 'D') {
                        if (q.contains('C'))
                            continue;
                        list.add(c);
                    }
                }
                for (char c : list) {
                    q.remove(c);
                    System.out.println(time);
                }
                time++;
                cnt++;

            }


        }


    }
}

