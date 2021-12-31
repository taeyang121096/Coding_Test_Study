package basic;
import java.sql.Array;
import java.util.*;
import java.io.*;

public class BfsCharge {

    static HashMap<Integer,List<Integer>> map = new HashMap<>();

    static boolean[] check;
    static int[] tmp;
    static boolean bfs(){
        if(tmp[0] != 1)
            return false;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        check[1] = true;
        int index = 1;
        Set<Integer> set = new HashSet<>();
        while(!q.isEmpty()){
            int k = q.poll();
            for(int val : map.get(k)){
                if(check[val])
                    continue;
                check[val] = true;
                set.add(val);
            }
            int size = set.size();
            for(int i =0;i<size;i++){
                if(set.contains(tmp[index])){
                    set.remove(tmp[index]);
                    q.offer(tmp[index++]);
                }else{
                    return false;
                }
            }
        }
        return true;

    }
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        check = new boolean[n+1];
        tmp = new int[n];

        for(int i = 0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if(map.containsKey(f))
                map.get(f).add(s);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(s);
                map.put(f,list);
            }


            if(map.containsKey(s))
                map.get(s).add(f);
            else{
                List<Integer> list = new ArrayList<>();
                list.add(f);
                map.put(s,list);
            }
        }
        int index = 0;
        for(String str : br.readLine().split(" ")){
            tmp[index++] = Integer.parseInt(str);
        }
        if(bfs())
            System.out.println(1);
        else
            System.out.println(0);

    }

}
