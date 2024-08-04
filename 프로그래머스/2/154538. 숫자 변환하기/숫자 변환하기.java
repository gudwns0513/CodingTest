import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        queue.offer(new int[] {0, x});
        visited.add(x);
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int level = current[0];
            int num = current[1];
            
            if(num == y) return level;
            
            int numP = num + n;
            int numTwo = num * 2;
            int numThree = num * 3;
            
            if(numP <= y && !visited.contains(numP)) {
                queue.offer(new int[] {level+1, numP});
                visited.add(numP);
            }
            if(numTwo <= y && !visited.contains(numTwo)) {
                queue.offer(new int[] {level+1, numTwo});
                visited.add(numTwo);
            }
            if(numThree <= y && !visited.contains(numThree)) {
                queue.offer(new int[] {level+1, numThree});
                visited.add(numThree);
            }
        }
        return -1;
    }
}