//import java.util.*;
//class Solution {
//    static int[] arr;
//    static int answer = 0;
//    static HashMap<String, Integer> map = new HashMap<>();
//    static List<String> list = new ArrayList<>();
//    static ArrayList<List<String>> candidateKeys = new ArrayList<>();
//    static boolean isOne(HashMap<String, Integer> map){
//        for(String key : map.keySet()){
//            if(map.get(key) >= 2){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    static public void put(int[] arr, String[][] relation){
//        // arr = {0, 1}, relation[][]
//        for(int i = 0; i < relation.length; i++){ //
//            String str = ""; //
//            for(int j = 0; j < arr.length; j++){ // arr[0] arr[1]
//                str += relation[i][arr[j]]; // relation[0][0] + relation[0][1]
//            }
//            if(!map.containsKey(str)){
//                map.put(str, 1);
//            } else {
//                map.put(str, map.get(str) + 1);
//            }
//        }
//    }
//
//    static public void find(String[][] relation, int N, int M, int select, int idx){ // 4 1 0 1
//        // 종료 조건
//        if(M == select){
//            put(arr, relation);
//            if(isOne(map)){
//                String tmp = "";
//                for(int i = 0; i < arr.length; i++){
//                    tmp += String.valueOf(arr[i]);
//                }
//                list.add(tmp);
//            }
//            map.clear();
//            return;
//        }
//
//        if (idx >= N) {
//            return;
//        }
//
//        // 실행 조건
//        arr[select] = idx; // arr[0] = 1
//        find(relation, N, M, select + 1, idx + 1);
//
//        // 선택이 되지 않는 경우
//        find(relation, N, M, select, idx + 1);
//    }
//
//    public int solution(String[][] relation) {
//        // 튜플을 유일하게 식별할수 있는 속성, 속성의 집합 중 유일성 최소성 만족
//        for(int i = 1; i <= relation[0].length; i++){
//            arr = new int[i];
//            find(relation, relation[0].length, i, 0, 0); // find(4, 1, 0, 1)
//        }
//
//        for(int i = 0; i < list.size(); i++){
//            List<String> cKey = Arrays.asList(list.get(i).split(""));
//            // 0 01
//            boolean flag = true;
//            for(int j = 0; j < candidateKeys.size(); j++){
//                if(cKey.containsAll(candidateKeys.get(j))){
//                    flag = false;
//                    break;
//                }
//            }
//
//            if(flag){
//                candidateKeys.add(cKey);
//            }
//        }
//
//
//        return candidateKeys.size();
//    }
//}