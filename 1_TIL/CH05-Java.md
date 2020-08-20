# CHAPTER 5



## 01. 배열(array)이란?

- `같은 타입`의 여러 변수를 하나의 `묶음`으로 다루는 것.
- 배열을 사용하면 많은 양의 데이터를 손쉽게 다룰 수 있다.



## 02. 배열의 선언과 생성

| 선언방법         | 선언 예                         |
| ---------------- | ------------------------------- |
| 타입[] 변수이름; | int[] score;<br/>String[] name; |
| 타입 변수이름[]; | int score[];<br/>String name[]; |



#### 배열의 생성

- 배열 선언은 단지 생성된 배열을 다루기 위한 참조변수를 위한 공간이 만들어질 뿐이고, 배열을 생성해야만 비로소 값을 저장할 수 있는 공간이 만들어지는 것이다.
- 배열 생성 시, 타입과 길이를 지정해 주어야 한다.

```` java
/**
* 타입 [] 변수 이름;				>> 배열 선언 (배열을 다루기 위한 참조변수 선언)
* 변수이름 = new 타입[길이]; >> 배열 생성 (실제 저장공간을 생성)
*/

int [] score;				// int 타입의 배열을 다루기 위한 참조변수 socre 생성
score = new int[5]; // int 타입의 값 5 개를 저장 할 수 있는 배열 생성
````


![배열](http://www.javachobo.com/images/p5_6.gif)

> 변수와 달리 배열은 각 저장공간이 연속적으로 배치되어 있다.





## 03. 배열의 인덱스

- 생성된 배열의 각 저장공간을 `'배열의 요소(element)'` 라고 한다.
- '배열이름[인덱스]' 의 형식으로 배열의 요소에 접근.
- **index는 배열의 요소마다 붙여진 일렬번호**로 각 요소를 구별하는데 사용된다.(1이 아닌 0부터 시작)
  - 인덱스(index)의 범위는 0부터 '배열길이 -1' 까지.
- index로 상수 대신 변수나 수식도 사용할 수 있단 장점이 있다.

```` java
score[3] = 100; 			// 배열 score의 4번째 요소에 100을 저장한다
int value = score[3]; // 배열 score의 4번째 요소 값을 읽어서 value에 저장.
````



#### 배열과 for문

```` java
score[0] = 0;
score[1] = 10;
score[2] = 20;
score[3] = 30;
````

```` java
for (int i = 0; i <= 3; i++){
  score[i] = i * 10;
}
````





## 04. 배열의 길이(배열이름.length)

자바에서는 자바 가상 머신(JVM)이 모든 배열의 길이를 별도로 관리하며, `'배열이름.length'` 를 통해서 배열의 길이에 대한 정보를 얻을 수 있다.

```` java
int [] arr = new int[5]; 	// 길이가 5인 int 배열
int tmp = arr.length; 		// arr.length의 값을 5이고 tmp에는 5가 저장된다.
````

> 배열은 한 번 생성하면 길이를 변경할 수 없다. 따라서 '배열이름.length' 는 **상수** 이다. 값을 읽을 수 있지만, 변경할 순 없다.



#### 배열의 길이와 for문

```` java
int[] score = new int[6];
for(int i = 0; i < score.length; i ++){
  System.out.println(score[i]);
}
````

> 배열의 길이는 6이고, 인덱스의 범위는 0 ~ 5이다.



```` java
int [] score = new int[5]; 			// 배열의 길이를 6에서 5로 변경
for(int i = 0; i < 6; i ++){ 		// 조건식은 변경하지 않음
  System.out.println(score[i]); // 에러 발생
}

````

> - 배열의 길이가 변경되면 for문에 사용되는 조건의 범위도 변경해주어야 하는데, 만일 이것을 잊고 실행한다면 for문은 배열의 유효한 인덱스 범위인 0 ~ 4를 넘어 0부터 5까지 반복.
> -  5번째 반복에서 ArrayIndexOutOfBoundsException이라는 예외 (배열의 index가 유효한 범위를 벗어났다는 에러) 가 발생하여 비정상적으로 종료된다.
> - 그래서 조건식에 배열의 길이를 직접 적는 것 보다 '배열이름.length' 를 사용하는 것이 좋다.



## 05. 배열의 초기화

배열은 생성과 동시에 자동적으로 기본값(0)으로 초기화되므로 배열을 사용하기 전에 따로 초기화를 해주지 않아도 되지만, 원하는 값을 저장하려면 각 요소마다 값을 지정해줘야 한다.

```` java
int[] score = new int[5];      // 크기가 5인 int형 배열을 생성한다. 
score[0] = 100;                // 각 요소에 직접 값을 저장한다. 
score[1] = 90; 
score[2] = 80; 
score[3] = 70; 
score[4] = 60; 
````

```` java
// 위 코드를 for문으로 변경했다.
int [] score = new int [5];
for(int i = 0; i < score.length; i++){
  score[i] = i * 10 + 50;
}
````

> for문으로 배열을 초기화하려면, 저장하려는 값에 일정한 규칙이 있어야만 가능하기 때문에 자바에서 배열을 간단히 초기화 할 수 있는 방법을 제공한다.
>
> > ```` java
> > int[] score = new int[] {50, 60, 70, 80, 90}; 
> > // 배열의 생성과 초기화를 동시에 함.
> > 
> > int[] score = {50, 60, 70, 80, 90}; 
> > // new int[] 를 생략할 수 있음.
> > 
> > int[] score;
> > score = {50, 60, 70, 80, 90}; 					// 에러. new int[] 는 생략할 수 없음.
> > score = new int[]{50, 60, 70, 80, 90};  // 가능.
> > ````
> >
> > 저장할 값들을 괄호 {} 안에 쉼표로 구분해 나열하며, 괄호 {} 안의 값 개수에 의해 배열의 길이가 자동으로 결정된다. (괄호 [] 안에 길이는 안 적어도 됨.)





## 06. 배열의 출력

배열을 초기화 할 때 for문을 사용하듯, 배열에 저장된 값을 확인할 때도 다음과 같이 for문을 사용하면 된다.

``` java
int[] iArr = { 100, 95, 80, 70, 60 };
for(int i = 0; i < iArr.length; i++){	// 배열의 요소를 순서대로 하나씩 출력
  System.out.print(iArr[i] + ", "); 	// 각 요소 간의 구별을 위해 쉼표를 넣는다
}
System.out.println(); // 다음 출력이 바로 이어지지 않도록 줄바꿈
```



더 간단한 방법은 'Arrays.toString(배열이름)' 메서드를 사용하는 것이다. 이 메서드는 배열의 모든 요소를 '[첫번째 요소, 두번쨰 요소, ....]' 와 같은 형식의 문자열로 만들어서 반환한다.

```` java
int[] iArr = { 100, 95, 80, 70, 60 };
// 배열 iArr 의 모든 요소를 출력한다. [ 100, 95, 80, 70, 60 ] 이 출력된다.
System.out.println(Arrays.toString(iArr));
````

> 만일 iArr의 값을 바로 출력하면 '타입@주소' 형식의 참조변수가 출력된다.
>
> 예외적으로 char 배열은 println 메서드로 출력하면 각 요소가 구분자 없이 그대로 출력된다.



## 07. String 배열의 선언과 생성

배열의 타입이 String 인 경우에도 int 배열의 선언과 생성 방법은 다르지 않다. 

```` java
String[] name = new String[3]; // 3개의 문자열을 담을 수 있는 배열을 생성한다.
````

![배열](http://www.javachobo.com/images/p5_7.gif)

> null은 어떠한 객체로 가리키고 있지 않다는 뜻이다.



#### 변수 타입에 따른 기본값

| 자료형           | 기본값        |
| ---------------- | ------------- |
| boolean          | false         |
| char             | '\u0000'      |
| byte, short, int | 0             |
| long             | 0L            |
| float            | 0.0f          |
| double           | 0.0d 또는 0.0 |
| 참조형           | null          |





## 08. String 배열의 초기화

초기화 역시 int 배열과 동일한 방법만 한다.

```` java
String [] name = new String[3];

//case 1
name[0] = "Kim";
name[1] = "Park";
name[2] = "Yi";

//case2
String[] name = new String[] { "Kim", "Park", "Yi" };

//case3
String[] name = { "Kim", "Park", "Yi" }; // new String[]을 생략할 수 있음
````





## 09. String 클래스

String 클래스는 char 배열에 기능(메서드 == 함수)을 추가한 것이다.



#### char 배열과 String 클래스의 차이

String 객체(문자열)는 읽을 수만 있을 뿐 내용을 변경할 수 없다.

```` java
String str = "Java";
str = str + "8";					// "Java8" 이라는 새로운 문자열이 str에 대입
System.out.println(str);  // "Java8"
````

> 문자열 str의 내용이 변경되는 것 같지만, 문자열은 변경할 수 없으므로 새로운 내용의 문자열이 생성된다.





## 10. String 클래스의 주요 메서드

| 메서드                             | 설명                                                         |
| ---------------------------------- | ------------------------------------------------------------ |
| char charAt(int index)             | 문자열에서 해당 위치 (index) 에 있는 문자를 반환한다.        |
| int length()                       | 문자열의 길이를 반환한다.                                    |
| String substring(int from, int to) | 문자열에서 해당 범위 (from ~ to) 의 문자열을 반환한다 . (to는 포함 안 됨) |
| boolean equals(Object obj)         | 문자열의 내용이 같은지 확인한다. 같으면 결과는 true, 다르면 false. |
| char[] toCahrArray()               | 문자열을 문자배열(char[])로 변환해서 반환한다.               |



#### charAt 메서드

문자열에서 지정된 index에 있는 한 문자를 가져온다. 배열에서 '배열이름[index]' 로 index 에 위치한 값을 가져오는 것과 같다고 생각하면 된다. 배열과 마찬가지로 charAt 메서드의 index 값은 0부터 시작한다.

``` java
Strign str = "ABCDEF";
char ch = str.charAt(3); // 문자열 str의 네번째 문자 'D' 를 ch에 저장.
```



#### substring() 

문자열의 일부를 추출한다. 주의할 것은 범위의 끝은 포함되지 않는 것. (index의 범위가 1 ~ 4 일 때 4는 범위에 포함되지 않음.)

```` java
String str = '012345';
String temp = str.substring(1,4); // str에서 index범위 1 ~ 4 의 문자들을 반환
System.out.println(temp); 				// 123 이 출력된다.
````



#### equals()

문자열의 내용이 같은지 다른지 확인. 대소문자를 구분하니 주의가 필요하다.

대소문자를 구분하지 않으려면 equalsIgnoreCase() 를 사용해야 한다.

```` java
String str = "abc";
if(str.equals("abc")){} // str 과 "abc" 의 내용이 같은지 확인
````





## 11. 커맨드 라인을 통해 입력받기

Scanner 클래스의 nextLine() 외오데 화면을 통해 사용자로부터 값을 입력 받을 수 있다.

- 커맨드 라인을 이용한 방법.

```` java
c:\jdk1.8\work\ch5>java MainTest abc 123
````

> 실행할 프로그램의 main 메서드가 담긴 클래스 이름이 MainTest이고, args[0] 은 "abc", args[1]은 "123".
>
> - 커맨드 라인에 입력된 매개변수는 공백문자로 구분하기 때문에 입력될 값에 공백이 있는 경우 큰따옴표("")로 감싸주어야 한다.
> - 커맨드 라인에서 숫자를 입력해도 숫자가 아닌 문자열로 처리된다.



## 12. 2차원 배열의 선언

 2차원 이상의 배열, 다차원(multi-dimensional) 배열을 선언해서 사용할 수 있다. 2차원 배열을 선언한느 방법은 1차원 배열과 같다. 다만 대괄호[]가 하나 더 들어간다.

- 2차원 배열은 주로 테이블 형태의 데이터를 담는데 사용

| 선언 방법            | 선언 예          |
| -------------------- | ---------------- |
| 타입 [] [] 변수이름; | int[] [] score;  |
| 타입 변수이름 [] []; | int score [] []; |
| 타입[] 변수이름 [];  | int[] score[];   |

```` java
int [][] score = new int [4][3]; // 4행 3열의 2차원 배열을 생성한다.
````

> 배열요소의 타입인 int의 기본값인 0이 저장된다. 배열이 생성하면, 배열의 각 요소에는 배열요소 타입의 기본값이 자동적으로 저장된다.





## 13. 2차원 배열의 인덱스

- 2차원 배열은 행(row)와 열(column)로 구성
  - index도 행과 열에 각각 하나씩 존재
  - '행index'의 범위는 '0 ~ 행의 길이 -1' 이고 '열index'의 범위는 '0 ~ 열의 길이 -1'
  - 2차원 배열의 각 요소에 접근하는 방법은 '배열이름[행index], [열index]'

```` java
int[][] score = new int[4][3]; 	// 4행 3열의 2차원 배열 score를 생성

socre [0][0] = 100;							// 배열 score의 1행 1열에 100을 저장
System.out.println(score[0][0]);// 배열 score의 1행 1열의 값을 출력
````





## 14. 2차원 배열의 초기화

2차원 배열도 괄호 {} 를 사용해서 생성과 초기화를 동시에 할 수 있다. 1차원 배열보다 괄호{} 를 한 번 더 써서 행별로 구분해 준다.

```` java
//case1
int [][] arr = new int[][]{ {1, 2, 3}, {4, 5, 6} };

//case2
int [][] arr = { {1, 2, 3}, {4, 5, 6} }; // new int [][] 가 생략됨

//case3
int [][] arr = {
  								{1, 2, 3},
								  {4, 5, 6}
								};
````

 

## 15. Arrays로 배열 다루기

#### 문자열의 비교와 출력 - equals(), toString()

#### toString()

- toString() 배열의 모든 요소를 문자열로 출력 가능

- toString()은 일차원 배열에만 사용 가능, 다차원 배열에는 deepToString();

  ```` java
  int [] arr = { 0,1,2,3,4 };
  int [][] arr2D = { {11, 12}, {21, 22} };
  
  System.out.println(Arrays.toString(arr)); 			// [0, 1, 2, 3, 4]
  System.out.println(Arrays.deepToString(arr2D)); // [[11, 12], [21, 22]]
  ````

  

####  equals()

- 두 배열에 저장된 모든 요소를 비교해서 같으면 true, 다르면 false를 반환한다

-  equals()도 일차원 배열에서만 사용 가능하며, 다차원 배열의 비교에는 deepEquals()를 사용한다.

  ```` JAVA
  String [][] str2D = new String[][] { {"aaa", "bbb"}, {"AAA", "BBB"} };
  String [][] str2D2 = new String[][] { {"aaa", "bbb"}, {"AAA", "BBB"} };
  
  System.out.println(Arrays.equals(str2D, str2D2)); 		// false
  System.out.println(Arrays.deepEquals(str2D, str2D2)); // true
  ````

-----------------------------------



#### 배열의 복사 - copyOf(), copyOfRange()

`copyOf()` 는 배열 전체를, `copyOfRange()` 는 배열의 일부를 복사해서 새로운 배열을 만들어 반환한다.

copyOfRange() 에 지정된 범위의 끝은 포함되지 않는다.

````` java
int [] arr1 = { 0, 1, 2, 3, 4 };
int [] arr2 = Arrays.copyOf(arr, arr.length); // arr2 = [0,1,2,3,4] 	
int [] arr3 = Arrays.copyOf(arr, 3);					// arr3 = [0,1,2] 
int [] arr4 = Arrays.copyOf(arr, 7);					// arr4 = [0,1,2,3,4,0,0] 
int [] arr5 = Arrays.copyOfRange(arr, 2, 4);	// arr5 = [2,3] <- 4는 불포함 
int [] arr6 = Arrays.copyOfRange(arr, 0, 7);	// arr6 = [0,1,2,3,4,0,0] 
`````

-----------



#### 배열의 정렬 - sort()

```` java
int [] arr = { 3, 2, 0, 1, 4 };
Arrays.sort(arr);  // 배열 arr 를 정렬한다.
System.out.println(Arrays.toString(arr)); // [0,1,2,3,4]
````





