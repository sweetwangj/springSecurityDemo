package com.operation.qkwall.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class StringToTimestampConverter implements Converter<String,Timestamp> {
    @Override
    public Timestamp convert(String text) {
        Timestamp timestamp=null;
        if(StringUtils.hasText(text)){
            text = text.trim();
            boolean isLong = true;
            try {
                System.out.println("text:"+text);
                final String formatTime = text.replace("T"," ");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = sdf.parse(formatTime);
                long millisecond = Long.parseLong(String.valueOf(date.getTime()));
                timestamp=new Timestamp(millisecond);
            }catch(Exception e){
                isLong = false;
            }
            if(!isLong) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String format = sdf.format(sdf.parse(text));
                    System.out.println(format);
                } catch (ParseException var3) {
                    throw new IllegalArgumentException("Could not parse date: " + var3.getMessage(), var3);
                }
            }
        }
        return timestamp;
    }
}


