import java.util.*;
import java.io.*;

public class Lupin_SOF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] < o2[1]) {
                    return 1;
                } else if (o1[1] > o2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{weight, val});
        }

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            if (w >= tmp[0]) {
                answer += tmp[0] * tmp[1];
                w -= tmp[0];
            } else {
                answer += w * tmp[1];
                break;
            }
        }
        System.out.println(answer);
    }
}
