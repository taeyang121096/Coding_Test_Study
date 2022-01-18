import java.util.*;
import java.io.*;

public class SecretMenu_SOF {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String secretMenu = br.readLine().replace(" ","");
        String buttonNum = br.readLine().replace(" ","");

        // 비교
        if(buttonNum.toString().indexOf(secretMenu.toString()) > -1){ 
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
        
    }
}