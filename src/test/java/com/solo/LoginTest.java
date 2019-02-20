package com.solo;

import java.lang.invoke.VolatileCallSite;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author gaojian
 * @Date 2018/10/22
 */
public class LoginTest {
    public static final DateTimeFormatter DATETIME_FORMATTER =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        /*Double a = 309.0;
        Double b = 318.0;
        BigDecimal bi1 = new BigDecimal("0.00");
        BigDecimal bi2 = new BigDecimal(b.toString());
        BigDecimal divide = bi1.divide(bi2, 2, RoundingMode.DOWN).multiply(new BigDecimal("10")).setScale(1);
        System.out.println(divide.toString());
        int i = bi1.compareTo(BigDecimal.ZERO);
        System.out.println(i);*/

        /*Double num = 0.33333;
        BigDecimal bigDecimal = new BigDecimal(num);
        System.out.println("1  "+bigDecimal.setScale(2,RoundingMode.UP));//不管后一位是多大，都向上+1
        System.out.println("2  "+bigDecimal.setScale(2,RoundingMode.HALF_UP));//四舍五入
        System.out.println("3  "+bigDecimal.setScale(2,RoundingMode.DOWN));
        System.out.println("4  "+bigDecimal.setScale(2,RoundingMode.HALF_DOWN));
        System.out.println("5  "+bigDecimal.setScale(2,RoundingMode.HALF_EVEN));
        System.out.println("6  "+bigDecimal.setScale(2,RoundingMode.CEILING));
        System.out.println("7  "+bigDecimal.setScale(2,RoundingMode.FLOOR));*/
//        System.out.println("8  "+bigDecimal.setScale(RoundingMode.UNNECESSARY));


       /* String idCard = "510902199106130691";
        idCard = idCard.replaceAll("(\\d{8})\\d{6}(\\w{4})","$1******$2");
        System.out.println(idCard);
*/
      /*  Double price = 0.01;
        BigDecimal orderPrice = new BigDecimal(price);
        BigDecimal unit = new BigDecimal("0.0");

        BigDecimal total = orderPrice.subtract(unit).setScale(2,BigDecimal.ROUND_HALF_UP);
        if(unit.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("小于等于");
        }else{
            System.out.println("大于");
        }
        System.out.println(total);

        BigDecimal totalPrice = new BigDecimal(price).subtract(unit);
        System.out.println(totalPrice.longValue());
        if(totalPrice.equals(BigDecimal.ZERO)){
            System.out.println("小于等于");
        }else{
            System.out.println("大于");
        }*/

     /*   List<List<String>> content = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> data = new ArrayList<>();
            data.add("1");
            data.add("2");
            data.add("3");
            data.add("4");
            data.add("5");
            data.add("6");
            content.add(data);
        }
        List<String> strings = content.get(content.size() - 1);
        String s = "00000000000";
        content.get(content.size() - 1).set(strings.size() - 1,s);
        content.forEach(c -> {
            for (String sss : c) {
                System.out.println(sss);
            }
        });*/
        Date now = new Date();
        LocalDateTime dateTime = dateToLocaleDateTime(now);
        ZoneId zone = ZoneId.systemDefault();

        Date secondDate = Date.from(dateTime.plusMonths(-2).atZone(zone).toInstant());

        LocalDateTime firstDateTime = dateToLocaleDateTime(now);
        LocalDateTime secondDateTime = dateToLocaleDateTime(secondDate);
        System.out.println(firstDateTime.format(DATETIME_FORMATTER));
        System.out.println(secondDateTime.format(DATETIME_FORMATTER));

        System.out.println(firstDateTime.compareTo(secondDateTime)>0);


    }

    public static Date addMinute(Date date, Integer offset) {
        LocalDateTime beginDateTime = dateToLocaleDateTime(date);
        ZoneId zone = ZoneId.systemDefault();
        return Date.from(beginDateTime.minusMinutes(offset).atZone(zone).toInstant());
    }

    public static LocalDateTime dateToLocaleDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }
}
