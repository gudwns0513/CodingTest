import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
/*
    - 시간복잡도 접근
    제한시간 : 2초
    1. 단순 List에 하면 O(N^2)이므로 최대 입력값 10000개 가능하지만 10만이므로 시간초과
    2. HashMap을 2개 사용하면 O(N)이므로 최대 입력값 4천만이므로 통과
*/

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();


        for(int i = 0; i < n; i++){
            String pocketmon = br.readLine();
            map.put(pocketmon, i+1);
            map2.put(i+1, pocketmon);
        }


        for(int i = 0; i < m; i++){
            String question = br.readLine();
            //알파벳이라면
            if(!Character.isDigit(question.charAt(0))){
                System.out.println(map.get(question));
            }
            else{ //숫자라면
                System.out.println(map2.get(Integer.parseInt(question)));
            }
        }


    }
}