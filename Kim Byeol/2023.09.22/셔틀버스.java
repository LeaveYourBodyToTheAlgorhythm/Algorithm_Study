import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        PriorityQueue<Integer> timeTable = new PriorityQueue<>(); 
        
        for(String time : timetable) {
            timeTable.add(makeMinutes(time));
        }
        
        int answer = 0;
        int baseTime = 9*60;
        for(int i=0;i<n;i++) {
            int cnt =0;
            int target =0;
            if(timeTable.isEmpty()) break;
            for(int j=0;j<m;j++) {
                if(timeTable.isEmpty()) break;
                target = timeTable.peek();
                if(target<=baseTime) {
                    timeTable.poll();
                    cnt++;
                }
            }
            if(i==n-1) {
                if(cnt == m) {
                    answer = target -1;
                }
                if(cnt < m) {
                    answer = baseTime;
                }
            }
            baseTime += t;
        }
        
        return makeHHMM(answer);
    }
    
    static int makeMinutes(String time) {
        int[] times = Arrays.stream(time.split(":")).mapToInt(t->Integer.parseInt(t)).toArray();
        return times[0]*60 + times[1];
    }
    
    static String makeHHMM (int time) {
        int hour = time/60;
        int minute = time%60;
        String answerH =""+hour;
        String answerM =""+minute;
        if(hour<10){
            answerH = "0"+hour;
        }
        if(minute<10){
            answerM ="0"+minute;
        }
        return answerH+":"+answerM;
    }
}
