package Programmers;

class GoodRec_Prog {
    
    static long gcd(long a, long b){
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        
        long tmp = 0;
        
        while(min!=0){
            tmp = max % min;
            max = min;
            min = tmp;
        }
        
        return max;
    }
    
    public long solution(int w, int h) {
        long answer = 0;
        
        long r = (long)w;
        long c = (long)h;
        
        long res = gcd(r, c);
        
        answer = r*c-(r+c-res);
        
        return answer;
    }
}
