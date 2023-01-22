class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int last_deli = deliveries.length - 1;
        int last_pick = pickups.length - 1;
        
        while(last_deli > -1 || last_pick > -1) {
            int last = -1;
            int truck = 0;
            while(last_pick > -1 && truck < cap){
                if(pickups[last_pick] > 0){
                    last = Math.max(last_pick, last);
                    if(pickups[last_pick] > (cap - truck)){
                        pickups[last_pick] -= cap - truck;
                        truck = cap;
                    }
                    else{
                        truck += pickups[last_pick];
                        last_pick--;
                    }
                }
                else{
                    last_pick--;
                }
            }
            truck = 0;
            while(last_deli > -1 && truck < cap){
                if(deliveries[last_deli] > 0){
                    last = Math.max(last_deli, last);
                    if(deliveries[last_deli] > (cap - truck)){
                        deliveries[last_deli] -= cap - truck;
                        truck = cap;
                    }
                    else{
                        truck += deliveries[last_deli];
                        last_deli--;
                    }
                }
                else{
                    last_deli--;
                }
            }
            answer += 2 * (last+1);
        }
        return answer;
    }
}