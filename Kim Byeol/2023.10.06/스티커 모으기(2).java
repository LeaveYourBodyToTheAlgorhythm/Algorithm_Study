import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int len = sticker.length;
        int[] firstTake = new int[len];
        int[] firstNotTake = new int[len];
        
        //첫 스티커 뗀 것
        firstTake[0]=sticker[0];
        firstTake[1]=sticker[0];
        for(int i=2;i<len-1;i++) {
            firstTake[i] = Math.max(firstTake[i-1],firstTake[i-2]+sticker[i]);
        }
        
        //첫 스티커 안 뗀 것
        firstNotTake[0]=0;
        firstNotTake[1]=sticker[1];
        for(int i=2;i<len;i++) {
            firstNotTake[i] = Math.max(firstNotTake[i-1],firstNotTake[i-2]+sticker[i]);
        }
        
        return Math.max(firstNotTake[len-1],firstTake[len-1]);
        
    }
   
}
