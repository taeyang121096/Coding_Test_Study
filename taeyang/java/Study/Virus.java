import java.util.*;
public class Virus {
//    com = 1<= <=100,  1-> start
//    con = connect val
    static HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
    static boolean[] check;
    static int count = -1;
    static void conn(int s,int e){
        map.get(s).add(e);
    }
    
    static void find(int start){
        if(check[start])
            return;
        check[start] = true;
        count++;
        for(int key : map.get(start)){
            find(key);
        }
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int com = sc.nextInt();
        int con = sc.nextInt();
        check = new boolean[com+1];
        for(int i = 0;i<=com;i++)
            map.put(i,new ArrayList<Integer>());
        for(int i = 0;i<con;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            conn(start,end);
        }
        
        find(1);
        if(count == 0)
            System.out.println(count);
        else
            System.out.println(count);


    }
}
