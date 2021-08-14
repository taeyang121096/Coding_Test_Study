/*2021 KAKAO BLIND RECRUITMENT 순위 검색*/


/*
풀이 1

brute를 이용한 search를 시행했을 때 정답은 전부 맞았지만
효용성에서 전부 실패가 나왔다.

*/

import java.util.*;
class Solution {
    
    class Person{
        String language;
        String part;
        String career;
        String food;
        int score;
        
        public Person(String language, String part, String career, String food, int score){
            this.language = language;
            this.part = part;
            this.career = career;
            this.food = food;
            this.score = score;
        }     
    }   
    public int[] solution(String[] info, String[] query) {
        
        int[] answer = new int[query.length];
        ArrayList<Person> people = new ArrayList<>();
        
        for(int i=0; i<info.length; i++){
            String[] data = info[i].split(" ");
            people.add(new Person(data[0],data[1],data[2],data[3],Integer.parseInt(data[4])));
        }
           
        for(int i=0; i<query.length; i++){
            String[] que = query[i].split(" and | ");
            ArrayList<Person> tmp = new ArrayList<>();
            tmp.addAll(people);
                        
            int j=0;
            while(j<tmp.size()){
                if(tmp.get(j).score < Integer.parseInt(que[4])){
                    tmp.remove(j);
                    continue;
                }
                if(!tmp.get(j).language.equals(que[0]) && !que[0].equals("-")){
                    tmp.remove(j);
                    continue;
                }
                if(!tmp.get(j).part.equals(que[1]) && !que[1].equals("-")){
                    tmp.remove(j);
                    continue;
                }
                if(!tmp.get(j).career.equals(que[2]) && !que[2].equals("-")){
                    tmp.remove(j);
                    continue;
                }
                if(!tmp.get(j).food.equals(que[3]) && !que[3].equals("-")){
                    tmp.remove(j);
                    continue;
                }
                j++;
            }
            answer[i]=tmp.size();
        }          
        return answer;
    }
}



/*
풀이 2

블로그 글을 확인하며 참고 했다 
출처 : https://velog.io/@courage331/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4Java-%EC%88%9C%EC%9C%84%EA%B2%80%EC%83%89
*/


import java.util.*;
class Solution {   
    
    Map<String, ArrayList<Integer>> map = new HashMap();
    
    public void Key(String info){
        String[] tmp = info.split(" ");
        String [] language = {tmp[0],"-"};
        String [] part = {tmp[1],"-"}; 
        String [] career ={tmp[2],"-"};
        String [] food = {tmp[3],"-"};
        int score = Integer.parseInt(tmp[4]);
        
         for(int i=0; i<2;i++){
            for(int j=0; j<2;j++){
                for(int l=0; l<2;l++){
                    for(int m=0; m<2; m++){
                        String key = language[i]+part[j]+career[l]+food[m];
                        if(map.containsKey(key)){
                            ArrayList<Integer> arr = map.get(key);
                            arr.add(score);
                            map.put(key,arr);
                        }else{
                            ArrayList<Integer> arr = new ArrayList();
                            arr.add(score);
                            map.put(key,arr);
                        }
                        
                    }
                }
            }
        }      
    }  
    public int search(ArrayList<Integer> arr, int score){
        
        int mid=0;
        int end = arr.size();
        int start = 0;

        while (end > start) 
        {
            mid = (start + end) / 2; 
            if (arr.get(mid) >= score) 	end = mid;
            else start = mid + 1; 
        }
        
        return arr.size()-start;
     
    }
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0; i<info.length; i++){
            Key(info[i]);
        }
        
        ArrayList<String> savekey = new ArrayList();
        for(Map.Entry<String,ArrayList<Integer>> entry : map.entrySet()){
            if(savekey.contains(entry.getKey())){
                continue;
            }else{
                savekey.add(entry.getKey());
                Collections.sort(entry.getValue());
            }        
        }
        
        for(int i=0; i<query.length; i++){
            String[] tmp = query[i].split(" and | ");
            String key = tmp[0]+tmp[1]+tmp[2]+tmp[3];
            
            if(!map.containsKey(key)){
                answer[i]=0;
                continue;
            }
            ArrayList<Integer> arr = map.get(key);       
            answer[i]=search(arr, Integer.parseInt(tmp[4]));
        }
 
        return answer;
    }
}