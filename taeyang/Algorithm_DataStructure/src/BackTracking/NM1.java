package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NM1 {
    static boolean[] check;
    static void permu(int[] tmp,StringBuilder sb, int level,int m){
        if(level == m){
            System.out.println(sb.toString());
            return;
        }
//        if 조건으로 백트래킹 을 한다.
        for(int i = 0;i<tmp.length;i++){
            if(check[i])
                continue;
            check[i] = true;
            if(level == 0){
                permu(tmp,sb.append(tmp[i]),level+1,m);
                sb.setLength(sb.length()-1);
            }else{
                permu(tmp,sb.append(" "+tmp[i]),level+1,m);
                sb.setLength(sb.length()-2);
            }
            check[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] tmp = new int[n];
        check= new boolean[n];

        for(int i = 0;i<n;i++) tmp[i] = i + 1;

        permu(tmp,new StringBuilder(),0,m);




    }
}
