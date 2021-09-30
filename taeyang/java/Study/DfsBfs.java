import java.util.*;

public class DfsBfs {

    static boolean check[];
    static TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

    static void dfs(int start){
        check[start] = true;
        System.out.print(start +" ");

        for(int i : map.get(start)){
            if(check[i])
                continue;
            dfs(i);
        }

    }

    static void bfs(int start){
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int index = queue.poll();
            if(check[index])
                continue;
            check[index] = true;
            System.out.print(index+" ");
            for(int i : map.get(index)){
                if(check[i])
                    continue;
                queue.offer(i);
            }
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        check = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            if (map.containsKey(start)) {
                map.get(start).add(end);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(end);
                map.put(start, set);
            }
            if (map.containsKey(end)) {
                map.get(end).add(start);
            } else {
                TreeSet<Integer> set = new TreeSet<>();
                set.add(start);
                map.put(end, set);
            }
        }



        dfs(v);
        System.out.println();
        Arrays.fill(check,false);
        bfs(v);

    }
}
