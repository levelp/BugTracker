package ru.polinabevad.bugtracker.taskmanagement;

import org.junit.Assert;
import org.junit.Test;
import ru.polinabevad.bugtracker.services.*;

import java.text.ParseException;
import java.util.Date;

/**
 *
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
