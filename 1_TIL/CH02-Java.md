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

| 분류 | 변수의 타입 |                             설명                             |
| :--: | :---------: | :----------------------------------------------------------: |
| 숫자 |   **int**   |             정수 (integer) 를 저장하기 위한 타입             |
|      |    long     |                      20억이 넘으면 long                      |
|      |    float    | 실수(floating-point-number) 를 저장하기 위한 타입 -> float는 오차없이 **7자리** |
|      | **double**  | 실수(floating-point-number) 를 저장하기 위한 타입 ->  double은 **15자리** |
| 문자 |    char     |            문자 (character) 를 저장하기 위한 타입            |
|      |   String    |       여러 문자( 문자열, String)를 저장하기 위한 타입        |

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



#### 리터럴

'상수'의 다른 이름.

```` 
변수 (Variable) : 하나의 값을 저장하기 위한 공간
상수 (Constant) : 값을 한버만 저장할 수 있는 공간
리터럴 (Literal) : 그 자체로 값을 의미하는 것
````

(![3.상수](https://lh3.googleusercontent.com/proxy/EbRJeo14lZsCvWdQkSgdK3aFO6pAa5v8cUVTPwDlMWUt1k-Y5bXwTPGHn5-cf_UQyzF7RUNnPkBYWstbv90tYuddzVIGCAD8wjw75gRt22Q))





## 06. 리터럴의 타입과 접미사

|  종류  |            리터럴             |                   접미사                   |
| :----: | :---------------------------: | :----------------------------------------: |
| 논리형 |          false, true          |                    없음                    |
| 정수형 | 123, 0b01010, 077, 0xFF, 100L |  **<span style = "color: red">L</span>**   |
| 실수형 |  3.14, 3.0e8, 1.4f, 0x1.0p-1  | **<span style = "color: red">f</span>**, d |
| 문자형 |        'A', '1', '\n'         |                    없음                    |
| 문자열 |  "ABC", "1234", "A", "true"   |                    없음                    |

> 정수형과 실수형에는 여러 타입이 존재하므로, 리터럴에 접시라르 붙여서 타입을 구분한다.
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

