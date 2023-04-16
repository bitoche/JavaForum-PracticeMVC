package com.example.forumjavatrue.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String DoFormat(Date date){
        try{
            return date == null ? "" : DATE_FORMAT.format(date) ;
        } catch (Exception e) {
            System.out.println("log// Не удалось конвертировать дату из Date в String");
            throw new RuntimeException(e);
        }

    }
    public static Date UnFormat(String stringDate) throws ParseException {
        try {
            return DATE_FORMAT.parse(stringDate);
        } catch (ParseException e) {
            System.out.println("log// Не удалось конвертировать дату из String в Date");
            throw new RuntimeException(e);
        }
    }
}
