package basic;

import java.util.*;
public class TailArray {

    public static void main(String[]args){
        ArrayList<String>list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        for(int i = 0;i<str.length();i++){
            list.add(str.substring(i));
        }
        Collections.sort(list);
        for(String s : list)
            System.out.println(s);
    }
}
