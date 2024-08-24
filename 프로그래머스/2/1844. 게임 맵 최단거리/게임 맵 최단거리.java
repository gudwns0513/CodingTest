import java.util.*;
class Solution {
    int answer;
    boolean[][] visited;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[][] map;
    public int solution(int[][] maps) {
        answer = Integer.MAX_VALUE;
        map = maps;
        visited = new boolean[maps.length][maps[0].length];
        
        return bfs(0, 0);
    }
    
    public int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y, 1});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx == map.length-1 && ny == map[0].length-1) 
                    return current[2] + 1;
                
                if(nx < 0 || nx > map.length-1 || ny < 0 || ny > map[0].length-1) //맵 밖은 이동 X 
                    continue;
                
                if(visited[nx][ny]) //이미 방문한 곳 이동 X
                    continue;
                
                if(map[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[] {nx, ny, current[2] + 1});
                
            }
        }
        
        return -1;
        
    }
}

//BFS로 바꿔서 풀기 !!!