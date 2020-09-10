# [Java의 정석 연습문제] 

## Chapter7 객체지향 프로그래밍2



**[7-1] 섯다카드 20장을 포함하는 섯다카드 한 벌(SutdaDeck클래스)을 정의한 것이다. 섯다카드 20장을 담는 SutdaCard배열을 초기화하시오. 단, 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고, 숫자가 1, 3, 8인 경우에는 둘 중의 한 장은 광(Kwang)이어야 한다. 즉, SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.**

```java
class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	SutdaDeck() {
		/* (1)배열 SutdaCard 를 적절히 초기화 하시오. */
	}
}

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}


	// info()대신 Object클래스의 toString()을 오버라이딩했다.
  // toString()을 재정의 하지 않으면, Object 클래스(최상위)의 toString()을 사용할 것이다. -> 그럼 클래스명@객체고유값 이 출력됨
    // 그렇게 하지 않기 위해서 toString()을 오버라이딩 한다.
	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class Exercise7_1 {
	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++)
      //deck.cards[i].toString() 을 생략한듯??
			System.out.print(deck.cards[i] + ",");
	}
}


[실행결과]
1K,2,3K,4,5,6,7,8K,9,10,1,2,3,4,5,6,7,8,9,10,
```

```java
SutdaDeck() {
  for(int i = 0; i < cards.length; i++){
    //if(i == 0 || i == 2 || i == 7 ){
    //  cards[i] = new SutdaCard(i + 1, true);
    // } else {
    //  cards[i] = new SutdaCard(i % 10 + 1, false);
    // }

    int num = i % 10 + 1;
    boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8 );
    cards[i] = new SutdaCard(num, isKwang);
  } // end for
}
```



**[7-2] 문제7-1의 SutdaDeck클래스에 다음에 정의된 새로운 메서드를 추가하고 테스트 하시오.**

**([주의] Math.random()를 사용하는 경우 실행결과와 다를 수 있음.)**

```java
/**
 * 1. 메서드명 : shuffle
 * 기능 : 배열 cards에 담긴 카드의 위치를 뒤섞는다. (Math.random() 사용)
 * 반환타입 : 없음
 * 매개변수 : 없음
 *
 * 2. 메서드명 : pick
 * 기능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다.
 * 반환타입 : SutdaCard
 * 매개변수 : int index - 위치
 *
 * 3. 메서드명 : pick 
 * 기능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다. (Math.random() 사용)
 * 반환타입 : SutdaCard
 * 매개변수 : 없음   
 *
 */

class SutdaDeck {
  final int CARD_NUM = 20;
  SutdaCard[] cards = new SutdaCard[CARD_NUM];

  SutdaDeck() { 
    /* 문제 7-1의 답이므로 내용생략  */
  } 

  /* (1) 위에 정의된 세 개의 메서드를 작성하시오 . */

} // SutdaDeck

class SutdaCard {
  int num;
  boolean isKwang;

  SutdaCard() {
    this(1, true);
  }

  SutdaCard(int num, boolean isKwang) {
    this.num = num;
    this.isKwang = isKwang;
  }

  public String toString() {
    return num + (isKwang ? "K" : "");
  }
}

class Exercise7_2 {
  public static void main(String args[]) {
    SutdaDeck deck = new SutdaDeck();

    System.out.println(deck.pick(0));
    System.out.println(deck.pick());
    deck.shuffle();

    for (int i = 0; i < deck.cards.length; i++)
      System.out.print(deck.cards[i] + ",");

    System.out.println();
    System.out.println(deck.pick(0));
  }
}

[실행결과] 
1K
7
2, 6, 10, 1K, 7, 3, 10, 5, 7, 8, 5, 1, 2, 9, 6, 9, ,4 ,8K, 4, 3K
2
```

```java
void shuffle(){
  for (int i = 0; i < cards.length; i ++ ){
    int j = (int)(Math.random() * cards.length);
    
    SutdaCard temp = cards[i];
    cards[i] = cards[j];
    cards[j] = temp;
  } // end for
}

public SutdaCard pick (int index) {
  if (index < 0 || index >= CARD_NUM){
    return null;
  }
  return cards[index];
}

SutdaCard pick() { // 임의의 카드 꺼내기 
  int index = (int)(Math.random() * cards.length);
  return pick(index);
}
```



**[7-3] 다음의 코드는 컴파일하면 에러가 발생한다. 그 이유를 설명하고 에러를 수정하기 위해서는 코드를 어떻게 바꾸어야 하는가?**

```java
class Product {
  int price; // 제품의 가격
  int bonusPoint; // 제품구매 시 제공하는 보너스점수

  Product(int price) {
    this.price = price;
    bonusPoint = (int) (price / 10.0);
  }
}


class Tv extends Product {
  Tv() {}
  public String toString() {
    return "Tv";
  }
}

class Exercise7_3 {
  public static void main(String[] args) {
    Tv t = new Tv();
  }
}
```

```java
class Product {
	int price;
	int bonusPoint;

	Product() {} // 기본 생성자 추가!!!!!!!!!!111

	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price / 10.0);
	}
}
```



**[7-4] MyTv클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 접근할 수 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록 getter와 setter메서드를 추가하라.**

```java
class MyTv {
  boolean isPowerOn;
  int channel;
  int volume;

  final int MAX_VOLUME = 100;
  final int MIN_VOLUME = 0;
  final int MAX_CHANNEL = 100;
  final int MIN_CHANNEL = 1; 

  /* (1) 알맞은 코드를 넣어 완성하시오. */

}

class Exercise7_4 {
  public static void main(String args[]) {
    MyTv t = new MyTv();
   
    t.setChannel(10);
    System.out.println("CH:" + t.getChannel());
    t.setVolume(20);
    System.out.println("VOL:" + t.getVolume());
  }
}

[실행결과]
CH : 10
VOL : 20
```

```java
private boolean isPowerOn;
private int channel;
private int volume;

public void setPowerOn(boolean isPowerOn) {
	this.isPowerOn = isPowerOn;
}

public int getVolume(){
  return volume;
}

public void setVolum(int volume) {
  if(volume > MAX_VOLUME || volume < MIN_VOLUME){
    return;
  }
  this.volume = volume;
}

public int getChannel(){
  return channel;
}

public void setChannel(int channel) {
  if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
    return;
  }
  this.channel = channel;
}

```



**[7-5] 문제7-4에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는 기능의 메서드를 추가해서 실행결과와 같은 결과를 얻도록 하시오. ([Hint]이전 채널의 값을 저장할 멤버변수를 정의하라.)**

```java
/**
 * 메서드명 : gotoPrevChannel
 * 기능 : 현재 채널을 이전 채널로 변경한다.
 * 반환타입 : 없음
 * 매개변수 : 없음
 */

class MyTv2 { 
	/*  (1)문제 7-10의 MyTv2클래스에 gotoPrevChannel 메서드를 추가하여 완성하시오. */
}

class Exercise7_5 {
	public static void main(String args[]) {
		MyTv2 t = new MyTv2();
    
		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setChannel(20);
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
	}
}

[실행결과]
CH:10
CH:20
CH:10
CH:20
```

```java
private int prevCh; // 이전 채널

public void setChannel(int channel) {
	if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
    return;
  }  
	prevCh = this.channel; // 현재 채널을 이전 채널에 대입함
	this.channel = channel;
}

public void gotoPrevChannel(){
  setChannel(prevCh); // 현재채널을 이전 채널로 바꿀거임
}

```





**[7-6] Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.**

```java
class Outer {
  class Inner {
    int iv = 100;
  }
}

class Exercise7_6 {
  public static void main(String[] args) { 
    /* (1) 알맞은 코드를 넣어 완성하시오. */
  }
}


[실행결과]
100
```

```java
Outer outer = new Outer();
Outer.Inner inner = outer.new Inner();
System.out.println(inner.iv);
```



**[7-7] Outer클래스의 내부 클래스 Inner의 멤버변수 iv의 값을 출력하시오.**

```java
class Outer {
	static class Inner {
		int iv = 200;
	}
}

class Exercise7_7 {
	public static void main(String[] args) { 
		/* (1)알맞은 코드를 넣어 완성하시오  . */
	}
}

[실행결과]
200
```

```java
Outer.Inner inner = new Outer.Inner();
System.out.println(inner.iv);
```



**[7-8] 다음과 같은 실행결과를 얻도록 (1)~(4)의 코드를 완성하시오.**

```java
class Outer {
	int value = 10;

	class Inner {
		int value = 20;
		
    void method1() {
			int value = 30;
    
			System.out.println(/* (1) */);
			System.out.println(/* (2) */);
			System.out.println(/* (3) */);
    }
	} // Inner 클래스의 끝
}// Outer클래스의 끝

class Exercise7_8 {
	public static void main(String args[]) {
		/* (4) 알맞은 코드를 넣어 완성하시오 . */
		inner.method1();
	}
}

[실행결과]
30
20
10
```

```java
1. value
2. this.value
3. Outer.this.value
4.
  Outer o = new Outer();
	Outer.Inner inner = o.new Inner();
```





**[7-9] 아래의 EventHandler를 익명 클래스(annoymous class)로 변경하시오.**

```java
import java.awt.*;
import java.awt.event.*;

class Exercise7_9 {
	public static void main(String[] args) {
		Frame f = new Frame();
		f.addWindowListener(new EventHandler());
	}
}

class EventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}
}
```

```java
public static void main(String[] args) {
  Frame f = new Frame();
	f.addWindowListener(new EventHandler() {
    public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
  }
                      
} // end main
```

