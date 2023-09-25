import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int answer =0;
        int jobIndex = 0;
        int endTime = 0;
        int cnt =0;
        
        //요청시간 오름차순
        Arrays.sort(jobs,(j1,j2)->j1[0]-j2[0]);
        
        //끝나는 시간 이내 같이 시작하는 애들 중 가장 짧은 처리시간순
        PriorityQueue<int[]> pq = new PriorityQueue<>((j1,j2)->j1[1]-j2[1]);
        
        while(cnt < jobs.length) {
            
            while(jobIndex < jobs.length && jobs[jobIndex][0]<=endTime) {
                pq.add(jobs[jobIndex++]);
            }
            
            if(jobIndex < jobs.length && pq.isEmpty()) {
                endTime = jobs[jobIndex][0]; // 0 3 ,1 2,  2 4
            } else {
                
                int[] spot = pq.poll();
                answer+= spot[1]+ (endTime - spot[0]); // 실행시간 + 대기시간
                endTime += spot[1]; // 작업 완료 시간
                cnt++;
                
            }
        }
        
        return (int) Math.floor(answer/jobs.length);
    }
}
