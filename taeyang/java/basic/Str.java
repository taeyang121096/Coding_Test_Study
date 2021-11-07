package basic;
import java.util.*;
import java.io.*;
public class Str {

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] val = new int[4];
        int s = 'a';
        int e = 'z';
        int S = 'A';
        int E = 'Z';
        String str;
        for(int i = 0;i<100;i++){
            Arrays.fill(val,0);
            str = br.readLine();
            if(str == null)
                break;

            for(char c: str.toCharArray()){
                if(c>= s && c<= e){
                    val[0] += 1;
                }
                else if(c>= S && c <=E){
                    val[1] += 1;
                }
                else if(c ==' '){
                    val[3]+= 1;
                }
                else{
                    val[2] += 1;
                }
            }
            for(int j = 0;j<val.length;j++)
                System.out.print(val[j]+" ");
            System.out.println();
        }
    }
}
