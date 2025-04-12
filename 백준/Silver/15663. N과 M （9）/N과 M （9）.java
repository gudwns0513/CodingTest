import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    - 접근
    1.
 */

public class Main {
    static int n, m;
    static int[] answer;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        answer = new int[m];
        sb = new StringBuilder();

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if(depth == m){
            for (int i = 0; i < m; i++) {
                sb.append(answer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }


        int before = 0;
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                if (before != arr[i]) {
                    before = arr[i];
                    answer[depth] = arr[i];
                    visited[i] = true;
                    dfs(depth + 1);
                    visited[i] = false;
                }
            }
        }
    }

}
