package BOJ.samsungSW;
import java.io.*;
public class _14891 {
  
  static int[][] gear = new int[4][8];
  static boolean[] visit;
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int answer=0;
    for(int i=0; i<4; i++){
      String[] str= br.readLine().split("");
      for(int j=0; j<8; j++){
        gear[i][j] = Integer.parseInt(str[j]);
      }
    }
    int K = Integer.parseInt(br.readLine());
    for(int i=0; i<K; i++){
      String[] tmp = br.readLine().split(" ");
      visit = new boolean[4];
      rotate(Integer.parseInt(tmp[0])-1,Integer.parseInt(tmp[1]));
    }

    int add=1;
    for(int i=0; i<4; i++){
      if(gear[i][0]==1){
        answer+=add;
      }
      add=add*2;
    }
    System.out.println(answer);
  }

  public static void rotate(int index, int mode){
    visit[index]=true;
    if(mode==-1){   //반시계
      if(index==0){
        if(gear[index][2] != gear[index+1][6] && !visit[index+1]) rotate(index+1,1);
      }else if(index==3){
        if(gear[index][6] != gear[index-1][2] && !visit[index-1]) rotate(index-1,1);

      }else{
        if(gear[index][2] != gear[index+1][6] && !visit[index+1]) rotate(index+1,1);
        if(gear[index][6] != gear[index-1][2] && !visit[index-1]) rotate(index-1,1);
      }
      int tmp = gear[index][0];
      for(int i=1; i<8; i++){
        gear[index][i-1]=gear[index][i];
      }
      gear[index][7]=tmp;

    }else if(mode==1){  //시계
      if(index==0){
        if(gear[index][2] != gear[index+1][6] && !visit[index+1]) rotate(index+1,-1);
      }else if(index==3){
        if(gear[index][6] != gear[index-1][2] && !visit[index-1]) rotate(index-1,-1);
      }else{
        if(gear[index][2] != gear[index+1][6] && !visit[index+1]) rotate(index+1,-1);
        if(gear[index][6] != gear[index-1][2] && !visit[index-1]) rotate(index-1,-1);
      }

      int tmp = gear[index][7];
      for(int i=7; i>0; i--){
        gear[index][i]=gear[index][i-1];
      }
      gear[index][0]=tmp;
    }
  }
}
