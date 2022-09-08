import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {
    static int cnt = 0;
    public static void hanoi(int from,int tmp,int to,int num,StringBuilder sb){
        if(num == 0)
            return;
        hanoi(from,to,tmp,num-1,sb);
        cnt++;
        sb.append(from+" "+to+"\n");
        hanoi(tmp,from,to,num-1,sb);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        hanoi(1,2,3,num,sb);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
