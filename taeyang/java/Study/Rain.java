import java.util.*;
public class Rain {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int ans = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[] count = new int[col];
        for(int i = 0;i<col;i++){
            count[i] = sc.nextInt();
        }
        int left=0,right=0;

        for(int i =1;i<col;i++){
            left = 0;
            right = 0;
            for(int j = 0;j<i;j++){
                left = Math.max(left,count[j]);
            }
            
            for(int j = i+1;j<col;j++){
                right = Math.max(right,count[j]);
            }
            
            if(left > count[i] && right > count[i] )
                ans += Math.min(left,right) - count[i];
            
        }

        System.out.println( ans);

    }

}
