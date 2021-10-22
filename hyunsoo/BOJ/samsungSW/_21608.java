package BOJ.samsungSW;
import java.util.*;
import java.io.*;
public class _21608 {
  
  static int N;
  static int[][] arr;
  static int[][] favor;
  static int[] dx={0,0,1,-1};
  static int[] dy={1,-1,0,0};
  static List<node> list;
  static int max;
  static int answer=0;

  static class node{
    int x;
    int y;
    int blank;
    public node(int x, int y, int blank){
      this.x=x;
      this.y=y;
      this.blank=blank;
    }
    // public int compareTo(node o){
    //   // if(o.blank == blank){
    //   //   if(o.x==x){
    //   //     return y-o.y;
    //   //   }

    //   //   return x-o.x;
    //   // }
    //   return blank - o.blank;
    // }
  }
  public static void main(String[] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N= Integer.parseInt(br.readLine());

    arr = new int[N][N];
    favor = new int[N*N][5];


    for(int i=0; i<N*N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j=0; j<5; j++){
        favor[i][j]=Integer.parseInt(st.nextToken());
      }
      findfavor(i);     
    }

    findanswer();
    System.out.print(answer);

  }
  public static void findanswer(){
    
    for(int i=0; i<N; i++){
      for(int j=0; j<N; j++){
        for(int k=0; k<N*N; k++){
          if(arr[i][j]==favor[k][0]){
            int count=0;  
            for(int m=0; m<4; m++){
              int tx= i+dx[m];
              int ty =j+dy[m];
              if(tx<0 || ty<0 || tx>=N || ty>=N) continue;
              for(int l=1; l<=4; l++){
                if(favor[k][l]==arr[tx][ty]) count++;
              }  
            }
            switch(count){
              case 0:
                answer +=0;
                break;
              case 1:
                answer +=1;
                break;
              case 2:
                answer +=10;
                break;
              case 3:
                answer +=100;
                break;  
              case 4:
                answer +=1000;
                break;
            }
            continue;
          }
        }
      }
    }
  }

 public static void findfavor(int index){
    
  list = new LinkedList<>();
  max=0;
  for(int i=0; i<N; i++){
    for(int j=0; j<N; j++){  
      
      int count=0;
      int blank=0;
  
      if(arr[i][j]==0){
        for(int k=0; k<4; k++){
          int tx = i+dx[k];
          int ty = j+dy[k];
         
          if(tx<0 || ty<0 || tx>=N || ty>=N) continue;
          if(arr[tx][ty]!=0){  
            for(int l=1; l<=4; l++){     
              if(favor[index][l]==arr[tx][ty]) count++;
            }  
          }else{
            blank++;
          }
        }     
      if(count>max){
        max=count;
        list.clear();
        list.add(new node(i,j,blank));
      }else if(count==max){
        list.add(new node(i,j,blank));
      }
    }
    }
  }

  Collections.sort(list, new Comparator<node>(){
    public int compare(node o1, node o2){
      if(o2.blank==o1.blank){
        if(o1.x==o2.x){
          return o1.y-o2.y;
        }
        return o1.x-o2.x;
      }
      return o2.blank - o1.blank;
    }
  });
  node tmp = list.get(0);
  arr[tmp.x][tmp.y]=favor[index][0];
 }
}
