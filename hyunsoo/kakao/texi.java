package kakao;

class Solution {    
    static int[][] value;
    static int[] leastA;
    static int[] leastB;
    static int[] leastS;
       
    public void getValue(int[][] fares,int n){
        for(int[] v : fares){
            int x=v[0];
            int y=v[1];
            int z=v[2];
            value[x][y]=z;
            value[y][x]=z;
        }
    }
    public int[] find(int start, int n){
        int[] arr = new int[n+1];
        boolean[] check = new boolean[n+1];
        
        for(int i=0; i<n+1; i++){
            arr[i]=Integer.MAX_VALUE;
        }
        arr[start]=0;
        
        for(int i=0; i<n+1; i++){
            int min = Integer.MAX_VALUE;
            int index=0;
            for(int j=0; j<n+1; j++){
                if(!check[j] && min>arr[j]){
                    index=j;
                    min =arr[j];
                }
            }
            for(int j=0; j<n+1; j++){
                if(!check[j] && value[index][j]!=0 && arr[index] != Integer.MAX_VALUE && arr[index]+value[index][j]<arr[j] ){
                    arr[j]=arr[index]+value[index][j];
                }
            }
            check[index]=true;
        }
        return arr;  
    } 
    public int minValue(int n,int s, int a, int b){
        
        int value= leastS[a] + leastS[b];
        
        for(int i=1; i<n+1; i++){
            if(leastS[i]!=Integer.MAX_VALUE && i != s && leastS[i]+leastA[i] + leastB[i] < value){
                value = leastS[i]+leastA[i] + leastB[i];
            }
        }
        
        return value;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        value= new int[n+1][n+1];
        getValue(fares,n);
        
       
        leastA = find(a,n);
        leastB = find(b,n);
        leastS = find(s,n);
        
        answer = minValue(n,s,a,b);
     
        return answer;
    }
}