/*
    접근
    1. BFS 2번 사용(레버, 탈출)
*/
import java.util.*;
class Solution {
    static int[] start;
    static int[] lever;
    static int[] exit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int answer;
    
    public int solution(String[] maps) {
        answer = 0;
        char[][] map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S') start = new int[]{i, j};
                if(maps[i].charAt(j) == 'L') lever = new int[]{i, j};
                if(maps[i].charAt(j) == 'E') exit = new int[]{i, j};
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        System.out.print(exit[0] + " " + exit[1]);
        //시작지점에서 레버까지 최단거리
        if(!bfs(map, start, lever)) return -1;
        
        visited = new boolean[maps.length][maps[0].length()];
        
        //레버에서 출구까지 최단거리
        if(!bfs(map, lever, exit)) return -1;
        
        
        return answer;
    }
    
    public boolean bfs(char[][] map, int[] start, int[] end){
        Queue<int[]> queue = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        queue.offer(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            //상,하,좌,우 가능한 곳 방문
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + current[0];
                int ny = dy[i] + current[1];
                
                //map 바깥부분은 방문X
                if(nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;
                
                //벽이라면 방문X
                if(map[nx][ny] == 'X') continue;
                
                if(visited[nx][ny]) continue;
                
                if(nx == end[0] && ny == end[1]){
                    visited[nx][ny] = true;
                    answer += current[2] + 1;
                    return true;
                }
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, current[2] + 1});
            }
        }
        return false;
        
    }
    
    
    
    
}