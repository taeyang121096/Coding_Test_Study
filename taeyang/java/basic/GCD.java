package basic;
import java.util.*;
public class GCD {
    static ArrayList<int[]> list = new ArrayList<>();
    static void cate(int[] arr,int level,int[]tmp,int start){

        if(level == 2){
            int[] cat = tmp.clone();
            list.add(cat);
            return;
        }


        for(int i = start;i<arr.length;i++){

            tmp[level] = arr[i];
            cate(arr,level+1,tmp,i+1);

        }

    }
    static long ans =0;
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<t;i++){
            String []num = sc.nextLine().split(" ");
            int[] arr = new int[num.length-1];
            for(int j = 0;j<arr.length;j++)
                arr[j] = Integer.parseInt(num[j+1]);
            cate(arr,0,new int[2],0);
            calc();
            System.out.println(ans);
            ans = 0;
            list.clear();
        }
    }
    static void calc(){
        for(int[] t : list){
            int a = 0;
            int b = 0;
            int r = 0;
            if(t[0]>t[1]) {
                a = t[0];
                b = t[1];
            }else{
                b =t[0];
                a = t[1];
            }
            while(b!=0){
                r=a%b;
                a=b;
                b=r;
            }
            ans += a;
        }

    }
}
