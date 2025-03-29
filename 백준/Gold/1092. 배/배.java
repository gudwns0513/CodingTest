import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초
    N의 최대값 3,000

    - 접근
    가장 많이 들 수 있는 크레인이 가장 무거운걸 계속 든다.(그리디)

    - 풀이
    1. List에 크레인과 박스들을 넣어서 내림차순
    2. 각 크레인을 순회하며 자신이 들 수 있는 최대 값의 박스를 든다(list에서 박스 삭제)
    3. 만약 들 수 있는 박스가 없다면 아무것도 삭제하지 않는다.

    - 참고
    1. 모든 박스를 옮기지 못하면 -1 출력

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> crains = new ArrayList<>();
        List<Integer> boxes = new ArrayList<>();

        //크레인 삽입(내림차순)
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crains.add(Integer.parseInt(st.nextToken()));
        }
        crains.sort(Collections.reverseOrder());

        //박스 삽입(내림차순)
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        boxes.sort(Collections.reverseOrder());

        if (crains.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int count = 0;
        while(!boxes.isEmpty()) {
            for(int i = 0; i < crains.size(); i++) {
                int boxCount = 0;
                while (boxCount < boxes.size()) {
                    if (crains.get(i) < boxes.get(boxCount)) {
                        boxCount++;
                    }else{
                        boxes.remove(boxCount);
                        break;
                    }
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
