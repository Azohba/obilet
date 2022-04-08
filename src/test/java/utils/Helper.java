package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Helper {
    public static String getDate(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        System.out.println(formatter.format(date));
        return formatter.format(date);
    }

    public static String selectCustomDate(String curDate) throws ParseException {
        final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        final Date date = format.parse(curDate);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        return format.format(calendar.getTime());
    }
}

