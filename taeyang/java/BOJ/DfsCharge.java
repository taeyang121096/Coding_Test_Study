package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;

public class DfsCharge {
    static boolean[] check;
    static int[] tmp;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static int idx = 1;
    static boolean flag = true;
    static void dfs(int x){
        if(check[x])
            return;
        check[x] = true;
        Set<Integer> set = new HashSet<>();
        for(int val : map.get(x)){
            if(check[val])
                continue;
            set.add(val);
        }
        if(set.size() == 0)return;
        if(set.contains(tmp[idx])){
            dfs(tmp[idx++]);
        }else{
            flag = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        check = new boolean[n + 1];
        tmp = new int[n];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if (map.containsKey(f))
                map.get(f).add(s);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(s);
                map.put(f, list);
            }


            if (map.containsKey(s))
                map.get(s).add(f);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(f);
                map.put(s, list);
            }
        }
        int index =0;
        for(String str : br.readLine().split(" ")){
            tmp[index++] = Integer.parseInt(str);
        }
        if(tmp[0] != 1)
            flag = false;
        dfs(1);
        if(flag)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
