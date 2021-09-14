import java.util.*;
class Solution {
    TreeMap<Double,ArrayList<Integer>> map = new TreeMap<>(Collections.reverseOrder());

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        for(int i = 1;i<=N;i++){
            int count = 0;
            int clear = 0;
            for(int x : stages){
                if(x > i)
                    count++;
                else if(x == i){
                    count++;
                    clear++;
                }
            }
            Double key;
            if(count == 0)
                key = 0.0;
            else
                key = (double)clear / (double)count;

            ArrayList<Integer> list;
            if(map.containsKey(key)){
                list = map.get(key);
            }
            else
                list = new ArrayList<Integer>();
            list.add(i);
            map.put(key,list);
        }
        int count = 0;
        for(Double s : map.keySet()){
            for(int key : map.get(s)){
                System.out.print(key+" ");
                answer[count++] = key;
            }
            System.out.println();
        }




        return answer;
    }
}