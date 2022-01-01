import java.util.*;
import java.io.*;
public class Deque_BOJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if(command.equals("push_back")){
                int val = Integer.parseInt(st.nextToken());
                q.offer(val);
            }
            else if(command.equals("push_front")){
                int val = Integer.parseInt(st.nextToken());
                q.offerFirst(val);
            }
            else if(command.equals("pop_front")){
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(String.valueOf(q.pollFirst())+"\n");

            }
            else if(command.equals("pop_back")){
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(String.valueOf(q.pollLast())+"\n");

            }
            else if(command.equals("size")){
                sb.append(String.valueOf(q.size())+"\n");
            }
            else if(command.equals("empty")){
                if(q.isEmpty()){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }

            }
            else if(command.equals("front")){
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(String.valueOf(q.peekFirst())+"\n");
            }else if(command.equals("back")){
                if(q.isEmpty())
                    sb.append("-1\n");
                else
                    sb.append(String.valueOf(q.peekLast())+"\n");
            }
        }
        System.out.println(sb.toString());
    }

}
