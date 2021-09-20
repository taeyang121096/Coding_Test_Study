import java.util.*;
public class FoodTime {

    class Solution {
        class Food{
            int index;
            int time;
            public Food(int index, int time){
                this.index = index;
                this.time = time;
            }
        }

        LinkedList<Food> list = new LinkedList<>();
        public int solution(int[] food_times, long k) {

            int cnt = food_times.length;
            for(int i = 0;i<cnt;i++)
                list.add(new Food(i+1,food_times[i]));
            Collections.sort(list,(f1,f2) -> f1.time - f2.time);
            int index = 0;
            int preT = 0;
            for(Food f : list){
                long dif = f.time - preT;
                if(dif > 0){
                    long spend = dif * (long)cnt;
                    if(spend <= k){
                        k -= spend;
                        preT = f.time;
                    }
                    else{
                        k = k %(long)cnt;
                        List<Food> tmp = list.subList(index,food_times.length);
                        Collections.sort(tmp,(f1,f2) -> f1.index - f2.index);
                        return tmp.get((int)k).index;
                    }
                }
                index++;
                cnt--;
            }





            return -1;
        }
    }
}
