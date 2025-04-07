import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간복잡도
    N의 최댓값 100,000 M의 최댓값 100,000 O(N^2)으로 모든 경우 찾기 불가능
    O(N(logN + logN)) = O(NlogN)으로 풀었음
    제한시간: 1초

    - 접근
    이분탐색으로 찾아서 출력하기

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
        }
        Collections.sort(list);
        long answer = Long.MAX_VALUE;
        int first = 0;
        int second = 0;

        for (int i = 0; i < n-1; i++) {
            int num = list.get(i);

            int left = i + 1;
            int right = list.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                long sum = num + list.get(mid);

                if (Math.abs(sum) < answer) {
                    first = num;
                    second = list.get(mid);
                    answer = Math.abs(sum);
                }

                if (sum <= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }
        System.out.println(first + " " + second);



    }
}