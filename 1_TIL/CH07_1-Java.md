# CHAPTER 7_1

# 객체지향 프로그래밍 (Object Oriented Programming; OOP)



## 01. 상속(Inheritence)

기존의 클래스를 `재사용`하여 새로운 클래스를 작성하는 것. 코드의 재사용성을 높이고 중복을 제거하여 **프로그램의 생산성과 유지보수에 크게 기여한다.**

- **`IS-A 관계`**

- 적은 양의 코드로 새로운 클래스를 작성할 수 있다.

- 코드를 공통적으로 관리하여 코드의 추가 및 변경이 용이하다.

- 새로 작성하는 클래스 이름 뒤에 `extend` 키워드와 상속받고자 하는 클래스를 사용한다.

  ```java
  /**
  * 자손 클래스 : 조상 클래스의 모든 멤버를 상속 받는다. Child 클래스는 Parent 클래스의 멤버들을 포함한다.
  * 						생성자와 초기화 블럭은 상속되지 않는다.
  * 					 	자손 클래스의 멤버 개수는 조상 클래스와 같거나 항상 많다.
  */
  
  class Parent {} // 조상클래스 
  class Child extends Parent{} // 자손클래스 
  ```



## 02. 클래스 간의 관계 - 포함관계(Composite)

**has-a 관계**  :  상속 이외의 클래스를 재사용하는 방법. `포함 관계` 는 한 클래스의 멤버변수로 `다른 클래스 타입의 참조변수를 선언`하는 것이다.

```java
class Circle {
  //int x; // 원점의 x 좌표
  //int y; // 원점의 y 좌표
  Point c = nwe Point(); // 원점
  int r; // 반지름
}

class Point {
	int x; // x 좌표
	int y; // y 좌표  
}
```



## 03. 클래스 간의 관계 결정하기

- **상속 관계** '~은 ~이다.(is - a)'
- **포함 관계** '~은 ~을 가지고 있다.(has - a)'



## 04. 단일 상속(single inheritance)

둘 이상의 클래스로부터 상속 받을 수 없다.

- 클래스 간의 관계가 보다 명확해진다
- 코드를 신뢰할 수 있다

```java
class TvDVD extends Tv, DVD {
  // 에러. 조상은 하나만 허용된다.
}
```





## 05. Object 클래스 - 모든 클래스의 조상

`Object 클래스`는 모든 클래스 상속 계층도의 `최상위 조상 클래스`  이다.

- 다른 클래스로부터 상속 받지 않는 모든 클래스를 자동적으로 Object 클래스로부터 상속 받게 한다.
  - 이미 상속 받도록 작성 된 클래스에 대해서는 컴파일러가 'extends Object'를 추가하지 않는다.
- 상속 계층도에서는 단순화 하기 위해 Object 클래스를 생략하는 경우도 있다.
- toString() 이나 equals(Object o ) 와 같은 메서드를 따로 정의하지 않고 사용할 수 있던 이유이기도 하다.                                 (메서드들이 Object 클래스에 정의된 것이기 때문.)



## 06. 오버라이딩 (overriding)

메소드의 기능을 재정의하는 것을 메소드 재정의 (Method overriding)이라 부른다.

```java
public class Person {
  public void writeCode() {
    System.out.println("아무 코드나 일단 적어보았다.");
  }
}
```

```java
public class Developer extends Person {
  @Override
  public void writeCode() {
    System.out.println("깔끔하고 예쁜 코드를 적어보았다.");
  }
}
```



### 오버라이딩의 조건

오버라이딩은 메서드의 내용만 새로 작성하는 것이므로 **메서드의 선언부(메서드 이름, 매개변수, 반환타입) 은 조상의 것과 완전히 일치**해야 한다. 접근 제어자(access modifier)와 예외(exception)는 제한된 조건 하에 다르게 변경 할 수 있다.

1. **접근 제어자는 조상 클래스의 메서드보다 좁은 점위로 변경할 수 없다.**

   - 조상 클래스의 정의된 메서드의 접근 제어자가 protected 라면, 이를 오버라이딩 하는 자식 클래스 메서드의 접근제어자는 protected나  public이어야 한다.
   - 접근 범위 : public > protected > (default) > private

2. **조상 클래스의 메서드보다 많은 수의 예외를 선언할 수 없다.**

   ```java
   class Parent {
     void parentMethod() throws IOException, SQLException {
       ...
     }
   }
   
   
   class Child extends Parent  {
     @Override
     void parentMethod() throws IOException { // 부모의 parentMethod 의 예외보다 적게 선언됨.
       ...
     }
   }
   ```

   



## 07. 오버로딩 VS 오버라이딩

**오버로딩 (overloading)**

- 기존에 없는 새로운 메서드를 정의하는 것 (new)

**오버라이딩 (overriding)**

- 상속받은 메서드의 내용을 변경하는 것 (change, modify)

```java
class Parent {
  void parentMethod(){}
  }
}

class Child extends Parent  {
	@Override
  void parentMethod() {} // 오버라이딩 
	void parentMethod(int i) {} // 오버로딩
  
  void childMethod() {}
  void childMethod(int i) {} // 오버로딩
}
```



## 08. 참조변수 super

- `this`가 현재 객체를 참조하듯, `super`는 부모 객체를 참조한다. ( 상속받은 멤버와 자신의 멤버가 이름이 같을 때 사용)

- `super`로 부모의 부모 객체에는 접근할 수 없다.

  ```java
  public class Foo {
    String x = "foo";
  }
  
  public class Bar extends Foo{
    String x = "bar";
  
    void method() {
      String x = "method";
  
      System.out.println(x); 			// bar
      System.out.println(this.x); // bar
      System.out.println(super.x);// foo
    }
  }
  ```





## 09. super() - 조상의 생성자

- 부모의 생성자를 호출하는 `super`

- 반드시 생성자의 첫줄에만 올 수 있음

  ```java
  public class Foo {
    String x;
  
    public Foo(String x) {
      this.x = x;
    }
  }
  
  public class Bar extends Foo {
    String y;
  
    public Bar(String x, String y) {
      super(x);		 // 조상 클래스의 생성자 Foo(String x) 를 호출 
      this.y = y;  // 자신의 멤버를 초기화
    }
  }
  ```

  

## 10. 패키지 (Packages)

- 클래스의 묶음 ( 클래스의 효율적인 관리)
- Java에서 소스 코드를 관리하는 방식
- 물리적으로 디렉토리로 구분된 파일을 .으로 계층적으로 구분
- 패키지 이름을 짓는 규칙: `package 소속.프로젝트.용도`
  -  ex) `package com.google.dev.utils` 
  - ex) `package com.fastcampus.catcare.service`



### 패키지의 선언

- 주석과 공백을 제외하고 소스 파일(.java) 맨 위에 선언한다.

```java
package 패키지명;
```

- 하나의 소스파일에 단 한 번만 선언 가능
- 패키지명은 소문자로 작성하는 것이 원칙



## 11. 임포트(Imports)

- 모든 소스파일(.java) 에서 import문은 package문과 클래스 선언문 사이에 위치

  - 한 소스에 여러번 선언 가능

- 다른 패키지에 선언된 클래스를 사용하기 위한 키워드

- 패키지에 속한 모든 클래스를 import (하위 패키지는 포함하지 않음)

  ```java
  import com.example.project.utils.*;
  ```

- 패키지에 속한 특정 클래스를 import

  ```java
  import com.fastcampus.dogcare.service.WebAPI;
  import java.io.InputStream;
  ```

- 클래스의 이름이 겹치는 경우, 패키지명을 포함하여 사용

  ```java
  import java.util.List;
  
  public class Foo {
    public static void main(String args[]) {
      List list = new List();
      java.awt.List list2 = new java.awt.List();
    }
  }
  ```



## 12. static import문

- static 멤버는 static import하여 클래스를 생략하고 사용 가능

  ```java
  import static java.lang.Math.random;
  import static java.lang.System.out;
  
  public class StaticImport {
    public static void main(String args[]) {
      out.println(random());
    }
  }
  ```

  

## 13. 제어자(Modifier)

- 클래스, 변수, 메소드에 부가 기능을 부여하는 키워드
- 접근 제어자 (Access modifiers)
  - 접근할 수 있는 범위를 정하는 키워드
  - `public`, `protected`, `(default = package)`, `private`
- 그 외 제어자 (Other modifiers)
  - 특별한 기능을 부여하는 제어자
  - `static`, `final`, `abstract`, `synchronized`



## 14. static - 클래스의, 공통적인

- `static`(클래스 변수)
  - 클래스 변수, 클래스 메소드 등을 선언하기 위해 사용

| 제어자 | 대상     | 의미                                                         |
| ------ | -------- | ------------------------------------------------------------ |
| static | 멤버변수 | - 모든 인스턴스에 공통적으로 사용되는 클래스 변수<br/>- 클래스 변수는 인스턴스를 생성하지 않고도 사용가능 <br/>- 클래스가 메모리에 로드될 때 생성 |
|        | 메서드   | - 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드<br/>- static 메서드 내에서는 인스턴스 멤버들을 직접 사용할 수 없다 |

```java
class StaticTest {
  static int width = 200;  // 클래스 변수 = static 변수
  static int heigth = 120; // 클래스 변수 = static 변수

  static { // 클래스 초기화 블럭
    // static 변수의 복잡한 초기화 수행
  }
  
  static int max(int a, int b) { // 클래스 메서드 = static 메서드
     return a > b ? a : b;
  }
  
}
```



## 15. final - 마지막의, 변경될 수 없는

- 더 이상 바뀔 수 없음을 의미

- 클래스, 메소드, 변수에 사용할 수 있음

  - 클래스 : 더 이상 상속 불가능. (다른 클래스의 조상이 될 수 없다.)
  - 메서드 : 자식 클래스에서 오버라이드 불가능
  - 변수 : 변수의 값이 초기화 이후 변하지 않는다
    - 생성자에서 초기화가 이루어지는 것을 `blank final` 변수라 한다.

  ```java
  public class Foo {
    final int x = 0; // final variable
    final int y; // blank finial variable
  
    public Foo(int y) {
      this.y = y; // blank final variable initialization
    }
  
  }
  ```



## 16. abstract - 추상의, 미완성의

- 추상 클래스에서 사용
- 인스턴스 생성 불가능

| 제어자   | 대상   | 의미                                                         |
| -------- | ------ | ------------------------------------------------------------ |
| abstract | 클래스 | 클래스 내에 추상 메서드가 선언 되었음을 의미                 |
|          | 메서드 | 선언부만 작성하고 구현부는 작성하지 않은 추상 메서드임을 알림 |

```java
abstract class AbstractTest {  // 추상 클래스 (추상 메서드가 포함된 클래스)
  abstract void move(); // 추상 메서드 (구현부가 없는 메서드)
}
```



## 17. 접근 제어자 (Access modifier)

- 접근 가능한 범위를 정해, 데이터 은닉/보호 (Encapsulation) 기능을 추가한다.

- public (접근제한 x) > protected (같은 패키지 + 자식) > default (같은 패키지) > private (같은 클래스)

- 접근 제어자별 접근 범위

  | 제어자      | 같은 클래스 | 같은 패키지 | 다른 패키지에 속한 자식 클래스 | 전체 |
  | ----------- | ----------- | ----------- | ------------------------------ | ---- |
  | `public`    | O           | O           | O                              | O    |
  | `protected` | O           | O           | O                              |      |
  | `default`   | O           | O           |                                |      |
  | `private`   | O           |             |                                |      |





## 18. 캡슐화와 접근 제어자

### 캡슐화(Encapsulation), 데이터 감추기 (Data hiding) 

- 데이터가 유효한 값을 유지하게끔 함.

- 외부에서 함부로 데이터를 변경하지 못하도록 접근 제한.

- 외부에서 접근할 필요가 없는 멤버를 private로 지정하여 복잡성을 줄임

- `private` 또는 `protected` 변수에 접근하기 위해 getter와 setter 사용

  ```java
  class public Foo {
    private int x = 0;
    private int y = 1;
  
    public void setX(int x) { // setter
      this.x = x;
    }
  
    public void setY(int y) { // setter
      if (y >= 0) {
        this.y = y;
      }
    }
  
    public int getX() { // getter
      return x;
    }
  
    public int getY() { // getter
      return y;
    }
  }
  ```



## 19.다형성 (Polymorphism)

여러 가지 형태를 가질 수 있는 능력.

- 부모 클래스 타입으로 자식 클래스 객체를 참조하는 특징

  ```java
  public class Foo {
    public void methodA() {
      return;
    }
  }
  
  public class Bar extends Foo {
    public void methodB() {
      return;
    }
  }
  
  public class Main {
    public static void main(String args[]) {
      Bar bar = new Bar();
  
      Foo foo = (Foo)bar;
    }
  }
  ```

  

- 부모 클래스로 자식 클래스를 참조한 경우, 자식 클래스의 메소드는 사용할 수 없다.

  ```java
  public class Main {
    public static void main(String args[]) {
      Bar bar = new Bar();
      Foo foo = (Foo)bar;
  
      foo.methodA(); // works
      // foo.methodB(); // error
    }
  }
  ```

  

- 자식 클래스로 부모 클래스를 참조하려 하면 java.lan.ClassCastException 오류 발생

  ```java
  public class Main {
    public static void main(String args[]) {
      Foo foo = new Foo();
      Bar bar;
  
      // bar = (Bar)foo; // error
      if (foo instanceof Bar) { // returns false
        bar = (Bar)foo;
      }
    }
  }
  ```

  