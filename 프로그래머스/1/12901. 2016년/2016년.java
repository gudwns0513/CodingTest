class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] dayOfMonth = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeek = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int m = 1;
        int d = 1;
        int dayCount = 0;
        
        while(m != a || d != b){
            if(dayOfMonth[m] > d){
                d++;
            }else{
                d = 1;
                m++;
            }
            dayCount++;
        }
        
        return dayOfWeek[dayCount % 7];
        
    }
}