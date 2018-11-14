package com.cz.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component("dateConverter")
public class DateConverter implements Converter<String,Date> {
    public Date convert(String source) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        //true:这种情况下java会把你输入的日期进行计算，比如55个月那么就是4年以后，这时候年份就会变成03年了
        //false:这种情况下java不会把你输入的日期进行计算，比如55个月那么就是不合法的日期了，直接异常
        try {
            return dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
