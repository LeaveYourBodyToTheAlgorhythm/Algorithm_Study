## 접근
><a href="https://www.acmicpc.net/problem/12919">A와B 2</a>
- 어떤 문자열 S가 T가 될 수 있는지 검사한다.
- S에 A를 추가하는 경우에는 문자열 가장 마지막에 추가
- S에 B를 추가하는 경우 문자열 가장 마지막에 추가하고 뒤집는다.
- 이런 과정을 거치면서 T가 될 수 있는가 검사

## 실패사유  
단순히 BFS로 풀었고 11%에서 시간초과가 발생
생각해보면 S에 대해서 각각 A를 더하는 과정, B를 더해서 뒤집는 과정을 반복하였다.

하지만 우리에게 정답이 주어져 있기 때문에 위 방법보다 경우의 수를 더 적게 가져갈 수 있다.
정답 T를 이정표 삼아서 A가 추가된 B가 추가된 경우를 따라가 보는 것이다.
바로 T에서 시작해서 빼가며 S가 될 수 있는가 검사합니다.

## 방법
아래는 풀이에서 DFS만 따로 가져온 것이다.
```java
static int makeS(String target, String start) {


        if(target.length() == start.length()) {
            if(target.equals(start)){
                return 1;
            }
            return 0;
        }

        int result = 0;

        if(target.charAt(0)=='B') {
            StringBuffer sb = new StringBuffer(target.substring(1));
            result += makeS(sb.reverse().toString(),start);
        }

        if(result != 1 && target.charAt(target.length()-1)=='A') {
            result +=makeS(target.substring(0,target.length()-1),start);
        }

        return result > 0? 1:0;
    }

```
