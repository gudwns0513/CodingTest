import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간 복잡도
    제한시간 : 10초

    - 접근
    NXN에 N개의 퀸을 놓으려면 반드시 한 행에 1개의 퀸만이 존재할 수 있으므로 각 행 마다 퀸을 지정해가며 풀어보자

    -풀이
    1. visited를 만들고 0이 아닌 자리는 미리 true로 모두 설정
    2. 0인 자리에 들어갈 수 있는 수를 체크하고 dfs로 반복
    3. 0인 자리에 들어갈 수 있는 수가 없다면 return
    4. 0인 자리가 없다면 정답

 */

public class Main {
    static int[] queens;
    static int n;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queens = new int[n];

        dfs(0);
        System.out.println(answer);

    }

    private static void dfs(int depth) {
        //마지막 행까지 퀸을 모두 채웠으면 탈출
        if (depth == n) {
            answer++;
            return;
        }

        //행에 하나라도 놓는다면 다음 행으로 진행
        for (int i = 0; i < n; i++) {

            //가로 검사는 불 필요

            //퀸을 놓을 수 있는지 검사
            if (isPossibleQueen(depth, i)) {
                queens[depth] = i;
                dfs(depth + 1);
            }
        }
    }

    //세로 및 대각선 검사
    private static boolean isPossibleQueen(int row, int col) {

        //세로 및 대각선 검사
        for (int i = 0; i < row; i++) {
            if (queens[i] == col) {
                return false;
            }

            if (Math.abs(queens[i] - col) == row - i) {
                return false;
            }
        }

        return true;
    }


}
