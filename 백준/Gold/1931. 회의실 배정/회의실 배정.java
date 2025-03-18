import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static class Meeting{
        int start;
        int end;

        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Meeting> meetings = new ArrayList<>();


        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        //종료 시간 오름차순 정렬(같다면 시작이 빠른 순)
        List<Meeting> descMeetings = meetings.stream()
                .sorted((m1, m2) -> {
                    if(m1.end == m2.end) return m1.start - m2.start;

                    return m1.end - m2.end;
                })
                .collect(Collectors.toList());

        int count = 0;
        int end = 0;

        for(int i = 0; i < n; i++){
            if(end <= descMeetings.get(i).start){
                count++;
                end = descMeetings.get(i).end;
            }
        }

        System.out.println(count);
    }


}