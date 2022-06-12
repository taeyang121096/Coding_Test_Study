import java.util.*;
class Solution {

    static List<Map<String,Integer>> count = new ArrayList<>();

    static void combi(Map<String,Integer> cnt, char[] str, int course, StringBuilder sb,int level,int start){

        if(level == course){
            char[] tmp = sb.toString().toCharArray();
            Arrays.sort(tmp);
            cnt.put(String.valueOf(tmp),cnt.getOrDefault(String.valueOf(tmp),0)+1);
            return;
        }
        for(int i = start;i<str.length;i++){
            combi(cnt,str,course, sb.append(str[i]),level+1,i+1);
            sb.setLength(sb.length()-1);
        }
    }

    static Map<String,Integer> counting(Map<String,Integer> cnt, int course,String order){
        combi(cnt,order.toCharArray(),course,new StringBuilder(),0,0);
        return cnt;
    }

    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();

        for(int i = 0;i<course.length;i++){

            Map<String,Integer> cnt = new HashMap<String,Integer>();

            for(String order : orders){
                cnt = counting(cnt, course[i],order);
            }
            count.add(cnt);
        }

        for(int i = 0;i<count.size();i++){
            Map<String,Integer> cnt = count.get(i);
            int max = 2;
            List<String> tmp = new ArrayList<>();
            for(String key : cnt.keySet()){
                if(max < cnt.get(key)){
                    max = cnt.get(key);
                    tmp.clear();
                    tmp.add(key);
                }else if(max == cnt.get(key)){
                    tmp.add(key);
                }
            }
            ans.addAll(tmp);
        }
        Collections.sort(ans);

        return ans.stream().toArray(String[]::new);
    }
}