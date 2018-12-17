package com.suanfa;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class SimpleTest {
    public static void main(String[] args) {
        try {
            Date date = new Date();
            Date date1 = new Date(118, 10, 11);
            Date date2 = new Date(118, 10, 11);
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sff = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sf.format(date).length());
            System.out.println(sf.format(date1));
            System.out.println(sf.format(date2));
            Instant instant1 = date.toInstant();
            Instant instant2 = date1.toInstant();
            Instant instant3 = date2.toInstant();
            LocalDateTime of1 =  LocalDateTime.ofInstant(instant1, ZoneId.systemDefault());
            LocalDateTime of2 = LocalDateTime.ofInstant(instant2, ZoneId.systemDefault());
            LocalDateTime of3 = LocalDateTime.ofInstant(instant3, ZoneId.systemDefault());
            String s = new DateTime(date).minusMonths(-3).toString("yyyy-MM-dd HH:mm:ss");
            System.out.println(s);
            boolean before = new DateTime(date1).plusDays(-3).isAfter(new DateTime());
            System.out.println(before);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}





