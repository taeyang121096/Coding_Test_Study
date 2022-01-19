import java.util.*;
import java.io.*;

public class Ju_Hhyun {


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] tmp = new int[2];
            tmp[0] = Integer.parseInt(st.nextToken());
            tmp[1] = Integer.parseInt(st.nextToken());
            list.add(tmp);
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] f, int[] s) {
                if (f[1] == s[1]) {
                    return f[0] > s[0] ? -1 : 1;
                }
                return f[1] > s[1] ? -1 : 1;
            }
        });

        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (w == 0)
                break;
            int weight = list.get(i)[0];
            int cost = list.get(i)[1];

            if (w >= weight) {
                max += cost * weight;
                w -= weight;
            } else {
                max += cost * w;
                w = 0;
            }

        }
        System.out.print(max);

    }
}

