package ru.polinabevad.bugtracker.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Предназначен для парсинга и форматирования дат в целом по проекту
 */
public class DateService extends Date{
    public String returnBeatifulDate() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(this);
    }
    public Date parseBeatifulDate(String formatDate) throws ParseException {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.parse(formatDate);
    }
}
