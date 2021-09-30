import java.util.*;
public class ReduceNum {

    static List<String> list = new ArrayList<>();
    static List<Long> res = new ArrayList<>();
    static void make(int level,String tmp,int start){
        if(level == 0)
            list.add(tmp);
        for(int i = start;i<=9;i++){
            make(level-1,String.valueOf(i)+tmp,i+1);
        }
        
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1;i<=10;i++){
            make(i,"",0);
        }
        for(String i : list)
            res.add(Long.parseLong(i));
        Collections.sort(res);
        if(n >= res.size())
            System.out.println(-1);
        else
            System.out.println(res.get(n));
    }
}
