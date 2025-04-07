import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간복잡도
    N의 최댓값이 5000이므로 O(5000(5000-1)/2 * log5000) = O
    O(N(logN + logN)) = O(NlogN)으로 풀었음
    제한시간: 1초

    - 접근
    이분탐색으로 찾아서 출력하기

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);

        long answer = Long.MAX_VALUE;
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < n-2; i++) {
            int first = list.get(i);
            for (int j = i + 1; j < n-1; j++) {
                int second = list.get(j);

                int left = j + 1; //최소
                int right = n - 1; //최대

                while (left <= right) {
                    int mid = left + (right - left) / 2;

                    long sum = (long)first + (long)second + (long)list.get(mid);

                    if (Math.abs(sum) < answer) {
                        answer = Math.abs(sum);
                        one = first;
                        two = second;
                        three = list.get(mid);
                    }

                    if (sum <= 0) {
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
        }
        System.out.println(one + " " + two + " " + three);


    }
}