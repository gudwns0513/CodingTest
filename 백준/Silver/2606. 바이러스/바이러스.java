import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static boolean[] visited;
    static int[][] network;
    static int count = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        network = new int[N+1][N+1];
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            network[n][m] = 1;
            network[m][n] = 1;
        }
        dfs(1);

        System.out.println(count-1);
    }

    public static void dfs(int a){
        visited[a] = true;
        count++;
        for(int i = 1; i < N + 1; i++){
            if(!visited[i] && network[a][i] == 1){
                dfs(i);
            }
        }
    }
}