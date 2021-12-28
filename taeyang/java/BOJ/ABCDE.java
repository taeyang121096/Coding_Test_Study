package basic;


import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
public class ABCDE {
    static List[] list;
    static boolean flag = false;
    static boolean[] visit;
    static void check(int i,int level){
        if(flag)
            return;
        if(level == 4){
            flag = true;
            return;
        }
        visit[i] = true;
        for(int j = 0;j<list[i].size();j++){
            if(!visit[(int) list[i].get(j)])
                check((int)list[i].get(j),level+1);
        }
        visit[i] = false;
    }
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        visit = new boolean[n];
        for(int i = 0;i<n;i++)
            list[i] = new ArrayList<Integer>();

        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            list[f].add(s);
            list[s].add(f);
        }

        for(int i = 0;i<n;i++){
            check(i,0);
            if(flag)
                break;
        }
        if(flag)
            System.out.println(1);
        else
            System.out.println(0);


    }


}
