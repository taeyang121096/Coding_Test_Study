import java.util.*;
class Solution {

    ArrayList<int[]> list = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    HashSet<ArrayList<Integer>> key = new HashSet<>();

    int answer = 0;

    void combi(int n,int level,int start, int size,int[] tmp){
        if(n == level){
            add(tmp);
            return;
        }
        for(int i = start;i<size;i++){
            tmp[n] = i;
            combi(n+1,level,i+1,size,tmp);
        }
    }

    void add(int[] tmp){
        int[] t = tmp.clone();
        list.add(t);
    }

    void com(int size){

    }

    boolean checking(int[] x){
        ArrayList<Integer> ls = new ArrayList<>();
        int size = x.length;
        for(int i : x){
            ls.add(i);
            if(set.contains(ls))
                return false;
        }
        if(ls.size() >=2){
            for(ArrayList<Integer> k : key){
                int count = k.size();
                for(int s : k){
                    for(int j : ls){
                        if(s==j){
                            count--;
                            break;
                        }
                    }
                }
                if(count == 0)
                    return false;
            }
        }

        key.add(ls);
        return true;
    }

    void res(String[][] relation){
        for(int[] x : list){
            for(int i = 0;i<relation.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j : x){
                    sb.append(relation[i][j]);
                }
                set.add(sb.toString());
            }
            if(set.size() == relation.length){
                if(checking(x))
                    answer++;

            }
            set.clear();
        }
    }


    public int solution(String[][] relation) {

        int size = relation[0].length;

        for(int i = 1;i<=size;i++){
            int[] tmp = new int[i];
            combi(0,i,0,size,tmp);
        }

        res(relation);
        for(ArrayList<Integer>ls : key){
            for(int k : ls)
                System.out.print(k+" ");
            System.out.println();
        }


        return answer;
    }
}