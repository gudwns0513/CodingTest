import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초
    N의 최대값이 100,000이므로 브루트포스X

    -접근
    1. List를 2개 만들어 각각 도시의 기름값과 도로의 길이를 저장
    2. 총 거리 계산하기
    3. 도시 기름값의 최소값 계산하기
    4. 만약 기름값이 최소인 도시를 만나면 남은 거리만큼 기름을 전부 다 사기
    5. 만약 기름값이 최소인 도시가 아니라면 다음 도시로 갈 만큼 기름 사기
    6. 기름을 살 때 마다 총 거리에 -해주고 최종 기름값 +하기


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int totalDistance = 0;
        int totalPrice = 0;
        List<Integer> distances = new ArrayList<>();
        List<Integer> oilPrices = new ArrayList<>();
        PriorityQueue<Integer> oilPrices2 = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n-1; i++) {
            int distance = Integer.parseInt(st.nextToken());
            distances.add(distance);
            totalDistance += distance;

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            int price = Integer.parseInt(st.nextToken());
            oilPrices.add(price);
            oilPrices2.add(price);
        }

        int minOilPrice = oilPrices2.poll();

        for (int i = 0; i < n - 1; i++) {
            if (oilPrices.get(i) == minOilPrice) {
                totalPrice += oilPrices.get(i) * totalDistance;
                break;
            }else{
                totalPrice += oilPrices.get(i) * distances.get(i);
                totalDistance -= distances.get(i);
            }
        }

        System.out.println(totalPrice);


    }
}
