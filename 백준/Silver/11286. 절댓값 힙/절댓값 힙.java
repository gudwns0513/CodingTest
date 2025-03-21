import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/*
    - 시간복잡도
    제한시간: 1초
    N의 최댓값이 100,000
    따라서 O(NlogN)부터 가능
    - 접근
    1. PriorityQueue 사용

 */
public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)){
                    return o1- o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num != 0){
                heap.offer(num);
            }else{
                System.out.println(heap.isEmpty() ? 0 : heap.poll());
            }
        }

    }

}
