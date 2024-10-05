class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int k = 1; k * (k - 1) / 2 < n; k++) {
            int num = n - k * (k - 1) / 2;
            if (num % k == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
