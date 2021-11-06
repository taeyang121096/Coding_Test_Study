package basic;
import java.util.*;
public class Alphabet {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        String s = sc.nextLine();
        int start = 'a';
        int end = 'z';
        for(int i =start;i<=end;i++){
            map.put((char)i,0);
        }
        for(char c: s.toCharArray()){
            map.put(c,map.get(c)+1);
        }
        for(char key : map.keySet())
            System.out.print(map.get(key)+" ");
    }
}
