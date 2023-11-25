import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] floor;
    static int N;
    static int M;
    static int K;
    static int Max;
    static int count = 0;

    public static void dfs(int a, int b) {
        if (a - 1 > -1 && floor[a - 1][b] == 1) { // 위 확인
            floor[a-1][b] = 0;
            count++;
            dfs(a-1, b);
        }
        if (a + 1 < N && floor[a + 1][b] == 1) { // 아래 확인
            floor[a+ 1][b] = 0;
            count++;
            dfs(a+1, b);
        }
        if (b - 1 > -1 && floor[a][b - 1] == 1) { // 좌측 확인
            floor[a][b-1] = 0;
            count++;
            dfs(a, b-1);
        }
        if (b + 1 < M && floor[a][b + 1] == 1) { // 우측 확인
            floor[a][b+1] = 0;
            count++;
            dfs(a, b+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        floor = new int[N][M];
        Max = 0;
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            floor[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(floor[i][j] == 1){
                    floor[i][j] = 0;
                    count++;
                    dfs(i, j);
                    Max = Math.max(Max, count);
                    count = 0;
                }
            }
        }
        System.out.print(Max);
    }
}
