package School;
import java.util.*;
public class Roma {
    static LinkedHashMap<Integer,String> map = new LinkedHashMap<>();
    static HashMap<Integer,Integer> ans = new HashMap<>();
    public static void main(String[]args){

        map.put(1000,"M");
        map.put(900,"CM");
        map.put(500,"D");
        map.put(400,"CD");
        map.put(100,"C");
        map.put(90,"XC");
        map.put(50,"L");
        map.put(40,"XL");
        map.put(10,"X");
        map.put(9,"IX");
        map.put(5,"V");
        map.put(4,"IV");
        map.put(1,"I");



        for(int i = 1;i<5000;i++){
            String answer = "";
            int tmp = i;
            for(int key : map.keySet()){
                if(tmp ==0)
                    break;
                int val = tmp/key;
                if(val!=0)
                    answer += map.get(key).repeat(val);
                tmp %= key;
            }
            ans.put(answer.length(),ans.getOrDefault(answer.length(),0)+1);
        }

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        System.out.println(ans.getOrDefault(n,0));




    }
}
