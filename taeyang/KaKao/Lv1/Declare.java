import java.util.*;
public class Declare {

    class Solution {
        /*
            유저는 한 번에 한명 신고
            신고 횟수 제한 x, 다른 유저 계속 신고 o
            동일한 유저 신고 횟수 1로 통일
            k 번 이상 신고 된 유저 정지
            신고 내용 취합 후 정지, 정지 메일 발송(신고한 유저에게)

            id_list 2 ~ 1000
                1 ~ 10 -> 중복x, 소문자로 이루어짐
            report 1  ~ 200,000 20십만
                이용자 신고한 format
            k 1 ~ 200

            data structure : map, list
            1. key 별로 list를 갖는다 -> key(신고자) : list(신고자들) 초기화
            2. id_list에 맞게 cnt를 초기화
            3. 신고자들의 count 를 더해준다.
            4. id_list 순서에 맞게 key를 검색해서 list의 값들이 k를 넘는지 확인한다.


        */
        public int[] solution(String[] id_list, String[] report, int k) {
//         return 초기화
            int[] answer = new int[id_list.length];
//         선언
            Map<String,List<String>> map = new HashMap<>();
            Map<String,Integer> count = new HashMap<>();
//         초기화
            for(String id : id_list){
                map.put(id,new ArrayList<String>());
                count.put(id,0);
            }
//      3.   로직
            for(String rep : report){
                String[] tmp = rep.split(" ");
                if(!map.get(tmp[0]).contains(tmp[1])){
                    map.get(tmp[0]).add(tmp[1]);
                    count.put(tmp[1],count.get(tmp[1])+1);
                }
            }
//      4. 로직
            for(int i = 0;i<id_list.length;i++){
                int cnt = 0;
                for(String declare : map.get(id_list[i])){
                    if(count.get(declare) >= k)
                        cnt++;
                }
                answer[i] = cnt;
            }


            return answer;
        }
    }
}
