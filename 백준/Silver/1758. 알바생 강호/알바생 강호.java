import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초
    N의 최댓값이 100,000이므로 O(NlogN)안에 풀어야함

    -접근


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalTip = 0;

        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i < n+1; i++) {
            long tip = pq.poll() - (i - 1);
            totalTip += tip > 0 ? tip : 0;
        }

        System.out.println(totalTip);
    }
}
