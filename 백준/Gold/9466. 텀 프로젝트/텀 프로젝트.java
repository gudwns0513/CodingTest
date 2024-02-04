import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] want;
    static boolean[] visited;
    static boolean[] finished;
    static int count;
   
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int student = Integer.parseInt(br.readLine());
            want = new int[student+1];
            visited = new boolean[student+1];
            finished = new boolean[student+1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < student+1; j++){
                want[j] = Integer.parseInt(st.nextToken());
            }

            
            count = 0;
            for(int k = 1; k < student+1; k++){
                    dfs(k);
            }
            System.out.println(student - count);
        }
    }
    static void dfs(int current){
        if(visited[current])
            return;

        visited[current] = true;
        int next = want[current];

        if(!visited[next])
            dfs(next);
        else{
            if(!finished[next]){
                count++;
                while(next != current){
                    count++;
                    next = want[next];
                }
            } 
        }
        finished[current] = true;
    }
}