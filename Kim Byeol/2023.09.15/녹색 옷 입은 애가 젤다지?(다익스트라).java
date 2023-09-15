package org.prgrms;

import java.util.*;
import java.io.*;

class Main{

    static int[][] answer;
    static int[][] cave;
    static int N;
    static List<Integer> trueAnswer = new ArrayList<>();

    static int[] cx= {-1,1,0,0};
    static int[] cy= {0,0,-1,1};

    static class Cost{
        int x;
        int y;
        int cost;
        public Cost(int x, int y, int cost){
            this.x=x;
            this.y = y;
            this.cost = cost;
        }
    }

    static void BFS(){
        PriorityQueue<Cost> Q = new PriorityQueue<>((c1,c2)->{
            return c1.cost -c2.cost;
        });
        Q.offer(new Cost(0,0,cave[0][0]));
        answer[0][0]=cave[0][0];
        while(!Q.isEmpty()){
            Cost min_starter = Q.poll();
            //이미 누군가에 의해서 최소값이 넣어졌지만 안에 중복의 vertex가 담겨져 있어서
            // 마지막에 꺼낸 경우
            if(min_starter.cost>answer[min_starter.x][min_starter.y]) continue;
            for(int i=0;i<4;i++){
                int X = min_starter.x + cx[i];
                int Y = min_starter.y + cy[i];

                if(X<0 || X>=N || Y<0 || Y >=N) continue;

                Cost v = new Cost(X,Y,cave[X][Y]);

                if(answer[v.x][v.y]>v.cost+min_starter.cost) {
                    answer[v.x][v.y] = v.cost + min_starter.cost;
                    Q.offer(new Cost(v.x,v.y,v.cost+min_starter.cost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N==0) break;

            answer = new int[N][N];
            for (int[] a : answer) {
                Arrays.fill(a, Integer.MAX_VALUE);
            }

            cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                cave[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            BFS();

            trueAnswer.add(answer[N - 1][N - 1]);
        }

        for(int i=0;i<trueAnswer.size();i++) {
            System.out.println("Problem "+(i+1)+": "+trueAnswer.get(i));
        }

        br.close();
    }
}
