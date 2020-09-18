# CHAPTER 8

# 예외처리 (Exception Handling)



## 01. 프로그램 오류

- 프로그램 실행 중 오작동을 하거나 비정상적으로 종료되는 경우

- 발생시점에 따라 `컴파일 에러(compile - time error)` 와 `런타임 에러(runtime error)` 로 나뉜다.

  - `논리적 에러(logical error)` : 실행은 되지만, 의도와 다르게 동작하는 것

- 실행(runtime) 시 발생할 수 있는 프로그램 오류를 `에러(error)` 와 `예외(exception)` 로 구분할 수 있다.  

  

### 에러 (오류, Errors) 

- 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
  - 시스템의 메모리가 부족하거나, 무한히 메소드 호출이 발생하는 등 프로그램 복구가 불가능한 상황 ex) 메모리부족(OutOfMemoryError), 스택오버플로우(StackOverflowError)
- 오류가 발생하는 원인을 찾아서 제거하는 방법으로 해결  



### 예외 (Exceptions)

- 프로그램 코드에 의해서 수습될 수 있으며, 오류에 비해 심각도가 낮다.
  - 프로그램의 정상적인 흐름을 방해 ex) 파일명으로 파일을 읽으려 하는데, 파일을 찾을 수 없음
- 문제 상황을 해결하는 로직을 별도로 구성하여 해결 가능  





## 02. 예외 클래스의 계층구조

- 모든 클래스의 조상은 Object 클래스이므로 Exception과 Error 클래스 역시 Object 클래스의 자손이다.
- 모든 예외의 최고 조상은 Exception이다.
- 예외 클래스는 크게 두 그룹으로 나눌 수 있다.
  - Exception클래스와 그 자손들 (RuntimeException과 자손들 제외)
  - RuntimeException클래스와 그 자손들

![Exception클래스와 runtimeException클래스 중심의 상속계층도](https://blog.kakaocdn.net/dn/lQtmI/btqwOl7yCfm/t7rnJnKrWJAkDFpyKSwUd1/img.png)





## 03. Exception과 RuntimeException

- Exception 클래스와 자손 : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
  - ex) 존재하지 않는 파일이름 작성(FileNotFoundException), 잘못된 클래스 이름 작성(ClassNotFoundException) 등
- RuntimeException 클래스와 자손 : 프로그래머의 실수로 발생하는 예외
  - ex) 배열의 범위를 벗어나거나(ArrayIndexOutOfBoundsException), 값이 null인 참조변수 멤버 호출(NullPointerException) 등  





## 04. 예외 처리하기 (try - catch 문)

### 예외처리

- 예외가 발생했을 때, 상황을 감지하고 해결하기 위해 동작하는 코드
- try ~ catch 구문과 Exception 클래스와 그 자식 클래스를 활용
  - 하나의 try 블럭 다음에는 여러 종류의 예외를 처리할 수 있도록 하나 이상의 catch 블럭이 올 수 있다
  - if ~ else if 구문처럼, 순차적으로 검사하면서 적용 가능한 예외를 처리하지만 괄호 {} 생략 불가능
  - 다형성이 적용되어, 자식 예외를 처리 가능

```java
try {
  // 예외가 발생할 수 있는 코드 영역
  // 예외 발생 시 예외 객체를 던짐 (throw)
} catch (Exception1 e1) { // 던져진 예외를 받음 (catch)
  // Exception의 자식 클래스로 지정하여 특정 클래스를 받는다.
  // 예외 상황을 처리하는 코드
} catch (Exception2 e2) { // 던져진 예외를 받음 (catch)
  // Exception2가 발생했을경우 이를 처리하는 코드
}
```







## 05. try - catch문에서의 흐름

- try 블럭 내에서 예외 발생
  - 발생한 예외와 일치하는 catch 블럭의 유무 체크
  - 일치하는 catch 블럭을 찾으면 그 블럭 내 코드를 수행하고, 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다. (catch 블럭을 찾지 못하면 예외는 처리되지 못한다)
- try 블럭 내에서 예외가 발생하지 않음
  - catch 블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.

```java
class Ex8_1 {
  public static void main(String args[]) {
    System.out.println(1);			
    try {
      System.out.println(2);
      System.out.println(3);
    } catch (Exception e)    {
      System.out.println(4);  // 실행되지 않는다
    } // try-catch의 끝
    System.out.println(5);
  }
}

[결과]
1
2
3
5
```





## 06. 예외의 발생과 catch 블럭

```java
try {
  // 예외 발생 가능 코드 영역
  // 예외 발생 가능 코드 실행하던 중 예외가 발생하면 예외 코드 이후는 실행하지 않고
  // catch 블럭의 괄호( ) 내에 선언된 참조변수의 종류와 생성된 예외클래스의 인스턴스에 
  // instanceOf 연산자를 이용해 검사 -> 검사 결과가 true 블럭을 만날 때까지 검사한다.
} catch (AException e) {
  // A예외 처리
} catch (BException e) {
  // B예외 처리
} catch (CException e) {
  // C예외 처리
} catch (Exception e) {
  // 나머지 모든 예외 처리
}
```





## 07. printStackTrace()와 getMessage()

- catch 블럭의 괄호 ( ) 에 선언된 참조변수를 통해 인스턴스 접근 가능
- catch 블럭 내에서만 사용 가능



### 자주 사용되는 메서드

- printStackTrace()
  - 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외 메시지를 화면 출력
- getMessage()
  - 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

```java
class Ex8_5 {
  public static void main(String args[]) {
    System.out.println(1);			
    System.out.println(2);

    try {
      System.out.println(3);
      System.out.println(0/0); // 예외발생!!!
      System.out.println(4);   // 실행되지 않는다.
    } catch (ArithmeticException ae)	{
      ae.printStackTrace();
      System.out.println("예외메시지 : " + ae.getMessage());
    }	// try-catch의 끝

    System.out.println(6);
  }	// main메서드의 끝
}

[결과]
1
2
3
java.lang.ArithmeticException: / by zero
  at Ex8_5.main(Ex8_5.java:8)
예외메시지 : /	by zero
6
```







## 멀티 catch 블럭

- JDK1.7 부터 여러 catch블럭을 `|` 을 이용해 하나의 catch 블럭으로 합칠 수 있다 ( = 멀티 catch 블럭)

  ```java
  try {
    // 예외 발생 가능 코드 영역
  } catch (ExceptionA | ExceptionB e) {
    e.printStackTrace();
  }
  ```

- 멀티 catch 블럭 중 예외 클래스가 조상과 자손의 관계에 있다면 컴파일 에러 발생

  ```java
  try {
    // 예외 발생 가능 코드 영역
  //} catch (ParentException | ChildException e) { // 에러
  } catch (ParentException e) { // 위 라인과 의미상 동일
  	e.printStackTrace();
  }
  ```

- 멀티 catch는 하나의 catch블럭으로 여러 예외를 처리하는 것이므로, 멀티 catch 내에서는 실제로 어떤 예외가 발생한 것이지 알 수 없다.

  - 참조변수 e 로 멀티 catch 블럭 | 로 연결된 예외클래스들의 공통분모인 조상 예외 클래스에 선언된 멤버만 사용 가능

  ```java
  try {
    // 예외 발생 가능 코드 영역
  } catch (ExceptionA | ExceptionB e) {
    e.methodA(); // 에러. ExceptionA에 선언된 methodA()는 호출 불가
  
    if(e instanceOf ExceptionA) {
      ExceptionA e1 = (ExceptionA)e;
      e1.methodA(); // ExceptionA에 선언된 메서드 호출가능
    } 
  }
  ```





## 08. 예외 발생시키기

- 키워드 `throw` 를 이용해 고의로 예외를 발생시킬 수 있다.

  - 연산자 new 를 이용해서 발생시키려는 예외 클래스의 객체 생성

  ```java
  Exception e = new Exception("고의 발생");
  ```

  - 키워드 throw 를 이용해 예외 발생

  ```java
  throw e;
  ```

- 호출한 메소드로 예외 처리를 전달하는 방식

```java
class Ex8_6 {
  public static void main(String args[]) {
    try {
      Exception e = new Exception("고의로 발생시켰음.");
      throw e;	 // 예외를 발생시킴
      //  throw new Exception("고의로 발생시켰음."); // 위 두 줄을 한 줄로 처리

    } catch (Exception e)	{
      System.out.println("에러 메시지 : " + e.getMessage());
      e.printStackTrace();
    }
    System.out.println("프로그램이 정상 종료되었음.");
  }
}
```







## 10. checked 예외, unchecked 예외

- Checked Exceptions: 예외 처리되지 않으면 컴파일이 되지 않는 예외

- Unchecked Exceptions: 예외 처리되지 않아도 컴파일이 되는 예외

- 




## 11. 메서드에 예외 선언하기

- 메서드 선언부에 키워드 `throws` 를 사용한다.

- 메서드 내에서 발생할 수 있는 예외를 키워드 뒤에 적어준다.

  - 예외가 여러 개일 경우에는 쉼표  ' , ' 로 구분한다.

- 예외를 발생시키는 키워드 `throw`, 예외를 메서드에 선언하는 키워드 `throws`

- Checked Exception의 경우 throws로 위임 가능하나, 최종적으로 try ~ catch를 만나야 함

  ```java
  class CheckedException {
    void methodA() throws ClassNotFoundException {
      Class.forname("A Class");
    }
  
    void methodB() {
      try {
        methodA();
      } catch (ClassNotFoundException e) {
        ...
      }
    }
  }
  ```

- Unchecked Exception의 경우 throws로 위임하지 않아도 자동으로 전달

  ```java
  class UncheckedException {
    void methodA() {
      int x = 10;
      x = 10/0;
    }
    void methodB() {
      try {
        methodA();
      } catch (ArithmeticException e) {
        ...
      }
    }
  }
  
  ```

- 메소드를 오버라이드한 경우, 조상 클래스의 메소드보다 조상 예외는 던질 수 없음

  ```java
  class Foo {
    void methodA() throws IOException {}
  }
  
  class BarOne extends Foo{
    void methodA() throws IOException {} // possible
  }
  
  class BarTwo extends Foo{
    void methodA() throws FileNotFoundException {} // possible
  }
  
  class BarThree extends Foo{
    void methodA() throws Exception {} // *NOT* possible
  }
  ```



## 12. finally 블럭

- try 구문 실행 중에 어떤 일이 발생해도 반드시 실행되어야 하는 구문은 finally 블록에 작성

- try - catch - finally 순으로 실행

- try 구문 내에 return문이 있는 경우에도 finally 블록은 실행됨

- try 구문 내에서 접근한 System 자원을 안전하게 복구하기 위해 사용

  ```java
  FileInputStream file = null;
  
  try {
    // 예외가 발생할 가능성이 있는 코드
    file = new FileInputStream(fileName);
    file.read();
  } catch (IOException e) {
    // 예외처리를 위한 코드
    System.out.println("파일처리실패");
  } finally {
    // 예외의 발생여부에 관계없이 항상 실행되어야 하는 구문
    // finally 블럭은 try-catch문의 맨 마지막에 위치해야 함
    if (file != null) {
      try {
        file.close();
      } catch (IOException e) {
        System.out.println("파일인풋스트림 종료 실패");
      }
    }
  }
  ```

  



## 13. 사용자 정의 예외 만들기

### 사용자 정의 예외 (Custom Exceptions)

- Exception 또는 RuntimeException 클래스를 상속하여 작성

  - Exception을 상속한경우 Checked Exception이 되어 반드시 예외를 처리해야 한다.

  ```java
  class MyException extends RuntimeException {
    // RuntimeException 클래스로부터 상속받아 MyException 클래스 생성
    enum ErrorCode {
      ERROR_A, ERROR_B;
    }
  
    private ErrorCode errorCode;
  
    public MyException(ErrorCode errorCode, String message) { // 생성자
      super(message);
      this.errorCode = errorCode;
    }
  
    @Override
    public String getLocalizedMessage() {
      String message = getMessage();
      ...
        return localizedMessage;
    }
  }
  ```

  



## 14. 예외 되던지기(exception re - throwing)

- 예외를 처리한 후, 인위적으로 다시 발생시키는 방법

- 예외가 여럿인 경우, try-catch문을 통해 메서드 내에서 자체 처리하고, 나머지는 선언부에 지정하여 호출한 메서드에서 처리 가능

- 단 하나의 예외일 때도 예외가 발생한 메서드와 호출한 메서드, 양쪽에서 처리 가능

  - 예외가 발생할 메서드에서는 try-catch문을 사용해서 예외처리를 해둠과 동시에 메서드의 선언부에서 발생할 예외를 throws에 지정해줘야 함

  ```java
  class Ex8_12 {
    public static void main(String[] args) {
      try  {
        method1();		
      } catch (Exception e)	{
        System.out.println("main메서드에서 예외가 처리되었습니다.");
      }
    }	// main메서드의 끝
  
    static void method1() throws Exception {
      try {
        throw new Exception();
      } catch (Exception e) {
        System.out.println("method1메서드에서 예외가 처리되었습니다.");
        throw e;			// 다시 예외를 발생시킨다.
      }
    }	// method1메서드의 끝
  }
  
  [결과]
  method1메서드에서 예외가 처리되었습니다.
  main메서드에서 예외가 처리되었습니다.
  ```







## 15. 연결된 예외(chained exception)

- 한 예외가 다른 예외를 발생시킬 수 있다.

  - 여러가지 예외를 하나의 큰 분류 예외로 묶어서 다루기 위함

- Throwable 클래스는 Exception과 Error 클래스에 의해 상속

  - Exception
    - Checked Exceptions, Unchecked Exceptions
  - Error: 프로그램이 복구 불가능한 상황  

  ```java
  static void startInstall() throws SpaceException {
    if(!enoughSpace()) // 충분한 설치 공간이 없으면
      throw new SpaceException("설치 공간 부족"); 
    
    if(!enoughMemory()) // 충분한 메모리가 없으면
      throw new RuntimeException(new MemoryException("메모리 부족"));
   		 // MemoryException은 Exception의 자손이므로 반드시 예외처리르 해야하는데
    	 // 이 예외를 RuntimeException가 감싸고 있기 때문에 Unchecked Exceptions 이 됨 
  } // end startInstall 
  ```

  

### Exception 클래스

- Throwable 클래스의 주요 메서드

  | 메소드                                        | 설명                                                         |
  | --------------------------------------------- | ------------------------------------------------------------ |
  | `public String getMessage()`                  | 발생한 예외에 대한 메세지를 반환                             |
  | `public String getLocalizedMessage()`         | 오버라이드하여 추가 메세지 제공 (오버라이드하지 않으면 getMessage()와 동일) |
  | `public Throwable getCause()`                 | 예외의 원인이 되는 Throwable 객체 반환. ( 원인 예외 반환 )   |
  | `public void printStackTrace()`               | 예외가 발생된 메소드가 호출될 때의 Method call stack을 출력  |
  | `public Throwable initCause(Throwable cause)` | 지정한 예외를 원인 예외로 등록                               |
  | `public RuntimeException(Throwable cause)`    | 원인 예외를 등록하는 생성자                                  |

