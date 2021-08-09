import java.util.*;

class Solution {
	static int order[][]={{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
	static char c[]= {'+','-','*'};
    public long solution(String expression) {
    	long answer=0;
        long temp;
        ArrayList<String> arr=new ArrayList<>();
		StringBuilder sb=new StringBuilder();
        
		for(int i=0;i<expression.length();i++) {
			char c=expression.charAt(i);
            
			if('0'<=c&&c<='9') sb.append(c);
			else {
				arr.add(sb.toString());
				arr.add(c+"");
				sb.setLength(0);
			}
		}
		arr.add(sb.toString());
        
        for(int i = 0; i<6;i++){
            temp = calc(arr, i);
            if(temp<0) temp*=-1;
            answer = answer<temp?temp:answer;
        }
        
		return answer;
	}
    
	static long calc(ArrayList<String> arr, int n) {
		ArrayList<String> list=new ArrayList<>();
            for(int i=0;i<arr.size();i++) list.add(arr.get(i));
        
            for(int j=0;j<3;j++) {
			    char operator=c[order[n][j]];
                
			    for(int k=1;k<list.size()-1;k++) {
				    String cs=list.get(k);
                    
				    if(cs.equals(operator+"")) {
				    	long prev=Long.parseLong(list.get(k-1));
                        long next=Long.parseLong(list.get(k+1));
                        
                        if(order[n][j]==0) prev+=next;
                        else if(order[n][j]==1) prev-=next;
                        else prev*=next;
                        
                        list.remove(k+1);
                        list.set(k, prev+"");
                        list.remove(k-1);
                        
                        k--;
				    }
			    }
		    }
		return Long.parseLong(list.get(0));
    }
}