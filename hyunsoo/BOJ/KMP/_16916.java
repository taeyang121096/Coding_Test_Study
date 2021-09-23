package BOJ.KMP;
import java.util.*;
public class _16916 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String substr = sc.nextLine();

        int[] table = new int[str.length()];

        int j=0;
        int same=0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==substr.charAt(j)) 
        }

    }
}
