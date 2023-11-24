import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] farm;
    static int M;
    static int N;
    public static void dfs(int a, int b){
        if (b-1 != -1 && farm[a][b - 1] == 1) {
            farm[a][b-1] = 0;
            dfs(a, b - 1);
        }
        if (b+1 != N && farm[a][b + 1] == 1) {
            farm[a][b + 1] = 0;
            dfs(a, b + 1);
        }
        if (a-1 != -1 && farm[a-1][b] == 1) {
            farm[a-1][b] = 0;
            dfs(a-1, b);
        }
        if (a+1 != M && farm[a+1][b] == 1) {
            farm[a+1][b] = 0;
            dfs(a+1, b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                farm[a][b] = 1;
            }
            int count = 0;
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (farm[j][k] == 1) {
                        count++;
                        farm[j][k] = 0;
                        dfs(j, k);
                    }
                }
            }
            System.out.println(count);
        }

    }
}
