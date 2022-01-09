import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Short_BOJ {

    static int[] height;
    static boolean[] check;
    static void ans(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<9;i++){
            if(check[i])
                list.add(height[i] );
        }
        Collections.sort(list);
        for(int i : list)
            System.out.println(i);

    }
    static void make(int level,int sum){
        if(level == 7){
            if(sum == 100){
                ans();
                System.exit(0);
            }
            return;
        }
        for(int i = 0;i<9;i++){
            if(check[i])
                continue;
            check[i] = true;
            make(level+1,sum+height[i]);
            check[i]=false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height = new int[9];
        check = new boolean[9];
        for(int i = 0;i<9;i++){
            height[i] = Integer.parseInt(br.readLine());
        }
        make(0,0);
    }
}
