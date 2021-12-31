package basic;
import java.util.*;
public class ROT13 {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String ans = "";
        int s = 'a';
        int e = 'z';
        int S = 'A';
        int E = 'Z';
        for(char c : str.toCharArray()){
            if(c>= s && c<=e){
                c += 13;
                if(c >e){
                     c -= e;
                     c += s;
                     c -=1;
                     ans += c;
                }else{
                    ans += c;
                }
            }
            else if(c>= S && c<=E){
                c+=13;
                if(c >E){
                    c -= E;
                    c += S;
                    c -=1;
                    ans += c;
                }else{
                    ans += c;
                }
            }
            else
                ans += c;
        }
        System.out.println(ans);
    }
}
