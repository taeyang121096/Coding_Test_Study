import java.util.*;

class Solution {

    Set<String> set = new HashSet<>();
    Map<String,Integer>map = new HashMap<>();
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        for(String gem : gems){
            set.add(gem);
        }

        int min = Integer.MAX_VALUE;
        int start =0,end=0;

        for(int i = 0;i<gems.length;i++){
            if(!map.containsKey(gems[i])){
                map.put(gems[i],1);
            }
            else{
                map.put(gems[i],map.get(gems[i])+1);
            }
            end++;
            if(map.size() == set.size()){

                while(start < end){
                    if(map.get(gems[start]) > 1){
                        map.put(gems[start],map.get(gems[start])-1);
                        start++;
                    }
                    else if(min > end - start){

                        min = end - start;
                        answer[0] = start +1;
                        answer[1] = end;
                        break;
                    }
                    else
                        break;

                }
            }



        }


        return answer;
    }
}