import java.util.*;
public class SubString {

    static int[] pi;
    static void makePattern(String p){
        int j = 0;
        for(int i = 1;i<p.length();i++){
            while(j>0 && p.charAt(i) != p.charAt(j))
                j = pi[j-1];
            if(p.charAt(i) == p.charAt(j))
                pi[i] = ++j;
        }
    }

    static boolean count(String s,String p){

        int j = 0;
        for(int i = 0;i<s.length();i++){
            while(j>0 && s.charAt(i) != p.charAt(j))
                j = pi[j-1];
            if(s.charAt(i) == p.charAt(j)){
                if(j == p.length()-1){
                    return true;
                }
                else
                    j++;
            }

        }
        return false;
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        String s = sc.next();
        String p = sc.next();
        pi = new int[p.length()];
        makePattern(p);
        if(count(s,p))
            System.out.println(1);
        else
            System.out.println(0);




    }
}
