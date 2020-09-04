# [Java의 정석 연습문제] 

## Chapter2 변수

**[2-1] 다음 표의 빈칸에 8개의 기본형(primitive type)을 알맞은 자리에 넣으시오.**

| 종류/크기 | 1byte   | 2byte | 4byte | 8byte  |
| --------- | ------- | ----- | ----- | ------ |
| 논리형    | boolean |       |       |        |
| 문자형    |         | char  |       |        |
| 정수형    | byte    | short | int   | long   |
| 실수형    |         |       | float | double |



**[2-2] 다음 중 키워드가 아닌 것은? (모두 고르시오)**  

a. if

**b. True**

**c. NULL**

<span style="color:red">☠️☠️d. class</span> ☠️☠️

**e. System**



**[2-3] char타입의 변수에 저장될 수 있는 정수 값의 범위는? (10진수로 적으시오)**

**0 ~ 65535**



**[2-4] 다음 중 변수를 잘못 초기화한 것은? (모두 고르시오)**

**a. byte b = 256;** 

**b. char c = ' ';** 

**c. char answer = 'no';** 

**d. float f = 3.14;**

e. double d = 1.4e3f; 

 

**[2-5] 다음의 문장에서 리터럴, 변수, 상수, 키워드를 적으시오.**

```java
int i = 100;
long l = 100L;
final float PI = 3.14f;
```

\- 리터럴 : **100, 100L, 3.14f**

\- 변수 : **i, l**

\- 키워드 : **int, long, final, float**

\- 상수 : **PI**



**[2-6] 다음 중 기본형(primitive type)이 아닌 것은?**

a. int

**b. Byte**

c. double

d. boolean



**[2-7] 다음 문장들의 출력 결과를 적으세요. 오류가 있는 문장의 경우, 괄호 안에 '오류'라고 적으시오.**

System.out.println("1" + "2") → **"12"**

System.out.println(true + "") → **"true"**

System.out.println('A' + 'B') → **131**

System.out.println('1' + 2) → **51**

System.out.println('1' + '2') → **99**

System.out.println('J' + 'ava') → **"Java"**

System.out.println(true + null) → **오류**



**[2-8] 아래는 변수 x, y, z의 값을 서로 바꾸는 예제이다. 결과와 같이 출력되도록 (1)에 알맞은 코드를 넣으시오.**

```java
public class Exercise2_8 {
  public static void main(String[] args) {
    int x = 1;
    int y = 2;
    int z = 3;
    
    /*
    	알맞은 코드 작성 (1)
    */
    
    System.out.println("x = " + x); // 2
    System.out.println("y = " + y); // 3
    System.out.println("z = " + z); // 1
  }
}
```

```java
int tmp = x;
x = y;
y = z;
z = tmp;
```



## Chapter3 연산자

**[3-1]** **다음 중 형변환을 생략할 수 있는 것은? (모두 고르시오)**

```java
byte b = 10;
char ch = 'A';
int i = 100;
long l = 1000L;
```

a. b = (byte)i;

b. ch = (char)b;

c. short s = (short)ch; 

**d. float f = (float)l;**

**e. i = (int)ch;**



**[3-2] 다음 연산의 결과를 적으시오.**

```java
class Exercise3_2 { 
  public static void main(String[] args) { 
    int x = 2; 
    int y = 5; 
    char c = 'A'; // 'A'의 문자코드는 65 
    
    System.out.println(1 + x << 33); 							 // 6
    System.out.println(y >= 5 || x < 0 && x > 2);  // true
    System.out.println(y += 10 - x++);  					 // 13
    System.out.println(x+=2);  										// 14
    System.out.println( !('A' <= c && c <='Z') ); // false
    System.out.println('C' - c); 									// 2
    System.out.println('5'-'0');  								// 5
    System.out.println(c + 1); 										// 66
    
    /*********** 여기서부터 모름 ******************/
    
    System.out.println(++c); 
    System.out.println(c++); 
    System.out.println(c); 
  } 
}
```



**[3-3] 아래는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다. 만일 변수 num의 값이 '456'이라면 '400'이 되고, '111'이라면 '100'이 된다. (1)에 알맞은 코드를 넣으시오.** 

```java
class Exercise3_3 { 
	public static void main(String[] args) { 
		int num = 456; 
		System.out.println( /* (1) */ ); 
	} 
}

실행결과 : 400
```

```java
num / 100 * 100
```



**[3-4] 아래의 코드는 사과를 담는데 필요한 바구니 수를 구하는 코드이다. 만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면, 13개의 바구니가 필요할 것이다. (1)에 알맞은 코드를 넣으시오.**

```java
class Exercise3_4 { 
  public static void main(String[] args) { 
    int numOfApples = 123; // 사과의 개수 
    int sizeOfBucket = 10; // 바구니의 크기 (바구니에 담을 수 있는 사과의 개수)
    int numOfBucket = ( /* (1) */ ) ;

    System.out.println("필요한 바구니의 수 :"+numOfBucket);
  }
}

실행결과 : 13
```

```java
numOfApples / sizeOfBucket + sizeOfBucket > 0 ? 1 : 0;
```



**[3-5] 아래는 변수 num의 값에 따라 '양수', '음수', '0'을 출력하는 코드이다. 삼항 연산자를 이용해서 (1)에 알맞은 코드를 넣으시오. (Hint. 삼항 연산자를 두 번 사용하라.)**

```java
class Exercise3_5 { 
  public static void main(String[] args) { 
    int num = 10; 
    System.out.println( /* (1) */ ); 
  } 
}

실행결과 : 양수
```

```java
num < 0 ? "음수" : (num > 0 ? "양수" : 0)
```



☠️☠️☠️

**[3-6] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다. 변환공식이 'C = 5/9 * (F-32)'라고 할 때, (1)에 알맞은 코드를 넣으시오. 단, 변환 결과값은 소수점 셋째자리에서 반올림해야한다. (Math.round()를 사용하지 않고 처리할 것)**

 ☠️☠️☠️(틀렷음 )

```java
class Exercise3_7 {
  public static void main(String[] args) { 
    int fahrenheit = 100; 
    float celcius = ( /* (1) */ );

    System.out.println("Fahrenheit:"+fahrenheit); 
    System.out.println("Celcius:"+celcius); 
  }
}

실행결과 :
Fahrenheit:100 
Celcius:37.78
```



## Chapter4 조건문과 반복문

**[4-1] 다음의 문장들을 조건식으로 표현하라.**

1. int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식

    ```java
    if ( x > 10 && x < 20)
    ```

2. char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식

   ```java
    if(ch != '' || ch != '\t')
   ```

3. char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식

   ```java
   if(ch == 'x' && ch == 'X')
   ```

4. char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식

   ```java
   if(ch >= '0' && ch <= '9')
   ```

5. char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식

   ```java
   if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
   ```

6. int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인 조건식

   ```java
   if(( year % 400 == 0) || ( year % 4 == 0 && year % 100 != 0))
   ```

7. boolean형 변수 powerOn가 false일 때 true인 조건식

   ```java
   if(!powerOn)
   ```

8. 문자열 참조변수 str이 "yes"일 때 true인 조건식

   ```java
   if(str.equals("yes"))
   ```

   

**[4-2] 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.**

```java
public static void main(String[] args) {
  int num = 0;
  for(int i = 1; i <= 20; i++){
    if(i % 2 != 0 && i % 3 != 0){
      num += i;
    }
  }
  System.out.println(num);
} 

결과 : 73
```



**[4-3] 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하시오.**

```java
public static void main(String[] args) {
  int sum = 0;
  int num = 0;

  for(int i = 1; i <= 10; i ++){
		sum += i;
    num += sum;
  }// end for
  
  System.out.println(num);
}
결과 : 220
```



☠️☠️☠️

**[4-4] 1+(-2)+3+(-4)+...와 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는지 구하시오.**

☠️☠️☠️ ( 못풀엇음 )





**[4-5] 다음의 for문을 while문으로 변경하시오.**

```java
public class Exercise4_5 { 
	public static void main(String[] args) { 
		for(int i=0; i<=10; i++) { 
			for(int j=0; j<=i; j++) 
				System.out.print("*"); System.out.println(); 
		} 
	} // end of main 
} // end of class

```

```java
public static void main(String[] args) {
	int i = 0;

	while (i <= 10) {
		int j = 0;
		while (j <= i) {
			System.out.print("*");
			j++;
		}
		System.out.println();
		i++;
	}// end while
}
```



**[4-6] 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하시오.**

```java
public static void main(String[] args) {
  for (int i = 1; i <= 6; i++) {
    for (int j = 1; j <= 6; j++) {
      if (i + j == 6) {
        System.out.printf("%d + %d = %d", i, j, i+j);
      }
    }
  } // end for
}
```



**[4-7] 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 만일 문자열이 "12345"라면, '1+2+3+4+5'의 결과인 15를 출력이 출력되어야 한다. (1)에 알맞은 코드를 넣으시오.**

**(Hint. String클래스의 charAt(int i)를 사용)**

```java
class Exercise4_7 { 
  public static void main(String[] args) { 
    String str = "12345"; 
    int sum = 0; 
    for(int i = 0; i < str.length(); i++) { 
      /* 알맞은 코드를 넣어 완성하시오 (1) . */ 
    } 
    System.out.println("sum = " + sum); 
  } 
}
```

```java
sum += str.charAt(i) - '0';
```



**[4-8] Math.random()을 이용해서 1부터 6사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하라. (1)에 알맞은 코드를 넣으시오.** 

```java
class Exercise4_8 {
	public static void main(String[] args) { 
		int value = ( /* (1) */ ); 
		System.out.println("value:"+value); 
	}
}
```

```java
(int)(Math.random() * 6) + 1
```





**[4-9] int타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하라. 만일 변수 num의 값이 12345라면, '1+2+3+4+5'의 결과인 15를 출력하라. (1)에 알맞은 코드를 넣으시오.**

**[주의] 문자열로 변환하지 말고 숫자로만 처리해야 한다.**

```java
class Exercise4_9 {
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0; 
    
    /* 알맞은 코드를 넣어 완성하시오 (1) . */
    
		System.out.println("sum=" + sum);
	}
}
```

```java
while (num > 0) {
  sum += num % 10;
  num /= 10;
} // end while
```



**[4-10] 다음은 숫자맞히기 게임을 작성한 것이다. 1과 100사이의 값을 반복적으로 입력해서 컴퓨터가 생각한 값을 맞추면 게임이 끝난다. 사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다. 사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번 만에 숫자를 맞췄는지 알려준다. (1)~(2)에 알맞은 코드를 넣어 프로그램을 완성하시오.**

```java
class Exercise4_14 {
  public static void main(String[] args) { 
    
    // 1~100사이의 임의의 값을 얻어서  answer에 저장한다.
    int answer = /* (1) */; 
    int input = 0; //사용자입력을 저장할 공간 
    int count = 0; //시도횟수를 세기위한 변수

    // 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용 
    java.util.Scanner s = new java.util.Scanner(System.in); 

    do { 
      count++; 
      System.out.print("1과 100사이의 값을 입력하세요  :"); 
      input = s.nextInt(); //입력받은 값을 변수 input에 저장한다. 

      /* 알맞은 코드를 넣어 완성하시오 (2) . */ 
      
    } while(true); //무한반복문
  } // end of main 
} // end of class

실행결과 :
1과 100 사이의 값을 입력하세요 :50 
  더 큰 수를 입력하세요.  
1과 100 사이의 값을 입력하세요 :75 
  더 큰 수를 입력하세요. 
1과 100 사이의 값을 입력하세요 :87 
  더 작은 수를 입력하세요.
1과 100 사이의 값을 입력하세요 :80 
  더 작은 수를 입력하세요. 
1과 100 사이의 값을 입력하세요 :77 
  더 작은 수를 입력하세요. 
1과 100 사이의 값을 입력하세요 :76 
  맞췄습니다. 
  시도횟수는 6 번입니다.
```

```java
(1)
(int)(Math.random() * 100) + 1

(2)
if (answer > input ) {
	System.out.println("더 큰 수를 입력하세요.");
} else if (answer < input ) {
	System.out.println("더 작은 수를 입력하세요");
} else {
  System.out.println("맞췄습니다.");
	System.out.println("시도횟수는 "+ count + "번 입니다.");
  break;
}
```





## Chapter5 배열

**[5-1] 다음은 배열을 선언하거나 초기화한 것이다. 잘못된 것을 고르고 그 이유를 설명하시오.**

1. int[] = arr[];
2. int[] arr = {1,2,3,};
3. int[] arr = new int[5];
4. **int[] arr = new int[5]{1,2,3,4,5};** 
   - 크기 지정할 수 없음
5. **int arr[5];**
   - 배열 선언 할 때 크기 지정 할 수 없음
6. int[] arr[] = new int[3]\[ ]



**[5-2] 다음과 같은 배열이 있을 때, arr[3].length의 값은 얼마인가?**

```java
int[][] arr = { 
  { 5, 5, 5, 5, 5}, 
  {10, 10, 10}, 
  {20, 20, 20, 20}, 
  {30, 30} 
};

결과 : 2 
```



**[5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.**

```java
class Exercise5_3 {
	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50 };
		int sum = 0;
		/*
		 * 알맞은 코드를 넣어 완성하시오 (1) .
		 */
		System.out.println("sum=" + sum);
	}
}

```

```java
for(int i = 0; i < arr.length; i++)
	sum += arr[i];
}
```



**[5-4] 2차원 배열 arr에 담긴 모든 값의 총합과 평균을 구하는 프로그램을 완성하시오.**

```java
class Exercise5_4 {
	public static void main(String[] args) {
		int[][] arr = { 
      { 5, 5, 5, 5, 5 }, 
      { 10, 10, 10, 10, 10 },
      { 20, 20, 20, 20, 20 }, 
      { 30, 30, 30, 30, 30 } 
    };

		int total = 0;
		float average = 0;
		
		/*
		 * 알맞은 코드를 넣어 완성하시오 (1) .
		 */
		
		System.out.println("total=" + total);
		System.out.println("average=" + average);
	} // end of main

} // end of class

실행결과 :
total=325 
average=16.25
```

```java
for(int i = 0 ;i < arr.length; i++){
	for(int j =0; j < arr[i].length; j++){
		total += arr[i][j];
	}
} // end for

average = total / (float)(arr.length * arr[0].length);
```



**[5-5] 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다. (1)~(2)에 알맞은 코드를 넣어서 프로그램을 완성하시오. ([참고] Math.random()을 사용했기 때문에 실행결과와 다를 수 있다.)**

```java
class Exercise5_5 {
  public static void main(String[] args) {
    int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int[] ball3 = new int[3];

    // 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
    for (int i = 0; i < ballArr.length; i++) {
      int j = (int) (Math.random() % ballArr.length);
      int tmp = 0;

      /*
			 * 알맞은 코드를 넣어 완성하시오 (1) .
			 */

    }
    // 배열 ballArr의 앞에서 3개의 수를 배열 ball3로 복사한다.
    /* (2) */

    for (int i = 0; i < ball3.length; i++) {
      System.out.print(ball3[i]);
    }
  } // end of main
} // end of class

실행결과 : 465
```

```java
(1)
tmp = ballArr[i];
ballArr[i] = ballArr[j];
ballArr[j] = tmp;

(2)
for(int i = 0; i < ballArr.length; i++){
	ball3[i] = ballArr[i];
}

// (2) 정답 : 
// System.arraycopy(ballArr, 0, ball3 , 0, 3); 
// ballArr[0]에서 ball3[0]으로 3개의 데이터를 복사.

```



**[5-6] 단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다. 실행결과와 같이 동작하도록 예제의 빈 곳을 채우시오.**

```java
import java.util.Scanner;

class Exercise5_6 {
	public static void main(String args[]) {
		String[] words = { "television", "computer", "mouse", "phone" };

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); // String을 char[]로 변환

			/*
			 * (1) 알맞은 코드를 넣어 완성하시오 . 
			 * char배열 question에 담긴 문자의 위치를 임의로 바꾼다.
			 */

			System.out.printf("Q%d. %s의 정답을 입력하세요 .>", i + 1, new String(question));
			String answer = scanner.nextLine();

			// trim()으로 answer의 좌우 공백을 제거한 후 , equals로 word[i]와 비교
			if (words[i].equals(answer.trim()))
				System.out.printf("맞았습니다.%n%n");
			else
				System.out.printf("틀렸습니다.%n%n");
		}
	} // main의 끝
}

실행결과 :
Q1. lvtsieeoin의 정답을 입력하세요.> television 
맞았습니다.

Q2. otepcumr의 정답을 입력하세요.> computer 
맞았습니다.

Q3. usemo 의 정답을 입력하세요.> asdf 
틀렸습니다.
  
Q4. ohpne 의 정답을 입력하세요.> phone 
맞았습니다.
```

```java
for(int j = 0; j < question.length; j++){
  char tmp = question[i];
  question[i] = question[j];
  question[j] = tmp;
}

// 정답
for(int j =0; j < question.length; j++){
	int idx = (int)(Math.random() * question.length);  // 이거 왜 함???
	char tmp = question[i];
	question[i] = question[idx];
	question[idx] = tmp;
}
```





## Chapter6 객체지향 프로그래밍1

**[6-1] 다음과 같은 멤버변수를 갖는 Student 클래스를 정의하시오.**

| 타입   | 변수명 | 설명     |
| ------ | ------ | -------- |
| String | name   | 학생이름 |
| int    | ban    | 반       |
| int    | no     | 번호     |
| int    | kor    | 국어점수 |
| int    | eng    | 영어점수 |
| int    | math   | 수학점수 |

```java
public class Student {
  String name;
	int ban;
  int no;
  int kor;
  int eng;
  int math;
}
```



**[6-3] 문제 6-3에서 정의한 Student클래스에 다음과 같이 정의된 두 개의 메서드 getTotal()과 getAverage()를 추가하시오.**

```java
/*
 * 1. 메서드명 : getTotal
   기능 : 국어(kor), 영어(eng), 수학(math)의 점수를 모두 더해서 반환한다.
   반환타입 : int
   매개변수 : 없음

 * 2. 메서드명 : getAverage
   기능 : 총점(국어점수+영어점수+수학점수)을 과목수로 나눈 평균을 구한다.
         소수점 둘째자리에서 반올림할 것.
   반환타입 : float
   매개변수 : 없음
*/

class Exercise6_4 {
	public static void main(String args[]) { 
		Student s = new Student();  
		s.name = "홍길동"; 
		s.ban = 1; 
		s.no = 1; 
		s.kor = 100;  
		s.eng = 60; 
		s.math = 76;
		
		System.out.println("이름 :"+s.name); 
		System.out.println("총점 :"+s.getTotal());  
		System.out.println("평균 :"+s.getAverage());
	}
}
class Student { 
	/* (1) 알맞은 코드를 넣어 완성하시오.  */ 
}

결과 : 
이름 : 홍길동
총점 : 236
평균 : 78.7

```

```java
(1) 
String name;
int ban;
int no;
int kor;
int eng;
int math;

public int getTotal() {
	return kor + eng + math;
}

public float getAverage(){
	return (int)(getTotal() / 3f * 10 + 0.5f) /10f;
}
```



**[6-5] 다음의 코드에 정의된 변수들을 종류별로 구분해서 적으시오.**

```java
class PlayingCard { 
  int kind; 
  int num; 

  static int width; 
  static int height; 

  PlayingCard(int k, int n) { 
    kind = k; 
    num = n; 
  } 

  public static void main(String args[]) { 
    PlayingCard card = new PlayingCard(1,1); 
  } // main
}// end class
```

\- 클래스변수 (static변수) : width, height

\- 인스턴스변수 : kind, num

\- 지역변수 : k, n



**[6-7] 다음은 컴퓨터 게임의 병사(marine)를 클래스로 정의한 것이다. 이 클래스의 멤버 중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가? (단, 모든 병사의 공격력과 방어력은 같아야 한다.)**

```java
class Marine { 
  int x=0, y=0; //Marine의 위치좌표 (x,y) 
  int hp = 60; //현재 체력 
  int weapon = 6; //공격력 
  int armor = 0; //방어력

  void weaponUp() { 
    weapon++; 
  }

  void armorUp() { 
    armor++; 
  } 

  void move(int x, int y) { 
    this.x = x; 
    this.y = y; 
  } 
}
```

```java
// 공격력과 방어력은 모두 같아야 하기 때문
static int weapon = 6; //공격력 
static int armor = 0; //방어력

// 메서드는 static 변수를 가지고 사용하기 때문에 static method
static void weaponUp() { 
  weapon++; 
}

static void armorUp() { 
  armor++; 
}

```



**[6-9] 다음 중 this에 대한 설명으로 맞지 않은 것은? (모두 고르시오)**

a. 객체 자신을 가리키는 참조변수이다.

**b. 클래스 내에서라면 어디서든 사용할 수 있다.**

​	→  인스턴스메서드에서만 사용가능. 클래스 멤버(static이 붙은 변수나 메서드)에는 사용할 수 없다.

c. 지역변수와 인스턴스변수를 구별할 때 사용한다.

d. 클래스 메서드 내에서는 사용할 수 없다.



**[6-11] 다음 중 아래의 add메서드를 올바르게 오버로딩 한 것은? (모두 고르시오)**

```java 
long add(int a, int b) { return a+b; }
```

a. long add(int x, int y) { return x+y; }

**b. long add(long a, long b) { return a+b; }**

**c. int add(byte a, byte b) { return a+b; }**

**d. int add(long a, int b) { return (int)(a+b); }**



**[6-13] 다음 중 인스턴스변수의 초기화 순서가 올바른 것은?**

a. **기본값-명시적초기화-초기화블럭-생성자**

b. 기본값-명시적초기화-생성자-초기화블럭

c. 기본값-초기화블럭-명시적초기화-생성자

d. 기본값-초기화블럭-생성자-명시적초기화



**[6-15] 호출스택이 다음과 같은 상황일 때 옳지 않은 설명은? (모두 고르시오)**

![자바의 정석 연습문제 - chapter6](https://t1.daumcdn.net/cfile/tistory/99172C435DA80E8734)

a. 제일 먼저 호출스택에 저장된 것은 main메서드이다.

**b. println메서드를 제외한 나머지 메서드들은 모두 종료된 상태이다.**

​	→ 호출스택의 제일 위에 있는 메서드가 현재 수행중인 메서드이며, 호출스택 안의 나머지 메서드들은 대기상태이다.

c. method2메서드를 호출한 것은 main메서드이다.

d. println메서드가 종료되면 method1메서드가 수행을 재개한다.

e. main-method2-method1-println의 순서로 호출되었다.

f. 현재 실행중인 메서드는 println뿐이다.



**[6-17] 다음과 같이 정의된 메서드를 작성하고 테스트하시오. ([주의] Math.random()을 사용하는 경우 실행결과와 다를 수 있음.)**

```java
/* 메서드명 : shuffle
 *		기능 : 주어진 배열에 담긴 값의 위치를 바꾸는 작업을 반복하여 뒤섞이게 한다.
 *          처리한 배열을 반환한다.
 * 반환타입 : int[]
 * 매개변수 : int[] arr - 정수값이 담긴 배열
*/

class Exercise6_17 { 
	/* 
	 *  (1) shuffle 메서드를 작성하시오. 
	 * */

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(java.util.Arrays.toString(original));

		int[] result = shuffle(original);
		System.out.println(java.util.Arrays.toString(result));
	}
}
```

```java
public static int[] shuffle(int[] arr) {
	for (int i = 0; i < arr.length; i++) {
		int j = (int)Math.random() * arr.length;
		
    int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
    
	} // end for
	return arr;
}
```



**[6-19] Tv클래스를 주어진 로직대로 완성하시오. 완성한 후에 실행해서 주어진 실행결과와 일치하는지 확인하라. ([참고] 코드를 단순히 하기 위해서 유효성검사는 로직에서 제외했다.)**

```java
class MyTv {
	boolean isPowerOn;
	int channel;
	int volume;

	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;

	void turnOnOff() {
		// (1) isPowerOn의 값이 true면 false로, false면 true로 바꾼다.
	}

	void volumeUp() {
		// (2) volume의 값이 MAX_VOLUME보다 작을 때만 값을 1 증가시킨다.
	}

	void volumeDown() {
		// (3) volume의 값이 MIN_VOLUME보다 클 때만 값을 1 감소시킨다.
	}

	void channelUp() {
		// (4) channel의 값을 1 증가시킨다.
		// 만일 channel이 MAX_CHANNEL이면 , channel의 MIN_CHANNEL 값을 로 바꾼다.
	}

	void channelDown() {
		// (5) channel의 값을 1 감소시킨다 .
		// 만일 channel이 MIN_CHANNEL이면, channel의 값을 MAX_CHANNEL 로 바꾼다.
	}
} 

class Exercise6_19 {
	public static void main(String args[]) {
		MyTv t = new MyTv();
	
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);

		t.channelDown();
		t.volumeDown();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);

		t.volume = 100;
		t.channelUp();
		t.volumeUp();
		System.out.println("CH:" + t.channel + ", VOL:" + t.volume);
	}
}

[실행결과]
CH: 100, VOL: 0
CH: 99, VOL: 0
CH: 100, VOL: 100
```

```java
(1) 
isPowerOn = !isPowerOn;

(2) 
if (volume < MAX_VOLUME) {
  volume++;
} 

(3) 
if (volume > MIN_VOLUME) {
  volume--;
}

(4) 
if(channel == MAX_CHANNEL) {
	channel = MIN_CHANNEL;
} else {
	channel++;
}

(5)
if (channel == MIN_CHANNEL) {}
	channel = MAX_CHANNEL;
} else {
	channel--;
}
```



**[6-21] 다음과 같이 정의된 메서드를 작성하고 테스트하시오.**

```java
/* 
 * 메서드명: abs
 * 기능 : 주어진 값의 절대값을 반환한다.
 * 반환타입 : int
 * 매개변수 : int value
*/ 

class Exercise6_21 {

	/* (1) abs 메서드를 작성하시오. */

	public static void main(String[] args) {
		int value = 5;
		System.out.println(value + "의 절대값 :" + abs(value));
		value = -10;
		System.out.println(value + "의 절대값 :" + abs(value));
	}
}

[실행결과]
5의 절대값 : 5
-10의 절대값 : 10
```

```java
public static int abs(int value){
	return value >= 0 ? value : -value;
}
```

