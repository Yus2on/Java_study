# [Java의 정석_연습문제 풀이] 

## Chapter10 날짜와 시간 & 형식화



**[10-1] Calendar 클래스와 SimpleDateFormat클래스를 이용해서 2020년의 매월 두 번째 일요일의 날짜를 출력하시오.**

```java
[실행결과]
2010-01-10은 2번째 일요일입니다.
2010-02-14은 2번째 일요일입니다.
2010-03-14은 2번째 일요일입니다.
2010-04-11은 2번째 일요일입니다.
2010-05-09은 2번째 일요일입니다.
2010-06-13은 2번째 일요일입니다.
2010-07-11은 2번째 일요일입니다. 
2010-08-08은 2번째 일요일입니다.
2010-09-12은 2번째 일요일입니다. 
2010-10-10은 2번째 일요일입니다.
2010-11-14은 2번째 일요일입니다.
2010-12-12은 2번째 일요일입니다.
```

```java
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Main {
  public static void main(String [] args){
    Calendar cal = Calendar.getInstance();
		cal.set(2020, 0, 1); // cal = 2020.01.01로 세팅함
 			
   	for(int i = 0; i < 12; i ++) { // 12달 반복
			int week = cal.get(Calendar.DAY_OF_WEEK);
 		
  	  // 1일 = 일요일이면 8이고
			// 1일 != 일요일이면 16 - 1일의요일 하면 ㄷ나옴
			int sunday = (week == 1) ? 8 : 16 - week;	

	    // sunday로 cal날짜 변경 = DAY_OF_WEEK 사용	
      cal.set(Calendar.DAY_OF_MONTH, sunday);
	
      Date d = cal.getTime();
			System.out.println(new SimpleDateFormat("yyyy-MM-dd은 F번째 E요일입니다.").format(d));

      // 다음 달 1일로 변경
			cal.add(Calendar.MONTH, 1);
			cal.set(Calendar.DAY_OF_WEEK, 1);
    } // end for

  }
}
```





**[10-2] 화면으로부터 날짜를 "2007/05/11"의 형태로 입력받아서 무슨 요일인지 출력하는 프로그램을 작성하시오.**

**단, 입력된 날짜의 형식이 잘못된 경우 메세지를 보여주고 다시 입력받아야 한다.**

```java
[실행결과]
날짜를 yyyy/MM/dd의 형태로 입력해주세요. (입력예:2007/05/11)
>>2009-12-12
날짜를 yyyy/MM/dd의 형태로 입력해주세요. (입력예:2007/05/11)
>>2009/12/12
입력하신 날짜는 토요일입니다.
```

```java
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws ParseException {
    String pattern = "yyyy/MM/dd";
    String day = "입력하신 날짜는 E요일입니다.";

    DateFormat df = new SimpleDateFormat(pattern);
    DateFormat df2 = new SimpleDateFormat(day);

    Scanner scanner = new Scanner(System.in);
    Date date = null;

    do {
      System.out.println("날짜를 " + pattern + " 의 형태로 입력해주세요. (입력예:2020/10/01)");

      System.out.print(">>");
      
      try {
        date = df.parse(scanner.nextLine());
        break;
      } catch (ParseException e) {
        e.printStackTrace();
      }
      
    }while (true);

    System.out.println(df2.format(date));

  }
}
```





**[10-3] 어떤 회사의 월급날이 매월 21일이다. 두 날짜 사이에 월급날이 몇 번있는지 계산해서 반환하는 메서드를 작성하고 테스트하시오.**

```java
import java.util.*;
import java.text.*;

class Exercise10_3 {
  static int paycheckCount(Calendar from, Calendar to) {

    /*
		 * (1) 아래의 로직에 맞게 코드를 작성하시오. 
		 * 	1.from 또는 to가 null이면 0을 반환한다. 
		 * 	2.from와 to가 같고 날짜가 21일이면 1을 반환한다.  
		 * 	3.to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다.
		 * 	4.monDiff가 음수이면 0을 반환한다.
		 * 	5.만일 from의 일(DAY_OF_MONTH)이 21일이거나 이전이고 
		 *  	 to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 monDiff의 값을 1 증가시킨다.
		 * 	6.만일 from의 일(DAY_OF_MONTH)이 21일 이후고
		 *  	 to의  일(DAY_OF_MONTH)이 21일 이전이면 monDiff의 값을 1 감소시킨다.
		 */

    return monDiff;
  }

  static void printResult(Calendar from, Calendar to) {
    Date fromDate = from.getTime();
    Date toDate = to.getTime();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    System.out.print(sdf.format(fromDate) + "~" + sdf.format(toDate) + ":");
    System.out.println(paycheckCount(from, to));
  }

  public static void main(String[] args) {
    Calendar fromCal = Calendar.getInstance();
    Calendar toCal = Calendar.getInstance();

    fromCal.set(2020, 0, 1);
    toCal.set(2020, 0, 1);
    printResult(fromCal, toCal);

    fromCal.set(2020, 0, 21);
    toCal.set(2020, 0, 21);
    printResult(fromCal, toCal);

    fromCal.set(2020, 0, 1);
    toCal.set(2020, 2, 1);
    printResult(fromCal, toCal);

    fromCal.set(2020, 0, 1);
    toCal.set(2020, 2, 23);
    printResult(fromCal, toCal);

    fromCal.set(2020, 0, 23);
    toCal.set(2020, 2, 21);
    printResult(fromCal, toCal);

    fromCal.set(2021, 0, 22);
    toCal.set(2020, 2, 21);
    printResult(fromCal, toCal);
  }
}

[실행결과]
2020-01-01 ~ 2020-01-01:0 
2020-01-21 ~ 2020-01-21:1 
2020-01-01 ~ 2020-03-01:2 
2020-01-01 ~ 2020-03-23:3 
2020-01-23 ~ 2020-03-21:2
2021-01-22 ~ 2020-03-21:0
```

```java
import java.util.*;
import java.text.*;

int fMonth = from.get(Calendar.MONTH);
int tMonth = to.get(Calendar.MONTH);
int fDay = from.get(Calendar.DAY_OF_MONTH);
int tDay = to.get(Calendar.DAY_OF_MONTH);

// from 또는 to가 null이면 0을 반환한다.
if(from == null || to == null) {
  return 0;
}

// from와 to가 같고 날짜가 21일이면 1을 반환한다.
if (from.compareTo(to) == 0 && fDay == 21) {
  return 0;
}

// to와 from이 몇 개월 차이인지 계산해서 변수 monDiff에 담는다.
int monDiff = tMonth - fMonth;

// monDiff가 음수이면 0을 반환한다.
if (monDiff < 0) {
  return 0;
}

// 만일 from의 일(DAY_OF_MONTH)이 21일이거나 이전이고
// to의 일(DAY_OF_MONTH)이 21일이거나 이후이면 monDiff의 값을 1 증가시킨다.
if (fDay <= 21 || tDay >= 21) {
  monDiff++;
}

// 만일 from의 일(DAY_OF_MONTH)이 21일 이후고
// to의  일(DAY_OF_MONTH)이 21일 이전이면 monDiff의 값을 1 감소시킨다.
if (fDay > 21 || tDay < 21) {
  monDiff--;
}

return monDiff;
```





**[10-4] 자신이 태어난 날부터 지금까지 며칠이 지났는지 계산해서 출력하시오.**

```java
[실행결과]
birth day =2000-01-01
today = 2020-10-01
9008 days
```

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
  public static void main(String[] args) {
    LocalDate birthDay = LocalDate.of(1996, 02, 02);
    LocalDate now = LocalDate.now();

    long days = birthDay.until(now, ChronoUnit.DAYS);

    System.out.println("birth day = " + birthDay);
    System.out.println("today = " + now);
    System.out.println(days + " days");

  }
}
```

