import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 1초

    -접근
    1. list에 내림차순 정렬 후 앞에 3개를 없애면서 3번째는 더하지 않으면 됨
    2. list가 3개 이하로 남게되면 그냥 다 더하기


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int totalPrice = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int price = Integer.parseInt(br.readLine());
            list.add(price);

        }

        list.sort(Collections.reverseOrder());

        while (!list.isEmpty()) {
            if (list.size() >= 3) {
                totalPrice += list.remove(0);
                totalPrice += list.remove(0);
                list.remove(0);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    totalPrice += list.remove(0);
                }
            }
        }
        System.out.println(totalPrice);
    }
}
