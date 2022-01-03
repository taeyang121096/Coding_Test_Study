// list deque(스택)
// stack
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Okeunsu_BOJ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine()," ");

        Deque<Integer> stack = new ArrayDeque<>();
//        List<Integer> list = new ArrayList<>();
        int[] val = new int[n];

        int[] ans = new int[n];
        for(int i = 0;i<n;i++)
            val[i] =Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && val[stack.peek()] < val[i]){
                ans[stack.pop()] = val[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }

        for(int i = 0 ; i<n;i++)
            sb.append(ans[i]+" ");

        sb.setLength(sb.length()-1);
        System.out.println(sb.toString());

//        System.out.println(Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(" ")));


    }
}
