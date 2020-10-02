# CHAPTER 10

# 날짜와 시간 & 형식화 (Date, Time and Formatting)   



## 01. 날짜와 시간

### java.util.Date

- 날짜와 시간을 다룰 목적으로 생성된 클래스 (JDK1.0)
- Calendar 클래스 : JDK1.1부터 제공
- JDK1.8부터 `java.time package` 추가



### java.util.Calendar

- Date 클래스를 개선한 새로운 클래스 (JDK1.1)



### java.time 패키지

- Date와 Calendar의 단점을 개선한 새로운 클래스 제공 (JDK1.8)



## 02. Calendar 클래스

- java.util.Calendar : `추상 클래스` 로, **getInstance()**를 통해 완전히 구현된 클래스의 인스턴스를 얻어야 한다.

  ```java
  // Calendar cal - new Calendar(); // 에러. 추상클래스이기 때문에 인스턴스 생성 불가
  
  Calendar cal = Calendar.getInstance(); 
  // getInstance() 메서드는 Calendar 클래스를 구현한 클래스의 인스턴스를 반환한다 
  ```

- 태국인 경우 `BuddhistCalendar()`, 그레고리력은 `GregorianCalendar()` 사용

  ```java
  class MyApplication {
    public static void main (String [] args) {
      Calendar cal = new GregorianCalendar(); // 경우에 따라 변경 필요.
      
      // 새로운 역법이 추가되거나 역법이 변경될 경우엔 getInstance() 사용
      // 이렇게 하면 MyApplication 을 변경하지 않아도 된다
      Calendar cal = Calendar.getInstance();
    }
  }
  ```





### Calendar 메서드

- get() : 날짜와 시간 필드. int get(int field)

  ```java
  Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간으로 세팅
  int thisYear = cal.get(Calendar.YEAR); // 올해 년도 추출
  int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE); // 이 달의 마지막 날
  ```

  | 필드명               | 설 명                          |
  | -------------------- | ------------------------------ |
  | YEAR                 | 년                             |
  | MONTH                | 월(0부터 시작)                 |
  | WEEK_OF_YEAR         | 일                             |
  | WEEK_OF_MONTH        | 그 달의 몇 번째 주             |
  | DATE                 | 일                             |
  | DAY_OF_MONTH         | 그 달의 몇 번째일              |
  | DAY_OF_YEAR          | 그 해의 몇 번째일              |
  | DAY_OF_WEEK          | 요일                           |
  | DAY_OF_WEEK_IN_MONTH | 그 달의 몇 번째 요일           |
  | HOUR                 | 시간(0~11)                     |
  | HOUR_OF_DAY          | 시간(0~23)                     |
  | MINUTE               | 분                             |
  | SECOND               | 초                             |
  | MILLISECOND          | 천분의 일초                    |
  | ZONE_OFFSET          | GMT기준 시차(천분의 일초 단위) |
  | AM_PM                | 오전/오후                      |

- set() : 날짜와 시간 지정

  ```java
  void set(int field, int value);
  
  void set(int year, int month, int date)
  void set(int year, int month, int date, int hourOfDay, int minute) 
  void set(int year, int month, int date, int hourOfDay, int minute, int second)   
  ```

  - 날짜 지정 시, 월(Month)이 0부터 시작한다는 점 주의

  ```java
  Calendar date = Calendar.getInstance();
  date.set(2020, 9, 1); // 2020년 10월 1일 . 9월 아님
  //date.set(Calendar.YEAR, 2020);
  //date.set(Calendar.MONTH, 9);
  //date.set(Calendar.DATE, 1);
  ```

  - 시간 지정

  ```java
  Calendar time = Calendar.getInstance();
  time.set(Calendar.HOUR_OF_DAY, 10); // time을 10시 20분 30초로 설정
  time.set(Calendar.MINUTE, 20);
  time.set(Calendar.SECOND, 30);
  ```

- clear(), clear(int field)로 Calendar 객체 초기화

  - clear()는 Calendar 객체의 모든 필드 초기화

    ```java
    Calendar dt =. alendar.getInstance();
    
    // Thu Oct 01 13:27:03 KST 2020
    System.out.println(new Date(dt.getTimeInMillis()));
    
    dt.clear(); // 모든 필드 초기화
    // Thu Jan 01 00:00:00 KST 1970
    System.out.println(new Date(dt.getTimeInMillis()));
    ```

  - clear(int field) 는 Calendar 객체의 특정 필드 초기화

    ```java
    Calendar dt =. alendar.getInstance();
    
    // Thu Oct 01 13:29:03 KST 2020
    System.out.println(new Date(dt.getTimeInMillis()));
    
    dt.clear(Calendar.SECOND); // 초 초기화
    dt.clear(Calendar.MINUTE); // 분 초기화
    dt.clear(Calendar.HOUR_OF_DAY); // 시간 초기화
    dt.clear(Calendar.HOUR); // 시간 초기화
    
    // Thu Oct 01 00:00:00 KST 2020
    System.out.println(new Date(dt.getTimeInMillis()));
    ```

    





## 03. Date와 Calendar 간의 변환

- Calendar 가 새로 추가되면서 Date는 대부분의 메서드가 `deprecated` 되었음

  - 더 이상 사용을 권장하지 않는 대상에 `deprecated` 사용

- Calendar를 Date로 변환

  ```java
  Calendar cal = Calendar.getInstance();
  Date d = new Date(cal.getTimeInMillis()); // Date(long date)
  ```

- Date를 Calendar로 변환

  ```java
  Date d = new Date();
  Calendar cal = Calendar.getInstance();
  cal.setTime(d);
  ```

  

## 04. 형식화 클래스

- 숫자, 날짜, 텍스트 데이터를 일정한 형식에 맞게 표현하는 방법을 객체지향적으로 설계, 표준화
- java.text 패키지에 포함
- 형식화에 사용될 패턴을 정의 -> 형식화된 데이터에서 원래 데이터를 얻을 수도 있음



### 숫자 형식화

- DecimalFormat

  - 숫자 데이터를 정수, 부동수소점, 금액 등의 다양한 형식으로 표현

  ```java
  double number = 1234567.89;
  DecimalFormat df = new DecimalFormat("#.#E0");
  String result = df.format(number); // "1.2E6"
  ```

  - 일정한 형식 텍스트 데이터를 숫자로 변환 가능

  ```java
  DecimalFormat df = new DecimalFormat("#,###.##");
  Number num = df.parse("1,234,567.89");
  // Integer.parseInt()는 콤마 (,) 가 포함된 문자열을 숫자로 변환할 수 없음
  
  double d = num.doubleValue();
  ```

  

  

  ![image](https://user-images.githubusercontent.com/46306263/94766550-91e50980-03e6-11eb-96a4-5c7df3f21500.png)

  ![image](https://user-images.githubusercontent.com/46306263/94767300-f607cd80-03e6-11eb-8852-15d4a2c7ce65.png)





### 날짜 형식화

- SimpleDateFormat

  - 날짜와 시간을 다양한 형식으로 출력

    ```java
    Date today = new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    //오늘 날짜를 yyyy-MM-dd 형식으로 변환
    String result = df.format(today);
    ```

    ![image](https://user-images.githubusercontent.com/46306263/94767480-6ca4cb00-03e7-11eb-9cce-852888f7337e.png)

    

  - 특정 형식으로 되어 있는 문자열에서 날짜와 시간 추출

    ```java
    DateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
    DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");
    
    Date d = df.parse("2020년 10월 1일"); // 문자열을 Date로 변환
    String result = df2.format(d);
    ```

    ![image](https://user-images.githubusercontent.com/46306263/94767584-b7bede00-03e7-11eb-9a05-9a0a8f05bbb5.png)

