# CHAPTER 6

# 객체지향 프로그래밍 (Object Oriented Programming; OOP)



## 01. 객체지향 언어(Object-Oriented Programming Language)

### 객체지향 언어의 주요 특징

1. **코드의 재사용성이 높다.**

   새로운 코드를 작성할 떄 기존의 코드를 이용하여 쉽게 작성할 수 있다.

2. **코드의 관리가 용이하다.**

   코드간의 관계를 이용해서 적은 노력으로 쉽게 코드를 변경할 수 있다.

3. **신뢰성이 높은 프로그래밍을 가능하게 한다.**

   제어자와 메서드(함수, method)를 이용해서 데이터를 보호하고 올바른 값을 유지하도록 하며, 코드의 중복을 제거하여 코드의 불일치로 인한 오작동을 방지할 수 있다.



## 02. 클래스와 객체

#### 클래스(Class)

- 객체를 정의해 놓은 것
- 객체의 설계도 또는 틀
- 클래스는 객체를 생성하는데 사용된다. 

> 클래스의 정의 : 클래스란 객체를 정의해 놓은 것.
>
> 클래스의 용도 : 클래스는 객체를 생성하는 데 사용



#### 객체(Object/Instance)

- 객체는 클래스에 정의된 대로 메모리에 생성되는 것. (클래스의 인스턴스)
- 실제로 메모리 상에 할당된 것

> 객체의 정의 : 실제로 존재하는 것, 사물 또는 개념
>
> 객체의 용도 : 객체가 가지고 있는 기능과 속성에 따라 다름
>
> 
>
> 유형의 객체 : 책상, 의자, 자동차, TV와 같은 사물
>
> 무형의 객체 : 수학 공식, ㅍ로그램 에러와과 같은 논리나 개념



클래스와 객체는 제품 설계도와 제품과의 관계와도 같다. (붕어빵 틀과 붕어빵)



## 03. 객체의 구성요소 - 속성과 기능

객체는 **속성과 기능의 집합**. 객체가 가지고 있는 속성과 기능을 **객체의 멤버(member)** 라고 한다.

객체지향 프로그래밍에서는 속성과 기능을 각각 변수와 메서드로 표현한다.

> - 속성(Attribute, field) : 클래스에 속하는 멤버 변수(member variable), 상태, 필드
> - 기능(function) : 메소드(Method). 클래스에 속하는 멤버 함수(member function), 행동

> Field는 클래스의 data member. public, static, non-static, final로 선언될 수 있는 것을 모두 field라고 함.
> Attribute는 field를 지칭하는 용어인데 보통 바로 접근할 수 있는 public field를 attribute라고 부른다고 함
> Property도 field를 지칭하는데 보통 getter, setter 조합과 함께 사용되는 field를 말한다고 함



## 04. 객체와 인스턴스

### 인스턴스 (Instance)

**어떤 클래스로부터 만들어진 객체를 그 클래스의 인스턴스라고 한다.**

### 인스턴스화(Instantiate)

클래스로부터 객체를 만드는 과정. (클래스에서 객체를 생성하는 과정)

- Object, Instace : Instantiation으로 인해 생성된 객체



## 05. 한 파일에 여러 클래스 작성하기

소스 파일의 이름은 public class의 이름과 일치해야 한다. 소스 파일 내 public class 가 없다면 소스 파일의 이름은 파일 내 어떤 클래스의 이름으로 해도 상관없다.

> 하나의 소스파일에 둘 이상의 public class 가 존재할 수 없다.
>
> - ex) Hello.java를 컴파일하면 -> Hello2.class 와 Hello3.class 두 개의 클래스 파일이 생성됨





## 06. 객체의 생성과 사용

```` java
클래스명 변수명;					// 클래스의 객체를 참조하기 위한 참조변수를 선언
변수명 = new 클래스명(); // 클래스의 객체(인스턴스)를 생성한 후에, 객체(인스턴스)의 주소를 참조변수에 저장

Tv t;					// Tv 클래스 타입의  참조변수 t 를 선언
t = new Tv(); // Tv 인스턴스를 생성한 후에, Tv 인스턴스의 주소를 t 에 저장
````

```java
클래스명 변수명 = new 클래스명();

Car car = new Car();
```

- 클래스를 구체화하여 값을 생성한 것을 객체라 한다.
- 하나의 클래스로 여러개의 객체를 만들 경우, 같은 타입의 독립적인 객체가 된다.



## 07. 객체 배열

객체를 배열로 다루는데, 객체 배열 안에 객체가 저장되는 것이 아니라 **객체의 주소가 저장된다.**

```` java
Tv tv1, tv2, tv3;

Tv[] tvArr = new Tv[3]; // 길이가 3인 Tv 타입의 참조변수 배열
````

> 각 요소는 참조변수의 기본값인 null로 자동 초기화 된다.



```` java
Tv[] tvArr = new Tv[3]; // 참조변수 배열(객체배열) 을 생성

// 객체를 생성해서 배열의 각 요소에 저장
tvArr[0] = new Tv();
tvArr[1] = new Tv();
tvArr[2] = new Tv();

// 배열 초기화 블럭 사용
Tv[] tvArr = { new Tv(), new Tv(), new Tv() };

````





## 08. 클래스의 정의 (1) - 데이터와 함수의 결합

1. **변수**

   하나의 데이터를 저장할 수 있는 공간

2. **배열** 

   같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간

3. **구조체**

   서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간

4. **클래스** 

   데이터와 함수의 결합(구조체 + 함수)



**서로 관련된 변수와 함수들을 정의한 것이 클래스이다.**



## 09. 클래스의 정의 (2) - 사용자 정의 타입

#### 사용자 정의 타입(user-defined type)

프로그래머가 서로 관련된 변수들을 묶어서 하나의 타입으로 새로 추가하는 것. ( 클래스가 곧 사용자 정의 타입 )



## 10. 선언위치에 따른 변수의 종류

- 클래스 변수 (Class Variable)
- 인스턴스 변수 (Instance Variable)
- 지역 변수 (Local Variable)

변수의 종류를 결정짓는 중요한 요소는 `변수 선언 위치 ` 이다.

멤버변수(member Variable) 을 제외한 나머지 변수는 모두 지역 변수이며, 멤버 변수 중 static이 붙은 것은 클래스 변수, 붙지 않은 것은 인스턴스 변수이다.



| 구분      | 선언 위치           | 변수 종류          | 특징               |
| --------- | ------------------- | ------------------ | ------------------ |
| 멤버 변수 | 클래스 영역         | 클래스 멤버 변수   | `static` 키워드 o  |
| 멤버 변수 | 클래스 영역         | 인스턴스 멤버 변수 | `static` 키워드 x  |
| 로컬 변수 | 메소드 및 블록 내부 | 로컬 변수          |                    |
| 로컬 변수 | 메소드 내부         | 파라미터 변수      | 메소드의 입력 인자 |

```java
public class Variables {
  int instanceVar; // 인스턴스 멤버 변수
  static int classVar; // 클래스 멤버 변수

  public void method(int parameterVar) { // 파라미터 변수
    int localVar = 0; // 로컬 변수(메서드 영역. 메서드(함수)안에서만 선언 되고, 메서드 안에서만 유효함.)
    {
      localVar = 30;
      int localVar2 = 40;
    } 
    localVar2 = 40; // => 접근 불가. 생명주기가 끝났다 (Life-cycle)

  }
}

class VariableTest {
  public static void main(String[] args) {
    System.out.println("클래스 변수");
    System.out.println(Variables.classVar); // 0 으로 초기화 됨
    //클래스 변수는 클래스  이름으로 바로 접근 가능
    Variables.classVar = 10; // 클래스이름.변수명으로 접근
    // 접근 -> 수정도 가능
    System.out.println(Variables.classVar);
    System.out.println("");

    System.out.println("인스턴스 멤버 변수");
    Variables var = new Variables(); // 인스턴스 생성
    System.out.println(var.instanceVar); // 0 으로 초기화 됨
    var.instanceVar = 20;
    System.out.println(var.instanceVar);

    Variables var2 = new Variables();
    System.out.println(var2.instanceVar);
    System.out.println("");

    // System.out.println(var2.classVar); // 가능하나 권장하지 않음
    // Varables.instanceVar // 접근 불가능. 인스턴스 변수는 클래스에서 참조할 수 없음. (인스턴스에서만가능)
    System.out.println("");

    System.out.println("로컬 변수");
    var.method(9); 
    //로컬 변수는 메서드 안에서만 유효.

  }
}
```





## 11. 메서드란?

메서드(Methods) 는 특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것. 

- 객체가 하는 동작을 정의하는 어떠한 작업을 수행하는 코드의 집합
- 코드의 중복을 방지하고 유지보수성을 향상시키기 위해 사용

```java
public class Car {
  String name;

  void printModel() { // 메소드의 정의 (Method definition)
    System.out.println(name);
  }
}

Car hyundai = new Car();
Car kia = new Car();

hyundai.name = "Hyundai";
kia.name = "Kia";

hyundai.printModel(); // 메소드의 호출 (Method call)
kia.printModel();
```



## 12. 메서드의 선언부

- 메소드는 함수의 형태로 구성된다.
  - 파라미터 (Parameters, 입력)
  - 실행문 (Executional Statements)
  - 리턴 값 (Return Value, 출력)

  ![](https://blog.kakaocdn.net/dn/kO3C8/btqEeZH7LC0/ozPFJkhgkYJKZBCtxErUUK/img.png)



#### 매개변수 선언 (parameter declaration)

메서드에 선언 된 입력 값. 필요한 값의 개수만큼 변수를 선언하며, 각 변수간의 구분은 쉼표를 사용한다. 각 변수의 타입이 같아도 변수 타입은 생략할 수 없다.

```` java
int add (int x, int y) { 
  ...
}

// 불가능
int add (int x, y) {} // 매개변수 y의 타입이 없어 에러.
````



- 가변 인자 (Variable Arguments)
  - 입력 인자의 개수가 정해지지 않은 경우

```java
public int sumAll(int... params) {
    int sum = 0;
    for (int i: params) {
      sum += i;
    }
    return sum;
}
```



#### 반환 타입 (return type)

```java
public int add(int x, int y) {
  return x + y;
}

제한자 리턴타입 메소드명(파라미터타입1 파라미터이름1, 파라미터타입2 파라미터이름2, ...) {
  // 실행문
}
```

>  반환값이 없으면 리턴타입(반환타입)으로 `void`  를 사용한다.



## 13. 메서드의 구현부

메서드 선언 부 다음에 오는 괄호를 메서드 구현부 {} 라고 한다.



#### return 문

- 메서드 리턴타입이 void가 아닌 경우, 구현부 {} 안에 'return 반환값;' 이 반드시 있어야 한다.

- 이 값의 타입은 반환타입과 일치하거나, 적어도 자동 형변환이 가능한 것이어야 한다.

- 단 하나의 값만 반환할 수 있다.

```` java
int add (int x, int y){
  int result = x + y; 
  return result; // 작업 결과(반환값)을 반환한다
}
````



#### 지역 변수 (Local variable)

메서드 내에 선언된 변수. (매개변수도 메서드 내에서 선언된 것으로 간주되므로 지역 변수임)

```` java
int add (int x, int y){
  int result = x + y;
  return result;
}

int multiply (int x, int y){
  int result = x * y;
  return result;
}
````





## 14. 메서드의 호출

``` java
int add (int x, int y){
  return x + y;
}

public static void main(String[] args) {
  int result = add(3, 5); // 메서드 호출 (Method call)
  // int result add(1, 2, 3); // 경고. 메서드의 선언된 매개변수의 개수가 다름.
  // int result add(1.0, 2.9); // 경고. 매개변수의 타입이 다름.
  
}
```







## 15. 메서드의 실행 흐름

```` java
class MyMath {
  long add (long a, long b){
    long result = a + b;
    return result;
  }

  long subtract(long a, long b){
    return a - b;
  }

  long multiply(long a, long b){
    return a * b;
  }

  double divide(double a, double b){
    return a / b;
  }
}

MyMath mm = new MyMath();		 // 인스턴스 생성
long value = mm.add(1L, 2L); // 메서드 호출

````

> 1. add 메서드를 호출한다 -> 인수 1L과 2L이 메서드 add의 매개변수 a, b에 각각 복사(대입) 된다.
> 2. 메서드 add의 괄호 {} 안에 있는 문장들이 순서대로 수행된다
> 3. 메서드 add 의 모든 문장이 실행되거나, return 문을 만나면 호출한 메서드(main 메서드)로 되돌아와서 이후 문장들이 실행된다.





## 16. return문

현재 실행 중인 메서드를 종료하고 호출한 메서드로 되돌아 간다. 

- 원래 반환값 유무에 관계 없이 모든 메서드에서는 적어도 하나의 return문이 있어야 하지만, 반환 타입이 void 일 경우 return문은 생략된다.(컴파일러가 자동 추가)

- ```` java
  void printGugudan(int dan) {
    for(int i = 0; i <= 9; i++){
      Systme.out.printf("%d * %d = %d%n", dan, i, dan * i);
    }
  //  return; // 반환타입이 void 이므로 생략가능
  }
  
  ````

> void 가 아닐 경우 return 문이 없으면 컴파일 에러 발생.



## 17. 반환값

return 문의 반환값이 항상 변수인 것은 아니다.

```` java
int add (int x, int y) {
  int result = x + y;
  return result;
}

int add (int x, int y) {
  return x + y;
}
````

```` java
int abs (int x){
  if(x >= 0){
    return x;
  }else {
    return -x;
  }
}

int diff (int x, int y) {
  int result = abs(x - y);
  return result;
}




int abs (int x){
  return x >= 0 ? x : -x;
}

int diff (int x, int y) {
  return abs(x - y);
}
````





## 18. 호출스택(Call stack)

- 메소드 호출 스택 (Method Call Stack)

  - 메서드가 호출되면 수행에 필요한 만큼의 메모리를 스택에 할당받는다.
  - 메소드가 호출될 때 마다 메소드 동작과 로컬 변수가 쌓이는 메모리 영역.
  - 메서드가 수행을 마치고 나면 사용했던 메모리를 반환하고 스택에서 제거된다.
  - 호출 스택의 제일 위에 있는 메서드가 현재 실행중인 메서드이다.
  - 아래 있는 메서드는 바로 위의 메서드를 호출한 메서드이다.
  - 메소드가 종료될 때 메모리가 함께 반환됨(메모리 공간은 비워진다)

  

  

## 19. 기본형 매개변수 / 참조형 매개변수

메서드를 호출할 때 매개변수로 지정한 값을 메서드의 매개변수에 복사해서 넘긴다.

- 매개변수 타입이 기본형(primitive type)일 땐 메서드 값이 복사됨 (Call by value). 값을 읽기만 할 수 있다 (read only)
- 매개변수 타입이 참조형(reference type) 일 땐 인스턴스의 주소값이 복사됨 (Call by reference). 변경 가능. (read & write).

```java
public class Foo {
  int value;
}

public class Bar {
  public void swapPrimitive(int x, int y) { // 기본형 매개변수
    int temp = x;
    x = y;
    y = temp;
  }

  public void swapReference(Foo x, Foo y) { // 참조형 매개변수
    int temp = x.value;
    x.value = y.value;
    y.value = temp;
  }
}

Bar bar = new Bar();

int x = 1, y = 10;
bar.swapPrimitive(x, y);
System.out.println(x); // 1
System.out.println(y); // 10

Foo foo1 = new Foo(1); 
Foo foo2 = new Foo(10);
bar.swapReference(foo1, foo2); 	// 값이 저장된 주소를 넘겼기 때문에 값 변경도 가능함
System.out.println(foo1.value); // 10
System.out.println(foo2.value); // 1
```



#### 참조형 반환 타입

반환타입(리턴타입)이 reference(참조)형 이라는 것은 그 정수 값이 반환되는 것이다. 모든 참조형 타입의 값은 `객체의 주소`  이다!!





## 20. static 메서드와 인스턴스 메서드

- 클래스 메소드 (Class method)
  - `static` 키워드를 이용하여 선언된 메소드
  - 인스턴스가 아닌 클래스에 속하는 메소드
  - 대표적으로 main 메소드가 클래스 메소드이다.

  ```java
  public class Foo {
    static public void main(String args[]) {
      // class method
    }
  }
  ```

*** 멤버 변수는 클래스 영역에 선언된 변수이다. 멤버변수는 인스턴스 변수와 클래스 변수를 모두 통칭하는 말이다.



## 21. static을 언제 붙여야 할까?

1. 클래스를 설계할 때, 멤버변수 중 모든 인스턴스에 공통으로 사용하는 것에 static을 붙인다.

   생성된 각 인스턴스는 서로 독립적이기 때문에 각 인스턴스의 변수는 서로 다른 길을 유지한다. 그러나 **모든 인스턴스에서 같은 값이 유지되어야 하는 변수는 static  을 붙여서 클래스 변수로 정의**한다.

2. 클래스변수(static 변수)는 인스턴스를 생성하지 않아도 사용할 수 있다

   static 이 붙은 변수(클래스 변수)는 클래스가 메모리에 올라갈 때 이미 자동적으로 생성되기 때문이다.

3. 클래스 메서드(static 메서드) 는 인스턴스 변수를 사용할 수 없다.

   - 인스턴스 변수는 인스턴스가 반드시 존재해야만 사용할 수 있는데, 클래스 메서드(static 메서드) 는 인스턴스 생성 없이 호출 가능하므로 클래스 메서드가 호출되었을 때 인스턴스가 존재하지 않을 수 있다.
   - 인스턴스 변수나 인스턴스 메서드는 static 이 붙은 멤버들을 사용하는 것이 가능하다. 인스턴스 변수가 존재한다는 것은 staitc 변수가 이미 메모리에 존재하기 때문이다.

4. **메서드 내에서 인스턴스 변수를 사용하지 않는다면, static 을 붙이는 것을 고려한다.**

   메서드의 작업 내용 중에서 인스턴스변수를 필요로 한다면, static을 붙일 수 없다. 반대로 인스턴스 변수를 필요로 하지 않는다면 static을 붙이자. 메서드 호출 시간이 짧아지므로 성능이 향상된다. static을 안붙인 메서드(인스턴스메서드) 는 실행시 호출되어야 할 메서드를 찾는 과정이 추가적으로 필요하기 때문에 시간이 더 걸린다.



## 22. 메서드 간의 호출과 참조

- 같은 클래스에 속한 멤버들 간에는 별도의 인스턴스를 생성하지 않아도 서로 참조 또는 호출이 가능하다.

  (단, 클래스 멤버가 인스턴스멤버를 참조 또는 호출하고자 하는 경우에는 인스턴스 생성 필요)

  - **인스턴스 멤버(인스턴스 변수, 인스턴스 메서드)가 존재하는 시점에 클래스 멤버는 항상 존재**
  - **클래스멤버가 존재하는 시점에 인스턴스 멤버가 존재하지 않을 수도 있음**

``` java
class TestClass {
  int iv;					// 인스턴스 변수
  static int cv;	// 클래스 변수
  
  void instanceMethod() {} 			// 인스턴스 메서드
  static void staticMethod() {} // 클래스 메서드(static 메서드)
  
  void instanceMethod2() { // 인스턴스 메서드
    instanceMethod();			 // 다른 인스턴스 메서드 호출 
    staticMethod();				 // 클래스 메서드 호출
    System.out.println(iv);// 인스턴스 변수 사용 가능
    System.out.println(cv);// 클래스 변수 사용 가능
  }
  
  static void staticMethod2() { // 클래스 메서드
    //instanceMethod(); 				// 에러. 인스터스 메서드 호출 불가능
    staticMethod();							// static 메서드(클래스메서드) 호출 가능
    System.out.println(iv);			// 에러. 인스턴스 변수를 사용할 수 없다.
    System.out.println(cv);			// 클래스 변수 사용 가능
  }
}// end class
```



## 23. 오버로딩(Overloading)

메서드 오버로딩(Method Overloading), 오버로딩(Overloading)

- 동일 기능의 함수(메서드)를 추가로 구현하는 방법
- 입력 파라미터를 달리하는 동일 함수(메서드)명으로 구현한다.
  - 매개변수의 개수 다른 것 포함

```` java
public class Foo {
  
  // 오버로딩 
  public int sumAll(int ... params) {
    int sum = 0;
    for (int i: params) {
      sum += i;
    }
    return sum;
  }

  // 오버로딩
  public float sumAll(float ... params) {
    float sum = 0.0f;
    for (float x: params) {
      sum += x;
    }
    return sum;
  }
}

Foo foo = Foo();
int sum1 = foo.sumAll(1, 2, 3, 4, 5);
float sum2 = foo.sumAll(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
````



## 24. 생성자 (Constructor)

- 클래스에서 인스턴스를 생성할 때 사용되는 메소드. 인스턴스 초기화 메서드.
  - `new` 키워드를 이용해 호출
- 기본 생성자 (Default Constructor)
  - 구현하지 않아도 자동으로 생성되는 생성자
  - 아무런 동작도 하지 않고, 객체만을 생성
- 파라미터 생성자 (Parameter Constructors)
  - 입력 파라미터를 받는 생성자
  - 여러개의 파라미터 생성자를 오버로딩할 수 있음
  - 보통 멤버 변수를 초기화하는 동작 수행

```java
public class Foo {
  int x;
  int y;
  String z;

  // public Foo() {} // Default Constructor

  public Foo(int a, int b, String c) { // Parameter Constructor
    // 생성자의 이름은 클래스의 이름과 같아야 한다.
    // 생성자는 리턴 값이 없다
    x = a;
    y = b
    z = c;
  }
} // end class
```





## 25. 생성자에서 다른 생성자 호출하기 - this()

- 객체가 스스로를 가르키는 참조. 생성자의 이름으로 클래스 이름 대신 this 사용.

- 멤버 변수와 로컬 변수의 이름이 같을 때, 멤버 변수임을 명시

- 생성자를 호출하는 데에도 사용할 수 있다.

- 한 생성자에서 다른 생성자를 호출 할 때는 반드시 첫 줄에서만 호출이 가능하다.

  ```` java
  Car (String color){
    door = 5;							 // 첫번째 줄
    Car(color, "auto", 4); // 에러. 생성자의 두번째 줄에서 다른 생성자 호출함
  }												 // 에러. Car 가 아니라 this(color, "auto", 4); 로 해야 함
  ````

  ```java
  public class Foo {
    int x;
    int y;
    String z;
  
    public Foo(int x, int y, String z) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  
    public Foo(String z) {
      this(0, 0, z);
    }
  
    public Foo(int x, int y) {
      this(x, y, "Nothing");
    }
  }
  
  ```

  > 수정이 필요한 경우 보다 적은 코드만을 변경하면 되므로 유지보수가 쉬워진다.





## 26. 객체 자신을 가리키는 참조변수 - this

```` java
Car (String c, String g, int d){
  color = c; // color는 인스턴스변수, c는 로컬변수
  gearType = g;
  door = d;
}

Car (String color, String gearType, int door) {
  this.color = color;
  // this.color 는 인스턴스 변수, color는 생성자의 매개변수로 정의된 지역변수가 됨.
  this.gearType = gearType;
  this.door = door;
}
````

> this. 는 참조변수로 인스턴스 자신을 가리킨다. this를 사용할 수 있는 건 인스턴스멤버 뿐이다. 
>
> static 메서드(클래스메서드) 에서 인스턴스 멤버를 사용할 수 없는 것처럼, this도 사용할 수 없다.



- this : 인스턴스 자신을 가리키는 **참조 변수**. 인스턴스의 주소가 저장되어 있다. 모든 인스턴스 메서드에 지역변수로 숨겨진 채 존재한다.
- this(), this(매개변수) :  **생성자**, 같은 클래스의 다른 생성자를 호출할 때 사용한다.



## 27. 변수의 초기화

변수를 선언하고 처음으로 값을 저장하는 것. **지역변수(로컬변수)는 사용하기 전 초기화가 필수**

```` java
class InitTest {
  // 인스턴스 변수
  int x;
  int y = x;
  
  void method1(){
    int i; 			// 지역변수
    int j = i;	// 에러. 지역변수를 초기화 하지 않음
  }
}
````

> x와 i는 선언만 하고 초기화를 하지 않았다. y를 초기화 하는데는 x를, j를 초기화하는데는 i를 사용했다.
>
> 인스턴스 변수인 x는 초기화를 하지 않아도 자동적으로 int의 기본값인 0으로 초기화 되지만 method1() 의 지역변수 i는 자동적으로 초기화가 되지 않으므로, 초기화 되지 않은 상태에서 j를  초기화 하는데 사용할 수 없다.





## 28. 멤버변수의 초기화

멤버변수는 각 타입의 기본값으로 자동 초기화 된다.

- 명시적 초기화 -> 초기화 블럭 -> 생성자의 순서로 초기화 됨.
- 클래스 변수가 인스턴스 변수보다 먼저 초기화 된다.



#### 명시적 초기화(explicit initialization)

- 변수를 선언과 동시에 초기화하는 것.

```` java
class Car {
  int door = 4;							// primitive type(기본형) 변수의 초기화
  Engine e = new Engine();	// reference type(참조형) 변수의 초기화
  ...
}
````

- 보다 복잡한 초기화 작어비 필요할 땐 초기화 블럭, 생성자를 사용해야 함



#### 초기화 블록(Initializer)

- 클래스 또는 인스턴스를 생성할 때 단 한번 실행되는 코드 블록
  - 클래스 초기화 블럭 : 클래스 변수의 초기화에 사용
  - 인스턴스 초기화 블럭 : 인스턴스 변수의 초기화에 사용됨

  ```java
  public class Foo {
    static int classVar;
    int instanceVar;
  
    static {  // Class Initializater
      classVar = 100;
    }
  
    {  // Instance Initializer
      instanceVar = 10;
    }
  
    static {
      // May be more than one block
    }
  }
  ```

  



