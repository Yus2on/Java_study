# CHAPTER 2



## 01. Print() 와 Println()

화면에 글자를 출력할 땐 `System.out.print()` 을 사용한다. 괄호() 안에 출력하고자 하는 내용을 넣으면 된다

```java
System.out.print("Hello, Java"); // "Hello, Java" 출력
System.out.print(3 + 5); // 8 출력
System.out.print("3 + 5"); // "3 + 5" 출력
```

> 괄호() 안에 숫자를 넣으면 계산된 결과가 출력되지만 <span style="color:red">`큰따옴표 " " 안에 넣은 내용은 글자로 간주`</span>  되어 계산되지 않고 입력한 그대로 출력된다.

````java
System.out.print() // 괄호 안의 내용을 출력하고 줄바꿈을 하지 않는다. 바로 뒤에 이어서 출력.
System.out.println() // 괄호 안의 내용을 출력하고 줄바꿈을 한다
 
````

> 자바는 대소문자를 구분한다. System을 system으로 쓰지 않게 조심하기.
>
> * <span style ='color:red'>Intellij 기준 sout -> System.out.println() 자동 완성</span>



```` java
public static void main(String args[]) {
  System.out.println("Hello, world");
  // "Hello, world" 출력
  
  System.out.print("Hello");
  System.out.println("world");
  // "Helloworld" 출력
  
  System.out.print("3 + 5 =");
  System.out.println(3 + 5);
  // "3 + 5 =8" 출력  
}
````







## 02. 덧셈 뺄셈 계산

사칙 연산 (+, -, *, /)이 포함된 식의 결과를 도출하려면 괄호 안에 식을 넣어야 한다.

````java
System.out.println(3 + 5); // 8
````

> 위 문장이 수행되는 과정
>
> > System.out.print( 3 + 5 ); // 괄호 안의 식을 계산한다
> >
> > System.out.print( 8 ); // 식이 계산 결과로 바뀌어 8이 출력된다.



덧셈, 뺄셈 외에도 곱셈, 나눗셈같은 `연산자(Operatio)` 가 있다.

```` java
public static void main(String args[]) {
  System.out.println(5 + 3);
  System.out.println(5 - 2);
  System.out.println(5 * 3);
  System.out.println(5 / 3); // 정수 나누기 정수의 결과 -> 정수

  /**
  * 8
  * 3
  * 15
  * 1
  * 을 출력
  */
}
````





## 03.  변수의 선언과 저장

##### `변수란,` 하나의 값을 저장할 수 있는 저장공간.

- 값을 저장해 둘 공간이 필요한데 그 공간을 `변수(Variable)` 이라고 한다.
- 변수가 필요하다면 먼저 변수를 선언해야한다.

```` java
public static void main(String args[]) {
  // 변수타입 변수이름; 으로 선언
  int x; // 정수 (integer)타입을 저장하기 위한 변수 x 선언 하였다. --> 변수의 선언
  x = 5; // 변수 x에 5를 대입 된다. --> 변수에 대입
  x = 3; // 기존의 값 5는 지워지고 3이 대입 된다

  //int x; int x = 5; 를 한 줄로 처리
  int x = 5;
  System.out.println(x); // x 의 값인 5가 출력된다
}  
````

> '=' 의 의미는 같다가 아니라 오른쪽 값을 왼쪽에 저장한다는 의미. **대입연산자(assignment operator)** 이다.



매번 다른 숫자의 계산 결과를 얻고싶다면 변수를 이용하여 각 변수에 다른 값을 저장하면 된다.

```` java
public static void main(String args[]) {
  int x = 5;
	int y = 3;

  System.out.println(x + y);
  System.out.println(x - y);
  System.out.println(x * y);
  System.out.println(x / y);
  
  /**
  * 8
  * 3
  * 15
  * 1
  * 을 출력
  */
}  
````

> x, y의 값이 바뀌어도  출력문 System.out.println(x + y); 을 변경하지 않아도 된다.





## 04. 변수의 타입

변수를 선언할 때,  변수에 저장할 값의 종류에 따라 변수의 타입이 다르다. 변수의 타입은 `참조형` 과   `8개의 기본형` 이 있다.

**변수의 타입은 리터럴의 타입에 의해 결정된다** 

| 분류 |            변수의 타입            |                             설명                             |
| :--: | :-------------------------------: | :----------------------------------------------------------: |
| 숫자 |  **int**(4byte)<br/>long(8byte)   | 정수 (integer) 를 저장하기 위한 타입<br/>(20억이 넘으면 long) |
|      | float(4byte)<br>**double(8byte)** | 실수(floating-point-number) 를 저장하기 위한 타입<br> -> float는 오차없이 **7자리**<br>->  double은 **15자리** |
| 문자 |               char                |            문자 (character) 를 저장하기 위한 타입            |
|      |              String               |       여러 문자( 문자열, String)를 저장하기 위한 타입        |

```` java
public static void main(String args[]) {
  int x = 100;      // 정수(integer)를 저장할 변수의 타입은 int 로 한다
  double pi = 3.14; // 실수를 저장할 변수의 타입은 double 로 한다
  char ch = 'a';    // 문자(1개)를 저장할 변수의 타입은 char 로 한다
  String str = "abcd";    // 여러 문자(0~n개)를 저장할 변수의 타입은 String 로 한다
  
  System.out.println(x);
  System.out.println(pi);
  System.out.println(ch);
  System.out.println(str);
  
  /**
  * 100
  * 3.14
  * a
  * abcd
  * 을 출력
  */
  
}  
````





## 05. 상수와 리터럴

`상수(Constant)` 는 변수와 마찬가지로 값을 저장할 수 있는 공간이지만, **한번 값을 저장하면 다른 값으로 변경할 수 없다.**

변수의 타입 앞에 키워드 `final` 를 붙여 만든다.

````java
public static void main(String args[]) {
  final int MAX_SPEED;
  MAX_SPEED = 100; // 가능. 상수에 처음으로 값을 저장
  MAX_SPEED = 10;  // 에러. 상수에 저장된 값을 변경할 수 없음
  
}
````

> - 상수의 이름은 모두 대문자로 하는 것이 관례이다.
> - 여러 단어로 이루어져 있을 경우 '-' 로 구분한다



#### 리터럴(**Literal**)

'상수'의 다른 이름.

```` 
변수 (Variable) : 하나의 값을 저장하기 위한 공간
상수 (Constant) : 값을 한버만 저장할 수 있는 공간
리터럴 (Literal) : 그 자체로 값을 의미하는 것.(정확히 값과 리터럴은 다른 것으로 리터럴은 변수의 값이 변하지 않는 데이터. 메모리 위치 안의 값 을 의미한다.)
````

(![3.상수](http://www.soen.kr/book/java/book/323.files/image004.png))





## 06. 리터럴의 타입과 접미사

|  종류  |            리터럴             |                   접미사                   |
| :----: | :---------------------------: | :----------------------------------------: |
| 논리형 |          false, true          |                    없음                    |
| 정수형 | 123, 0b01010, 077, 0xFF, 100L |  **<span style = "color: red">L</span>**   |
| 실수형 |  3.14, 3.0e8, 1.4f, 0x1.0p-1  | **<span style = "color: red">f</span>**, d |
| 문자형 |        'A', '1', '\n'         |                    없음                    |
| 문자열 |  "ABC", "1234", "A", "true"   |                    없음                    |

> 정수형과 실수형에는 여러 타입이 존재하므로, 리터럴에 접미사를 붙여서 타입을 구분한다.
>
> - 정수형 -> long 타입 : 접미사 'l', 'L'
>
>   ​			-> 접미사가 없을 경우 int 타입의  리터럴
>
>   ​			-> byte 와 short 타입의 리터럴은 별도로 존재하지 않으며, int 타입의 리터럴 사용
>
> - 실수형 -> float 타입 : 접미사 'f', 'F'
>
>   ​			-> double 타입 : 접미사 'd', 'D'

````java
public static void main(String args[]) {
  // 10진수 외에도 2, 8, 16 진수로 표현된 리터럴을 변수에 저장할 수 있다
  // 16진수라는 것을 표시하기 위해 '0x' 또는 '0X'
  // 8진수라는 것을 표시하기 위해 '0' 
	int octNum = 010;		// 8진수 10, 10진수로 8
  int hexNum = 0x10; 	// 16진수 10, 10진수로 16
  
  long big = 1000_000_000L;						// long big = 100000000000L;
  long hex = 0xFFFF_FFFF_FFFF_FFFFL; 	// long hex = 0xFFFFFFFFFFFFFFFFFL;
  
  float pi = 3.14f; // 접미사 생략 불가
  double d = 1.618d;// 접미사 생략 가능
  
}
````

> 정수형에서는 int가, 실수형에선 double 이 기본 자료형이라서 접미사 생략이 가능하다





## 07. 문자 리터럴과 문자열 리터럴

'A'와 같이 작은따옴표로 문자 하나를 감싼것을 '문자 리터럴' 이라고 한다. 두 문자 이상은 큰 따옴표" " 로 감싸야 하며 '문자열 리터럴' 이라고 한다.

- char 는 단 하나의 문자만 저장할 수 있다.
- 여러 문자열을 저장하기 위해선 String 타입을 사영해야 한다.
- 문자열 리터럴은 " " 안에 아무런 문자도 넣지 않을 것을 허용한다. (= empty string)
- 문자 리터럴은 ' ' 안에 반드시 하나의 문자가 있어야 한다.

````java
public static void main(String args[]) {
  char ch = 'J'
  // char ch = 'Java'; -> 불가능
  String name = "Java"; // 변수 name 에 문자열 리터럴 "Java" 를 저장
  
  String str = ""; // 내용이 없는 빈 문자열
  char ch = ''; 	 // 에러
  char ch = '   '; // 가능. 공백 문자(blank)로 변수 ch를 초기화
}
````

> 문자열은 문자의 연속된 나열로, String 이라고 한다.
>
> - 원래 String 은 클래스이므로 객체를 생성하는 연산자 new를 사용해야 하지만 위와 같은 표현도 허용한다
>
> - ```` java
>   String name = new String("Java"); // String 객체를 생성
>   String name = new "Java"; //위 문장을 간단히 표기. 
>   ````





## 08. 문자열 결합

숫자가 아닌 문자열을 합칠 때도 덧셈(+)을 사용할 수 있다.

>문자열 + any type -> 문자열 + 문자열  
>
>any type + 문자열 -> 문자열 + 문자열

피연산자 중 어느 한쪽이 String  이면 나머지 한 쪽도 String으로 변환한 다음 두 String 을 결합한다.

````java
public static void main(String args[]) {
  String name = "Ja" + "va";
  String str = name + 8.0;
  
  Systme.out.println(name); // Java
  Systme.out.println(str); // Java8.0
  
  Systme.out.println(7 + " "); // 7 
  Systme.out.println(" " + 7); //  7
  Systme.out.println(7 + ""); // 7
  Systme.out.println("" + 7); // 7
  Systme.out.println(7 + 7 + ""); // 14
  Systme.out.println("" + 7 + 7); // 77
}
````







## *09. 두 변수의 값 바꾸기*

int x = 10, int y = 20 이 있을 때 직접 x = 20을 하면 x도 y도 20이기 때문에 원하는 결과가 아니다.

(두 개의 컵에 담겨있는 음료의 내용물을 바꾸기 위해선 빈 컵이 하나 더 필요한 것 처럼.)

``` java
public static void main(String args[]) {
	int x = 10;
  int y = 20;
  
  int temp; // 임시 변수인 temp 생성
  
  temp = x; // x값을 temp에 대입
  x = y; 		// y값을 x에 대입
  y = temp; // temp에 있던 x값을 y에 대입
  
  System.out.println("x = " + x); // x = 20
  System.out.println("y = " + y); // y = 10
}
```







## 10. 기본형과 참조형

값(data)의 종류(type)은 문자 / 숫자로 나눌 수 있고 숫자는 다시 정수 / 실수로 나눌 수 있다.

- 자료형 : 문자형(char), 정수형(byte, short, int, long), 실수형(float, double) 



#### 기본형과 참조형

자료형은 기본형과 참조형으로 나눌 수 있다.

- 기본형(primitive type) : 논리, 문자, 정수, 실수형 계산을 위한 실제 값을 저장 (모두 8개)

- 참조형(reference type) : **객체의 주소를 저장한다.** 메모리를 많이 차지함. 기본형 8개 외 나머지 타입이 참조형으로 분류된다.

  - 재할당시 발생 비용이 크기 때문에 주소를 저장해 참조하는 방식으로 접근.
  - String 이 참조형인 이유는 문자열의 길이를 알 수 없기 때문이다.

  



## 11. 기본형의 종류와 범위

| 종류 /크기 | 1 byte  | 2 byte | 4 byte                                    | 8 byte                                       |
| ---------- | ------- | ------ | ----------------------------------------- | -------------------------------------------- |
| **논리형** | boolean |        |                                           |                                              |
| **문자형** |         | char   |                                           |                                              |
| **정수형** | byte    | short  | <span style = "color: red">**int**</span> | long                                         |
| **실수형** |         |        | float                                     | **<span style = "color: red">double</span>** |

> 기본형에는 모두 8개의 타입(자료형)이 존재. 크게 논리형, 문자형, 정수형, 실수형으로 분리하며 정수형 중에선 **int** 가, 실수형 중에서는 **double**  이 기본이다
>
> - boolean은 ture / false 두 가지 값만 표현할 수 있기 때문에 가작 작은 크기인 1byte
> - char 은 자바에서 유니코드(2byte 문자체계) 를 사용하므로 2byte
> - byte는 크기가 1byte 라서 byte
> - int(4byte) 를 기준으로 짧아서 short(2byte), 길어서 long(8byte) 
> - float는 실수값을 부동소수점(**flot**ing-point) 방식으로 저장하기 때문에 float
> - double은 float보다 **두 배**의 크기 (8byte)를 갖기 때문에 double



#### 저장 가능한 값의 범위

- 정수형 (byte, short, int, long) : -2＾𝗇⁻¹ ~ 2＾𝗇⁻¹ -1(n은 bit 수)
  - int 형의 경우 32 bit(4byte)이므로 -2³¹ ~ 2³¹-1 의 범위를 갖는다 (대략 10자리수 (약 ±20억)의 값 저장 가능)
  - 7 ~ 9 자리 수를 계산할 땐 넉넉하게 long 타입(약 19자리)으로 변수를 선언하는 것이 좋다





## 12. printf 를 이용한 출력

같은 값이라도 다른 형식으로 출력하고 싶을 때 사용한다. (println은 변수의 값을 그대로 출력 -> 변환하지 않고 다른 형식으로 출력할 수 없음)

```` java
public static void main(String args[]) {
	int age = 14;
  int year = 2020;
  
  System.out.printf("age : %d", age);
  > System.out.printf("age : %d", 14);
  > System.out.printf("age : 14");  // "age : 14" 가 출력된다
  
  System.out.printf("age : %d year : %d", age, year);
  > System.out.printf("age : %d year : %d", 14, 2020); // "age : 14 year : 2020" 이 출력된다
}
````

> 출력하려는 값이 2개 이상일 경우에는 지시자도 그만큼 증가하며, 개수의 제한은 없다.
>
> 출력될 값과 지시자의 순서는 일치해야 한다.
>
> println()과 달리 printf()는 출력 후 줄바꿈을 하지 않는다. 지시자 '**%n**' 을 따로 넣어줘야 한다



| 지시자             | 설명                                                         |
| ------------------ | ------------------------------------------------------------ |
| %d                 | 10진(**d**ecimal)정수의 형식으로 출력                        |
| %x                 | 16진(he**x**a-decimal)정수의 형식으로 출력                   |
| %f <br/>(실수표현) | 부동 소수점(**f**loating-point)의 형식으로 출력 ->  기본적으로 소수점 아래 6자리 까지만 출력 됨. (이게 넘어갈 경우 반올림 |
| %c                 | 문자(**c**haracter)로 출력                                   |
| %s                 | 문자열(**s**tring)로 출력                                    |

- 실수형 값 출력 지시자

| %f     | 주로 사용되는 지시자 |
| ------ | -------------------- |
| **%e** | 지수 형태로 출력     |
| **%g** | 값을 간략하게 표현   |

> 전체 자리수와 소수점 아래의 자리수를 지정할 수도 있다. 
>
> EX ) System.out.printf("d = %14.10f%n", d);       // 전체 14자리 중 소수점 아래 10자리
>
> ​												%전체자리.소수점아래자리f
>
>  												여기서 소수점 아래의 빈자리는 0으로 채운다.

```java
public static void main(String[] args){
  String url = "www.codechobo.com";
  float f1 = .10f;                        // 0.10, 1.0e-1
  float f2 = 1e1f;                        // 10.0, 1.0e1, 1.0e+1
  float f3 = 3.14e3f;
  double d = 1.23456789;

  System.out.printif("f1 = %f, %e, %g%n", f1, f1, f1);
  System.out.printif("f2 = %f, %e, %g%n", f2, f2, f2);
  System.out.printif("f3 = %f, %e, %g%n", f3, f3, f3);
  System.out.printif("d = %f%n, d");
  System.out.printif("d = %14.10f%n, d");  // 전체 14자리 중 소수점 10자리 까지
  System.out.printif("[12345678901234567890]%n");
  System.out.printif("[%s]%n", url);
  System.out.printif("[%20s]%n", url);
  System.out.printif("[%-20]%n", url);   // 왼쪽 정렬
  System.out.printif("[%8s]%n", url);    // 왼쪽에서 8글자만 출력
  
  
  /**
  * f1 = 0.100000, 1.000000e-01, 0.100000
  * f2 = 10.000000, 1.000000e+01, 10.0000
  * f3 = 3140.000000, 3.140000e+03, 3140.00
  * d = 1.2345678 <- 마지막 자리 반올림
  * [12345678901234567890]
  * [www.codechobo.com]
  * [   www.codechobo.com]
  * [www.codechobo.com   ]
  * [www.code]
  */
}
```

>지시자 '%s' 에도 숫자를 추가하면 원하는 만큼 출력 공간을 확보하거나 문자열의 일부만 출력할 수 있다.  
>
>- 지정된 숫자보다 문자열의 길이가 작으면 빈자리는 공백으로 출력된다.
>  - System.out.printf("[%s]%n", url);		// 문자열의 길이만큼이나 출력공간 확보
>
>  
>
>- 공백이 있는 경우 기본적으로 우측 끝에 문자열을 붙인다.
>  - System.out.printf("[%20s]%n", url);   // 최소 20글자 출력공간 확보 (우측정렬)
>
>
>
>- ' - ' 를 붙이면 좌측 끝에 붙인다.
>
>  - System.out.printf("[%-20s]%n", url);  // 최소 20글자 출력공간 확보 (좌측정렬)
>
>  
>
>- ' . ' 을 붙이면 문자읠 일부만 출력할 수 있다.
>
>  - System.out.printf("[%.8s]%n", url);    // 왼쪽에서부터 8글자만 출력





## 13. 화면으로부터 입력받기

```` java
import java.util.Scanner; 						// Scanner 클래스를 사용하기 위해 추가
Scanner sc = new Scanner(System.in);  // Scanner 클래스의 객체 생성

String input = sc.nextLine(); 				// 입력받은 내용을 input에 저장
int num = Interger.parseInt(input);		// 입력받은 내용을 int타입의 값으로 변경

int num = sc.nextInt(); 							// 정수를 입력받아 num에 저장
````

> - nextLine() 이라는 메서드는 입력 후 엔터(Enter) 를 누르면 입력한 내용이 문자열로 반환된다.
>
> - nextInt() 외에도 nextFloat() 도 변환없이 바로 숫자를 입력받을 수 있다.
>   - 입력내용에 문자 또는 공백, 기호가 있으면 오류 발생



## 14. 정수형의 오버플로우

#### 오버플로우란 (overflow)

- 타입이 표현할 수 있는 값의 범위를 넘어서는 것

- 오버플로우가 발생했다고 에러인 것은 아니지만 예상치 못한 결과를 얻을 수 있음

  - 오버플로우가 발생하지 않게 충분한 크기의 타입 선택 필요

  > 1111 + 0001 = (1)0000
  >
  > (10진수) 9999 +  1 = (1)0000
  >
  > - 네자리로는 0000 ~ 9999 까지밖에 표현할 수 없기 때문에 위와 같은 경우 다섯자리인 10000은  저장할 공간이 없어 1이 버려진다.

  >
  >
  >(10진수) (1)0000 - 0001 = 9999
  >
  >(2진수) (1)0000 - 0001 = 1111
  >
  >- 뺄셈에서는 0에서 1을 뺄 수 없으므로 0000 앞에 저장되지 않은 1이 있다고 가정하고 뺄셈을 한다.



**정수형 타입이 표현할 수 있는 최대ㅔ값에 1을 더하면 최소값이 되고, 최소값에서 1을 빼면 최대값이 된다.**

> 최대값 + 1 -> 최소값
>
> 최대값 - 1 -> 최대값





## 15. 부호가 있는 정수의 오버플로우

부호가 없는 정수와 있는 정수의 최대값과 최소값이 다르기 때문에 오버플로우 발생 시점이 다르다.

|                                              부호없는 10진수 |                        2진수                         | 부호있는 10진수                                              |
| -----------------------------------------------------------: | :--------------------------------------------------: | :----------------------------------------------------------- |
|                                                          ... |                         ...                          | ...                                                          |
|                                                            7 | <span style=background-color:#50bcdf>**0**111</span> | <span style=background-color:#50bcdf>7 < 최대값 (오버플로우 발생)</span> |
|                                                            8 | <span style=background-color:#50bcdf>**1**000</span> | <span style=background-color:#50bcdf>-8 < 최소값 (오버플로우 발생)</span> |
|                                                            9 |                         1001                         | -7                                                           |
|                                                           10 |                         1010                         | -6                                                           |
|                                                           11 |                         1011                         | -5                                                           |
|                                                           12 |                         1100                         | -4                                                           |
|                                                           13 |                         1101                         | -3                                                           |
|                                                           14 |                         1110                         | -2                                                           |
| <span style=background-color:#50bcdf>최대값(오버플로우 발생)  > 15</span> |   <span style=background-color:#50bcdf>1111</span>   | -1                                                           |
| <span style=background-color:#50bcdf>최소값(오버플로우 발생)  >   0</span> |   <span style=background-color:#50bcdf>0000</span>   | 0                                                            |
|                                                          ... |                         ...                          | ...                                                          |

> 부호 없는 정수(4bit)의 경우 표현범위가 0 ~ 15 이므로 이 값이 계속 반복되고, 부호 있는 정수 (4bit)의 경우 표현범위가 -8 ~ 7 이므로 이 값이 무한히 반복된다.
>
> > short sMin = -32768, sMax = 32768
> >
> > char cMin = 0, cMax = 65535;
> >
> > 
> >
> > sMin - 1 = sMax 			// 최소값 - 1 = 최대값
> >
> > sMax + 1 = sMin 			// 최대값 + 1 = 최소값
> >
> > 
> >
> > cMin - 1 = cMax			// 최소값 -1 = 최대값
> >
> > cMax + 1 = cMin			// 최대값 + 1 = 최소값





## 16. 타입 간의 변환방법

1. 숫자를 문자로 변환 > 숫자에 ' 0 ' 을 더한다

   > (char)(3 + ' 0 ' ) = 3

2. 문자를 숫자로 변환 > 문자에서 ' 0 ' 을 뺀다

   > ' 3 ' - ' 0 ' = 3

3. 숫자를 문자열로 변환 > 숫자에 빈 문자열 ("") 을 더한다

   >3 + "" = "3"

4. 문자열을 숫자로 변환 > integer.parselnt() 또는 **Double.parseDouble()** 을 사용한다

   > - Integer.parseInt("3") = 3
   > - **Double.parseDouble("3.14") = 3.14**

5. 문자열을 문자로 변환 > charAt(0) 을 사용한다

   > "3".charAt(0) = '3'

6. 문자를 문자열로 변환 > 빈 문자열 ("") 을 더한다

   > '3' + "" = "3"