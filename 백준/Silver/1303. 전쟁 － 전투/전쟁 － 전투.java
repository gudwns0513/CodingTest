import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int M;
    static boolean[][] visited;
    static char[][] ground;
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];
        ground = new char[M][N];
        

        for (int i = 0; i < M; i++){
            String str = br.readLine();
            for (int j = 0; j < N; j++){
                ground[i][j] = str.charAt(j);
            }
        }
        int blue = 0;
        int white = 0;

        for (int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    if(ground[i][j] == 'B'){
                        blue = blue + bfs(i, j, 'B');
                    }
                    else{
                        white = white + bfs(i, j, 'W');
                    }
                }
            }
        }
        System.out.print(white + " " + blue);
    }
    
    static int bfs(int x, int y, char ch){
        int count = 1;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()){
            Point pt = queue.poll();
            for(int i = 0; i < 4; i++){
                int newX = pt.x + dx[i];
                int newY = pt.y + dy[i];
                if(newX < 0 || newY < 0 || newX > M-1 || newY > N-1)
                    continue;

                if(!visited[newX][newY] && ground[newX][newY] == ch){
                    queue.offer(new Point(newX, newY));
                    visited[newX][newY] = true;
                    count++;
                }
            }
        }
        return count * count;
    }




    
}