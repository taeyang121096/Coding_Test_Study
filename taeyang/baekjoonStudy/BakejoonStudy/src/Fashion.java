import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Fashion {

    /**
     * 1. test case 100
     * 2. 0 ~ 30 n
     * 3. n -> name " " category -> 1
     * 4. 1 ~ 20 lower case -> not same name
     */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for(int i = 0;i<test;i++){
            int j = Integer.parseInt(br.readLine());
            Map<String, List<String>> map = new HashMap<>();
            for(int k = 0;k<j;k++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                String name = st.nextToken();
                String category = st.nextToken();
                if(map.containsKey(category)){
                    map.get(category).add(name);
                }else{
                    List<String > ls = new ArrayList<>();
                    ls.add(name);
                    map.put(category,ls);
                }
            }
            int sum= 1;

            for(String key : map.keySet()){
                sum *= map.get(key).size()+1;
            }

            System.out.println(sum-1);
        }
//        1. 음... 각 key 별 갯수를 세어준다 -> depth 1
//        2. 음... 카테고리를 기준으로 combination을 돌려준다?????
//        3. 카테고리 기준으로 combination 돌리면 되잖아???

    }
}
