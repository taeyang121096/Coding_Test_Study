import java.util.*;
public class Bestalb_Pro {
    class Solution {

        //     1. 속한 노래가 많이 재생된 장르 먼저 수록
//     2. 장르 내에서 많이 재생된 노래 먼저 수록
//     3. 장르 내에서 재생 횟수가 같은 노래 중 고유 번호가 낮은 노래 먼저 수록
//     4. 장르에 속한 곡이 하나면 하나만 선택
//     2개씩 모음
//     1. 노래 제목 '누적 합'
//     2. 제목 리스트<idx,play>
        public int[] solution(String[] genres, int[] plays) {

            int len = plays.length;

            List<Integer> ans = new ArrayList<>();
            Map<String,Integer> map = new HashMap<>();
            Map<String,List<int[]>> alb = new HashMap<>();

            for(int i = 0;i<len;i++){
                map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
                if(alb.containsKey(genres[i])){
                    alb.get(genres[i]).add(new int[]{i,plays[i]});
                }else{
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i,plays[i]});
                    alb.put(genres[i],list);
                }
            }

            List<Map.Entry<String,Integer>> key = new ArrayList<>(map.entrySet());
            Collections.sort(key,new Comparator<Map.Entry<String,Integer>>(){
                @Override
                public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2){
                    return o1.getValue() > o2.getValue() ? -1:1;
                }
            });
            for(Map.Entry<String,Integer> m : key){
                List<int[]> ls = alb.get(m.getKey());
                Collections.sort(ls,new Comparator<int[]>(){
                    @Override
                    public int compare(int[]o1,int[]o2){
                        if(o1[1] == o2[1]){
                            return o1[0]>o2[0] ? 1:-1;
                        }
                        return o1[1] > o2[1] ? -1:1;
                    }
                });
                for(int i = 0;i<ls.size();i++){
                    if(i>=2)
                        break;
                    ans.add(ls.get(i)[0]);
                }

            }

            int[] answer = new int[ans.size()];
            int idx = 0;
            for(int i : ans)
                answer[idx++] = i;


            return answer;
        }
    }
}
