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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);

        long left = 1;
        long right = (long) list.get(list.size() - 1) * m;//가장 오래걸리는 시간은 가장 시간이 많이 걸리는 심사대에서 모두 심사하는 것

        while (left <= right) {
            long mid = (left + right) / 2;

            long count = 0;
            for (int i = 0; i < n; i++) {
                count += mid / list.get(i);
                if (count > m) {
                    break;
                }
            }

            if(count < m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(left);

    }
}