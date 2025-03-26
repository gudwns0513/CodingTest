import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초
    N의 최댓값이 100,000이므로 O(NlogN)안에 풀어야함

    -접근
    1. 우선순위 큐에 오름차순 정렬
    2. rope들의 총 무게 더하며 우선순위 큐에 삽입
    3. 가장 작은 로프 * 로프 개수가 최대 중량
    4. 최대 중량들을 모두 구한 후 가장 큰값 출력

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int totalRope = 0;
        int count = 0;
        int max = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < n+1; i++) {
            int weight = Integer.parseInt(br.readLine());
            totalRope += weight;
            count++;
            queue.add(weight);
        }

        while(!queue.isEmpty()) {
            int minRope = queue.poll();
            max = Math.max(minRope * count, max);
            totalRope -= minRope;
            count--;

        }

        System.out.println(max);

    }
}