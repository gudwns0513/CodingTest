import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 1초

    -접근
    1. 홀수개라면 가장 큰수를 마지막날 혼자하기
        1-1. 1.에서의 수를 제외한 가장 큰수와 가장 작은수끼리 묶기
        1-2. 반복하며 최소 M계산
    2. 짝수개라면 가장 큰수와 가장 작은수끼리 묶기
        2-1. 반복하며 최소 M계산


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<>();
        long m = 0;

        while(st.hasMoreTokens()) {
            list.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(list);

        if (n % 2 != 0) {
            m = Math.max(m, list.remove(list.size()-1));
        }
        while(!list.isEmpty()) {
            long min = list.remove(0);
            long max = list.remove(list.size()-1);

            m = Math.max(m, min + max);
        }

        System.out.println(m);
    }
}
