package BOJ;

import java.util.*;
import java.io.*;

public class SpeakCenter_BOJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        int num = Integer.parseInt(br.readLine());
        maxPq.offer(num);
        sb.append(maxPq.peek()).append("\n");
        for (int i = 1; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (maxPq.size() != minPq.size()) {
                minPq.offer(num);
            } else {
                maxPq.offer(num);
            }
            if (minPq.peek() < maxPq.peek()) {
                minPq.offer(maxPq.poll());
                maxPq.offer(minPq.poll());
            }

            sb.append(maxPq.peek()).append("\n");
        }
        System.out.print(sb);
    }
}
