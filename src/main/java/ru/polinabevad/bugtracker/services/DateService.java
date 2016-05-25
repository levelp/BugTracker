package ru.polinabevad.bugtracker.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Предназначен для парсинга и форматирования дат в целом по проекту
 */
abstract public class DateService extends Calendar {

    public String returnBeatifulDateWithSec() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(this);
    }

    public String returnBeatifulDateWithoutSec() {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(this);
    }

    public long parseBeatifulDateWithSec(String formatDate) throws ParseException {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.parse(formatDate).getTime();
    }

    public Date parseBeatifulDateWithoutSec(String formatDate) throws ParseException {
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.parse(formatDate);
    }

}
