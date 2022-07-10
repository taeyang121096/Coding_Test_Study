//import java.util.*;
//class Solution {
//    public int[] solution(String[] id_list, String[] report, int k) {
//        Map<String, ArrayList<String>> map = new HashMap<>(); // 중복 제거는 되어있는 상태
//        Map<String, Integer> reportCnt = new HashMap<>();
//        List<String> reportUser = new ArrayList<>();
//        int[] answer = new int[id_list.length];
//        // 각 유저는 한 번에 한 명의 유저 신고, 신고 횟수 제한
//        // 한 유저를 여러번 신고 가능, 동일한 유저 신고 1회
//
//        // k 번 이상 신고된 유저 정지, 정지 사일 메일 발송,
//        // 신고 내용 모두 취합, 마지막에 한꺼번에 정지시키고 메일 받음
//
//        // 먼저 유저 별로 유저 신고한 ID 를 정리, HashSet을 이용해서 넣음,
//        // 그다음 신고한 횟수가 1 2 0 2 이렇게 나오겠지 .. ? k 랑 같은 애들을 check neo나 frodo 면 정답 해쉬에 넣는다
//        for(int i = 0; i < report.length; i++){
//            String[] str = report[i].split(" "); // muzi , frodo ...
//            ArrayList<String> list = new ArrayList<>();
//            if(!map.containsKey(str[0])){
//                list.add(str[1]);
//                map.put(str[0], list);
//            } else {
//                ArrayList<String> l = map.get(str[0]);
//                if(hasValue(l, str[1])){ // 가지고 있지 않다면 ?
//                    l.add(str[1]);
//                    map.put(str[0], l);
//                }
//            }
//        }
//
//        for(int i = 0; i < id_list.length; i++){
//            if(!map.containsKey(id_list[i])){
//                map.put(id_list[i], new ArrayList<>());
//            }
//        }
//
//        // , id_list에 있는 애들이 map 에 포함되면, 안되면
//        for(int i = 0; i < id_list.length; i++){
//            if(map.containsKey(id_list[i])){ // 만약 muzi 야
//                ArrayList<String> user = map.get(id_list[i]); // frodo, neo
//                if(user.size() != 0){ // 2잖아
//                    for(int j = 0; j < user.size(); j++){ // j = 0, 1
//                        if(!reportCnt.containsKey(user.get(j))){ // map.포함(frodeo) x
//                            reportCnt.put(user.get(j), 1); //
//                        } else {
//                            reportCnt.put(user.get(j), reportCnt.get(user.get(j)) + 1);
//                        }
//                    }
//                }
//            }
//        }
//
//        for(int i = 0; i < id_list.length; i++){
//            if(!reportCnt.containsKey(id_list[i])){
//                reportCnt.put(id_list[i], 0);
//            }
//        }
//
//        for(String key : reportCnt.keySet()){
//            if(reportCnt.get(key) >= k ){
//                reportUser.add(key);
//            }
//        }
//
//        for(int i = 0; i < id_list.length; i++){ // muzi 일 때,
//            int cnt = 0;
//            ArrayList<String> z = map.get(id_list[i]); // frodo, neo
//            for(int j = 0; j < reportUser.size(); j++){
//                if(z.contains(reportUser.get(j))){
//                    cnt++;
//                }
//            }
//            answer[i] = cnt;
//        }
//
//        return answer;
//    }
//
//    public boolean hasValue(ArrayList<String> list, String str){
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).equals(str))
//                return false;
//        }
//        return true;
//    }
//}