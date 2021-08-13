package BOJ;

import java.util.*;
import java.io.*;
public class _5430 {
    public static void main(String[] args ) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int i=0; i<n; i++){
            
            String fuc = br.readLine();    //RD 읽기
            int input = Integer.parseInt(br.readLine());   // 입력될 숫자 읽기
            st = new StringTokenizer(br.readLine(),"[],");  // 숫자 파싱
            Deque<Integer> deq = new ArrayDeque<>();
            
            for(int j=0; j<input; j++){
                deq.add(Integer.parseInt(st.nextToken()));  // deq 에 저장
            }
            
            boolean first = true;   // 앞을 가리킬지 뒤를 가리킬지 포인터
            boolean error = false;
            for(int j=0; j<fuc.length(); j++){
             char a = fuc.charAt(j);

             if(a == 'R'){
                first = !first;
             }
             else if(a == 'D'){
                if(deq.size()==0) {sb.append("error\n"); error= true; break;}
                
                if(first){deq.removeFirst();}
                else deq.removeLast();
             }

            }
            
            if(!error){
            sb.append("[");
            if(first){
                if(deq.size()!=0){
                    sb.append(deq.removeFirst());
                }
                while(deq.size()>0){
                    sb.append(",").append(deq.removeFirst());
                }
            }else{
                if(deq.size()!=0){
                    sb.append(deq.removeLast());
                }
                while(deq.size()>0){
                    sb.append(",").append(deq.removeLast());
                }
            }
            sb.append("]\n");
        }
    }
        System.out.print(sb);
    }
}
        
        

    

