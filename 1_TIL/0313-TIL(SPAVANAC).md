# TIL (Today I Learned)

### **SPAVANAC**

###  https://www.acmicpc.net/problem/2884\

<br>

### 문제 설명

Every school morning Mirko is woken up by the sound of his alarm clock. Since he is a bit forgetful, quite often he leaves the alarm on on Saturday morning too. That's not too bad though, since he feels good when he realizes he doesn't have to get up from his warm and cozy bed.

He likes that so much, that he would like to experience that on other days of the week too! His friend Slavko offered this simple solution: set his alarm clock 45 minutes early, and he can enjoy the comfort of his bed, fully awake, for 45 minutes each day.

Mirko decided to heed his advice, however his alarm clock uses 24-hour notation and he has issues with adjusting the time. Help Mirko and write a program that will take one time stamp, in 24-hour notation, and print out a new time stamp, 45 minutes earlier, also in 24-hour notation.

Note: if you are unfamiliar with 24-hour time notation yourself, you might be interested to know it starts with 0:00 (midnight) and ends with 23:59 (one minute before midnight).

<!--more-->



<br>

### 입력

- The first and only line of input will contain exactly two integers H and M (0 ≤ H ≤ 23, 0 ≤ M ≤ 59) separated by a single space, the input time in 24-hour notation. H denotes hours and M minutes.

<br>

### 출력

- The first and only line of output should contain exactly two integers, the time 45 minutes before input time.

<br>

### 입출력 예

| 입력  | 출력  |
| ----- | ----- |
| 10 10 | 9 25  |
| 0 30  | 23 45 |
| 23 40 | 22 55 |



<br>



---------------



<br>



### 문제풀이

- 24시간 표현 사용
- 입력은 공백 한 칸을 기준으로 구분 되고 출력시 불필요한 0은 사용하지 않음 
- BufferedReader 로 입력받아 연산
  - 입력받은 분 (m) 을 45 기준으로 보다 작으면 시간(h) 를 -1 해주고
  - 아닐 경우에는 m - 45 를 해준다
  - h가 0보다 작으면 24시간 표현이기 때문에 23으로 수정 필요 

```java
import java.io.*;

// 알람 시계를 45 분 일찍 설정하면 매일 45 분 동안 완전히 깨어있는 편안한 침대를 즐길 수 있습니다.
// 24 시간 표기법으로 45 분 전에 새 타임 스탬프를 인쇄하십시오.
// 0:00 (자정)에서 시작하여 23:59 (자정 1 분 전)로 끝

class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
      
        int h = Integer.parseInt(str[0]); // 시간
        int m = Integer.parseInt(str[1]); // 분 
        
        if (m < 45) { // 1. 입력받은 분이 45 보다 작은지 체크
            h --; // 1-2. 작다면 시간을 1 감소 
            m = 60 - (45 - m); // 분 감소 
            
            if (h < 0) { // 2. 시간이 0보다 작은지 체크
                h = 23; // 작다면 시간을 23으로 변경
            }
            
            System.out.println(h + " " + m);
        } else {
            System.out.println(h + " " + (m - 45));
        }
    }
}

```

<br>

### 정리

- `readLine()` 을 통해 입력 받으면 한 행을 전부 읽기 때문에 공백을 단위로 분리해준다.
- **split(" ")** 을 이용해서 공백 단위로 나눠준 뒤 String 배열로 저장 -> 첫번째를 시간, 두번째를 분으로 저장했다.
- 문제를 보고 따로 종이에 정리하지 않고서는 바로 해결법을 찾을 수 없는데, 익숙해지면 쓰지 않아도 풀 수 있을까. 정진해야겠다.