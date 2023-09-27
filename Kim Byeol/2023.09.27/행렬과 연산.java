package org.prgrms.decorator;

import java.util.*;

class Solution {
    static Deque<Integer> leftSide = new LinkedList<>();
    static Deque<Integer> rightSide = new LinkedList<>();
    static Deque<Deque<Integer>> inside= new LinkedList<>();
    public int[][] solution(int[][] rc, String[] operations) {

        int X = rc.length;
        int Y = rc[0].length;
        System.out.println(X+" "+Y);

        for(int i=0;i<X;i++) {
            inside.addLast(new LinkedList<>());
            for(int j=0;j<Y;j++) {
                if(j==0) {
                    leftSide.addLast(rc[i][j]);
                    continue;
                }
                if(j==Y-1) {
                    rightSide.addLast(rc[i][j]);
                    continue;
                }
                inside.peekLast().addLast(rc[i][j]);
            }
        }

        for(String o : operations) {
            if(o.equals("ShiftRow")){
                makeShift();
            } else{
                makeRotate();
            }
        }

        int[][] answer = new int[X][Y];
        for(int i=0;i<X;i++) {
            answer[i][0] = leftSide.removeFirst();
            answer[i][Y-1] = rightSide.removeFirst();
           int j=1;
          for(int e : inside.removeFirst()) {
              answer[i][j++] =e;
         }
        }

        return answer;
    }
  
    static void makeRotate() {
        inside.peekFirst().addFirst(leftSide.removeFirst());
        rightSide.addFirst(inside.peekFirst().removeLast());
        inside.peekLast().addLast(rightSide.removeLast());
        leftSide.addLast(inside.peekLast().removeFirst());
    }

    static void makeShift() {
        leftSide.addFirst(leftSide.removeLast());
        inside.addFirst(inside.removeLast());
        rightSide.addFirst(rightSide.removeLast());
    }
}
