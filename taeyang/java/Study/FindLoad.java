
    import java.util.*;
    class Solution {
        //     nodeinfo <10,000 x,y < 100,000, level < 1000
//     1. y축 기준으로 sort y가 같으면 x축 작은거 부터
        List<Tree>list = new LinkedList<Tree>();
        int[][] answer;
        int counting = 0;
        class Tree implements Comparable<Tree>{
            int x, y, level;
            Tree left;
            Tree right;
            public Tree(int x, int y, int level){
                this.x= x;
                this.y=y;
                this.level=level;
            }
            @Override
            public int compareTo(Tree t){
                if(this.y == t.y)
                    return this.x-t.x;
                return t.y-this.y;
            }
        }
        void con(Tree root,Tree val){
            if(root.x<val.x){
                if(root.right == null){
                    root.right = val;
                    return;
                }
                con(root.right, val);
            }
            else{
                if(root.left == null){
                    root.left = val;
                    return;
                }
                con(root.left, val);
            }
        }


        void pre(Tree root){
            if(root != null){
                print(root.level,0);
                pre(root.left);
                pre(root.right);
            }
        }



        void print(int level,int index){
            answer[index][counting++] = level;
        }

        void post(Tree root){
            if(root != null){
                post(root.left);
                post(root.right);
                print(root.level,1);
            }

        }


        public int[][] solution(int[][] nodeinfo) {
            answer = new int[2][nodeinfo.length];
            int count = 1;
            for(int [] t : nodeinfo){
                list.add(new Tree(t[0],t[1],count++));
            }
            Collections.sort(list);

            Tree root = list.get(0);
            for(int i =1;i<list.size();i++){

                con(root,list.get(i));
            }

            pre(root);
            counting = 0;
            post(root);


            return answer;
        }
    }
