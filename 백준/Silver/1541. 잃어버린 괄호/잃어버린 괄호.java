import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초
    N의 최대값이 100,000이므로 브루트포스X

    -접근
    1. 그리디로 접근
    2. 가장 큰 에너지 드링크에 가장 작은 에너지드링크를 계속 합친다.


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] minusStrs = str.split("-");
        int answer = 0;

        for(int i = 0; i < minusStrs.length; i++) {
            String[] plusStrs = minusStrs[i].split("\\+");
            int num = 0;
            for(int j = 0; j < plusStrs.length; j++) {
                num += Integer.parseInt(plusStrs[j]);
            }
            if(i == 0) answer += num;
            else answer -= num;


        }
        System.out.println(answer);

    }
}
