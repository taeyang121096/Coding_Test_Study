import java.util.*;

public class Disk_Kakao {
//     작업이 없을시 들어온 요청순으로 진행 -> 큐

//     작업을 할때 대기시간을 줄이는게 중요(cost가 짧은 순으로) -> 정렬을 하겠구나

//     순서대로 구현하고 코스트 짧은 순으로 넣기 -> 정렬

//     배열 길이만큼 계산 되어진지 확인하기 -> 계산 되어졌는지 확인

//     중간에 빈 공간이 생길 경우 빈 공간 다음 코스트로 대채 하기 -> 채워준다 24

    public int solution(int[][] jobs) {
        int answer = 0;
//         서로 위치가 바뀔려면 양수를 리턴하고 아닐 경우에는 음수를 리턴
        Arrays.sort(jobs, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }

        });

        int size = jobs.length;
        int cnt = 0;
        int time = 0;
        int idx = 0;
//         cost 작은순 으로 정렬이 될거고 인덱스 1인 부분이 정렬이 되겠죠
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] > o2[1] ? 1 : -1);

        while (cnt < size) {
            while (idx < size && jobs[idx][0] <= time) {
                q.offer(jobs[idx++]);
            }
            if (q.isEmpty()) {
                time = jobs[idx][0];
            } else {
//                 0, 3    1, 9      2,6
//              time = 3   2,6 ->  3 - 2 + 6 1대기 6+   1, 9
                int[] tmp = q.poll();
                answer += time - tmp[0] + tmp[1];
                time += tmp[1];
                cnt++;
            }
        }

        answer /= size;

        return answer;
    }
}

