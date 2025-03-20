import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


/*
    시간복잡도
    제한시간: 2초
    N이 최대 10,000, M이 최대 10,000이므로 list사용 시 O(N^2)이기 때문에 최대 10,000이라서 애매
    set사용으로 contains를 O(1)로 줄여 총 O(N)이 나오도록 풀기

 */
public class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            if(set.contains(br.readLine())){
                count++;
            }
        }
        System.out.println(count);

    }

}
