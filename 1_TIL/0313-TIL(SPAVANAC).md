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

- `ArrayList` 생성 
- 문제에서 배열 원소는 0 ~ 9의 정수라고 했으니 값이 10인 변수를 생성해 비교
  - 배열의 원소와 변수를 비교 
  - 같지 않다면 리스트에 원소를 추가 -> 변수의 값을 배열의 원소로 초기화
  - 이렇게 하면 중복값을 걸러낼 수 있다
- 배열을 `ArrayList.size()` 로 지정 
- 반복문을 통해 리스트의 value 값을 가져와 배열의 i 번째로 넣어준다 

```java
import java.io.*;

// 알람 시계를 45 분 일찍 설정하면 매일 45 분 동안 완전히 깨어있는 편안한 침대를 즐길 수 있습니다.
// 24 시간 표기법으로 45 분 전에 새 타임 스탬프를 인쇄하십시오.
// 0:00 (자정)에서 시작하여 23:59 (자정 1 분 전)로 끝


class Main {
    public static void main (String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        
        if(m < 45) {
            h --;
            m = 60 - (45 - m);
            
            if (h < 0) {
                h = 23;
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

- 맨 처음 이중 for문과 while() 등만 생각 -> 각 문제에 맞는 방법을 바로 떠올리기 어려움
  - 문제를 **제대로** 읽고 이해하는 능력 필요.... -> 글로 풀이를 읽고 구현하는 시간 
- **문제 해결 전략**
  - 비슷한 문제를 풀어봤나?
  - 단순한 방법에서 시작할 수 있나?
  - 문제를 단순화 시킬 수 있나?
  - 그림으로 그려볼 수 있나?
  - 문제 분해가 가능한가?
  - 뒤에서부터, 혹은 순서를 강제할 수 있나?

