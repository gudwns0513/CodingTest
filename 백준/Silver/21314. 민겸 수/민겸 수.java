import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 1초
    N의 최대값 3,000

    -접근
    최댓값 구하기
    1. M은 처음 만나는 K와 모두 묶기
    2. K를 포함하지 않으면 M을 하나씩 계산하기

    최솟값 구하기
    1. 붙어있는 M끼리 싹 다 묶기
    2. K는 무조건 하나 씩 계산하기


   - 참고
   N의 최대값이 3,000이므로 10^3000을 담을 자료형이 애매하기 때문에 Math.pow가 아닌 String에 for문으로 붙여서 계산

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String str = text;
        int n = str.length();
        StringBuilder min = new StringBuilder();
        StringBuilder max = new StringBuilder();



        //최댓값 구하기
        while (max.length() < n) {
            int kIndex = str.indexOf("K");
            //K가 없다면 남은 M개수만큼 1을 전부 추가
            if (kIndex == -1) {
                for (int i = 0; i < str.length(); i++) {
                    max.append(1);
                }
            //K가 있다면 K까지 모두 묶어서 숫자 추가후 str에서 잘라 없애기
            }else{
                max.append(5);
                for (int i = 0; i < kIndex; i++) {
                    max.append(0);
                }
                str = str.substring(kIndex + 1);
            }
        }
        System.out.println(max);

        str = text;

        //최소 구하기
        while (min.length() < n) {
            int kIndex = str.indexOf("K");
            //K가 없다면 모든 M을 묶어서 계산
            if (kIndex == -1) {
                min.append(1);
                for(int i = 0; i < str.length()-1; i++) {
                    min.append(0);
                }
            }else{
                //K가 첫번째에 있다면 5를 넣고 str에서 자르기
                if (kIndex == 0) {
                    min.append(5);
                    str = str.substring(kIndex + 1);
                //K가 첫번째가 아니라면 K앞의 M들은 모두 묶고 K는 하나로 계산 후 자르기
                }else{
                    min.append(1);
                    for (int i = 0; i < kIndex-1; i++) {
                        min.append(0);
                    }
                    min.append(5);
                    str = str.substring(kIndex + 1);
                }
            }
        }

        System.out.println(min);


    }
}
