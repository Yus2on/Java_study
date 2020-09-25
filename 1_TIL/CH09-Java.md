

# CHAPTER 9

# java.lang 패키지와 유용한 클래스 (java.lang package & util casses)   





## 01. Object 클래스

### Object 메서드

- 멤버변수 없이 11개의 메서드만 가지고 있다.
- Object 클래스는 모든 클래스의 최고 조상이기 때문에 모든 클래스에서 바로 사용 가능
- equals(), hashCode(), toString()은 적절히 오버라이딩해야 한다.



![Object클래스의 메서드](https://user-images.githubusercontent.com/46306263/93731474-1cb84e00-fc08-11ea-8635-af7973966259.png)





## 02. Object 클래스의 메서드 - equals()

- 매개변수로 **객체의 참조변수**를 받아 비교하여 그 결과를 `blooean` 값으로 반환

  - 객체 자신과 주어진 객체(obj)를 비교해서 같으면 true, 다르면 false
  - 서로 다른 두 객체는 각각 다른 주소를 갖기 때문에 다른 객체를 equals() 메서드로 비교하면 값은 항상 `false` 

  - 두 개 이상의 참조 변수가 같은 주소값을 갖는 것은 가능 ( = 한 객체를 참조)



### equals()의 오버라이딩

- 주소가 아닌 객체(인스턴스)에 저장된 내용을 비교
- 다른 객체라도 같은 값을 가지고 있다면 true

```java
class Person {
  long id;

  public boolean equals(Object obj) { // equals() 오버라이딩 
    if(obj instanceof Person)
      return id ==((Person)obj).id; //  obj가 Object 타입이므로 id 값을 참조하려면 Person타입으로 형변환 필요
    else
      return false; // 타입이 Person이 아니면 값을 비교할 필요 없음!!! 
  }

  Person(long id) {
    this.id = id;
  }
}

class Ex9_2 {
  public static void main(String[] args) {
    Person p1 = new Person(8011081111222L);
    Person p2 = new Person(8011081111222L);

    if(p1 == p2) {
      System.out.println("p1과 p2는 같은 사람입니다.");
    } else {
      System.out.println("p1과 p2는 다른 사람입니다.");
    }
    
    if(p1.equals(p2))
      System.out.println("p1과 p2는 같은 사람입니다.");
    else
      System.out.println("p1과 p2는 다른 사람입니다.");
  }
  
}

[실행결과]
p1과 p2는 다른 사람입니다.
p1과 p2는 같은 사람입니다.
```





## 03. Object클래스의 메서드 - hashCode()

- 해싱(hashing) 기법 : 데이터관리기법 중 하나. 다량의 데이터를 저장 & 검색하는데 유용

- 객체의 해시코드(int타입의 정수,hash code)를 반환하는 메서드(해시함수)

  - Object클래스의 hashCode()는 객체의 내부주소를 반환.
  - `String 클래스` 오버라이딩이 되어 있음 -> 문자열의 내용이 같으면  동일한 해시코드 반환

  ```java
  String str1 = new String("abc");
  String str2 = new String("abc");
  
  System.out.println(str1.equals(str2)); // true
  System.out.println(str1.hashCode()); // 96354
  System.out.println(str2.hashCode()); // 96354
  ```

  - `System.identityHashCode(Object obj)` 는 Object클래스의 hashCode()와 동일한 결과  -> 모든 객체에 대해 항상 다른 해시코드 반환

  ```java
  String str1 = new String("abc");
  String str2 = new String("abc");
  
  System.out.println(System.identityHashCode(str1)); // 225534817
  System.out.println(System.identityHashCode(str2)); // 1878246837
  ```





## 04. Object클래스의 메서드 - toString()

- 객체의 정보를 문자열(String)로 제공할 목적으로 정의된 메서드

- toString()을 오버라이딩 하지 않을 경우 Object클래스에 정의된 toString() 코드대로 리턴

  - 클래스이름@16진수 해시코드

  ```java
  public String toString() {
    return getClass().gatName()+"@"+Integer.toHexString(hashCode());
  }
  ```





### toString()의 오버라이딩

- String 클래스의 toString()은 String 인스턴스가 갖고 있는 문자열을 반환
- Date 클래스는 Date 인스턴스가갖고 있는 날짜와 시간을 문자열로 변환하여 반환
- Object 클래스에 정의된 toString()의 접근제어자가 `public` 이기 때문에 자식 클래스에서 오버라이딩 할 때 접근 제어자가 `public` 이어야 한다.

```java
class Card {
  String kind;
  int number;
  
  Card(){
    this("SPADE", 1); // Card(String kind, int number) 메서드 호출
  }
  
  Card (String kind, int num) {
    this.kind = kind;
    this.number = num;
  }
  
  public String toString() {
    return "Kind : " + kind + ", number : " + number;
  }
} // class end

class CardToString {
  public static void main (String [] args) {
    Card c1 = new Card();
    Card c2 = new Card("HEART", 10);
    
    System.out.println(c1.toString()); // Kind : SPADE, number : 1
    System.out.println(c2.toString()); // Kind : HEART, number : 10
    System.out.println(c2); // Kind : HEART, number : 10
  }
}
```





## 05. String 클래스

### 변경 불가능한 클래스 (Immutable Class)

- 한번 생성된 String 인스턴스가 갖고 있는 문자열은 값 변경이 불가능하다. (read only)
- '+' 연산자를 이용해 문자열을 결합하는 경우, 새로운 문자열이 담긴 String 인스턴스가 생성

![String 문자열 결합](https://user-images.githubusercontent.com/46306263/93731457-090ce780-fc08-11ea-92e7-38e7d60dcebd.png)







## 06. 문자열(String)의 비교

- 문자열을 만들기 위한 방법

  - 문자열 리터럴 지정 : 이미 존재하는 것을 재사용

    ```java
    String str1 = "abc"; // 문자열 리터럴 "abc"의 주소가 str1에 저장
    String str2 = "abc"; // 문자열 리터럴 "abc"의 주소가 str2에 저장
    ```

    

  - String 클래스의 생성자 사용 : new 연산자에 의해 메모리 할당 후, 새로운 객체 생성

    ```java
    String str3 = new String("abc"); // 새로운 String 인스턴스(객체) 생성
    String str4 = new String("abc"); // 새로운 String 인스턴스(객체) 생성
    ```

  ![image](https://user-images.githubusercontent.com/46306263/93731595-a536ee80-fc08-11ea-8a1f-5eb7197bc64b.png)

```java
class Ex9_6 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		System.out.println("String str1 = \"abc\";"); // String str1 = "abc";
		System.out.println("String str2 = \"abc\";"); // String str2 = "abc";

		System.out.println("str1 == str2 ?  " + (str1 == str2)); // str1 == str2 ?  true
		System.out.println("str1.equals(str2) ? " + str1.equals(str2)); // str1.equals(str2) ? true
		System.out.println();

		String str3 = new String("abc");
		String str4 = new String("abc");

		System.out.println("String str3 = new String(\"abc\");"); // String str3 = new String("abc");
		System.out.println("String str4 = new String(\"abc\");"); // String str4 = new String("abc");

    // 문자열 주소값 비교 
		System.out.println("str3 == str4 ? " + (str3 == str4)); // str3 == str4 ? false
    // 문자열 내용 비교
		System.out.println("str3.equals(str4) ? " + str3.equals(str4)); // str3.equals(str4) ? true
	}
}
```







## 07. 문자열 리터럴 (String 리터럴)

- 같은 내용의 문자열 리터럴은 한번만 저장된다.

  - 문자열 리터럴도 String 인스턴스이고, 생성하면 내용 변경이 불가능하기 때문에 하나의 인스턴스를 공유하면 되기 때문이다.

  ```java
  class Ex9_7 {
    public static void main(String [] args) {
      String str1 = "AAA";
  		String str2 = "AAA";
  		String str3 = "AAA";    
  		String str4 = "BBB";    
      // "AAA"  문자열을 담고있는 String 인스턴스 생성 후,
      // 참조변수 str1, str2, str3은 모두 이 인스턴스를 참조함
      
      // 클래스 파일의 리터럴은 constant pool에 저장 -> "AAA" 문자열 자동 생성 저장
    }
  }
  ```





## 08. 빈 문자열 (Empty String)

- 길이(크기) 가 0인 배열( 생성하는 것은 어느 타입이나 가능함)

- 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열

- 길이가 0이기 때문에 아무런 문자도 저장할 수 없는 배열

  ```java
  class Ex9_8 {
    public static void main(String [] args) {
    	char[] chArr = new char[0]; // 길이가 0인 char 배열. 
      // char [] chArr = {}; // 위와 동일
      
      String s = new String(chArr);
      // String s = new String(""); // 위와 동일
      
      int [] iArr = {}; // 크기가 0인 int 배열
      
      String str = ""; // 빈 문자열로 초기화
      char c = ' '; // 공백으로 초기화
      
      System.out.println("chArr.length = " + chArr.lenght); // chArr.length = 0
      System.out.println("@@@" + s + "@@@"); // @@@@@@
      
    }
  }
  ```





## 09. String 클래스의 생성자와 메서드

![image](https://user-images.githubusercontent.com/46306263/93734443-28117680-fc14-11ea-9b35-9a9e31f19bc4.png)

![image](https://user-images.githubusercontent.com/46306263/93734461-3cee0a00-fc14-11ea-9d61-a7d21e1c7f48.png)

![image](https://user-images.githubusercontent.com/46306263/93734476-4aa38f80-fc14-11ea-86bb-9a24eca69f57.png)





## 10. join() 과 StringJoiner

### join()

- 여러 문자열 사이에 `구분자`를 넣어 결합 (JDK 1.8 부터 추가)

  ```java
  String animals = "dog, cat, bear";
  String [] arr = aniamls.split(", "); // 문자열을 ', ' 을 구분자로 잘라 배열에 저장
  String str = String.join("-", arr); // 배열의 문자열을 '-' 구분해서 결합
  
  System.out.println(str); // dog-cat-bear
  
  ```

  



### java.util.StringJoiner

- JDK 1.8부터 추가

```java

System.out.println(sj.toString()); // [aaa, bbb, ccc]
```







## 11. 문자열과 기본형 간의 변환

- 기본형 값을 문자열로 바꾸는 두 가지 방법

  ```java
  int i = 100;
  
  String str1 = i + ""; // 100을 "100"으로 변환하는 방법 1
  String str2 = String.valueOf(i); // 100을 "100"으로 변환하는 방법 2
  // 성능향상이 필요할 땐 valueOf()를 사용
  ```

  

- 문자열을 기본형 값으로 변환하는 방법

  ```java
  int i1 = Integer.parseInt("100"); // "100"을 100으로 변환
  int i2 = Integer.valueOf("100");  // "100"을 100으로 변환
  // 원래 반환타입이 Integer 인데, 오토박싱(auto-boxing)에 의해 int로 자동변환
  ```

  ![image](https://user-images.githubusercontent.com/46306263/93736130-54c88c80-fc1a-11ea-8281-866cb3448b8b.png)



### 문자열에 공백 또는 문자가 포함된 경우

- 변환 시 trim() 사용

  ```java
  int val = Integer.parseInt("123".trim());
  // 문자열 양 끝의 공백을 제거 후 변환
  
  ```

  





## 12. StringBuffer 클래스

- String처럼 문자형 배열(char[])을 내부적으로 가지고 있다.
- 생성 후 지정된 문자 변경이 불가능한 String 클래스 대신 StringBuffer 클래스 사용
- StringBuffer 인스턴스를 생성할 때 크기 지정 가능



### StringBuffer 생성자

- 인스턴스 생성 시 버퍼 크기를 지정하지 않으면 16으로 지정된다

  ```java
  public StringBuffer(int length) {
    value = new Char[lenght];
    shared = false;
  }
  
  public StringBuffer() {
    this(16); // 버퍼의 크기를 지저하지 않으면 16이 됨
  }
  
  public StringBuffer(String str) {
    this(str.length() + 16); // 지정한 문자열의 길이보다 16이 더 크게 버퍼를 생성
    append(str);
  }
  ```

- 버퍼의 크기를 변경할땐 `System.arrycopy()`  이용

  ```java
  System.arraycopy(value, 0, newValue, 0, count);
  // 배열 value의 내용을 배열 newValue로 복사한다.
  // count는 문자열의 길이
  ```

  



### StringBuffer의 변경

```java
StringBuffer sb = new StringBuffer("abc");

sb.append("123"); // sb의 내용 뒤에 "123"을 추가
sb.append("ZZ"); // sb의 내용 뒤에 "ZZ"를 추가

sb.append("123").append("ZZ"); // 위와 같은 코드
```





### StringBuffer의 비교

- String클래스와 달리 equals()를 오버라이딩하지 않기 때문에 `equals 메서드` 를 사용해도 '==' 로 비교한 것과 같은 결과를 얻음

  ```java
  StringBuffer sb = new StringBuffer("abc");
  StringBuffer sb2 = new StringBuffer("abc");
  
  System.out.println(sb == sb2);      // false
  System.out.println(sb.equals(sb2)); // false
  ```

- toString() 은 오버라이딩이 되어 있어서 toString() 호출 후, 얻은 String 인스턴스에 equals 메서드를 사용해야 한다

  ```java
  StringBuffer sb = new StringBuffer("abc");
  StringBuffer sb2 = new StringBuffer("abc");
  
  String s = sb.toString();
  String s2 = sb2.toString();
  
  System.out.printlng(s.equals(s2)); // true
  ```







### StringBuffer의 생성자와 메서드

![image](https://user-images.githubusercontent.com/46306263/93740717-03be9580-fc26-11ea-93f8-d2acb72508b2.png)

![image](https://user-images.githubusercontent.com/46306263/93740739-0f11c100-fc26-11ea-9d1b-831d54297957.png)







## 13. StringBuilder

- StringBuffer는 멀티 스레드에 안전(thread safe) 하도록 동기화 된 클래스 

- 멀티 스레드로 작성된 프로그램이 아닐 경우에는 `StringBuilder` 를 사용

  ```java
  StringBuffer sb;
  sb = new StringBuffer();
  sb.append("abc");
  
  StringBuilder sb;
  sb = new StringBuilder();
  sb.append("abc");
  ```

  







## 14. Math 클래스

- 기본적인 수학 계산에 유용한 메서드로 구성

- Math 클래스의 생성자는 `private` , 다른 클래스에서 Math 인스턴스 생성 불가능.

- Math 클래스의 모든 메서드는 static 이며, 상수가 2개 정의

  - ```java
    public static final double E = 2.7182818284590452354; // 자연로그의 밑
    ```

  - ```java
    public static final double PI = 3.14159265358979323846; // 원주율
    ```





### 올림, 버림, 반올림

- round() 메서드 : 소수점 첫째자리에서 반올림해서 정수값(long)으로 결과 반환

- 원하는 자리에서 반올림 값을 얻으려면 `10의 n 제곱 * / 곱한 수`

  ```java
  // 90.7552 -> 소수점 셋째자리 반올림 후 소수점 두 자리까지 값만 얻기
  
  90.7552 * 100 = 9075.52
    // 소수점 세 자리를 얻고 싶다면 * 1000 후  나누기 1000.0
    
  Math.round(9075.52) = 9076
    // 반올림이 필요할 때 round() 사용
    
  9076 / 100.0 = 90.76
  	// 정수형 값을 얻고 싶다면 9076 / 100 =. 0
  	// 정수간의 연산에선 반올림 불가능
  ```





### Math의 메서드

![Math 클래스의 메서드](https://user-images.githubusercontent.com/46306263/93741922-35386080-fc28-11ea-8f20-fc6aa1676a75.png)







## 15. 래퍼 클래스 (Wrapper Class)

- 기본형(primitive type) 변수를 객체로 다루기 위한 클래스     



### Wrapper 클래스의 종류

| 기본형  | Wrapper 클래스 | 생성자                                                       | 활용 예                                                      |
| ------- | -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| byte    | Byte           | Byte (byte value)<br/>Byte (String s)                        | Byte b = new Byte (10);<br/>Byte b2 = new Byte ("10");       |
| char    | **Character**  | Character (char value)                                       | Character c = new Character('a');                            |
| short   | Short          | Short (short value)<br/>Short (String s)                     | Short s = new Short (10);<br/>Short s2 = new Short ("10");   |
| int     | **Integer**    | Integer (int value)<br/>Integer (String s)                   | Integer i = new Integer (100);<br/>Integer i2 = new Integer ("100"); |
| long    | Long           | Long (long value)<br/>Long (String s)                        | Long i = new Long (100);<br/>Long i2 = new Long ("100");     |
| float   | Float          | Float (double value)<br/>Float (float value)<br/>Float (String s) | Float f = new Float (1.0);<br/>Float f2 = new Float (1.0f);<br/>Float f3 = new Float("1.0f"); |
| double  | Double         | Double (double value)<br/>Double (String s)                  | Double d = new Double (1.0);<br/>Double d2 = new Double ("1.0"); |
| boolean | Boolean        | Boolean (boolean value)<br/>Boolean (String s)               | Boolean b = new Boolean(true);<br/>Boolean b2 = new Boolean("true") |











## 16. Number 클래스

- `추상 클래스`로 내부적으로 숫자를 멤버변수로 갖는 래퍼 클래스의 조상
- 숫자와 관련된 래퍼 클래스는 모두 Number 클래스의 자식 

![래퍼 클래스의 상속 계층도](https://user-images.githubusercontent.com/46306263/93744007-09b77500-fc2c-11ea-8aab-5f9ff3829ea2.png)





### BigInteger

- long으로 다룰 수 없는 큰 범위의 정수를 처리하기 위한 메서드



### BigDecimal

- double로 다룰 수 없는 큰 범위의 부동 소수점수를 처리하기 위한 메서드









## 17. 문자열을 숫자로 변환하기

```java
int i = new Integer("100").intValue(); // floatValue(), longValue(), ....
int i2 = Integer.parseInt("100"); // 주로 이 방법을 사용
int i3 = Integer.valueOf("100");
```

| 문자열 -> 기본형                                             | 문자열 -> 래퍼 클래스                                        |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| byte      b = Byte.parseByte("100"); <br/>short     s = short.parseshort("100"); <br/>int          i = int.parseInt("100"); <br/>long       l = Long.parseLong("100"); <br/>float      f = Float.parseFloat("3.14"); <br/>double d = Double.parseDouble("3.14"); | Byte     b = Byte.valueOf("100"); <br/>Short    s = Short.valueOf("100"); <br/>Integer  i = Integer.valueOf("100"); <br/>Long      l = Long.valueOf("100"); <br/>Float      f = Float.valueOf("3.14"); <br/>Double d = Double.valueOf("3.14"); |





### 문자열이 10진수가 아닐 경우

```java
static int parseInt(String s, int radix); // 문자열 s를 radix 진법으로 인식
static Integer varlueOf(String s, int radix);


int i4 = Integer.parseInt("100", 2); // "100"이 2진법의 숫자일 때 10진수로 4 -> 2진수의 100을 100(2)로 표기
int i5 = Integer.parseInt("100", 8); // "100"이 8진법의 숫자일 때 10진수로 64
int i6 = Integer.parseInt("100", 16); // "100"이 16진법의 숫자일 때 10진수로 256
int i7 = Integer.parseInt("FF", 16); // "FF"이 16진법의 숫자일 때 10진수로 255
//int i8 = Integer.parseInt("FF"); // 진법을 생략하면 10진수로 간주되기 때문에 NumberFormatException 발생

```







## 18. Autoboxing & Unboxing

- 오토박싱 (Autoboxing)

  - JDK 1.5부터 추가된 기능

  - 기본형 값을 Wrapper 클래스의 객체로 자동 변환하는 기능 

    ```java
    int i = 5; 
    Integer iObj = new Integer(7);
    
    // 컴파일 전의 코드
    int sum = i + iObj;
    // 컴파일 후 코드
    int sum = i + iObj.intValue();
    ```

    

- 언박싱 (Unboxing)

  - wrapper 객체를 기본형으로 자동 변경하는 기능

    ```java
    int i = 10; // 기본형 int i 변수에 10 대입
    Integer wrapped = i; // Wrapper 클래스 Integer 변수 wrapped에 int형 변수 i 대입
    int b = 20 + wrapped; // 기본형 int 변수 b에 정수 20과 wrapped를 더함 -> 자동 언박싱....
    ```

    







--------------------

# 질문

1. StringBuilder 와 StringBuffer의 차이점은 각각 단일 스레드와 멀티 스레드로 작성 되었을 때에 따라 나뉘는 건가요? 자바의 정석 (347p) 에서는 `StringBuffer는 멀티스레드에 안전하도록 동기화 되어 있고, 동기화가 StringBuffer의 성능을 떨어뜨린다. 멀티 스레드로 작성된 프로그램이 아닌 경우, StringBuffer의 동기화는 불필요하게 성능만 떨어뜨린다.` 라고 하는데, 이 부분 말이 조금 어렵게 써있는 것 같아 긴가민가 합니다...  단일 스레드로 작성 되었다면 StringBuilder, 멀티 스레드로 작성되었다면 StringBuffer 를 사용하는게 좋다는 말일까요???     

   

2. join과 StringJoiner 의 차이는 뭔가요? 얘도 성능향상에 따라 번갈아 쓰면 되는 건가요?   

   

3. 빈 문자열을 생성하는 이유가 뭔가요?.,.,. 길이가 0이면 문자 저장이 불가능할텐데 이렇게 작성해서 어디다 쓸 수 있나요?.,. 실질적인 예시를 알고 싶은데 찾아봐도 모르겠습니다 ..

   ```java
   char [] chArr = new char[0];
   int [] iArr = {};
   int [] iArr2 = new int[0];
   ```

   

   