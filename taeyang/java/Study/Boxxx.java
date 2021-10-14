import java.util.*;
public class Boxxx {

    static class Person{
            double win;
            int count;
            int weight;
            int index;

            public Person(double win,int count,int weight,int index){
                this.win = win;
                this.count = count;
                this.weight = weight;
                this.index = index;
            }


        }
        static double[] rate(int[]weights,int index, String[] head){
            int size = weights.length;
            double[] arr = new double[2];
            char[] res = head[index].toCharArray();
            int count = 0;
            int win = 0;
            int heavy = 0;
            for(int i = 0;i<size;i++){
                if(i == index || res[i] == 'N')
                    continue;
                if(res[i] == 'W'){
                    if(weights[i] > weights[index])
                        heavy++;
                    win++;
                }
                count++;
            }
            if(count !=0)
                arr[0] = (double)win/(double)count * (double)100;
            else
                arr[0] = 0;
            arr[1] = heavy;
            return arr;
        }


        ArrayList<Person> list = new ArrayList<>();
        public int[] solution(int[] weights, String[] head2head) {

            int size = weights.length;

            for(int i = 0;i<size;i++){
                int weight  = weights[i];
                double[]arr = rate(weights,i,head2head);
                list.add(new Person(arr[0],(int)arr[1],weight,i));
            }
            Collections.sort(list, new Comparator<Person>(){
                @Override
                public int compare(Person p1, Person p2){
                    if(p1.win == p2.win){
                        if(p1.count == p2.count){
                            if(p1.weight == p2.weight){
                                return p1.index>p2.index ? 1:-1;
                            }
                            return p1.weight > p2.weight ? -1:1;
                        }
                        return p1.count > p2.count ? -1:1;
                    }
                    return p1.win > p2.win ? -1:1;
                }


            });

            int[] answer = new int[size];


            for(int i = 0;i<size;i++)
                answer[i] = list.get(i).index+1;



            return answer;
        }
    }
}
