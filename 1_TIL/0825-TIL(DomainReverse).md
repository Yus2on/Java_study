# TIL

## Today I Learned

```java
/**
 * 도메인 뒤집기
 *
 * 주어진 홈페이지 주소를 .을 기준으로 각각 뒤집어 출력하시오.
 *
 * ex) www.google.com -> www.elgoog.moc
 *
 * 인자
 * string: 홈페이지 주소
 */

public class DomainReverse {
  public static void main(String[] args) {
    String string = "www.google.com";

    int i = string.indexOf('.'); // 첫번째 .을찾아서 위치 반환함 결과는 3
    StringBuilder s = new StringBuilder(string.length()); //  ()안에 길이를 설정. 길이는 14가 됨.
    
    while (i > 0) { // 3, 6, -1 으로 i 가 -1일 때 반복문 탈출
      // 왜 마지막이 -1이냐면 그때 str 은 com인데 . 이 없기 때문에 못 찾아서 -1을 반환함 
      
      StringBuilder s_ = new StringBuilder(string.substring(0, i));
      
      string = string.substring(i + 1);
      // google.com, com
      // google.com -> . 뒤에 것부터 가져와야하니까 +1 함. 4번째 인덱스부터 가져와서 str에 대입
      // com -> 6 + 1 = 7 이니까 인덱스 7번째부터 가져옴 그걸 str에 대입
      s.append(s_.reverse());
      s.append('.');
      i = string.indexOf('.');
    } // end while
    
    s.append(new StringBuilder(string).reverse()); // 마지막 com을 뒤집음
    string = s.toString(); // 문자열로 변환
    // toString() 메서드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드임!!!
    // 결과값이 asdf@123 나오는 건 순수 str의 toString결과값임. 디폴트값 (의미x)

    System.out.println(string);
  }
}
```



1. **단일 스레드에서는 StringBuffer보다는 StringBuilder를 사용한다.**

   - 스레드 (Thread) : 프로세스에서 실행되는 작업의 단위. 프로그램에서 명령이 실행되는 흐름.
   - 단일 스레드 == main 스레드 : main 메서드만을 이용하여 프로그램을 실행하는 방법
   - 다중 스레드 : main 메서드와 별개로 실행되는 스레드를 만들어 명령이 동시에 실행되도록 만든 프로그램
     - main 메서드가 종료되도 프로그램이 종료되지 않음 (모든 스레드가 종료되면 프로그램이 종료)

2. **StringBuilder 사용 이유와 사용법**

   - String은 immutable(불변) 객체로 String + String 일 때 새로운 String 객체가 생성되기 때문에 기존의 데이터에 더하는 방식으로 StringBuilder 를 사용함.

     ```` java
     StringBuilder sb = new StringBilder();
     ````

   - StringBilder는 append() 를 사용한다. 문자열을 더하는 역할로 뒤에 계속 문자열을 추가하는 메서드(함수).

     ```` java
     sb.append('.');
     //append(넣고싶은값);
     /**  새로운 객체를 만들지 않고 바로 이용할 수 있음 **/
     ````

   - 만들어진 문자열을 출력하기 위해서는 StringBuilder의 인스턴스의 toString 사용함.

     ```` java
     sb = sb.toString();
     
     System.out.println(sb.toString());
     ````

     





