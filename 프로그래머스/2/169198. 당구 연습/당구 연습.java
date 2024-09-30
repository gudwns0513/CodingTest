/*
    *접근
    1. 위 아래 오른쪽 왼쪽의 4가지 원쿠션 지점을 생각하기
    2. 4개 중 거리의 최솟값을 answer에 추가
        2-1. 4개를 구할 때 원쿠션에 맞기 전 공에 맞으면 제외하기
        
    *시간복잡도
    O(N^2)까지 가능
*/
import java.util.*;
import java.lang.*;
class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];

            int minDistance = Integer.MAX_VALUE;

            // 위쪽 벽에 반사되는 경우
            if (!(startX == ballX && startY < ballY)) { 
                int reflectedY = 2 * n - ballY; // 위쪽 반사된 좌표
                int dist = (startX - ballX) * (startX - ballX) + (startY - reflectedY) * (startY - reflectedY);
                minDistance = Math.min(minDistance, dist);
            }

            // 아래쪽 벽에 반사되는 경우
            if (!(startX == ballX && startY > ballY)) { 
                int reflectedY = -ballY; // 아래쪽 반사된 좌표
                int dist = (startX - ballX) * (startX - ballX) + (startY - reflectedY) * (startY - reflectedY);
                minDistance = Math.min(minDistance, dist);
            }

            // 왼쪽 벽에 반사되는 경우
            if (!(startY == ballY && startX > ballX)) { 
                int reflectedX = -ballX; // 왼쪽 반사된 좌표
                int dist = (startX - reflectedX) * (startX - reflectedX) + (startY - ballY) * (startY - ballY);
                minDistance = Math.min(minDistance, dist);
            }

            // 오른쪽 벽에 반사되는 경우
            if (!(startY == ballY && startX < ballX)) { 
                int reflectedX = 2 * m - ballX; // 오른쪽 반사된 좌표
                int dist = (startX - reflectedX) * (startX - reflectedX) + (startY - ballY) * (startY - ballY);
                minDistance = Math.min(minDistance, dist);
            }

            answer[i] = minDistance;
        }
        
        return answer;
    }
}
