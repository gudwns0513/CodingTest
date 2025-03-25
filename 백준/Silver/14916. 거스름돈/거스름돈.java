import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    - 시간복잡도
    제한시간: 2초
    N의 최댓값이 100,000이므로 O(NlogN)안에 풀어야함

    -접근
    1. 5로 나눈 몫과 나머지 구하기
    2. 5로 나눈 나머지가 홀수면 몫을 -1로 계산하기
    3. 갯수구하기

 */
public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int moke = n / 5;
        int remain = n % 5;

        if(remain % 2 != 0){

            if(moke == 0){
                System.out.println(-1);
                return;
            }else{
                moke -= 1;
                remain += 5;
            }
        }

        System.out.println(moke + remain / 2);



    }


}
