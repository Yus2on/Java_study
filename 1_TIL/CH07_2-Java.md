# CHAPTER 7_2

# 객체지향 프로그래밍 (Object Oriented Programming; OOP)



## 01. 참조변수의 형변환

- 바로 윗 조상이나 자손이 아닌, 조상의 조상으로도 형변환이 가능하다.
- 모든 참조변수는 모든 클래스의 조상인 Object 클래스 타입으로 형변환이 가능하다.

```java
class Car{}
class FireEngine extends Car{}
class Ambulance extends Car{}
```

```java
FireEngine f = new FireEngine();
Car c = (Car)f;								 // 생략 가능 -> Car c = f;
FireEngine f2 = (FireEngine)c; // 생략 불가
Ambulance a = (Ambulance)f; 	 // 상속관계가 아닌 클래스 간의 형변환 불가능!
```

> FireEngine타입의 참조변수 f는 조상타입인 Car로 형변환이 가능하고, 반대의 형변환도 가능.
>
> - FireEngine과 Ambulance는 상속관계가 아니므로 형변환이 불가능.





## 02. instanceof 연산자

- 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 사용.
- `조건문`에 주로 사용함. 
- `instanceof` 왼쪽에는 참조변수를, 오른쪽에는 타입(클래스명)이 피연산자로 위치.
  - 연산의 결과로 boolean값 반환( `true` / `false` ) 

```java
/**
 * 1. Car 타입 참조변수 c를 매개변수로 하는 메서드가 호출.
 * 2. 매개변수로 Car 클래스 또는 그 자손 인스턴스를 넘겨받지만 메서드 내에서는 정확히 어떤 인스턴스인지 알 수 없기 때문에 `instanceof` 연산자 사용.
 * 3. 참조변수 c가 가리키고 있는 인스턴스 타입을 체크함.
 *
 * 값이 null 인 참조변수의 값 -> false
 */
   
void doWork(Car c) {
  if (c instanceof FireEngine) {		// 1. 형변환이 가능한지 확인
    FireEngine fe = (FireEngine)c;	// 2. 형변환
    fe.water();
    ...
  }
}
```





## 03. 매개변수의 다형성

```java
class Product {
  int price;			// 가격
  int bonusPoint; // 구매 시 제공하는 보너스
  
  Product(int price){
    this.price = price;
    bonusPoint = (int) (price/10.0); // 보너스는 제품가격의 10%
  }
}

class Tv extends Product {
  Tv() {
    // 조상 클래스의 생성자 Product(int price) 호출함...
    super(100); // Tv 가격을 100으로 지정
  }
  
  // Object클래스의 toString 오버라이드 함
  public String toString(){
    return "Tv";
  }
}

class Computer extends Product {
  Computer() {
    super(200);
  }

  public String toString(){
    return "Computer";
  }
}

class Buyer { // 고객, 물건을 사는 사람
  int money = 1000; 	// 소유금액
  int bonusPoint = 0; // 보너스
  
  /*******************************************/
  // 이런식으로 하면 제품의 종류가 늘어날 때마다 새로운 buy 메서드를 추가해야한다
  void buy(Tv t) { 
    // 바이어가 가진 돈(money)에서 제품가격(price)만큼 뺀다.
    money -= t.price; // money = money - t.price

    // 바이어의 보너스(bonusPoint)에서 제품의 보너스(t.bonusPoint)를 더한다.
    bonusPoint += t.bonusPoint;
	}
  /******************************************/
  
  void buy(Product p) {
    if(money < p.price){
      System.out.println("잔액부족");
    }
    
    money -= p.price;
    bonusPoint += p.bonusPoint
    System.out.println(p + " 구입 완료");
  }
}

class Ex7_8{
  public static void main(String[] args) {
    Buyer b = new Buyer();
    b.buy(new Tv());
    b.buy(new Computer());

    System.out.println("남은 돈 : " + b.money);
    System.out.println("모인 보너스 : " + b.bonusPoint);
  }
}

결과 :
Tv 구입 완료
Computer 구입 완료
남은 돈 : 700
모인 보너스 : 30
```





## 04. 여러 종류의 객체를 배열로 다루기

- 조상타입의 참조변수로 자식 타입의 객체 참조 가능

  - 배열로 사용하면 공통 조상을 가진 서로 다른 종류의 객체를 배열로 묶어서 사용할 수 있다.

  ``` java
  class Buyer { // 고객, 물건을 사는 사람
    int money = 1000; 	// 소유금액
    int bonusPoint = 0; // 보너스
    product[] cart = new product[10]; // 구입한 제품을 저장하기 위한 배열(== 카트)
    int i = 0;
      
    void buy(Product p) {
      if(money < p.price){
        System.out.println("잔액부족");
      }
      
      money -= p.price; // 가진 돈 - 제품 가격
      bonusPoint += p.bonusPoint // 가진 보너스 + 제품의 보너스
  		cart[i++] = p; // 제품을 product[] cart에 저장
      System.out.println(p + " 구입 완료");
    }
  }
  ```

  > new product[10] 로 배열의 크기를 10으로 맞췄기 때문에 11개 이상의 제품을 구매할 수 없는데 이럴 땐 `Vector` 클래스를 사용한다
  >
  > - 동적으로 크기가 관리되는 객체배열
  >
  > ```java
  > Public class Vector extends AbstractList implements List, cloneable, java.io.Serializable {
  >   producted Object elementData[];
  >   ...
  > }
  > ```





## 05. 추상 클래스 (Abstract Class)

- 미완성 설계도. 일부 메서드가 구현되지 않고 선언만 되어 있는 클래스.
  - 자식 클래스에서 반드시 구현해야 하는 메소드를 키워드  `abstract`로 선언
  - 필요한 모든 클래스가 구현될 수 있도록 강제
- 인스턴스 생성 불가능
- 조상 클래스로서 중요한 의미.

```java
abstract class AbstractFoo {
  public void method() {
    return;
  }
}
```





## 06. 추상 메서드(Abstract method)

- 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문에 조상 클래스에는 선언부만 작성.

  - 실제 내용은 상속받는 클래스에서 구현하도록 비워둔다.
  - 키워드   `abstract`로 선언한다.
  - 구현부가 없기 때문에 괄호 {} 대신 문장의 끝을 알리는 `;` 을 사용한다

  ```java
  /* 주석을 통해 어떤 기능을 수행할 목적으로 작성하였는지 설명 */
  public abstract void abstractMethod();
  //             리턴타입  메서드이름()
  ```

  ```java
  abstract class AbstractFoo { 				 // 추상 클래스
    abstract void method(int val) {};	 // 추상 메서드
    abstract void stop() {}; 	 				 // 추상 메서드 
  }
  
  class AbstractBar extends AbstractFoo {
    void method(int val){ // 추상 메서드를 구현
      /* 내용 생략 */
    }
    
    void stop(){					// 추상 메서드를 구현
      /* 내용 생략 */
    }
  }
  
  abstract class AbstractBar2 extends AbstractFoo  {
    void method(int val) { // 추상 메서드를 구현
      /* 내용 생략 */
    }
  }
  ```





## 07. 추상 클래스의 작성

기존의 클래스의 공통부분을 뽑아내서 조상 클래스를 만드는 것

- 상속 -> 자식 클래스를 만드는데 조상 클래스 사용
- 추상화 <-> 구체화

```java
abstract class Unit { // 공통 부분을 뽑아 클래스로 정의함
  int x, y; // 위치
  abstract void move(int x, int y);
  void stop(){/* 현재 위치에 정지 */}
}

class Marine extends Unit { // 보병
  void move(int x, int y){
    // 지정된 위치로 이동
  }
  
  void stimPack(){
    // 스팀팩 사용
  }
}

class Tank extends Unit { // 탱크
  void move(int x, int y){
    // 지정된 위치로 이동
  }
  
  void changeMode(){
    // 공격모드를 변환
  }
}

class Dropship extends Unit { // 수송선
  void move(int x, int y){
    // 지정된 위치로 이동
  }
  
  void load(){
    // 선택된 대상을 태운다
  }
  
  void unload(){
    // 선택된 대상을 내린다
  }
}
```





## 08. 인터페이스(Interface)

- 클래스를 사용하는 방식, 접점만을 선언하는 클래스와 유사한 틀
- 아무런 구현이 되어 있지 않으며, 모든 메소드가 추상 메소드. 
  - 추상 메서드와 상수만을 멤버로 가질 수 있다.
- class 가 아닌 `Interface` 키워드를 사용한다.
  - `public` 또는 `default` 접근 제어자만 사용 가능
- 멤버 변수는 항상 `public static final`이며, 생략 가능
- 멤버 메소드는 항상 `public abstract`이며, 생략 가능
- 클래스와 달리 인터페이스는 여러 개 상속받을 수 있다.

```java
public interface IFoo {
  public static final int MEMBER_VAR = 10;
  int MEMBER_VAR2 = 20; // public static final

  public abstract void methodA(int param);
  void methodB(int param); // public abstract
}

public class Foo implements IFoo {
  @Override
  void methodA(int param) {
    System.out.println(param);
  }

  @Override
  void methodB(int param) {
    System.out.println(param);
  }
}
```





## 09. 인터페이스의 상속

- 인터페이스 간의 'IS-A' 관계
- 인터페이스가 인터페이스를 상속할 경우 `extends`로 상속
- 클래스-클래스와 달리 다중 상속 가능

```java
interface Walkable {
  // 걷는 메서드
  void walk();
}

interface Runnable {
	// 달리는 메서드
  void run();
}

public interface Jumpable extends Walkable, Runnable {
  void jump();
}

public class Jumper implements Jumpable {
  @Override
  void walk() {
    System.out.println("walk");
  }

  @Override
  void run() {
    System.out.println("run");
  }

  @Override
  void jump() {
    System.out.println("jump");
  }
}
```





## 10. 인터페이스의 구현

- 그 자체로는 인스턴스 생성 불가능
- 키워드 `implements` 사용

```java
class className implements interfaceName {
  // 인터페이스에 정의된 추상메서드를 모두 구현
}

// Fighter 클래스는 Fightable 인터페이스를 구현한다
class Fighter implements Fightable {
  public void move(int x, int y){
    // 내용 생략
  }
  
  public void attack(Unit u){
    // 내용 생략
  }
}
```





## 11. 인터페이스를 이용한 다형성

- 인터페이스 타입의 참조변수로 이를 구현한 클래스의 인스턴스를 참조할 수 있다.

  - 인터페이스 타입으로 형변환 가능

    ```java
    // 인터페이스 Fightable을 클래스 Fighter	가 구현했을 때 
    // Fighter 인스턴스를 Fightable 타입의 참조변수로 참조함
    Fightable f = (Fightable)new Fighter();
    Fightable f = new Fighter();
    ```
    
  - 메서드 타입의 매개변수 타입으로도 사용 가능. 
  
    ```java
    class Fighter extends Unit implements Fightable {
      public void move(int x, int y) {
        ...
      }
    
    	public void attack(Fightable f) { // attack(new Fightable f) 가능 
      	...
    	}
      
    }
    ```
  
  - 리턴 타입으로 인터페이스 지정 가능.  **메서드가 해당 인터페이스를 구현한 클래스의 인스턴스를 반환하는 것**.
  
    ```java
    Fightable method() {
      Fighter f = new Fighter();
      return f;
      // return new Fighter(); 과 동일
    }
    ```
  
    

## 12. 인터페이스의 장점

- 개발시간을 단축할 수 있다.
  - 메서드를 호출하는 쪽에서 메서드의 내용 관계 없이 선언부만 알면 된다.
- 표준화가 가능하다.
  - 프로젝트에 사용되는 기본 틀을 인터페이스로 작성하면 일관되고 정형화된 프로그램의 개발이 가능하다.
- 서로 관계없는 클래스들에게 관계를 맺어 줄 수 있다.
  - 하나의 인터페이스를 공통적으로 구현함으로써 관계를 맺어 줄 수 있다.
- 독립적인 프로그래밍이 가능하다.
  - 클래스의 선언과 구현을 분리시킬 수 있기 때문에 실제구현에 독립적인 프로그램을 작성하는 것이 가능하다.
  - 클래스와 클래스 간의 직접적인 관계를 인터페이스를 이용해서 간접적인 관계로 변경하면, 한 클래스의 변경이 관련된 다른 클래스에 영향을 미치지 않는 독립적인 프로그래밍이 가능하다.



## 13. 디폴트 메서드(Default method)와 static 메서드

- 기본 메서드 (디폴트 메서드, Default method) : 자식 클래스에서 구현할 필요가 없는 메서드

  - `JDK 1.8` 추가 사용 가능
  - 인터페이스에 `default` 메소드를 구현할 수 있다.
  - `default` 메소드는 항상 `public`이다. 생략 가능.

  ```java
  interface IFoo {
    void abstractMethod();
  
    default void defaultMethod() { // 구현 클래스에서 구현할 필요가 없다.
      System.out.println("Default method");
    }
  }
  
  class SuperFoo {
    void defaultMethod() {
      System.out.println("Super method");
    }
  }
  
  class FooOne implements IFoo {
    void abstractMethod() {
      return;
    }
  }
  
  class FooTwo extends SuperFoo implements IFoo {
    void abstractMethod() {
      return;
    }
  }
  
  public class Main {
    public static void main(String[] args) {
      FooOne fooOne = new FooOne();
      fooOne.defaultMethod(); // Default method
  
      FooTwo fooTwo = new FooTwo();
      fooTwo.defaultMethod(); // Super method
    }
  }
  
  ```

  - 여러 인터페이스의 디폴트 메서드 간의 충돌 -> 인터페이스를 구현한 클래스에서 디폴트 메서드 오버라이딩 필요
  - 디폴트 메서드와 조상 클래스의 메서드 충돌 -> 조상 클래스의 메서드가 상속되고, 디폴트 메서드는 무시 됨



- static 메소드: 클래스 메소드와 동일하게 사용 가능
  - 인터페이스 이름으로 호출 가능
  - 클래스 구현체의 이름으로는 호출할 수 없음

  ```java
  interface IFoo {
    static void staticMethod() {
      System.out.println("static method");
    }
  }
  
  class Foo implements IFoo {
  }
  
  public class Main {
    public static void main(String[] args) {
      IFoo.staticMethod(); // static method
      // Foo.staticMethod(); // not possible
    }
  }
  ```

  

## 14. 내부 클래스 (Inner Classes)

- 클래스 내부에 선언하는 클래스로 중첩 클래스(Nested Class)라고도 부름

- `HAS-A` 관계에 있는 클래스가 해당 클래스에서만 사용될 경우 주로 사용

  ```java
  class A { // 외부 클래스
    ...
    class B { // 내부 클래스
      ...
    }
    ...
  }
  ```

  

### 내부 클래스의 장점

- 내부 클래스에서 외부 클래스의 멤버들을 쉽게 접근할 수 있다
- 코드의 복잡성을 줄일 수 있다 ( = 캡슐화)



## 15. 내부 클래스의 종류와 특징

### 인스턴스 내부 클래스 (Instance Inner Class)

- 외부 클래스의 멤버변수 선언위치에  `static` 키워드 없이 선언된 클래스
- 외부 클래스의 private을 포함한 모든 멤버에 접근 가능
- 외부 클래스 객체를 통해서만 생성 가능
- static 멤버 변수는 사용할 수 없으나, `static final`은 사용 가능

```java
class Outer {
  class InstanceInner {
    int innerMemberVar = 1;
    //static int staticMemberVar = 1;
    static final int CONSTANT_VAR = 10;

    void innerMethod() {
      System.out.println(innerMemberVar);
      System.out.println(outerMemberVar);
    }
  }

  private int outerMemberVar = 2;

  void outerMethod() {
    IstanceInner obj = new InstanceInner();
    obj.innerMethod();
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    InstanceInner inner = outer.new InstanceInner();
    inner.innerMethod();
  }

}
```

- 외부 클래스의 멤버 변수와 이름이 겹치는 경우 `this` 활용

```java
class Outer {
  class InstanceInner {
    int var = 1;

    void innerMethod() {
      System.out.println(var);
      System.out.println(this.var);
      System.out.println(Outer.this.var);
    }
  }

  private int var = 2;

  public static void main(String[] args) {
    Outer outer = new Outer();
    InstanceInner inner = outer.new InstanceInner();
    inner.innerMethod();
  }

}
```



### 스태틱 내부 클래스, 클래스 내부 클래스 (Static Inner Class, Class Inner Class)

- 외부 클래스의  `static` 키워드와 함께 멤버변수 선언 위치에 선언된 내부 클래스 
- 외부 클래스의 static 멤버처럼 사용할 수 있다.
- 외부 클래스 객체가 없어도 생성 가능
- 외부 클래스의 private을 포함한 모든 멤버에 접근 가능
- static 멤버 변수를 가질 수 있음

```java
class Outer {
  static class ClassInner {
    int innerVar = 1;
    static int staticInnerVar = 100;

    void innerMethod() {
      Outer outer = new Outer();
      System.out.println(outer.outerVar);
      System.out.println(innerVar);
    }
  }

  private int outerVar = 2;

  void outerMethod() {
    ClassInner inner = new ClassInner();
    inner.innerMethod();
  }

  public static void main(String[] args) {
    Static inner = new StaticInner();
    inner.innerMethod();
  }
}
```



### 로컬 내부 클래스 (Local Inner Class)

- 클래스 영역이 아닌 로컬 영역에서 선언된 클래스
  - 메소드, 생성자, 초기화 블록의 내부
- 정적 변수는 가질 수 없으나, static final 변수는 가질 수 있음
- 로컬 영역의 변수 다음과 같은 사항을 따름
  - Java1.7: final로 선언된 변수에만 접근 가능
  - Java1.8: 모든 변수에 접근 가능하나, final로 간주되어 새로운 값 할당 불가

```java
void outerMethod() {
  int var = 1; // 메소드 호출 스택

  class LocalInner {
    void innerMethod() {
      System.out.println(var);
    }
  }

  LocalInner inner = new LocalInner(); // 힙 영역
  inner.innerMethod();
}
```



### 익명의 내부 클래스 (Anonymous Inner Class)

- 로컬 내부 클래스와 동일하나, 이름이 없어 선언 즉시 한 번 사용 가능
- 추상 클래스나 인터페이스의 구현에 많이 사용

```java
interface IFoo {
  void do();
}

class AnonymousInnerClassTest {
  void useFoo(IFoo foo) {
    foo.do();
  }

  public static void main(String[] args) {
    useFoo(new IFoo() {
      @Override
      void do() {
        System.out.println("Do!");
      }
    });
  }
}
```





## 16. 내부 클래스의 선언

- 내부 클래스 선언 위치는 변수의 선언 위치와 동일

  - 선언 위치에 따라 선언 위치의 변수와 동일한 `scope(유효범위)`, `accessibility(접근성)`을 갖는다.

  ```java
  class OutClass {
    class InstanceInner {}
    static class StaticInner {}
    
    void Method() {
      class LocalInner {}
    }
  }
  ```



## 17. 내부 클래스의 제어자와 접근성

- 내부 클래스가 외부 클래스의 멤버와 같이 간주되고, 인스턴스멤버와 클래스멤버 간의 규칙이 내부 클래스에도 똑같이 적용 됨.

  - `abstract`, `final` 제어자 사용 가능
  - 멤버변수처럼 `private`, `protected`  과 접근 제어자 사용 가능

  ```java
  class OutClass { // 외부 클래스
    // 인스턴스 변수와 클래스 변수 선언 위치
    
    class InstanceInner { // 인스턴스 클래스
    	int instanceVal = 100;
      // static int classVal = 100; // 에러. static 변수는 선언할수 없다
      final static int CONST = 100; // final static 은 상수기 때문에 가능
    }
    
    static class StaticInner { // static 클래스 
    	int instanceVal = 200;
      static int classVal = 200; // static 클래스만 static 멤버를 정의 가능
    }
    
    void Method() {
      class LocalInner {
        int instanceVal = 300;
        //static int classVal = 300; // 에러. static 변수는 선언할수 없다
        final sattic int CONST = 300; // final static 은 상수기 때문에 가능
      }
    }
    
    public static void main(String [] args){
      System.out.println(InstanceInner.CONST);
      System.out.println(StaticInner.classVal);    
    }
    
  }
  
  
  결과 :
  100
  200
  ```

  



## 18. 익명 클래스(Anonymous Inner Class)

- 이름이 없어 한 번만 사용되고, 하나의 객체만 생성할 수 있는 `일회용 클래스`

- 하나의 클래스로 상속받는 동시에 인터페이스를 구현하거나, 둘 이상의 인터페이스 구현 불가능

  ```java
  Object istanceVal = new Object(){ // 익명 클래스
    void method(){};
  }
  
  static Object classVal = new Object() { // 익명 클래스
    void method(){};
  }
  
  void method() {
    Object localVal = new Object() { // 익명 클래스
      void method(){};
    }
  }
  ```

  