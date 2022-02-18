import java.util.*;

public class SheepWolf_KaKao {


    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[] Info;
    static int answer;

    static void dfs(int idx, int s, int w, List<Integer> next) {
        if (Info[idx] == 0)
            s++;
        else
            w++;
        if (w >= s) return;
        answer = Math.max(s, answer);
        List<Integer> ls = new ArrayList<>();
        ls.addAll(next);
        ls.remove(Integer.valueOf(idx));

        if (map.get(idx).size() != 0) {
            for (int child : map.get(idx))
                ls.add(child);
        }

        for (int id : ls) {
            dfs(id, s, w, ls);
        }
    }

    public int solution(int[] info, int[][] edges) {
        answer = 0;
        Info = info;

        for (int i = 0; i < info.length; i++)
            map.put(i, new ArrayList<>());

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0, 0, 0, list);


        return answer;
    }
}

