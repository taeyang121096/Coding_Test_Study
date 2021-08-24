import java.util.*;
class Solution {
    static int ans = Integer.MAX_VALUE;
    public void minStr(String s,int num){
        StringBuffer sb = new StringBuffer();
        char[] tmp = s.toCharArray();
        
        String compar="";
        for(int i =0;i<num;i++){
            compar +=tmp[i];
        }
        int count = 1;
        int index=0;
        for(int i=num;i<tmp.length;i+=num){
            StringBuffer tm = new StringBuffer();
            
            if(i+num > tmp.length){
                index = i;
                break;
            }
                
            for(int j = i;j<i+num;j++){
                tm.append(tmp[j]);
            }
            
            
            if(compar.equals(tm.toString())){
                count++;
            }
            else{
                if(count >1){
                    sb.append(count);
                    sb.append(compar);
                    count = 1;
                    compar=tm.toString();
                }
                else{
                    sb.append(compar);
                    compar=tm.toString();
                }
            }
        }
        if(count >1){
            sb.append(count);
            sb.append(compar);
        }
        else{
            sb.append(compar);
        }
        
        if(index !=0){
            for(int i = index;i<tmp.length;i++)
                sb.append(tmp[i]);
        }
        
        ans = Math.min(ans,sb.toString().length());
         
    }
    
    
    public int solution(String s) {
        
        
        int len = s.length()/2;
        for(int i =1 ;i<=len;i++){
            minStr(s,i);
        }
        if(len == 0)
            ans = 1;
        
        
        return ans;
    }
}