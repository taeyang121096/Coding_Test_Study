import java.util.*;
import java.io.*;

// 9 ~ 18
// n = 회의실 수
// m = 회의 수
// sonata 14 15 16, 10 11,
// 9 10    11 14    16 17
public class Confe_Hyun {


    static LinkedHashMap<String, boolean[]> map;
    static List<Integer> ls;

    static void check(String key) {
        boolean[] tmp = map.get(key);
        boolean flag = true;
        for (int i = 0; i <= 9; i++) {
            if (ls.size() % 2 == 0 && tmp[i] == false) {
                ls.add(i + 9);
                continue;
            }
            if (ls.size() % 2 == 0 && i + 1 <= 9 && tmp[i + 1] == false) {
                ls.add(i + 9);
                continue;
            }
            if (ls.size() % 2 == 1 && tmp[i] == true && i - 1 >= 0 && tmp[i - 1] == false) {
                ls.add(i + 9);
                continue;
            }

        }
        if (ls.size() % 2 != 0)
            ls.add(18);


    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list);
        map = new LinkedHashMap<>();

        for (String str : list)
            map.put(str, new boolean[10]);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s - 9; j <= e - 9; j++)
                map.get(key)[j] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            ls = new ArrayList<>();
            check(key);
            sb.append("Room " + key + ":" + "\n");
            if (ls.size() == 0)
                sb.append("Not available\n");
            else {
                sb.append(ls.size() / 2 + " " + "available:\n");
                for (int i = 0; i < ls.size(); i += 2) {
                    int s = i;
                    int e = i + 1;

                    if (ls.get(s) == 9)
                        sb.append("09");
                    else {
                        sb.append(ls.get(s));
                    }
                    sb.append("-" + ls.get(e) + "\n");
                }
            }
            sb.append("-----\n");
        }
        sb.setLength(sb.length() - 6);
        System.out.print(sb.toString());

    }
}

