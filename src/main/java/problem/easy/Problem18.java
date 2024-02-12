package problem.easy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Problem18 {

    /**
     * 스트림을 사용하여 정수 배열에서 PriorityQueue를 생성합니다.
     *
     * @param numbers 정수 배열
     * @return 생성된 PriorityQueue
     */
    public static Queue<Integer> createPriorityQueueFromStream(int[] numbers) {
        // 여기에 코드 작성
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        pq1.add(4);
        pq1.add(1);
        pq1.add(2);
        pq1.add(7);
        pq1.add(5);

        pq2.add(4);
        pq2.add(1);
        pq2.add(2);
        pq2.add(7);
        pq2.add(5);

        System.out.println(pq1.equals(pq2));
    }
}
