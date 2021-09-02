import java.util.*;
class Solution {
    class Stage implements Comparable<Stage>{
        int num;
        double rate;

        public Stage(int num, double rate){
            this.num = num;
            this.rate = rate;
        }
        @Override
        public int compareTo(Stage s){
            if(this.rate == s.rate){
                return this.num - s.num;
            }
            if(this.rate < s.rate)
                return 1;
            return -1;
        }

    }




    static List<Stage> list = new ArrayList<>();
    public int[] solution(int N, int[] stages) {

        for(int i = 1;i<=N;i++){
            int user = 0;
            int nclear = 0;
            for(int x : stages){
                if(x >= i)
                    user++;
                if(x==i)
                    nclear++;
            }
            if(nclear == 0){
                list.add(new Stage(i,0));
            }else{
                list.add(new Stage(i,(double)nclear/user));
            }
        }
        Collections.sort(list);
        int[] answer = new int[N];
        int count = 0;
        for(Stage s : list){
            answer[count++] = s.num;
        }

        return answer;
    }
}