import java.util.*;
import java.io.*;
public class Cicyle {
    static List<Integer>[] list = new ArrayList[4];
    static boolean[] check;

    static void bfs(int index, int rotate){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{index,rotate});

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(check[tmp[0]])
                continue;
            check[tmp[0]] = true;

            if(tmp[0] -1 >= 0){
                int[] cmd = new int[2];
                if(comp(tmp[0],tmp[0]-1,-1)){
                    cmd[0] = tmp[0]-1;
                    cmd[1] = -tmp[1];
                    q.offer(cmd);
                }
            }
            if(tmp[0]+1 < 4){
                int[] cmd = new int[2];
                if(comp(tmp[0],tmp[0]+1,1)){
                    cmd[0] = tmp[0]+1;
                    cmd[1] = -tmp[1];
                    q.offer(cmd);
                }
            }
            rot(tmp[0],tmp[1]);
        }
    }

    static void rot(int index, int cmd){
        if(cmd == 1){
            int tmp = list[index].get(7);
            list[index].remove(7);
            list[index].add(0,tmp);
        }
        else{
            int tmp = list[index].get(0);
            list[index].remove(0);
            list[index].add(tmp);
        }
    }

    static boolean comp(int first, int second, int cate){
        if(cate == -1){
            if(list[first].get(6) == list[second].get(2))
                return false;
            else
                return true;
        }
        else{
            if(list[first].get(2) == list[second].get(6))
                return false;
            else
                return true;
        }
    }

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0;i<4;i++){
            list[i] = new ArrayList<>();
            String[] str = br.readLine().split("");
            for(int j =0;j<8;j++)
                list[i].add(Integer.valueOf(str[j]));

        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0;i<k;i++){
            st = new StringTokenizer(br.readLine()," ");
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direct = Integer.parseInt(st.nextToken());
            check = new boolean[4];
            bfs(index,direct);

        }
        int count = 1;
        int ans = 0;

        for(int i = 0;i<4;i++){
            if(list[i].get(0) == 1)
                ans += count;
            count *= 2;
        }
        System.out.println(ans);


    }
}
