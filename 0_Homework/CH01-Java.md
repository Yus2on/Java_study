# CHAPTER 1



## 01. 자바(Java)란?

- 객체지향 프로그래밍 언어
- 운영체제(Operating System, 플랫폼)에 독립적 -> 운영체제에 따라 변경하지 않고 실행 가능



## 02. 자바의 특징

- 운영체제에 독립적
  - JVM (Java Virtual Machine) : 자바 가상 머신
  - 자바 응용프로그램은 JVM하고만 통신
  - 운영체제 / 하드웨어 관계 없이 실행
- 객체지향언어
  - 객체지향 프로그래밍 언어 (Object Oriented Programming language, OOP) 
  - 객체지향 특징 : 상속, 캡술화, 다형성, 재사용성, 유지보수
- 자동 메모리 관리
  - Garbage Collection : GC, 가비지 컬렉터. 
  - 자바로 된 프로그램이 실행되면 자동적으로 메모리 관리
- 네트워크와 분산처리 지원
  - 다양한 네트워크 프로그래밍 라이브러리(API)를 통해 네트워크 관련 프로그램 개발이 쉽다
- 멀티쓰레드 지원
  - multi thread 
  - 시스템과 관계없이 구현 가능, 관련된 라이브러리(Java API) 제공
  - 여러 쓰레드에 대한 스케줄링(scheduling)을 자바 인터프리터가 담당
- 동적 로딩 지원
  - Dynamic Loading
  - 실행 시 모든 클래스 로딩 X. 필요한 시점에 클래스를 로딩하여 사용



## 03. 자바 가상 머신 (JVM)

- JVM (Java Virtual Machine) : 자바를 실행하기 위한 가상 머신 (가상머신 -> 소프트웨어로 구성된 컴퓨터)

- OS에 종속적이고, 다른 OS에서 실행시키기 위해선 그 OS에 맞는 JVM이 필요

  | Java 애플리케이션    | 일반 어플리케이션 |
  | :------------------- | :---------------- |
  | JVM (OS에 따라 다름) | OS                |
  | OS                   | 컴퓨터 (하드웨어  |
  | 컴퓨터 (하드웨어)    |                   |



## 04. 자바 프로그램 작성

- JDK 외 메모장(notepad.exe), 에딧플러스(EditPlus) 등의 편집기 필요
- 파일명과 클래스 이름은 동일 (대소문자 체크)

```` java
class Hello {
  public static void main(String [] args) {
    System.out.println("Hello, World."); //화면에 글자 출력
    // result : Hello World.
  }
}
````

- Hello.java 작성 -> javac.exe 컴파일 -> Hello.class 생성 -> java.exe 실행(자바 인터프리터) -> "Hello, World." 출력
- 모든 코드는 클래스 안에 존재, 서로 관련된 코드들은 그룹으로 나눠 별도 클래스 구성

```` java
class 클래스이름 { // 메서드의 시작
  /*
  	주석을 제외한 모든 코드는 클래스의 블럭 {} 내에 작성
  	package문과 import문은 예외적으로 클래스 밖에 작성
	*/
} // 메서드의 끝
````

```` java
class 클래스이름 {
  public static void main(String [] args){ //main 메서드의 선언부
    // 실행될 코드를 작성
  }
}
````

- [] 은 배열을 의미는 기호로 배열의 타입(type) 또는 배열의 이름 옆에 붙인다. String[] args  -> String 타입의 배열 args를 선언한 것이다.



## 05. 자바 프로그램의 실행 과정

1. 프로그램의 실행에 필요한 클래스 (*.class 파일) 로드
2. 클래스 파일 검사. (파일형식, 악성코드 체크)
3. 지정된 클래스 (Hello)에서 main (String[] args)를 호출

```` Java
c:\jdk1.8\work>java Hello
           //  main(String[] args)
````

- 클래스 내에 main 메소드 없을 시 -> Exception in thread "main" java.lang.NoSuchMethodError: main



## 06. 주석(comment)

- 코드 설명, 프로그램의 작성자, 작성일시, 버전과 그에 따른 변경이력 등의 정보 제공 목적
- 컴파일러는 주석을 무시하고 진행
- 큰따옴표(" ") 안에 주석이 있을 땐 주석이 아니라 문자열로 인식

``` java
/* 범위 주석 */
// 한 줄 주석

/*
	Data : 2020.08.04
	Source : Hello.java
	Author : yuseon
*/

class Hello {
  public static void main(String [] args) /* 프로그램의 시작 */
  {
    System.out.println("Hello, world.") // Hello, world. 출력
    System.out.println("Hello, /* 주석 아님 */ world.") // Hello, /* 주석이 아님 */ world. 출력
    System.out.println("Hello, world. // 주석 아님 ") // Hello, world. // 주석 아님 출력      
  }
}
```



## 07.자주 발생하는 에러와 해결방법

- cannot find symbol 또는 cannot resolve symbol
  - 지정된 변수나 메서드를 찾을 수 없다는 의미. 선언되지 않은 변수나 메서드 사용, 변수  또는 메서드 이름을 잘못 사용한 경우에 발생
  - 대소문자 구분하기 때문에 철자와 대소문자의 일치여부도 확인
- ';' expectd
  - 세미콜론 ';'이 필요한 곳에 없다는 의미. 자바의 모든 문장은 ';' 으로 끝나야 한다
- Exception in thread "main" java.lang.NoSuchMethodError : main
  - 'main 메서드를 찾을 수 없다.' -> 클래스 내에 메서드가 존재 하지 않거나, public static void main(String [] args) 메서드 선언부의 오타 
- Exception in thread "main" java.lang.NoClassDefFoundError : Hello
  - 'Hello 라는 클래스를 찾을 수 없다.' -> 대소문자 체크 및 클래스파일(*.class) 생성 확인
- illegal start of expression
  - 문장 또는 수식의 앞부분이 문법에 맞지 않는단 의미. 문장에 문법적 오류 시 발생
  - { , ( 를 사용하고 닫지 않거나 if문, for문 등 문법적 오류가 있을 때, public / static과 같은 키워드를 잘못 사용한 경우에 발생
- class, interface, or enum expectd
  - 키워드 class 나 interface 또는 enum이 없다.
  - 보통 괄호의 개수가 일치하지 않아 발생하는 오류. 열린 괄호와 닫힌 괄호의 개수 체크.
- 에러 메시지를 잘 읽고 해당 코드 확인 필요 -> 이상 없을 시 기본적인 부분 재확인
- 의심이 가는 부분을 주석처리 하거나 따로 떼어내서 테스트



## 08. Question

1. 객체지향 프로그래밍 언어의 종류에는 무엇이 있을까?
2. 질문
3. 질문
4. 질문
5. 질문