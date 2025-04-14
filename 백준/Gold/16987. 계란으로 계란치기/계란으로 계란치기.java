import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 시간 복잡도
    제한시간 : 2초

    - 접근
    1. dfs 백트래킹으로 풀이
    2. 만약 마지막 계란을 선택했을 때 dfs깨기

 */

public class Main {
    static int n;
    static int[][] eggs;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        eggs = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken());
            eggs[i][1] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int result) {
        if (depth >= n) {
            answer = Math.max(answer, result);
            return;
        }

        //현재 게란
        int currentDurability = eggs[depth][0];
        int currentWeight = eggs[depth][1];

        if (currentDurability <= 0) {
            dfs(depth + 1, result);
            return;
        }

        boolean isAnyHit = false;
        for (int i = 0; i < n; i++) {

            //현재 계란으로 깨기를 선택한 계란
            int choiceDurability = eggs[i][0];
            int choiceWeight = eggs[i][1];

            //현재 계란과 또는 선택한 계란이 깨져있지 않으면
            if (choiceDurability > 0 && depth != i) {

                isAnyHit = true;

                //깼을 때 내구도 계산
                int changeCurrentDurability = currentDurability - choiceWeight;
                int changeChoiceDurability = choiceDurability - currentWeight;

                //내구도 반영
                eggs[depth][0] = changeCurrentDurability;
                eggs[i][0] = changeChoiceDurability;

                //내구도가 0보다 같거나 작아지면 꺠진 계란 수 더하기
                int broken = 0;
                if(changeCurrentDurability <= 0){
                    broken++;
                }
                if(changeChoiceDurability <= 0){
                    broken++;
                }
                dfs(depth + 1, result + broken);

                //계란 내구도 복구
                eggs[depth][0] = currentDurability;
                eggs[i][0] = choiceDurability;
            }
        }

        if(!isAnyHit){
            dfs(depth + 1, result);
        }

    }
}
