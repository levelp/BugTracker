package ru.polinabevad.bugtracker.tasmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.services.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by p.bevad.spb on 02.06.2016.
 */
public class DateTest extends Assert {
    @Test
    public void test1() {
        //форматируем дату
        DateService date = new DateService();
        String formatDate = date.returnBeatifulDate();
        System.out.println(formatDate);
    }
    @Test
    //парсим дату
    public void test2() throws ParseException {
        Date parseDate = new DateService().parseBeatifulDate("02.06.2016 16:28:12");
        System.out.println(parseDate);

    }
}
