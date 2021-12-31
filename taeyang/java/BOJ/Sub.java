package basic;
import java.util.*;
import java.io.*;
public class Sub {
    static int[] s = new int[21];
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[]args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0;i<m;i++){
            calc(br.readLine());
        }

        bw.flush();
        bw.close();

    }
    static void calc(String c) throws IOException {
        String[] cm = c.split(" ");
        String cmd = cm[0];
        int val = 0;
        if(cm.length>=2)
            val = Integer.parseInt(cm[1]);
        if(cmd.equals("add")){
            s[val] = 1;
        }
        else if(cmd.equals("remove")){
            s[val] = 0;
        }
        else if(cmd.equals("check")){
            bw.write(s[val]+"\n");
        }
        else if(cmd.equals("toggle")){
            if(s[val] == 1)
                s[val] = 0;
            else
                s[val] = 1;
        }
        else if(cmd.equals("all")){
            for(int i = 1;i<=20;i++)
                s[i] = 1;
        }
        else if(cmd.equals("empty")){
            s = new int[21];
        }
    }
}
