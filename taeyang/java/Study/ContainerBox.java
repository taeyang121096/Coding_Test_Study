import java.util.*;
import java.io.*;

public class ContainerBox {

    //    col, row
    static int max_r;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<int[]> list = new ArrayList<>();
        max_r = 0;

        for (int i = 0; i < n; i++) {
            int[] tmp = new int[2];
            st = new StringTokenizer(br.readLine(), " ");
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            max_r = Math.max(max_r, tmp[1]);
            list.add(tmp);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });


        Deque<int[]> l = new ArrayDeque<>();
        Deque<int[]> r = new ArrayDeque<>();
        int nr = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] > nr) {
                l.push(list.get(i));
                nr = list.get(i)[1];
            }
        }
        nr = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (list.get(i)[1] > nr) {
                r.push(list.get(i));
                nr = list.get(i)[1];
            }
        }
        count += (r.peek()[1] - l.peek()[1] + 1) * max_r;
        int nc = l.pop()[0];
        while (!l.isEmpty()) {
            int c = l.peek()[0];
            int height = l.peek()[1];
            count += (nc - c) * height;
            nc = c;
            l.pop();
        }

        int rc = r.pop()[0]+1;
        while (!r.isEmpty()) {
            int c = r.peek()[0]+1;
            int height = r.peek()[1];
            count += (c - rc) * height;
            rc = c;
            r.pop();
        }


        System.out.println(count);
    }

}
