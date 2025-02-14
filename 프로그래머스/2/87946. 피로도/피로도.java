class Solution {
    static int answer = 0;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length]; 
        dfs(k, 0, dungeons);
        return answer;
    }

    public void dfs(int k, int count, int[][] dungeons) {
        answer = Math.max(answer, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) { // 방문하지 않았고, 최소 필요 피로도를 만족하면 탐색
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1, dungeons); // k에서 소모 피로도 차감 후 탐색
                visited[i] = false; // 백트래킹
            }
        }
    }
}
